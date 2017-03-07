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
public class CharacterTime implements CharacterInterface{
    Time time;
    
    public CharacterTime(Time time){
        this.time = time;
    }
    
    @Override
    public boolean isMatch(Object time) {
        if(time instanceof Time)
            return true;
        else
            return false;
    }
    
    @Override
    public Object objToInteger(Object obj){
        Time time = (Time)obj;
        return time.getTime();
    }
    
    @Override
    public Object integerToObj(Object obj){
        long time = (long)obj;
        return new Time(time);
    }

   

    
}
