package heidt_hart.planefactories;

import heidt_hart.planeparts.engine.EngineIF;
import heidt_hart.planeparts.engine.PW2000;
import heidt_hart.planeparts.fuselage.Boeing757Fuselage;
import heidt_hart.planeparts.fuselage.FuselageIF;
import heidt_hart.planeparts.wing.Boeing757Wing;
import heidt_hart.planeparts.wing.WingIF;
import heidt_hart.planes.FreighterBoeing757;
import heidt_hart.planes.PlaneIF;

public class Boeing757Factory implements PlaneFactoryIF{
    @Override
    public EngineIF[] createEngine() {
        return new EngineIF[]{new PW2000(), new PW2000()};
    }

    @Override
    public FuselageIF createFuselage() {
        return new Boeing757Fuselage();
    }

    @Override
    public WingIF[] createWings() {
        return new WingIF[]{new Boeing757Wing(), new Boeing757Wing()};
    }

    @Override
    public PlaneIF createPlane(int passengerCount) {
        return new FreighterBoeing757(createFuselage(), createEngine(), createWings(), passengerCount);
    }
}
