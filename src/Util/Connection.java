/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.DriverManager;

/**
 *
 * @author Khang
 */
public class Connection {
    static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static String url = "jdbc:sqlserver://SE140281\\SE140281:1433; databaseName=Lab1; user=sa; password=01256230";
    
    public static java.sql.Connection openConnection() throws Exception {
        Class.forName(driver);
        return DriverManager.getConnection(url);
    }
}
