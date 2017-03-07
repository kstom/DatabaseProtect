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
    public boolean isMatch(Object str);
    
    public Object objToInteger(Object obj);
    
    public Object integerToObj(Object obj);

    /*
    public long getMaxnum(Object dimension);
    
    public String before(Object str);
    
    public String after(Object str);
    
    public long charToLong(Object ch);
    
    public char longToChar(Object num);
    
    public int getRange();
    */
}
