package fi.dy.masa.litematica.mixin.render;

import com.mojang.blaze3d.textures.GpuSampler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import net.minecraft.client.renderer.LevelRenderer;

@Mixin(LevelRenderer.class)
public interface IMixinLevelRenderer
{
    @Accessor("chunkLayerSampler")
    GpuSampler litematica_getChunkLayerSampler();
}