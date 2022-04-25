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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Update {
     Scanner sc= new Scanner(System.in);
     
     
     public void updatePatient() throws SQLException{
        PreparedStatement ps;
        ResultSet rs;
        int up_input = 0;
        String query = "SELECT * FROM `patient` WHERE `ID` =?";
        
        boolean done = true;
        int n = 0;
        
        //while(done){
            
            System.out.println("Please Enter ID number to see previous details of the Patient");
            //inputCorrection input = new inputCorrection();
            int o_n = correctID("ID"); // correct ID
            try {
                ps = MyConnection.getConnection().prepareStatement(query);
                ps.setInt(1, o_n); // replacing =? in pos. 1
                rs = ps.executeQuery(); 

               // if(rs.next()){
                    while (rs.next()){
                        int i = rs.getInt("ID");
                        String name = rs.getString("Name");
                        int age = rs.getInt("Age");
                        String disease = rs.getString("Disease");
                        String address = rs.getString("Address");
                        String cabin = rs.getString("CabinNo");
                        String occupation = rs.getString("Occupation");
                        String doctor = rs.getString("Doctor");

                        System.out.format("%s, %s, %s, %s, %s, %s, %s, %s\n","ID: " +i,"Name: " +name,"Age: "
                                + age, "Disease: " +disease, "Address: " + address,
                                "Cabin No: " +cabin, "Occupation: " + occupation,
                                "Appionted Doctor: " + doctor);
                        //done = false;
                    }
                    
//                }else{
//                       System.out.println("ID not found");
//                       System.out.println("Please Enter ID number to see previous details of the Patient");
//                       //o_n = input.correctInt(n, "ID");     
//                       // cashe data, refreshing 
//                 }

                    System.out.println("See the following instruction to update information accurately");
                    System.out.println("Enter 1 for update Name");
                    System.out.println("Enter 2 for update Age");
                    System.out.println("Enter 3 for update Disease");
                    System.out.println("Enter 4 for update Address");
                    System.out.println("Enter 5 for update CabinNo");
                    System.out.println("Enter 6 for update ccupation");
                    System.out.println("Enter 7 for update Doctor name");
//                    int z = sc.nextInt();
//                    String p = sc.nextLine(); // to solve int to String input error. check?
                    
                    up_input = correctInt_update();
                    
                    if(up_input == 1){
                        String p = sc.nextLine();
                        inputCorrection input1 = new inputCorrection();
                        String u_name = input1.correctString("abc", "Name");
                        String query1 = "UPDATE `patient` SET `Name` =? WHERE `ID` =?";
                        
                        try {
                            ps = MyConnection.getConnection().prepareStatement(query1);
                            ps.setString(1, u_name);
                            ps.setInt(2, o_n);
                            ps.executeUpdate();
                            System.out.println("Name is Successfully updated");
                        }catch(NullPointerException e) {
                            System.out.println("NullPointerException thrown!");
                        }
                    }
                    
                    else if(up_input == 2){
                        inputCorrection input1 = new inputCorrection();
                        int u_age = input1.correctInt("Age");
                        String query1 = "UPDATE `patient` SET `Age` =? WHERE `ID` =?";
                        
                        try {
                            ps = MyConnection.getConnection().prepareStatement(query1);
                            ps.setInt(1, u_age);
                            ps.setInt(2, o_n);
                            ps.executeUpdate();
                            System.out.println("Age is Successfully updated");
                        }catch(NullPointerException e) {
                            System.out.println("NullPointerException thrown!");
                        }
                    }
                    
                    else if(up_input == 3){
                        inputCorrection input1 = new inputCorrection();
                        String u_disease = "";
                        boolean done1 = true;
                        while(done1){
                            System.out.println("Enter the name of the Disease");
                            String b = sc.nextLine();
                            u_disease = sc.nextLine();
                            if(u_disease != null){ // check
                                done1 = false;
                                //System.out.println("Test");
                            }
                            else{
                                System.out.println("Disease name can not be empty");
                            }
                        }
                        String query1 = "UPDATE `patient` SET `Disease` =? WHERE `ID` =?";
                        
                        try {
                            ps = MyConnection.getConnection().prepareStatement(query1);
                            ps.setString(1, u_disease);
                            ps.setInt(2, o_n);
                            ps.executeUpdate();
                            System.out.println("Disease name is Successfully updated");
                        }catch(NullPointerException e) {
                            System.out.println("NullPointerException thrown!");
                        }
                    }
                    
                    else if(up_input == 4){
                        inputCorrection input1 = new inputCorrection();
                        String u_add = "";
                        boolean done1 = true;
                        while(done1){
                            System.out.println("Enter the Address");
                            String b = sc.nextLine();
                            u_add = sc.nextLine();
                            if(u_add != null){ // check
                                done1 = false;
                                //System.out.println("Test");
                            }
                            else{
                                System.out.println("Address can not be empty");
                            }
                        }
                        String query1 = "UPDATE `patient` SET `Address` =? WHERE `ID` =?";
                        
                        try {
                            ps = MyConnection.getConnection().prepareStatement(query1);
                            ps.setString(1, u_add);
                            ps.setInt(2, o_n);
                            ps.executeUpdate();
                            System.out.println("Address is Successfully updated");
                        }catch(NullPointerException e) {
                            System.out.println("NullPointerException thrown!");
                        }
                    }
                    
                    else if(up_input == 5){
                        inputCorrection input1 = new inputCorrection();
                        String u_cab = "";
                        boolean done1 = true;
                        while(done1){
                            System.out.println("Enter the name of the Cabin number");
                            String b = sc.nextLine();
                            u_cab = sc.nextLine();
                            if(u_cab != null){ // check
                                done1 = false;
                                //System.out.println("Test");
                            }
                            else{
                                System.out.println("Cabin number name can not be empty");
                            }
                        }
                        String query1 = "UPDATE `patient` SET `CabinNo` =? WHERE `ID` =?";
                        
                        try {
                            ps = MyConnection.getConnection().prepareStatement(query1);
                            ps.setString(1, u_cab);
                            ps.setInt(2, o_n);
                            ps.executeUpdate();
                            System.out.println("Cabin numbee is Successfully updated");
                        }catch(NullPointerException e) {
                            System.out.println("NullPointerException thrown!");
                        }
                    }
                    
                    else if(up_input == 6){
                        String p = sc.nextLine();
                        inputCorrection input1 = new inputCorrection();
                        String u_occupation = input1.correctString("abc", "Occupation");
                        String query1 = "UPDATE `patient` SET `Occupation` =? WHERE `ID` =?";
                        
                        try {
                            ps = MyConnection.getConnection().prepareStatement(query1);
                            ps.setString(1, u_occupation);
                            ps.setInt(2, o_n);
                            ps.executeUpdate();
                            System.out.println("Occupation is Successfully updated");
                        }catch(NullPointerException e) {
                            System.out.println("NullPointerException thrown!");
                        }
                    }
                    
                    else if(up_input == 7){
                        String p = sc.nextLine();
                        inputCorrection input1 = new inputCorrection();
                        String u_doctor = input1.correctString("abc", "Doctor");
                        String query1 = "UPDATE `patient` SET `Doctor` =? WHERE `ID` =?";
                        
                        try {
                            ps = MyConnection.getConnection().prepareStatement(query1);
                            ps.setString(1, u_doctor);
                            ps.setInt(2, o_n);
                            ps.executeUpdate();
                            System.out.println("Doctor is Successfully updated");
                        }catch(NullPointerException e) {
                            System.out.println("NullPointerException thrown!");
                        }
                    }
                                  
            }catch(NullPointerException e) {
                    System.out.println("NullPointerException thrown!");
            }
            
            
            System.out.println("Enter 1 for View patient");
            System.out.println("Enter 2 for Add patient");
            System.out.println("Enter 3 for Delete patient");
            System.out.println("Enter 0 to exit.");
            int input_new = correctInt_input();
            if(input_new == 1){
                View v = new View();
                v.viewPatient(); // fix it
            }
            else if(input_new == 2){
                System.out.println("You have to Enter following details.");
                Add a = new Add();
                a.addPatient();
            }
            else if(input_new == 3){
                Delete d = new Delete();
                d.deletePatient();
            }
            else if(input_new == 0){
            System.exit(0);
        }
        //}
        
       
     }
     
     public int correctInt_update(){
        boolean id_count = true;
        int id = 0;
        while(id_count){
            System.out.println("Please enter the input");
            try{
                id = sc.nextInt();
                if(id >=1 && id<=7){
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
        return id;
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
                    int c = 1;
                    for(int j=0; j<ids.size(); j++){
                        if(ids.get(j) != id){
                            c++;
                        }
                    }
                    if(c == ids.size()){
                        id_count = false;
                        System.out.println("ID found");
                    }
                    else{
                        System.out.println("ID not found!");
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
     

