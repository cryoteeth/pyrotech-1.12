package com.codetaylor.mc.pyrotech.modules.tech.refractory.block.fluid;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public class BlockFluidCoalTar
    extends BlockFluidClassic {

  public BlockFluidCoalTar(Fluid fluid) {

    super(fluid, Material.WATER);
    Blocks.FIRE.setFireInfo(this, 100, 5);
  }

}