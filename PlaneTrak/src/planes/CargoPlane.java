package planes;

public abstract class CargoPlane implements PlaneIF{
    private int cargoTonnage;

    public int getCargoTonnage(){
        return cargoTonnage;
    }

    public void setCargoTonnage(int cargoTonnage){
        this.cargoTonnage = cargoTonnage;
    }

}
