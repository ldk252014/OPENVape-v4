package gg.vape.module.blatant.scaffold;

import gg.vape.module.blatant.Scaffold;
import gg.vape.rotation.PointRotationController;
import gg.vape.wrapper.impl.EntityPlayerSP;
import gg.vape.wrapper.impl.GuiScreen;

public class ScaffoldPointRotationController
extends PointRotationController {
    private final int direction;
    private boolean speedInitialized;
    private final Scaffold scaffold;

    public ScaffoldPointRotationController(Scaffold scaffold, double targetX, double targetY,
                                           double targetZ, int direction,
                                           double[] placementPosition) {
        super(targetX, targetY, targetZ);
        this.scaffold = scaffold;
        this.direction = direction;
        this.speedInitialized = false;
    }

    @Override
    public void update(EntityPlayerSP player, GuiScreen currentScreen) {
        if (player.isNull() || currentScreen.isNotNull()) {
            return;
        }
        this.updateTargetRotation();
        this.updatePitch();
        if (!this.speedInitialized) {
            this.setSpeed(Math.min(Math.max(2.0f,
                    this.scaffold.getDirectionRotationSpeed(this.direction)), 8.0f));
            this.speedInitialized = true;
        }
        this.updateYaw();
    }
}
