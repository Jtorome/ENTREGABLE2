
package models;

import java.util.ArrayList;
import java.util.List;

public class Comentario {
    
    //static List<Comentario> CommentsList = new ArrayList<Comentario>();
    
    private String Description;
    private Persona Person;
    private String Date;
    
    public Comentario(String description, Persona person, String date){
        this.setDescription(description);
        this.setPerson(person);
        this.setDate(date);
    }
    
    public void setDescription(String description){this.Description=description;}
    public void setPerson(Persona person){this.Person=person;}
    public void setDate(String date){this.Date=date;}
    
    public String getDescription(){return this.Description;}
    public Persona getPerson(){return this.Person;}
    public String getDate(){return this.Date;}
    
}
