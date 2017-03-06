/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package associationrule.apriori;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author KSTOM
 */
public class Apriori {
    private double MIN_SUPPORT = 0.05; //最小支持度
    private boolean endTag = false; //循环状态
    private List<List<String>> record = null; //数据集
    private List<List<String>> asso_rul = null;
    
    
    public Apriori(List<String> list){
        setRecord(list);
        List<List<String>> CandidateItemset = this.findFirstCandidate();
         
        //************获取频繁1项集***************  
        List<List<String>> FrequentItemset = this.getSupprotedItemset(CandidateItemset);  
        
        //***************迭代过程**************  
        while(this.endTag!=true){  
            //**********连接操作****由k-1项频繁集      获取      候选k项集**************  
            List<List<String>> nextCandidateItemset = this.getNextCandidate(FrequentItemset);  
              
            //**************减枝操作***由候选k项集       获取     频繁k项集****************  
            List<List<String>> nextFrequentItemset = this.getSupprotedItemset(nextCandidateItemset);  
              
            
            //*********如果循环结束，输出最大模式**************  
            if(this.endTag == true){  
                this.asso_rul = FrequentItemset;
            }  
            //****************下一次循环初值********************  
            CandidateItemset = nextCandidateItemset;  
            FrequentItemset = nextFrequentItemset;  
        } 
    }
    
    
    
    public List<List<String>> getResult(){
        return asso_rul;
    }
    
    private void setRecord(List<String> list){
        List<List<String>> record = new ArrayList<List<String>>(); 
        for(int i=0;i<list.size();i++){
            String item = list.get(i);
            item = item.substring(1, item.length()-1);
            String[] splititem = item.split(",");
            List<String> lineList = new ArrayList<String>();
            for(int k=0;k<splititem.length;k++){
                lineList.add(splititem[k]);
            }
            record.add(lineList);
        }
        this.record = record;
    }
    
    /** 
     * 有当前频繁项集自连接求下一次候选集 
     * @param FrequentItemset 
     * @return 
     */  
    private List<List<String>> getNextCandidate(List<List<String>> FrequentItemset) {  
        List<List<String>> nextCandidateItemset = new ArrayList<List<String>>();  
        for (int i=0; i<FrequentItemset.size(); i++){  
              
            HashSet<String> hsSet = new HashSet<String>();  
            HashSet<String> hsSettemp = new HashSet<String>();  
            for (int k=0; k< FrequentItemset.get(i).size(); k++)//获得频繁集第i行  
                hsSet.add(FrequentItemset.get(i).get(k));  
            int hsLength_before = hsSet.size();//添加前长度  
            hsSettemp=(HashSet<String>) hsSet.clone();  
            for(int h=i+1; h<FrequentItemset.size(); h++){//频繁集第i行与第j行(j>i)连接   每次添加且添加一个元素组成    新的频繁项集的某一行，     
                hsSet=(HashSet<String>) hsSettemp.clone();//！！！做连接的hasSet保持不变  
                for(int j=0; j< FrequentItemset.get(h).size();j++)  
                    hsSet.add(FrequentItemset.get(h).get(j));  
                int hsLength_after = hsSet.size();            
                if(hsLength_before+1 == hsLength_after && isSubsetOf(hsSet,record)==1 && isnotHave(hsSet,nextCandidateItemset)){  
                    //如果不相等，表示添加了1个新的元素，再判断其是否为record某一行的子集     若是则其为  候选集中的一项  
                    Iterator<String> itr = hsSet.iterator();  
                    List<String>  tempList = new ArrayList<String>();  
                    while(itr.hasNext()){  
                        String Item = (String) itr.next();  
                        tempList.add(Item);  
                    }  
                    nextCandidateItemset.add(tempList);  
                }  
                      
            }  
              
        }  
        return nextCandidateItemset;  
    }  
    /** 
     * 判断新添加元素形成的候选集是否在  新的候选集中 
     * @param hsSet 
     * @param nextCandidateItemset 
     * @return 
     */  
    private boolean isnotHave(HashSet<String> hsSet,  
            List<List<String>> nextCandidateItemset) {  
        // TODO Auto-generated method stub  
        List<String>  tempList = new ArrayList<String>();  
        Iterator<String> itr = hsSet.iterator();  
        while(itr.hasNext()){  
            String Item = (String) itr.next();  
            tempList.add(Item);  
        }  
        for(int i=0; i<nextCandidateItemset.size();i++)  
            if(tempList.equals(nextCandidateItemset.get(i)))  
                return false;  
        return true;  
    }  

