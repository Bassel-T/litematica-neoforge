package fi.dy.masa.litematica.render;
 
import com.mojang.blaze3d.textures.GpuSampler;
 
import net.minecraft.client.renderer.chunk.ChunkSectionLayerGroup;
 
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderLevelStageEvent;
import net.neoforged.api.distmarker.Dist;
 
import fi.dy.masa.litematica.Reference;
import fi.dy.masa.litematica.mixin.render.IMixinLevelRenderer;
 
@EventBusSubscriber(modid = Reference.MOD_ID, value = Dist.CLIENT)
public class LitematicaRenderEvents
{
    @SubscribeEvent
    public static void onRenderAfterOpaque(RenderLevelStageEvent.AfterOpaqueBlocks event)
    {
        GpuSampler sampler = ((IMixinLevelRenderer) event.getLevelRenderer()).litematica_getChunkLayerSampler();
        LitematicaRenderer.getInstance().piecewiseDrawBlockLayerGroup(ChunkSectionLayerGroup.OPAQUE, sampler);
    }
 
    @SubscribeEvent
    public static void onRenderAfterTranslucent(RenderLevelStageEvent.AfterTranslucentBlocks event)
    {
        GpuSampler sampler = ((IMixinLevelRenderer) event.getLevelRenderer()).litematica_getChunkLayerSampler();
        LitematicaRenderer.getInstance().piecewiseDrawBlockLayerGroup(ChunkSectionLayerGroup.TRANSLUCENT, sampler);
    }
}
 