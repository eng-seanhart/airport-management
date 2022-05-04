package heidt_hart.planefactories;

import heidt_hart.planeparts.engine.EngineIF;
import heidt_hart.planeparts.fuselage.FuselageIF;
import heidt_hart.planeparts.wing.WingIF;
import heidt_hart.planes.PlaneIF;


public interface PlaneFactoryIF {
    public EngineIF[] createEngine();

    public FuselageIF createFuselage();

    public WingIF[] createWings();

    public PlaneIF createPlane(int planeCarryValue);
}
