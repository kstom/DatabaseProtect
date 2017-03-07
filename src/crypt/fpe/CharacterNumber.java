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
public class CharacterNumber implements CharacterInterface{

    @Override
    public boolean isMatch(Object str) {
        return true;
    }

    @Override
    public Object objToInteger(Object obj) {
        return obj;
    }

    @Override
    public Object integerToObj(Object obj) {
        return obj;
    }
    
}
