
package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Comentario {
    
    //static List<Comentario> CommentsList = new ArrayList<Comentario>();
    
    private String Description;
    private Persona Person;
    private LocalDate Date;
    
    public Comentario(String description, Persona person, LocalDate date){
        this.setDescription(description);
        this.setPerson(person);
        this.setDate(date);
    }
    
    public void setDescription(String description){this.Description=description;}
    public void setPerson(Persona person){this.Person=person;}
    public void setDate(LocalDate date){this.Date=date;}
    
    public String getDescription(){return this.Description;}
    public Persona getPerson(){return this.Person;}
    public LocalDate getDate(){return this.Date;}
    
}
