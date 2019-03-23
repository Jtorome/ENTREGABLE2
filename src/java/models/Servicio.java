
package models;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Servicio {
    
    static List<Servicio> ServiceList=new ArrayList<Servicio>();
    static List<Servicio> AvailableService=new ArrayList<Servicio>();
    
    private String MeetingTime;
    private String OutputCore;
    private String ArrivalNucleus;
    private String StartPlace;
    private String EndPlace;
    private int AvailableSeats;
    private Conductor Driver;
    private Vehiculo Vehicle;
    private String DateSer;
    private float AverageScoreSer=0;
    private List<Pasajero> RidersList=new ArrayList<Pasajero>();
    private List<Calificacion> QualificationsList=new ArrayList<Calificacion>();
    private HashMap <Pasajero, List> RiderxSeat=new HashMap <Pasajero, List>();
    
    public Servicio(String meetingtime, String outputcore, String arrivalnucleus, String startplace, String endplace, int availableseats, Conductor driver, Vehiculo vehicle, String dateser){
        this.setMeetingTime(meetingtime);
        this.setOutputCore(outputcore);
        this.setArrivalNucleus(arrivalnucleus);
        this.setStartPlace(startplace);
        this.setEndPlace(endplace);
        this.setAvailableSeats(availableseats);
        this.setDriver(driver);
        this.setVehicle(vehicle);
        this.setDateSer(dateser);
        Servicio.ServiceList.add(this);
        Servicio.AvailableService.add(this);
    }

    public void setMeetingTime(String meetingtime) {this.MeetingTime = meetingtime;}
    public void setOutputCore(String outputcore) {this.OutputCore = outputcore;}
    public void setArrivalNucleus(String arrivalnucleus) {this.ArrivalNucleus = arrivalnucleus;}
    public void setStartPlace(String startplace) {this.StartPlace = startplace;}
    public void setEndPlace(String endplace) {this.EndPlace = endplace;}
    public void setAvailableSeats(int availableseats) {this.AvailableSeats = availableseats;}
    public void setDriver(Conductor driver){
        this.Driver=driver;
        driver.setServiceListDri(this);
        driver.setCurrentService(this);
        driver.setServicesNumber();
    }
    public void setVehicle(Vehiculo vehicle) {this.Vehicle = vehicle;}
    public void setDateSer(String dateser) {this.DateSer=dateser;}
    public void setRidersList(Pasajero rider, int seat){
        this.RidersList.add(rider);
        rider.setServiceListPa(this);
        rider.setCurrentTrip(this);
        this.AvailableSeats=this.AvailableSeats-seat;
    }
    public void setRiderxSeat(Pasajero pasajero, List reason){
        RiderxSeat.put(pasajero, reason);
    }

    public String getMeetingTime() {
        return MeetingTime;
    }

    public String getOutputCore() {
        return OutputCore;
    }

    public String getArrivalNucleus() {
        return ArrivalNucleus;
    }

    public String getStartPlace() {
        return StartPlace;
    }

    public String getEndPlace() {
        return EndPlace;
    }

    public int getAvailableSeats() {
        return AvailableSeats;
    }

    public float getAverageScoreSer() {
        return AverageScoreSer;
    }

    public Conductor getDriver() {
        return Driver;
    }

    public Vehiculo getVehicle() {
        return Vehicle;
    }

    public List<Pasajero> getRidersList() {
        return RidersList;
    }

    public List<Calificacion> getQualificationsList() {
        return QualificationsList;
    }
    
    
}
