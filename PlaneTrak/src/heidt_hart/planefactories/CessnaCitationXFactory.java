package heidt_hart.planefactories;

import heidt_hart.planeparts.engine.EngineIF;
import heidt_hart.planeparts.engine.RollsRoyceAE3007;
import heidt_hart.planeparts.fuselage.CessnaCitationXFuselage;
import heidt_hart.planeparts.fuselage.FuselageIF;
import heidt_hart.planeparts.wing.CessnaCitationXWing;
import heidt_hart.planeparts.wing.WingIF;
import heidt_hart.planes.CessnaCitationX;
import heidt_hart.planes.PlaneIF;

public class CessnaCitationXFactory implements PlaneFactoryIF{
    @Override
    public EngineIF[] createEngine() {
        return new EngineIF[]{new RollsRoyceAE3007(), new RollsRoyceAE3007()};
    }

    @Override
    public FuselageIF createFuselage() {
        return new CessnaCitationXFuselage();
    }

    @Override
    public WingIF[] createWings() {
        return new WingIF[]{new CessnaCitationXWing(), new CessnaCitationXWing()};
    }

    @Override
    public PlaneIF createPlane(int cargoTonnage) {
        return new CessnaCitationX(createFuselage(), createEngine(), createWings(), cargoTonnage);
    }
}
