/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mysqltest;


import associationrule.apriori.Apriori;
import crypt.fpe.*;
import java.lang.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import mysqlkit.*;

/**
 *
 * @author KSTOM
 */
public class MySqlTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
/*        
        long key = 12345;
        double db = 2.36;
        
        CharacterDouble cs = new CharacterDouble();
        
        CteEncryption CE = new CteEncryption(cs,key);
        
        double str1 = (double)CE.Encoding(db);
        
        System.out.println(str1);
        double str2 = (double)CE.Decoding(str1);
        System.out.println(str2);
        //你：100111101100000
*/        
        

        MySqlUtil sqlutil = new MySqlUtil(JDBCconnect.getConnect("sakila"));
        
        String[] items = new String[2];
        items[0] = "store_id";
        items[1] = "manager_staff_id";
        String tablename = "store";
        SqlType[] types = {SqlType.INT,SqlType.INT};
        List<List<Object>> obj = sqlutil.onSelect(tablename, items, types);
        long key = 999999;
        CteEncryption cte = new CteEncryption(key);
        System.out.println("------------plaintext--------------");
        showSqlResult(obj,types);
        obj = DataEncrypt.Encryption(obj, cte, types);
        System.out.println("------------ciphertext--------------");
        showSqlResult(obj,types);
        System.out.println("------------plaintext--------------");
        obj = DataEncrypt.Decryption(obj, cte, types);
        showSqlResult(obj,types);
        
        /*
        //showList(apriori.record);
        
        List<List<String>> CandidateItemset = apriori.findFirstCandidate();
        System.out.println("第一次扫描后的1级 备选集CandidateItemset");  
        showList(CandidateItemset);
        
        //************获取频繁1项集***************  
        List<List<String>> FrequentItemset = apriori.getSupprotedItemset(CandidateItemset);  
        System.out.println("第一次扫描后的1级 频繁集FrequentItemset"); 
        showList(FrequentItemset);
        
        //***************迭代过程**************  
        while(apriori.endTag!=true){  
            //**********连接操作****由k-1项频繁集      获取      候选k项集**************  
            List<List<String>> nextCandidateItemset = apriori.getNextCandidate(FrequentItemset);  
              
            System.out.println("扫描后备选集");  
            showList(nextCandidateItemset);
              
            //**************减枝操作***由候选k项集       获取     频繁k项集****************  
            List<List<String>> nextFrequentItemset = apriori.getSupprotedItemset(nextCandidateItemset);  
              
            System.out.println("扫描后频繁集");  
            showList(nextFrequentItemset);
            //*********如果循环结束，输出最大模式**************  
            if(apriori.endTag == true){  
                System.out.println("Apriori算法--->频繁集");  
                showList(FrequentItemset);
            }  
            //****************下一次循环初值********************  
            CandidateItemset = nextCandidateItemset;  
            FrequentItemset = nextFrequentItemset;  
        } 
        
        */
        //System.out.println(list.toString());
    }
    
    static void showSqlResult(List<List<Object>> obj, SqlType[] types){
        for(int i=0;i<obj.size();i++){
            List<Object> items = obj.get(i);
            for(int j=0; j<types.length;j++){
                if(types[j] == SqlType.INT){
                    int item = (int)items.get(j);
                    System.out.print(item + " | ");
                }else if(types[j] == SqlType.DATE){
                    Date item = (Date)items.get(j);  
                    System.out.print(item + " | ");
                }else if(types[j] == SqlType.DOUBLE){
                    double item = (double)items.get(j); 
                    System.out.print(item + " | ");
                }else if(types[j] == SqlType.FLOAT){
                    float item = (float)items.get(j); 
                    System.out.print(item + " | ");
                }else if(types[j] == SqlType.LONG){
                    long item = (long)items.get(j); 
                    System.out.print(item + " | ");
                }else if(types[j] == SqlType.SHORT){
                    short item = (short)items.get(j); 
                    System.out.print(item + " | ");
                }else if(types[j] == SqlType.STRING){
                    String item = (String)items.get(j); 
                    System.out.print(item + " | ");
                }else if(types[j] == SqlType.TIME){
                    Time item = (Time)items.get(j); 
                    System.out.print(item + " | ");
                }else if(types[j] == SqlType.TIMESTAMP){
                    Timestamp item = (Timestamp)items.get(j); 
                    System.out.print(item + " | ");
                }
            }
            System.out.println();
        }
       
    }
    
    static void showList(List<List<String>> lists){
        for(int i=0;i<lists.size();i++){
            for(int j=0;j<lists.get(i).size();j++){
                System.out.print(lists.get(i).get(j)+" | ");
            }
            System.out.println();
        }
    }
    
    static void showTime(Time time){
        System.out.println(time.getHours()+":"+time.getMinutes()+":"+time.getSeconds());
    }
    
}
