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
public class CryptologyDE {
    static long Decryption(long cipherint,long key){
        long plainint = 0;
        plainint = cipherint^key;
        return plainint;
    }
    
    static long Encryption(long plainint,long key){
        long cipherint = 0;
        cipherint = plainint^key;
        return cipherint;
    }
/*    
    static int Decryption(int cipherint,int key){
        int plainint = 0;
        plainint = cipherint^key;
        return plainint;
    }
    
    static int Encryption(int plainint,int key){
        int cipherint = 0;
        cipherint = plainint^key;
        return cipherint;
    }
    
    static short Decryption(short cipherint,short key){
        short plainint = 0;
        plainint = (short)(cipherint^key);
        return plainint;
    }
    
    static short Encryption(short plainint,short key){
        short cipherint = 0;
        cipherint = (short)(plainint^key);
        return cipherint;
    }
    */
}
