/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class Admin {
    Scanner sc= new Scanner(System.in);
    private String name;
    private String pass;
    private int num;
    
    public void getAdmin() throws SQLException{
        
        System.out.println("Enter User Name: ");
        String uname = sc.nextLine();
        System.out.println("Enter User Password: ");
        String upass = sc.nextLine();
        PreparedStatement ps; // prepare objects from db
        ResultSet rs; // show the results of db
        String query = "SELECT * FROM `admin` WHERE `userName` =? AND `password` =?"; // catching values from DB
        
        try {
            ps = MyConnection.getConnection().prepareStatement(query);
            ps.setString(1, uname);
            ps.setString(2, upass);
            rs = ps.executeQuery(); // to show the result of DB

            if(rs.next()) // itteration of result set
            {
                System.out.println("Welcome "+uname);
                System.out.println("  ");
                System.out.println("Enter 1 for View patients Details");
                System.out.println("Enter 2 for Add patient");
                System.out.println("Enter 3 for Delete patient");
                System.out.println("Enter 4 for Edit patients Details");
                System.out.println("Enter 0 to exit.");
                int input_new = correctInt_input();
                if(input_new == 1){
                    View v = new View();
                    v.viewPatient();
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
                else if(input_new == 4){
                    System.out.println("You have to Enter following details.");
                    Update u = new Update();
                    u.updatePatient();
                }
                else if(input_new == 0){
                    System.exit(0);
                }

                
            }
            else{
                System.out.println("Incorrect Username or Password");
                System.out.println("Please try again");
                System.out.println(" ");
                getAdmin();
            }

        }catch(NullPointerException e) {
		System.out.println("NullPointerException thrown!");
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
                if(in >= 0 && in<=4){
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
}
