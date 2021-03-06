package com.codetaylor.mc.pyrotech.modules.tech.machine.recipe.spi;

import com.codetaylor.mc.pyrotech.library.spi.recipe.IRecipeTimed;
import net.minecraftforge.registries.IForgeRegistryEntry;

public abstract class MachineRecipeBase<T extends IForgeRegistryEntry<T>>
    extends IForgeRegistryEntry.Impl<T>
    implements IRecipeTimed {

  protected final int timeTicks;

  public MachineRecipeBase(int timeTicks) {

    this.timeTicks = timeTicks;
  }

  @Override
  public int getTimeTicks() {

    return this.timeTicks;
  }
}
