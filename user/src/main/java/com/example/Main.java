package com.example;

public class Main {
    public static void main(String[] args) {
        User user = new User(3, "Test5", "3", "3");
        UserDao userDao = new UserDao(user);
        userDao.insertToDB(user);

        userDao.updateFirstName(user,"Update");
        userDao.getUserById(2);
        System.out.println(userDao.getallUsers().get(0).getFirstName().toString());
      
        
        //userDao.deleteUser(user);

    
    }
}