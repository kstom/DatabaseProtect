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
public class CharacterAscii implements CharacterInterface{
    private static final int range = 256;
    
    @Override
    public boolean isMatch(String str){
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
    public long getMaxnum(long dimension){
        long max_num = 1;
        for(int i=0;i<dimension;i++){
            max_num *= range;
        }
        return max_num;
    }
    
    @Override
    public String before(String str){
        return "b"+str;
    }
    
    @Override
    public String after(String str){
        if(str.length()>=1) 
            return str.substring(1);
        else
            return "";
    }
    
    @Override
    public long charToLong(char ch){
        return ((long)ch-97);
    }
    
    @Override
    public char longToChar(long num){
        return (char)(num+97);
    }

    @Override
    public int getRange() {
        return range;
    }
    
    
    
}