    /** 
     * 判断hsSet是不是record2中的某一记录子集 
     * @param hsSet 
     * @param record2 
     * @return 
     */  
    private int isSubsetOf(HashSet<String> hsSet,  
            List<List<String>> record2) {  
        //hsSet转换成List  
        List<String>  tempList = new ArrayList<String>();  
        Iterator<String> itr = hsSet.iterator();  
        while(itr.hasNext()){  
            String Item = (String) itr.next();  
            tempList.add(Item);  
        }         
          
        for(int i=0;i<record.size();i++){  
            List<String>  tempListRecord = new ArrayList<String>();  
            for(int j=0;j<record.get(i).size();j++)  
                tempListRecord.add(record.get(i).get(j));  
            if(tempListRecord.containsAll(tempList))  
                return 1;  
            }  
        return 0;  
    }  
    
    /** 
     * 由k项候选集剪枝得到k项频繁集 
     * @param CandidateItemset 
     * @return 
     */  
    private List<List<String>> getSupprotedItemset(List<List<String>> CandidateItemset) {  
        // TODO Auto-generated method stub  
        boolean end = true;  
        List<List<String>> supportedItemset = new ArrayList<List<String>>();  
        int k = 0;  
          
        for (int i = 0; i < CandidateItemset.size(); i++){  
              
            int count = countFrequent(CandidateItemset.get(i));//统计记录数  
              
            if (count >= this.MIN_SUPPORT * (record.size()-1)){     
                supportedItemset.add(CandidateItemset.get(i));  
                end = false;  
            }  
        }  
        endTag = end;//存在频繁项集则不会结束  
        if(endTag==true)  
            System.out.println("无满足支持度项集,结束连接");  
        return supportedItemset;  
    }  
  
    /** 
     * 统计record中出现list集合的个数 
     * @param list 
     * @return 
     */  
    private int countFrequent(List<String> list) {  
        // TODO Auto-generated method stub  
        int count = 0;  
        for(int i = 0; i<record.size(); i++) {  
              
            boolean notHaveThisList = false;  
              
            for (int k=0; k < list.size(); k++){//判断record.get(i)是否包含list  
                boolean thisRecordHave = false;  
                for(int j=0; j<record.get(i).size(); j++){  
                    if(list.get(k).equals(record.get(i).get(j)))//list。get(k)在record。get(i)中能找到  
                        thisRecordHave = true;  
                }  
                if(!thisRecordHave){//只要有一个list元素找不到，则退出其余元素比较,进行下一个record。get(i)比较  
                    notHaveThisList = true;  
                    break;  
                }  
            }  
              
            if(notHaveThisList == false)  
                count++;  
              
        }  
        return count;  
    }  
          
    /** 
     * 获得一项候选集 
     * @return 
     */  
    private List<List<String>> findFirstCandidate() {  
        // TODO Auto-generated method stub  
        List<List<String>> tableList = new ArrayList<List<String>>();  
        HashSet<String> hs  = new HashSet<String>();  
        for (int i = 0; i<record.size(); i++){  //第一行为商品信息  
            for(int j=0;j<record.get(i).size();j++){  
                hs.add(record.get(i).get(j));  
            }  
        }     
        Iterator<String> itr = hs.iterator();  
        while(itr.hasNext()){  
            List<String>  tempList = new ArrayList<String>();  
            String Item = (String) itr.next();  
            tempList.add(Item);  
            tableList.add(tempList);  
        }  
        return tableList;  
    }  
    
    
}
