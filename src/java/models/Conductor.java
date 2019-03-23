
package models;

import java.util.ArrayList;
import java.util.List;

public class Conductor extends Persona {
    
    static List<Conductor> DriverList = new ArrayList<Conductor>();
    
    private int ServicesNumber=0;
    private float AccumulatedRating=0;
    private List<Vehiculo> VehiclesList=new ArrayList<Vehiculo>();
    private List<Servicio> ServiceListDri=new ArrayList<Servicio>();
    private List<Servicio> CurrentService=new ArrayList<Servicio>();
    private List<Pasajero> UnqualifiedRider=new ArrayList<Pasajero>();
    
    public Conductor(String email, String password, String name, String cellphone){
        super(email, password, name, cellphone);
        Conductor.DriverList.add(this);
    }
    
    public Conductor(String email, String password, String name, String cellphone, int servicesnumber, float accumulatedrating){
        super(email, password, name, cellphone);
        this.ServicesNumber=servicesnumber;
        this.AccumulatedRating=accumulatedrating;
        Conductor.DriverList.add(this);
    }
    
    public void setServicesNumber(){this.ServicesNumber=this.getServiceListDri().size();}
    public void setAccumulatedRating(){
        float sum=0;
        for(Servicio servicio: this.getServiceListDri()){
            sum+=servicio.getAverageScoreSer();
        }
        this.AccumulatedRating=sum;
    }
    public void setVehiclesList(Vehiculo vehicle){this.VehiclesList.add(vehicle);}
    public void setServiceListDri(Servicio service){this.ServiceListDri.add(service);}
    public void setCurrentService(Servicio service){this.CurrentService.add(service);}
    public void setUnqualifiedRider(Pasajero rider){this.UnqualifiedRider.add(rider);}
    
    public int getServicesNumber() {
        this.setServicesNumber();
        return this.ServicesNumber;
    }
    public float getAccumulatedRating() {
        this.setAccumulatedRating();
        return this.AccumulatedRating;
    }
    public List<Vehiculo> getVehiclesList() {return this.VehiclesList;}
    public List<Servicio> getServiceListDri() {return this.ServiceListDri;}
    public List<Servicio> getCurrentService() {return this.CurrentService;}
    public List<Pasajero> getUnqualifiedRider() {return this.UnqualifiedRider;}
    
}
