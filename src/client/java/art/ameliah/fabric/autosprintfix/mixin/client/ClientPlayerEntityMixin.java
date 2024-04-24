package art.ameliah.fabric.autosprintfix.mixin.client;

import art.ameliah.fabric.autosprintfix.AutoSprintFixClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.packet.c2s.play.ClientStatusC2SPacket;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {

    @Shadow @Final public ClientPlayNetworkHandler networkHandler;

    @Inject(at = @At("HEAD"), method = "requestRespawn")
    private void requestRespawnHead(CallbackInfo ci) {
        AutoSprintFixClient.respawning = true;
    }

    @Inject(at = @At("TAIL"), method = "requestRespawn")
    private void requestRespawnTail(CallbackInfo ci) {
        AutoSprintFixClient.respawning = false;
    }
}
