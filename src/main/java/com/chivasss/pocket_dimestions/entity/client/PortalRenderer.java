package com.chivasss.pocket_dimestions.entity.client;

import com.chivasss.pocket_dimestions.PocketDim;
import com.chivasss.pocket_dimestions.entity.custom.PortalEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Matrix3f;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.DragonFireball;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class PortalRenderer extends EntityRenderer<PortalEntity> {
    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(PocketDim.MODID,
            "textures/entity/pocket_portal.png");
    private static final RenderType RENDER_TYPE = RenderType.entityCutoutNoCull(TEXTURE_LOCATION);

    public PortalRenderer(EntityRendererProvider.Context p_173962_) {
        super(p_173962_);
    }

    protected int getBlockLightLevel(PortalEntity p_114087_, BlockPos p_114088_) {
        return 15;
    }

    public void render(PortalEntity render, float v, float v1, PoseStack poseStack, MultiBufferSource bufferSource, int vertex) {
        poseStack.pushPose();
        poseStack.scale(1.0F, 1.5F, 1.0F);
        poseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
        poseStack.mulPose(Vector3f.YP.rotationDegrees(180.0F));
        PoseStack.Pose posestack$pose = poseStack.last();
        Matrix4f matrix4f = posestack$pose.pose();
        Matrix3f matrix3f = posestack$pose.normal();
        VertexConsumer vertexconsumer = bufferSource.getBuffer(RENDER_TYPE);
        vertex(vertexconsumer, matrix4f, matrix3f, vertex, 0F, 0, 0, 1);
        vertex(vertexconsumer, matrix4f, matrix3f, vertex, 1F, 0, 1, 1);
        vertex(vertexconsumer, matrix4f, matrix3f, vertex, 1F, 1, 1, 0);
        vertex(vertexconsumer, matrix4f, matrix3f, vertex, 0F, 1, 0, 0);
        poseStack.popPose();
        super.render(render, v, v1, poseStack, bufferSource, vertex);
    }

    private static void vertex(VertexConsumer p_114090_, Matrix4f p_114091_, Matrix3f p_114092_, int p_114093_, float p_114094_, int p_114095_, int p_114096_, int p_114097_) {
        p_114090_.vertex(p_114091_, p_114094_ - 0.5F, (float)p_114095_ + 0.25F, 0.0F) //MOVE
                .color(255, 255, 255, 255).uv((float)p_114096_, (float)p_114097_)
                .overlayCoords(OverlayTexture.NO_OVERLAY).uv2(p_114093_)
                .normal(p_114092_, 0.0F, 1.0F, 0.0F).endVertex();
    }

    public ResourceLocation getTextureLocation(PortalEntity p_114078_) {
        return TEXTURE_LOCATION;
    }
}