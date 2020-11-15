package services;

import dataaccess.UserDB;
import models.User;

public class AccountService {
    UserDB userDB = new UserDB();
    public User login(String email, String password) {
        
        
        try {
            User user = userDB.get(email);
            if (password.equals(user.getPassword())) {
                return user;
            }
        } catch (Exception e) {
        }
        
        return null;
    }

    public User getAccount(String email) {
        try{
       User user = userDB.get(email);
        return user;
        }
        catch(Exception e){
         return null;
        }
    }
}
