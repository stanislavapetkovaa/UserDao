package com.example;

public class Main {
    public static void main(String[] args) {
        User user = new User(3, "Test5", "2", "3");
        UserDao userDao = new UserDao(user);
        System.out.println(userDao.getallUsers().get(0).toString());
      
        // userDao.insertToDB(user);

        // userDao.updateFirstName(user,"Update");
        // userDao.getUserById(2);
        //userDao.deleteUser(user);

    
    }
}