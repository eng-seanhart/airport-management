package heidt_hart.planefactories;

import heidt_hart.planeparts.engine.EngineIF;
import heidt_hart.planeparts.engine.RollsRoyceTrent900;
import heidt_hart.planeparts.fuselage.AirbusA380Fuselage;
import heidt_hart.planeparts.fuselage.FuselageIF;
import heidt_hart.planeparts.wing.AirbusA380Wing;
import heidt_hart.planeparts.wing.WingIF;
import heidt_hart.planes.PassengerAirbusA380;
import heidt_hart.planes.PlaneIF;

public class AirbusA380Factory implements PlaneFactoryIF{
    @Override
    public EngineIF[] createEngine() {
        return new EngineIF[]{new RollsRoyceTrent900(), new RollsRoyceTrent900(), new RollsRoyceTrent900(),
                new RollsRoyceTrent900()};
    }

    @Override
    public FuselageIF createFuselage() {
        return new AirbusA380Fuselage();
    }

    @Override
    public WingIF[] createWings() {
        return new WingIF[]{new AirbusA380Wing(), new AirbusA380Wing()};
    }

    @Override
    public PlaneIF createPlane(int passengerCount) {
        return new PassengerAirbusA380(createFuselage(), createEngine(), createWings(), passengerCount);
    }
}
