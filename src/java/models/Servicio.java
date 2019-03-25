
package models;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Servicio {
    
    //static List<Servicio> ServiceList=new ArrayList<Servicio>();
    //static List<Servicio> AvailableService=new ArrayList<Servicio>();
    
    private String MeetingTime;
    private String OutputCore;
    private String ArrivalNucleus;
    private String StartPlace;
    private String EndPlace;
    private int AvailableSeats;
    private Conductor Driver;
    private Vehiculo Vehicle;
    private LocalDate DateSer;
    private float AverageScoreSer=0;
    private List<Pasajero> RidersList=new ArrayList<Pasajero>();
    private List<Calificacion> QualificationsList=new ArrayList<Calificacion>();
    private HashMap <Pasajero, List> RiderxSeat=new HashMap <Pasajero, List>();
    
    public Servicio(String meetingtime, String outputcore, String arrivalnucleus, String startplace, String endplace, int availableseats, Conductor driver, Vehiculo vehicle, LocalDate dateser){
        this.setMeetingTime(meetingtime);
        this.setOutputCore(outputcore);
        this.setArrivalNucleus(arrivalnucleus);
        this.setStartPlace(startplace);
        this.setEndPlace(endplace);
        this.setAvailableSeats(availableseats);
        this.setDriver(driver);
        this.setVehicle(vehicle);
        this.setDateSer(dateser);
        //Servicio.ServiceList.add(this);
        //Servicio.AvailableService.add(this);
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
    public void setDateSer(LocalDate dateser) {this.DateSer=dateser;}
    public void setRidersList(Pasajero rider, int seat){
        this.RidersList.add(rider);
        rider.setServiceListPa(this);
        rider.setCurrentTrip(this);
        this.AvailableSeats=this.AvailableSeats-seat;
    }
    public void setQualificationsList(Calificacion Qualification){
        this.QualificationsList.add(Qualification);
        this.setAverageScoreSer();
    }
    public void setRiderxSeat(Pasajero pasajero, List reason){
        RiderxSeat.put(pasajero, reason);
    }
    public void setAverageScoreSer(){
        List<Calificacion> Qualifications=this.getQualificationsList();
        if(Qualifications.size()==0){
            this.AverageScoreSer=0;
        }
        else{
            int sum=0;
            for(Calificacion cali:Qualifications){
                sum+=cali.getScore();
            }
            this.AverageScoreSer=sum/Qualifications.size();
        }
    }

    public String getMeetingTime() {return MeetingTime;}
    public String getOutputCore() {return OutputCore;}
    public String getArrivalNucleus() {return ArrivalNucleus;}
    public String getStartPlace() {return StartPlace;}
    public String getEndPlace() {return EndPlace;}
    public int getAvailableSeats() {return AvailableSeats;}
    public Conductor getDriver() {return Driver;}
    public Vehiculo getVehicle() {return Vehicle;}
    public LocalDate getDateSer(){return this.DateSer;}
    public float getAverageScoreSer() {
        this.setAverageScoreSer();
        return AverageScoreSer;
    }
    public List<Pasajero> getRidersList() {return RidersList;}
    public List<Calificacion> getQualificationsList() {return QualificationsList;}
    public HashMap getRiderxSeat(){return this.RiderxSeat;}
}
