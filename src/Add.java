/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Add {
     Scanner sc= new Scanner(System.in);
     
     public void addPatient() throws SQLException{
        //id = n;
        PreparedStatement ps;
        
        int id = 0;
        String name = "";
        int age = 0;
        String disease = "";
        String address = "";
        String occu = "";
        String doctor = "";
        
        String query = "INSERT INTO `patient`(`ID`, `Name`, `Age`, `Disease`, `Address`, `CabinNo`, `Occupation`, `Doctor`) VALUES (?,?,?,?,?,?,?,?)";
         
        int o_id = correctID("ID");
        //System.out.println(o_id);
        name = sc.nextLine();
        String o_name = correctString(name,"name");
        //System.out.println(o_name);
        int o_age = correctInt(age, "Age");
        //System.out.println(o_age);
        String abc = sc.nextLine();
        System.out.println("Please enter Patient's disease");
        String o_disease = sc.nextLine();
        //System.out.println(o_disease);
        System.out.println("Please enter Patient's Address");
        String o_address = sc.nextLine();
        //System.out.println(o_address);
        System.out.println("Please enter Patient's Cabin Number");
        String o_cabin = sc.nextLine();
        //System.out.println(o_cabin);
        String o_occu = correctString(occu,"occupation");
        System.out.println(o_occu);
        String o_doctor = correctString(doctor,"Doctor name");
        //System.out.println(o_doctor);
        
        try{
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setInt(1,o_id);
            ps.setString(2,o_name);
            ps.setInt(3,o_age);
            ps.setString(4,o_disease);
            ps.setString(5,o_address);
            ps.setString(6,o_cabin);
            ps.setString(7,o_occu);
            ps.setString(8,o_doctor);
            ps.executeUpdate();
            System.out.println("New Patient has been Added!");
        }catch (SQLException e){
            System.err.println("Got an exception!");
        }
        
        System.out.println("Enter 1 for View patient");
        System.out.println("Enter 2 for Delete patient");
        System.out.println("Enter 3 for Edit patients Details");
        System.out.println("Enter 0 to exit.");
        int input_new = correctInt_input();
        if(input_new == 1){
            View v = new View();
            v.viewPatient(); // fix it
        }
        else if(input_new == 2){
            Delete d = new Delete();
            d.deletePatient();
        }
        else if(input_new == 3){
            System.out.println("You have to Enter following details.");
            Update u = new Update();
            u.updatePatient();
        }
        else if(input_new == 0){
            System.exit(0);
        }
        
     }
     
     
     
     public int correctInt(int id, String n){
         // logic for make characters as numbers
        boolean id_count = true;
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
         // logic for taking characters in between a-z and A-Z
         boolean done = true;
         while(done){
            System.out.println("Please enter Patient's " + n);
            name = sc.nextLine();
            if ((name != null) && (!name.equals(""))
                   && (name.matches("^[a-zA-Z]*$"))){
                // details needed
                   done = false;
            }
            else{
                System.out.println("Not Valid characters. Please try again");
            }
          
         }
         return name;
     }
     
     public int correctInt_input(){
         // logic for make characters as numbers
        int in = 0;
        boolean id_count = true;
        while(id_count){
            System.out.println("Please enter input");
            try{
                in = sc.nextInt();
                if(in >= 0 && in<=3){
                    id_count = false;
                }
                else{
                    System.out.println("Wrong input");
                }
            }catch(InputMismatchException ex){
                 String abc = sc.nextLine(); // added due to solve integer input loop problem
                 // source: https://www.youtube.com/watch?v=xH0nGFt7Bbs
                 //System.out.println(ex); 
                 System.out.println("Please give correct input"); 

            }
        }
        return in;
     }
     
     public int correctID(String n) throws SQLException{
         // logic for make characters as numbers
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
                    ArrayList<Integer> ids = new ArrayList<Integer>();
                    PreparedStatement ps;
                    ResultSet rs;
                    String query = "SELECT * FROM `patient`";
                    try {
                        ps = MyConnection.getConnection().prepareStatement(query);
                        rs = ps.executeQuery();
                        while (rs.next()) { 
                           ids.add(rs.getInt(1));
                        }
                    }catch(NullPointerException e) {
                        System.out.println("NullPointerException thrown!");
                    }
                    int c = 0;
                    for(int j=0; j<ids.size(); j++){
                        if(ids.get(j) == id){
                            System.out.println("This ID already exists!");
                            c++;
                        }
                    }
                    if(c == 0){
                        id_count = false;
                    }
                    
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
}
