/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Query;

import Interfce.InterfaceUser;
import Connection.MysqlConnection;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dutra
 */
public class QueryUser implements InterfaceUser{

    private Connection conn = MysqlConnection.getConnection();
    
    @Override
    public boolean insert(User data) {
        //To change body of generated methods, choose Tools | Templates.
       String mysql = "Insert Into user values (? , ?)";
        try {
            PreparedStatement statement = conn.prepareStatement(mysql);
            
            statement.setString(1, data.getUsername());
            statement.setString(2, data.getPassword());
            int row = statement.executeUpdate();
            if(row > 0 ){
                return true ;
            }
            statement.close();
        } catch (SQLException e) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE , null , e);
        }
        return false ; 
    }
    
}
