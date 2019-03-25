/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.time.LocalDate;

/**
 *
 * @author juana
 */
public class ENTREGA2{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Persona a=new Persona("juantoro", "hola", "juan", "312");
        //System.out.println(Persona.PeopleList.get(0).getName());
        LocalDate m= LocalDate.now().plusDays(1);
        System.out.println(m);
        LocalDateTime today = LocalDateTime.now(); 
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm");
        String b = today.format(format);
        int c=Integer.parseInt(b.split(":")[0]);
        int a=23;
        if(a>=c){
            System.out.println("SI");
        }
    }
}
