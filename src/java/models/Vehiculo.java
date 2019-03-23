package models;
import java.util.ArrayList;
import java.util.List;
public class Vehiculo {
    static List<Vehiculo> VehiclesList= new ArrayList<Vehiculo>();
    private String LicensePlate;
    private String Color;
    private String VehicleType;
    private String VehiculeModel;
    private int Seats;
    private String Active;
    
    public Vehiculo(String LicensePlate,String Color, String VehicleType,String VehiculeModel,int Seats,String Active,Conductor Driver ){
        this.setLicensePlate(LicensePlate);
        this.setColor(Color);
        this.setVehicleType(VehicleType);
        this.setVehiculeModel(VehiculeModel);
        this.setSeats(Seats);
        this.setActive(Active);
        Vehiculo.VehiclesList.add(this);
    }   

    public List<Vehiculo> getVehiclesList() {
        return VehiclesList;
    }

    public String getLicensePlate() {
        return LicensePlate;
    }

    public void setLicensePlate(String LicensePlate) {
        this.LicensePlate = LicensePlate;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getVehicleType() {
        return VehicleType;
    }

    public void setVehicleType(String VehicleType) {
        this.VehicleType = VehicleType;
    }

    public String getVehiculeModel() {
        return VehiculeModel;
    }

    public void setVehiculeModel(String VehiculeModel) {
        this.VehiculeModel = VehiculeModel;
    }

    public int getSeats() {
        return Seats;
    }

    public void setSeats(int Seats) {
        this.Seats = Seats;
    }

    public String getActive() {
        return Active;
    }

    public void setActive(String Active) {
        this.Active = Active;
    }
    
}
