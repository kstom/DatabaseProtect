/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crypt.fpe;

/**
 *
 * @author KSTOM
 */
public class CharacteraTz implements CharacterInterface{
    private static final int range = 26;
    
    
  
    
    @Override
    public boolean isMatch(Object obj){
        String str = (String)obj;
        if(str.length()<1)
            return false;
        boolean match = true;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(!('a'<=ch && ch<='z')){
                match = false;
                return match;
            }
        }
        return match;
    }
    
    @Override
    public Object objToInteger(Object obj) {
        String str = (String)obj;
        return this.stringToLong(str);
    }

    @Override
    public Object integerToObj(Object obj) {
        long num = (long)obj;
        return this.longToString(num);
    }
    
    
    public long getMaxnum(Object obj){
        long dimension = (long)obj;
        long max_num = 1;
        for(int i=0;i<dimension;i++){
            max_num *= range;
        }
        return max_num;
    }
    

    public String before(Object obj){
        Object str = (String)obj;
        return "b"+str;
    }
    

    public String after(Object obj){
        String str = (String)obj;
        if(str.length()>=1) 
            return str.substring(1);
        else
            return "";
    }
    

    public long charToLong(Object obj){
        char ch = (char)obj;
        return ((long)ch-97);
    }
    

    public char longToChar(Object obj){
        long num = (long)obj;
        return (char)(num+97);
    }


    public int getRange() {
        return range;
    }

    
    
    public String longToString(long num) {
        String str="";
        while(num != 0){            
            str = (this.longToChar(num%this.getRange())) + str;
            num = num / this.getRange();
        }
        return str;
    }

    public long stringToLong(String str) {
        long num = 0; 
        long trange = 1;
        for(int i=str.length()-1;i>=0;i--){
            num = num + this.charToLong(str.charAt(i))*trange;
            trange *= this.getRange();
        }
        return num;
    }
    
}
