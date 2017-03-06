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
public class CteEncryption {
    private long key=1234;
    CharacterInterface chaInter;
    private String ref="aap";
    
    public CteEncryption(CharacterInterface chaInter){
        this.chaInter = chaInter;
    }
    
    public CteEncryption(CharacterInterface chaInter, long key){
        this.chaInter = chaInter;
        this.key = key;
    }
       
    public String Encoding_s(String plaintext){
        plaintext = chaInter.before(plaintext);
        if(!chaInter.isMatch(plaintext)){
            System.out.println("the format is error!! can not encrypt!!");
            return "";
        }
        long pref = this.stringToLong(this.ref);
        long pstr = this.stringToLong(plaintext);
        //System.out.println(this.max_num);
        long num = (chaInter.getMaxnum(plaintext.length()) + pstr - pref)%chaInter.getMaxnum(plaintext.length());
        long enc_num = this.IntegerFpe(num, this.key);
        return this.longToString(enc_num);
           
    }
    
    public String Decoding_s(String ciphertext){
        if(!chaInter.isMatch(ciphertext)){
            System.out.println("the format is error!! can not decrypt!!");
            return "";
        }
        long num = this.stringToLong(ciphertext);
        long pref = this.stringToLong(this.ref);
        long num_dec = this.IntegerFpe(num, this.key);
        long pstr = (pref + num_dec) % chaInter.getMaxnum(ciphertext.length());
        String plaintext = chaInter.after(this.longToString(pstr));
        return plaintext;

    }

    
    private long IntegerFpe(long encoded,long key){
        long ciphertext = encoded ^ key;    
        return ciphertext;
    }
    

    public String longToString(long num) {
        String str="";
        while(num != 0){            
            str = (chaInter.longToChar(num%chaInter.getRange())) + str;
            num = num / chaInter.getRange();
        }
        return str;
    }

    public long stringToLong(String str) {
        long num = 0; 
        long trange = 1;
        for(int i=str.length()-1;i>=0;i--){
            num = num + chaInter.charToLong(str.charAt(i))*trange;
            trange *= chaInter.getRange();
        }
        return num;
    }
    
}
