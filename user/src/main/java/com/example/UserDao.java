package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<User> {
    private List<User> users = new ArrayList<>();

   

   
 

 


    public UserDao(User user) {
        users.add(user);
    }

    @Override
    public Optional<User> get(long id) {
        return null;
        // TODO Auto-generated method stub
    
    }

    @Override
    public List<User> getallUsers() {
        // TODO Auto-generated method stub
                        try{
                            users.clear();
            Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/User","postgres","Test");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from users");
            while(rs.next()){
            int id = rs.getInt("user_id");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String username = rs.getString("username");
            users.add(new User(id,username,firstName,lastName));
            }
            con.close();
        



        }catch(SQLException e){
            System.out.println(e.getMessage());


        }
                        return users;
    }

    @Override
    public void insertToDB(User user) {
        // TODO Auto-generated method stub
            try{
            Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/User","postgres","Test");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Insert into users(user_id,username,first_name,last_name) values('"+user.getId()+"','"+user.getUsername()+"','"+user.getFirstName()+"','"+user.getLastName()+"')");
            con.close();



        }catch(SQLException e){
            System.out.println(e.getMessage());

        }
    }

    @Override
    public void updateFirstName(User user,String updatedValue) {
        // TODO Auto-generated method stub
                try{
            Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/User","postgres","Test");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("update users set first_name='"+updatedValue+"' where username='"+user.getUsername()+"'");
            con.close();



        }catch(SQLException e){
            System.out.println(e.getMessage());

        }
    }

    @Override
    public void deleteUser(User user) {
               // TODO Auto-generated method stub
            try{
            Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/User","postgres","Test");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("delete from users where username='"+user.getUsername()+"'");
            con.close();



        }catch(SQLException e){
            System.out.println(e.getMessage());

        }

    }

    @Override
    public void getUserById(int id) {
                try{
            Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/User","postgres","Test");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from users where user_id="+id);
            if(rs.next()){
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            String username = rs.getString("username");
            System.out.println("User is: "+firstName+" "+lastName+" "+username);
            }
            con.close();
        



        }catch(SQLException e){
            System.out.println(e.getMessage());


        }
}
}



 
    
