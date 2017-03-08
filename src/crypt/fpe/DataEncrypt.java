/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crypt.fpe;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import mysqlkit.SqlType;
/**
 *
 * @author KSTOM
 */
public class DataEncrypt {
    public static List<List<Object>> Encryption(List<List<Object>>obj, CteEncryption cte, SqlType[] types){
        List<List<Object>> enc_data = new ArrayList<List<Object>>();
        for(int i=0;i<obj.size();i++){
            List<Object> items = obj.get(i);
            List<Object> enc_items = new ArrayList<Object>();
            for(int j=0; j<types.length;j++){
                if(types[j] == SqlType.INT){
                    int item = (int)(long)cte.Encoding(new CharacterNumber(), (int)items.get(j));
                    enc_items.add(item);                    
                }else if(types[j] == SqlType.DATE){
                    Date item = (Date)items.get(j); 
                    enc_items.add(cte.Encoding(new CharacterDate(), item));   
                }else if(types[j] == SqlType.DOUBLE){
                    double item = (double)items.get(j); 
                    enc_items.add(cte.Encoding(new CharacterDouble(), item));   
                }else if(types[j] == SqlType.FLOAT){
                    float item = (float)items.get(j); 
                    enc_items.add(cte.Encoding(new CharacterFloat(), item));   
                }else if(types[j] == SqlType.LONG){
                    long item = (long)cte.Encoding(new CharacterNumber(), (int)items.get(j));;
                    enc_items.add(item);   
                }else if(types[j] == SqlType.SHORT){
                    short item = (short)(long)cte.Encoding(new CharacterNumber(), (int)items.get(j)); 
                    enc_items.add(item);   
                }else if(types[j] == SqlType.STRING){
                    String item = (String)items.get(j); 
                    enc_items.add(cte.Encoding(new CharacterStander(), item));   
                }else if(types[j] == SqlType.TIME){
                    Time item = (Time)items.get(j); 
                    enc_items.add(cte.Encoding(new CharacterTime(), item));   
                }else if(types[j] == SqlType.TIMESTAMP){
                    Timestamp item = (Timestamp)items.get(j); 
                    enc_items.add(cte.Encoding(new CharacterTimestamp(), item));   
                }
            }
            enc_data.add(enc_items);
        }
        return enc_data;
    }
    
    public static List<List<Object>> Decryption(List<List<Object>>obj, CteEncryption cte, SqlType[] types){
        List<List<Object>> enc_data = new ArrayList<List<Object>>();
        for(int i=0;i<obj.size();i++){
            List<Object> items = obj.get(i);
            List<Object> enc_items = new ArrayList<Object>();
            for(int j=0; j<types.length;j++){
                if(types[j] == SqlType.INT){
                    int item = (int)(long)cte.Decoding(new CharacterNumber(), (int)items.get(j));
                    enc_items.add(item);                    
                }else if(types[j] == SqlType.DATE){
                    Date item = (Date)items.get(j); 
                    enc_items.add(cte.Decoding(new CharacterDate(), item));   
                }else if(types[j] == SqlType.DOUBLE){
                    double item = (double)items.get(j); 
                    enc_items.add(cte.Decoding(new CharacterDouble(), item));   
                }else if(types[j] == SqlType.FLOAT){
                    float item = (float)items.get(j); 
                    enc_items.add(cte.Decoding(new CharacterFloat(), item));   
                }else if(types[j] == SqlType.LONG){
                    long item = (long)cte.Decoding(new CharacterNumber(), (int)items.get(j));;
                    enc_items.add(item);   
                }else if(types[j] == SqlType.SHORT){
                    short item = (short)(long)cte.Decoding(new CharacterNumber(), (int)items.get(j)); 
                    enc_items.add(item);   
                }else if(types[j] == SqlType.STRING){
                    String item = (String)items.get(j); 
                    enc_items.add(cte.Decoding(new CharacterStander(), item));   
                }else if(types[j] == SqlType.TIME){
                    Time item = (Time)items.get(j); 
                    enc_items.add(cte.Decoding(new CharacterTime(), item));   
                }else if(types[j] == SqlType.TIMESTAMP){
                    Timestamp item = (Timestamp)items.get(j); 
                    enc_items.add(cte.Decoding(new CharacterTimestamp(), item));   
                }
            }
            enc_data.add(enc_items);
        }
        return enc_data;
    }
    
}
