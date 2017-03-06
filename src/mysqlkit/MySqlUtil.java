/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mysqlkit;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author KSTOM
 */
public class MySqlUtil {
    private Connection conn = null;
    private Statement statement = null;
    public enum Type {
    INT, SHORT, STRING, FLOAT, DOUBLE, LONG, TIME, TIMESTEMP, DATE;
    }
    
    public MySqlUtil(Connection conn){
        try {
            this.conn = conn;
            statement = conn.createStatement();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public List<String> getTablesName(){
        String sql = "show tables";
        List<String> tables = new ArrayList<String>();
        try {
            ResultSet rs = this.statement.executeQuery(sql);
            while(rs.next()){
                tables.add(rs.getString(1));
            }
            if(rs != null){
                try{
                    rs.close();
                }catch(SQLException e){
                    e.printStackTrace();
                    }
            }       
        }catch(SQLException e){
            e.printStackTrace();
        }
        return tables;
    }
    
    public String[] getAllItems(){
        List<String> items = new ArrayList<String>();
        
        return (String[])items.toArray();
    }
    
    public List<String> onSelect(String tablename, String[] items){
        if(items == null){
            return null;
        }
        String items_str = items[0];
        for(int i=1;i<items.length;i++){
            items_str = items_str + "," + items[i];
        }
        String sql = "select " + items_str + " from " + tablename;
        System.out.println("sql : "+sql);
        return this.getResultListSet(sql);
        
        
    }
    
    private List<List<String>> getOnSelectResult(String sql,Type[] type){
        List<List<String>> result = new ArrayList<List<String>>();
        try {
            ResultSet rs = this.statement.executeQuery(sql);
            while(rs.next()){
                for(int i=0;i<type.length;i++){
                    if(type[i] == Type.DATE){
                        Date item = rs.getDate(i+1);
                        long litem = item.getTime();
                    }else if(type[i] == Type.DOUBLE){
                        double item = rs.getDouble(i+1);
                    }else if(type[i] == Type.FLOAT){
                        float item = rs.getFloat(i+1);
                    }else if(type[i] == Type.){
                        rs.get
                    }else if(type[i] == Type.DOUBLE){
                    }else if(type[i] == Type.DOUBLE){
                    }else if(type[i] == Type.DOUBLE){
                    }
                }
                
            }
            if(rs != null){
                try{
                    rs.close();
                }catch(SQLException e){
                    e.printStackTrace();
                    }
            }  
            return result;
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return null;
    }
    
    private List<String> getResultListSet(String sql){
        List<String> result = new ArrayList<String>();
        try {
            ResultSet rs = this.statement.executeQuery(sql);
            while(rs.next()){
                result.add(rs.getString(1));
            }
            if(rs != null){
                try{
                    rs.close();
                }catch(SQLException e){
                    e.printStackTrace();
                    }
            }  
            return result;
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return null;
    }
    
}

