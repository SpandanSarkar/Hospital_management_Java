


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Spandan
 */
import java.util.*;
public class inputCorrection {
    Scanner sc= new Scanner(System.in);
    
    public int correctInt(String n){
        boolean id_count = true;
        int id = 0;
        while(id_count){
            System.out.println("Please enter Patient "+ n +" (Note: "+n+ " is a number)");
            try{
                id = sc.nextInt();
                if(id == 0){
                    System.out.println("0 Can not be an "+ n);
                }
                else{
                    id_count = false;
                }
            }catch(InputMismatchException ex){
                 String abc = sc.nextLine(); // added due to solve integer input loop problem
                 // source: https://www.youtube.com/watch?v=xH0nGFt7Bbs
                 //System.out.println(ex); 
                 System.out.println("Please give correct "+n); 

            }
        }
        return id;
     }
     
     public String correctString(String name, String n){
         boolean done = true;
         while(done){
            System.out.println("Please enter Patient's " + n);
            name = sc.nextLine();
            if ((name != null) && (!name.equals(""))
                   && (name.matches("^[a-zA-Z]*$"))){
                   done = false;
            }
            else{
                System.out.println("Not Valid characters. Please try again");
            }
          
         }
         return name;
     }
}
