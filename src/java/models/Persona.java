
package models;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    
    static List<Persona> PeopleList= new ArrayList<Persona>();
    
    private String Email;
    private String Password;
    private String Name;
    private String CellPhone;
    
    public Persona(String email, String password, String name, String cellphone){
        this.setEmail(email);
        this.setPassword(password);
        this.setName(name);
        this.setCellPhone(cellphone);
        Persona.PeopleList.add(this);
    }
    
    public void setEmail(String email){this.Email=email;}
    public void setPassword(String password){this.Password=password;}
    public void setName(String name){this.Name=name;}
    public void setCellPhone(String cellphone){this.CellPhone=cellphone;}
    
    public String getEmail(){return this.Email;}
    public String getPassword(){return this.Password;}
    public String getName(){return this.Name;}
    public String getCellPhone(){return this.CellPhone;}
}
