package models;

public class Calificacion {

    private float Score;
    private String Description;
    private Pasajero Rider = null;
    private Servicio Service = null;

    public Calificacion(float score, String description, Servicio service) {
        this.setScore(score);
        this.setDescription(description);
        this.setService(service);
    }

    public Calificacion(float score, String description, Pasajero rider) {
        this.setScore(score);
        this.setDescription(description);
        this.setRider(rider);
    }

    public void setScore(float score) {
        this.Score = score;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public void setRider(Pasajero rider) {
        rider.setScoreListPa(this);
        this.Rider = rider;
    }

    public void setService(Servicio service) {
        this.Service = service;
        service.setQualificationsList(this);
    }

    public float getScore() {
        return this.Score;
    }

    public String getDescription() {
        return this.Description;
    }

    public Pasajero getRider() {
        return this.Rider;
    }

    public Servicio getService() {
        return this.Service;
    }
}
