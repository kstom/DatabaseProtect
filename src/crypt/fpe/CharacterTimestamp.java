/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crypt.fpe;

import java.sql.Timestamp;

/**
 *
 * @author KSTOM
 */
public class CharacterTimestamp implements CharacterInterface{
    
    @Override
    public boolean isMatch(Object str) {
        if(str instanceof Timestamp)
            return true;
        else 
            return false;
    }

    @Override
    public Object objToInteger(Object obj) {
        Timestamp ts = (Timestamp)obj;
        return ts.getTime();
    }

    @Override
    public Object integerToObj(Object obj) {
        Timestamp ts = new Timestamp((long)obj);
        return ts;
    }

    
}
