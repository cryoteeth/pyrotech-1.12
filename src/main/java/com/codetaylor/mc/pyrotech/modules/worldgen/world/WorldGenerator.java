package com.codetaylor.mc.pyrotech.modules.worldgen.world;

import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WorldGenerator
    implements IWorldGenerator {

  private List<IWorldGenFeature> featureList;
  private Int2ObjectMap<List<IWorldGenFeature>> perDimensionFeatureList;

  public WorldGenerator() {

    this.featureList = Lists.newArrayList(
        new WorldGenFossil(),
        new WorldGenLimestone(),
        new WorldGenDenseCoal(),
        new WorldGenDenseNetherCoal(),
        new WorldGenRocks()
    );

    this.perDimensionFeatureList = new Int2ObjectOpenHashMap<>();
  }

  @Override
  public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {

    int dimension = world.provider.getDimension();
    List<IWorldGenFeature> features = this.perDimensionFeatureList.get(dimension);

    if (features == null) {
      features = new ArrayList<>();

      for (IWorldGenFeature feature : this.featureList) {

        if (feature.isAllowed(dimension)) {
          features.add(feature);
        }
      }

      this.perDimensionFeatureList.put(dimension, features);
    }

    if (!features.isEmpty()) {

      for (IWorldGenFeature feature : features) {
        feature.generate(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
      }
    }
  }

}
