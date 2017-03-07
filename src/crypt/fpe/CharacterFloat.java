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
public class CharacterFloat implements CharacterInterface{

    @Override
    public boolean isMatch(Object str) {
        if(str instanceof Float)
            return true;
        return false;
    }

    @Override
    public Object objToInteger(Object obj) {
        return (long)Float.floatToIntBits((float)obj);
    }

    @Override
    public Object integerToObj(Object obj) {
        long num = (long)obj;
        return Float.intBitsToFloat((int)num);
    }
    
}
