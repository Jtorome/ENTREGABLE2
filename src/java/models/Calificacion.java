
package models;

public class Calificacion {
    
    private float Score;
    private String Description;
    private Conductor Driver;
    private Pasajero Rider;
    private Servicio Service=null;
    
    public Calificacion(float score, String description, Conductor driver, Pasajero rider, Servicio service){
        this.setScore(score);
        this.setDescription(description);
        this.setDriver(driver);
        this.setRider(rider);
        this.setService(service);
    }
    
    public Calificacion(float score, String description, Conductor driver, Pasajero rider){
        this.setScore(score);
        this.setDescription(description);
        this.setDriver(driver);
        this.setRider(rider);
    }
    
    public void setScore(float score){this.Score=score;}
    public void setDescription(String description){this.Description=description;}
    public void setDriver(Conductor driver){this.Driver=driver;}
    public void setRider(Pasajero rider){this.Rider=rider;}
    public void setService(Servicio service){this.Service=service;}
    
    public float getScore(){return this.Score;}
    public String getDescription(){return this.Description;}
    public Conductor getDriver(){return this.Driver;}
    public Pasajero getRider(){return this.Rider;}
    public Servicio getService(){return this.Service;}
}
