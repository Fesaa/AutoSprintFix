package art.ameliah.fabric.autosprintfix.mixin.client;

import art.ameliah.fabric.autosprintfix.AutoSprintFixClient;
import net.minecraft.client.option.StickyKeyBinding;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(StickyKeyBinding.class)
public class StickyKeyBindingMixin {

    @Inject(at = @At("HEAD"), method = "untoggle", cancellable = true)
    public void onUnToggle(CallbackInfo ci) {
        if (AutoSprintFixClient.respawning) {
            ci.cancel();
        }
    }

}
