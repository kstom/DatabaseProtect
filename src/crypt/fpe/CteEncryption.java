/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crypt.fpe;

import java.sql.Time;


/**
 *
 * @author KSTOM
 */
public class CteEncryption {
    private long key=12345;
    //CharacterInterface chaInter;
    //private Object ref;
    
    //public CteEncryption(CharacterInterface chaInter){
        //this.chaInter = chaInter;
        //this.ref = ref;
    //}
    
    public CteEncryption(long key){
        //this.chaInter = chaInter;
        //this.ref = ref;
        this.key = key;
    }
    public Object Encoding(CharacterInterface chaInter, Object plaintext){
        if(!chaInter.isMatch(plaintext)){
            System.out.println("the format is error!! can not encrypt!!");
            return "";
        }
        if(plaintext instanceof String){
            plaintext = "b"+plaintext;
        }
        long num = (long)chaInter.objToInteger(plaintext);
        long ciphernum = CryptologyDE.Encryption(num, key);
        Object ciphertext = chaInter.integerToObj(ciphernum);
        
        return ciphertext;
    }
    
    public Object Decoding(CharacterInterface chaInter, Object ciphertext){
        if(!chaInter.isMatch(ciphertext)){
            System.out.println("the format is error!! can not encrypt!!");
            return "";
        }
        long num = (long)chaInter.objToInteger(ciphertext);
        long plainnum = CryptologyDE.Decryption(num, key);
        Object plaintext = chaInter.integerToObj(plainnum);
        
        if(plaintext instanceof String)
            plaintext = ((String)plaintext).substring(1);
        
        return plaintext;
    }
    
/*
    public Time Encoding_time(Time time){
        return Encoding_time(time,this.key);
    }
    
    public Time Encoding_time(Time time, long key){
        long time_int = (long)chaInter.objToInteger(time);
        long ciphertext = CryptologyDE.Encryption(time_int, key);
        Time time_cipher = (Time)chaInter.integerToObj(ciphertext);
        return time_cipher;
    }
    
    public Time Decoding_time(Time time){
        return Decoding_time(time, this.key);
    }
    public Time Decoding_time(Time time, long key){
        long time_int = (long)chaInter.objToInteger(time);
        long ciphertext = CryptologyDE.Decryption(time_int, key);
        Time time_cipher = (Time)chaInter.integerToObj(ciphertext);
        return time_cipher;
    }
    
    public String Encoding_s(String plaintext){
        return this.Encoding_s(plaintext,this.key);
    }
    
    public String Encoding_s(String plaintext, long key){
        plaintext = 'b'+plaintext;
        if(!chaInter.isMatch(plaintext)){
            System.out.println("the format is error!! can not encrypt!!");
            return "";
        }
        long num = (long)chaInter.objToInteger(plaintext);
              
        long enc_num = this.Encoding_long(num, this.key);
        
        return (String)chaInter.integerToObj(enc_num);
           
    }
    
    public String Decoding_s(String ciphertext){
        return this.Decoding_s(ciphertext, this.key);
    }
    
    public String Decoding_s(String ciphertext, long key){
        if(!chaInter.isMatch(ciphertext)){
            System.out.println("the format is error!! can not decrypt!!");
            return "";
        }
        long num = (long)chaInter.objToInteger(ciphertext);
        //long pref = this.stringToLong(this.ref);

        long num_dec = this.Decoding_long(num, this.key);
        //long pstr = (pref + num_dec) % chaInter.getMaxnum(ciphertext.length());      
        String plaintext = (String)chaInter.integerToObj(num_dec);      
        return plaintext.substring(1);
    }

    */
    

    
    
}
