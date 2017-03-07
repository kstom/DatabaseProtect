/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crypt.fpe;

import java.util.Date;

/**
 *
 * @author KSTOM
 */
public class CharacterDate implements CharacterInterface{

    @Override
    public boolean isMatch(Object str) {
        if(str instanceof Date)
            return true;
        return false;
    }

    @Override
    public Object objToInteger(Object obj) {
        Date date = (Date)obj;
        return date.getTime();       
    }

    @Override
    public Object integerToObj(Object obj) {
        long date = (long)obj;
        return new Date(date);
    }
    
}
