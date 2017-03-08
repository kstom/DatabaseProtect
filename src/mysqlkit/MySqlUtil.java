/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mysqlkit;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Timestamp;
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
    
    public List<List<Object>> onSelect(String tablename, String[] items, SqlType[] types){
        if(items == null){
            return null;
        }
        String items_str = items[0].toString();
        for(int i=1;i<items.length;i++){
            items_str = items_str + "," + items[i].toString();
        }
        String sql = "select " + items_str + " from " + tablename;
        System.out.println("sql : "+sql);
        return this.getOnSelectResult(sql,types);
        
        
    }
    
    private List<List<Object>> getOnSelectResult(String sql,SqlType[] type){
        List<List<Object>> result = new ArrayList<List<Object>>();
        try {
            ResultSet rs = this.statement.executeQuery(sql);           
            while(rs.next()){
                System.out.println("statement");
                List<Object> listitems = new ArrayList<Object>();
                for(int i=0;i<type.length;i++){
                    if(type[i] == SqlType.INT){
                        int item = rs.getInt(i+1);
                        listitems.add(i, item);
                    }else if(type[i] == SqlType.DATE){
                        Date item = rs.getDate(i+1);
                        listitems.add(i,item);
                    }else if(type[i] == SqlType.DOUBLE){
                        double item = rs.getDouble(i+1);
                        listitems.add(i,item);
                    }else if(type[i] == SqlType.FLOAT){
                        float item = rs.getFloat(i+1);
                        listitems.add(i,item);
                    }else if(type[i] == SqlType.LONG){
                        long item = rs.getLong(i+1);
                        listitems.add(i,item);
                    }else if(type[i] == SqlType.SHORT){
                        short item = rs.getShort(i+1);
                        listitems.add(i,item);
                    }else if(type[i] == SqlType.STRING){
                        String item = rs.getString(i+1);
                        listitems.add(i,item);
                    }else if(type[i] == SqlType.TIME){
                        Time item = rs.getTime(i+1);
                        listitems.add(i,item);
                    }else if(type[i] == SqlType.TIMESTAMP){
                        Timestamp item = rs.getTimestamp(i+1);
                        listitems.add(i,item);
                    }
                }
                result.add(listitems);               
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
    
    public List<String> getResultListSet(String sql){
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

