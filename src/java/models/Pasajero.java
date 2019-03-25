
package models;

import java.util.ArrayList;
import java.util.List;

public class Pasajero extends Persona {
    
    //static List<Pasajero> PassengerList = new ArrayList<Pasajero>();
    
    private float AverageScore=0;
    private List<Servicio> ServiceListPa=new ArrayList<Servicio>();
    private List<Servicio> CurrentTrip=new ArrayList<Servicio>();
    private List<Calificacion> ScoreListPa=new ArrayList<Calificacion>();
    private List<Servicio> UnqualifiedService=new ArrayList<Servicio>();
    
    public Pasajero(String email, String password, String name, String cellphone){
        super(email, password, name, cellphone);
    }
    
    public Pasajero(String email, String password, String name, String cellphone, float averageScore){
        super(email, password, name, cellphone);
        this.AverageScore=averageScore;
    }
    
    public void setAverageScore(){
        List<Calificacion> pasa=this.getScoreListPa();
        if(pasa.isEmpty()){
            return;
        }
        float sum=0;
        for(Calificacion cali:pasa){
            sum+=cali.getScore();
        }
        this.AverageScore=sum/(pasa.size());
    }
    public void setServiceListPa(Servicio service){this.ServiceListPa.add(service);}
    public void setScoreListPa(Calificacion Qualification){
        this.ScoreListPa.add(Qualification);
        this.setAverageScore();
    }
    public void setCurrentTrip(Servicio service){this.CurrentTrip.add(service);}
    public void setUnqualifiedService(Servicio service){this.UnqualifiedService.add(service);}
    
    public float getAverageScore(){
        this.setAverageScore();
        return this.AverageScore;
    }
    
    public List<Servicio> getServiceListPa(){return this.ServiceListPa;}
    public List<Calificacion> getScoreListPa(){return this.ScoreListPa;}
    public List<Servicio> getCurrentTrip(){return this.CurrentTrip;}
    public List<Servicio> getUnqualifiedService(){return this.UnqualifiedService;}
}
