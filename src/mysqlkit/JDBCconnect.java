/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mysqlkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author KSTOM
 */
public class JDBCconnect {
    private static String driver = "com.mysql.jdbc.Driver"; 
    private static String url = "jdbc:mysql://127.0.0.1:3306/";
    private static String database = "sakila";
    private static String user = "root";   
    private static String password = "mysql";
    
    public static Connection getConnect(){
        return getConnect(database,user,password);
    }
    public static Connection getConnect(String database){
        return getConnect(database,user,password);
    }
    static Connection getConnect(String database, String user, String password){
        try{
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url+database, user, password);
            if(!conn.isClosed()){
                System.out.println("Succeeded connecting to the Database!");
                return conn;
            }else{
                return null;
            }
            
        }catch(ClassNotFoundException e) {
            System.out.println("Sorry,can`t find the Driver!"); 
            e.printStackTrace();
        }catch(SQLException e) {
            e.printStackTrace();
        }catch(Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    }

