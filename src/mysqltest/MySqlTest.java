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
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import mysqlkit.JDBCconnect;
import mysqlkit.MySqlUtil;
/**
 *
 * @author KSTOM
 */
public class MySqlTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        long key = 12345;
        double db = 2.36;
        
        CharacterDouble cs = new CharacterDouble();
        
        CteEncryption CE = new CteEncryption(cs,key);
        
        double str1 = (double)CE.Encoding(db);
        
        System.out.println(str1);
        double str2 = (double)CE.Decoding(str1);
        System.out.println(str2);
        //你：100111101100000
        
        
        /*
        MySqlUtil sqlutil = new MySqlUtil(JDBCconnect.getConnect("groceries"));
        List<String> list = sqlutil.getTablesName();
        String[] items = new String[1];
        items[0] = "items";
        list = sqlutil.onSelect("inventory",items);
        
        Apriori apriori = new Apriori(list);
        
        List<List<String>> result = apriori.getResult();
        
        showList(result);
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
