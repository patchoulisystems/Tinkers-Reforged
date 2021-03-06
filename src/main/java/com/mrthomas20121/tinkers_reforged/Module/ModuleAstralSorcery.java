package com.mrthomas20121.tinkers_reforged.Module;

import com.mrthomas20121.libs.RegistryLib;
import com.mrthomas20121.tinkers_reforged.Config.Config;
import com.mrthomas20121.tinkers_reforged.Traits.Traits;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.MaterialIntegration;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.materials.*;
import slimeknights.tconstruct.library.utils.HarvestLevels;
import slimeknights.tconstruct.tools.TinkerTraits;

import static com.mrthomas20121.tinkers_reforged.Module.Materials.mats;

public class ModuleAstralSorcery extends ModuleBase {

    public RegistryLib starmetal = new RegistryLib(Materials.starmetal);

    public ModuleAstralSorcery() {
        starmetal.setCraftable(false).setCastable(true);
        starmetal.registerMaterialTrait(Traits.astral, MaterialTypes.HEAD);
        starmetal.registerMaterialTrait(TinkerTraits.alien);
        starmetal.registerHeadStats(200, 5.2f, 3.2f, HarvestLevels.IRON);
        starmetal.registerHandleStats(0.9f, 70);
        starmetal.registerExtraStats(50);
        starmetal.registerBowStats(3.0f, 3f, 3f);
    }
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        if(Config.starmetal) {
            FluidRegistry.registerFluid(ModuleFluids.starmetal);
            FluidRegistry.addBucketForFluid(ModuleFluids.starmetal);
            starmetal.addCommonItems("AstralStarmetal");
            starmetal.addIngotItem("ingotAstralStarmetal");
            starmetal.addIngotItem("dustAstralStarmetal");
            starmetal.registerPreInit("ingotAstralStarmetal", ModuleFluids.starmetal);
            Materials.mats.add(starmetal.getMat());
        }
    }
    @Override
    public void init(FMLInitializationEvent e) {
        starmetal.setCastable(true).setCraftable(false);
        this.registerDefaultMelting("AstralStarmetal", ModuleFluids.starmetal);
    }
    @Override
    public void postInit(FMLPostInitializationEvent e) { }
}