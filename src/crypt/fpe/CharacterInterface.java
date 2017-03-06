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
public interface CharacterInterface {
    public boolean isMatch(String str);
    
    public long getMaxnum(long dimension);
    
    public String before(String str);
    
    public String after(String str);
    
    public long charToLong(char ch);
    
    public char longToChar(long num);
    
    public int getRange();

}
