package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Comentario {

    //static List<Comentario> CommentsList = new ArrayList<Comentario>();
    private String Description;
    private Persona Person;
    private LocalDate Date;

    public Comentario(String description, Persona person, LocalDate date) {
        this.setDescription(description);
        this.setPerson(person);
        this.setDate(date);
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public void setPerson(Persona person) {
        this.Person = person;
    }

    public void setDate(LocalDate date) {
        this.Date = date;
    }

    public String getDescription() {
        return this.Description;
    }

    public Persona getPerson() {
        return this.Person;
    }

    public LocalDate getDate() {
        return this.Date;
    }

    public static Comentario BuscadorDeComentario(String description, String email, LocalDate date, List<Comentario> CommentsList) {
        for (Comentario comment : CommentsList) {
            if (comment.getDescription().equals(description) && comment.getPerson().getEmail().equals(email) && comment.getDate().equals(date)) {
                return comment;
            }
        }
        return null;
    }
}
