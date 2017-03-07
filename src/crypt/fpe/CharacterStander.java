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
public class CharacterStander implements CharacterInterface{
    private static final int range = 63; 
    
    
    
    @Override
    public boolean isMatch(Object obj){
        String str = (String)obj;
        if(str.length()<1)
            return false;
        boolean match = true;
        
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(!(('A'<=ch && ch<='Z') || ('a'<=ch && ch<='z') || ('0'<=ch && ch<='9') || (ch == '_'))){
                match = false;
                return match;
            }
        }
        return match;
    }
    
    @Override
    public Object objToInteger(Object obj) {
        String ciphertext = (String)obj;
        return this.stringToLong(ciphertext);
    }

    @Override
    public Object integerToObj(Object obj) {
        long num = (long)obj;
        return this.longToString(num);
    }
    
    

    public long getMaxnum(Object obj) {
        long dimension = (long)obj;
        long max_num = 1;
        for(int i=0;i<dimension;i++){
            max_num *= range;
        }
        return max_num;
    }


    public String before(Object obj) {
        String str = (String)obj;
        return '0'+str;
    }

    public String after(Object obj) {
        String str = (String)obj;
        if(str.length()>=1) 
            return str.substring(1);
        else
            return "";
    }

    public long charToLong(Object obj) {
        char ch = (char)obj;
        if(ch == '_'){
            return 0;
        }else if('0'<=ch && ch<='9'){
            return (long)ch-47;
        }else if('A'<=ch && ch<='Z' ){
            return (long)ch-54;
        }else if('a'<=ch && ch<='z'){
            return (long)ch-60;
        }
        return 0;
    }

    public char longToChar(Object obj) {
        long num = (long)obj;
        if(num == 0){
            return '_';
        }else if(((long)'0'-47)<=num && num<=((long)'9'-47)){
            return (char)(num+47);
        }else if(((long)'A'-54)<=num && num<=((long)'Z'-54) ){
            return (char)(num+54);
        }else if(((long)'a'-60)<=num && num<=((long)'z'-60)){  
            return (char)(num+60);
        }
        return 0;
    }

    public int getRange() {
        return range;
    }

    public String longToString(long num) {
        String str="";
        //System.out.println("long : "+ num);
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
