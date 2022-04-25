/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSet;
import java.sql.SQLException;

public class Delete {
    Scanner sc= new Scanner(System.in);
    //private int id;
    
    public void deletePatient() throws SQLException{
       // id = n;
//        System.out.println("Enter Patient ID which you want to delete");
//        int i = sc.nextInt();
        int n = correctID("ID");
        
        PreparedStatement ps;
        String query = "DELETE FROM `patient` WHERE `ID` =?";
        
        try {
            ps = MyConnection.getConnection().prepareStatement(query); // setting query into the DB using MyConnection class
            ps.setInt(1, n);
            ps.execute();
            // if id is not found
            System.out.println("All the record of the Patient has been deleted!");

        }catch(NullPointerException e) {
		System.out.println("NullPointerException thrown!");
	}
        
        System.out.println("Enter 1 for View patient");
        System.out.println("Enter 2 for Add patient");
        System.out.println("Enter 3 for Edit patients Details");
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
            System.out.println("You have to Enter following details.");
            Update u = new Update();
            u.updatePatient();
        }
        else if(input_new == 0){
            System.exit(0);
        }
        
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
