package models;
import java.util.ArrayList;
import java.util.List;
public class Vehiculo {
    
    //static List<Vehiculo> VehiclesList= new ArrayList<Vehiculo>();
    
    private String LicensePlate;
    private String Color;
    private String VehicleType;
    private String VehiculeModel;
    private int Seats;
    private Conductor Driver;
    
    public Vehiculo(String licenseplate, String color, String vehicletype, String vehiculemodel, int seats, Conductor driver){
        this.setLicensePlate(licenseplate);
        this.setColor(color);
        this.setVehicleType(vehicletype);
        this.setVehiculeModel(vehiculemodel);
        this.setSeats(seats);
        this.setDriver(driver);
        //Vehiculo.VehiclesList.add(this);
    }

    

    public void setLicensePlate(String LicensePlate) {this.LicensePlate = LicensePlate;}
    public void setColor(String Color) {this.Color = Color;}
    public void setVehicleType(String VehicleType) {this.VehicleType = VehicleType;}
    public void setVehiculeModel(String VehiculeModel) {this.VehiculeModel = VehiculeModel;}
    public void setSeats(int Seats) {this.Seats = Seats;}
    public void setDriver(Conductor driver){this.Driver=driver;
        driver.setVehiclesList(this);}

    public String getLicensePlate() {return this.LicensePlate;}
    public String getColor() {return this.Color;}
    public String getVehicleType() {return this.VehicleType;}
    public String getVehiculeModel() {return this.VehiculeModel;}
    public int getSeats() {return this.Seats;}
    public Conductor getDriver() {return this.Driver;}
}
