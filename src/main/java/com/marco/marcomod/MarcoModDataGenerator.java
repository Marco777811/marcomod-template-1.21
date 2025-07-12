package com.marco.marcomod;

import com.marco.marcomod.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class MarcoModDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(MBtags::new);
		pack.addProvider(MLtables::new);
		pack.addProvider(Mmodels::new);
		pack.addProvider(EN_US::new);
		pack.addProvider(ZH_CN::new);
		pack.addProvider(Mrecipes::new);
	}
}
