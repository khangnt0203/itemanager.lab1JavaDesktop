/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import DTO.UserDTO;
import java.util.*;
import java.sql.*;
/**
 *
 * @author Khang
 */
public class UserDAO extends Util.Connection{
    
    public static UserDTO getUser (String userID, String password) throws Exception{
        String sql = "select userID, password from  tblUsers where userID like ? and password like ?";
        try(Connection c = openConnection();
                PreparedStatement ps = c.prepareStatement(sql))
        {
            ps.setString(1, userID);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                return new UserDTO(rs.getString("userID"),rs.getString("password"));
            }
        }
        return null;
    }
}
