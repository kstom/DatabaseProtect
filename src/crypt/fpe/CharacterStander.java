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
    public boolean isMatch(String str){
        if(str.length()<1)
            return false;
        boolean match = true;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(!('A'<=ch && ch<='Z') || ('a'<=ch && ch<='z') || ('0'<=ch && ch<='9') || (ch == '_')){
                match = false;
                return match;
            }
        }
        return match;
    }
    
    @Override
    public long getMaxnum(long dimension) {
        long max_num = 1;
        for(int i=0;i<dimension;i++){
            max_num *= range;
        }
        return max_num;
    }

    @Override
    public String before(String str) {
        return '0'+str;
    }

    @Override
    public String after(String str) {
        if(str.length()>=1) 
            return str.substring(1);
        else
            return "";
    }

    @Override
    public long charToLong(char ch) {
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

    @Override
    public char longToChar(long num) {
        if(num == (long)'_'){
            return 0;
        }else if((long)'0'<=num && num<=(long)'9'){
            return (char)(num+47);
        }else if((long)'A'<=num && num<=(long)'Z' ){
            return (char)(num+54);
        }else if((long)'a'<=num && num<=(long)'z'){
            return (char)(num+60);
        }
        return 0;
    }

    @Override
    public int getRange() {
        return range;
    }
    
}
