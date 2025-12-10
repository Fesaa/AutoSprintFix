package art.ameliah.fabric.autosprintfix.mixin.client;

import art.ameliah.fabric.autosprintfix.AutoSprintFixClient;
import net.minecraft.client.player.LocalPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LocalPlayer.class)
public class ClientPlayerEntityMixin {

    @Inject(at = @At("HEAD"), method = "respawn")
    private void requestRespawnHead(CallbackInfo ci) {
        AutoSprintFixClient.respawning = true;
    }

    @Inject(at = @At("TAIL"), method = "respawn")
    private void requestRespawnTail(CallbackInfo ci) {
        AutoSprintFixClient.respawning = false;
    }
}
