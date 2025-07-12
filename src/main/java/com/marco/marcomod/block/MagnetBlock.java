package com.marco.marcomod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class MagnetBlock extends Block {
    public static final BooleanProperty ENABLED = BooleanProperty.of("enabled");
    public static final IntProperty LEVEL = IntProperty.of("level", 1, 24); // 范围 1~24
    public static final BooleanProperty FULL = BooleanProperty.of("full");

    public MagnetBlock(Settings settings) {
        super(settings);
        // 合并所有属性到默认状态
        this.setDefaultState(
                this.getStateManager().getDefaultState()
                        .with(ENABLED, false)
                        .with(LEVEL, 1)
                        .with(FULL,false)
        );
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ENABLED, LEVEL,FULL);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        if (world.isClient) return;

        // 红石逻辑
        boolean isPowered = world.isReceivingRedstonePower(pos);
        if (isPowered != state.get(ENABLED)) {
            world.setBlockState(pos, state.with(ENABLED, isPowered), Block.NOTIFY_ALL);
        }

        // 检测相邻磁铁并升级（仅在未达到最大等级时）
        if (state.get(LEVEL) < 24) {
            for (Direction direction : Direction.values()) {
                BlockPos neighborPos = pos.offset(direction);
                BlockState neighborState = world.getBlockState(neighborPos);

                if (neighborState.getBlock() == ModBlocks.MAGNET) {
                    // 避免无限递归：检查相邻磁铁的等级是否更低
                    if (neighborState.get(LEVEL) < state.get(LEVEL)) {
                        world.breakBlock(neighborPos, false); // 破坏相邻磁铁
                        world.setBlockState(pos, state.with(LEVEL, state.get(LEVEL) + 1), Block.NOTIFY_ALL);
                    }
                }
            }
        }else if(!state.get(FULL)) world.setBlockState(pos,state.with(FULL,true));

    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (world.isClient) return;
        boolean isPowered = world.isReceivingRedstonePower(pos);
        if (isPowered != state.get(ENABLED)) {
            world.setBlockState(pos, state.with(ENABLED, isPowered), Block.NOTIFY_ALL);
        }

        if (state.get(LEVEL) < 24) {
            for (Direction direction : Direction.values()) {
                BlockPos neighborPos = pos.offset(direction);
                BlockState neighborState = world.getBlockState(neighborPos);

                if (neighborState.getBlock() == ModBlocks.MAGNET) {
                    // 避免无限递归：检查相邻磁铁的等级是否更低
                    if (neighborState.get(LEVEL) == 1) {
                        world.breakBlock(neighborPos, false); // 破坏相邻磁铁
                        world.setBlockState(pos, state.with(LEVEL, state.get(LEVEL) + 1), Block.NOTIFY_ALL);
                    }
                }
            }
        }
        if (state.get(LEVEL) == 24) world.setBlockState(pos,state.with(FULL,true));
    }
}