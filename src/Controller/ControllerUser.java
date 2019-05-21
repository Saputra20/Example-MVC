/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Query.QueryUser;
import Model.User;

/**
 *
 * @author Dutra
 */
public class ControllerUser {
    private QueryUser queryUser = new QueryUser();
    
    public boolean InsertUser(String username , String password){
        if(username.isEmpty() && password.isEmpty()){
            return false ; 
        }else{
            User user = new User(username, password);
            return queryUser.insert(user);
        }
    }
}
