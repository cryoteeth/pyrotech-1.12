package com.codetaylor.mc.pyrotech.modules.storage.plugin.crafttweaker;

import com.codetaylor.mc.athenaeum.tools.ZenDocArg;
import com.codetaylor.mc.athenaeum.tools.ZenDocMethod;
import com.codetaylor.mc.athenaeum.tools.ZenDocClass;
import com.codetaylor.mc.athenaeum.tools.ZenDocPrepend;
import com.codetaylor.mc.pyrotech.modules.core.plugin.crafttweaker.ZenStages;
import com.codetaylor.mc.pyrotech.modules.storage.ModuleStorageConfig;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenDocClass("mods.pyrotech.SimpleRockBag")
@ZenDocPrepend({"docs/include/header.md"})
@ZenClass("mods.pyrotech.SimpleRockBag")
public class ZenSimpleRockBag {

  @ZenDocMethod(
      order = 1,
      args = {
          @ZenDocArg(arg = "stages", info = "game stages")
      },
      description = {
          "Sets game stage logic required to use the device."
      }
  )
  @ZenMethod
  public static void setGameStages(ZenStages stages) {

    ModuleStorageConfig.STAGES_SIMPLE_ROCK_BAG = stages.getStages();
  }
}
