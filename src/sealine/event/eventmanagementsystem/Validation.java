/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sealine.event.eventmanagementsystem;

/**
 *
 * @author Teha
 */
public class Validation {
    public boolean isEmpty(String text){
        if(text==""|| text==" " || text==null){
            return true;
        }
        else{
            return false;
        }
    }
    
    /*public boolean isAlphebatic(String text){
        if()
    }*/
    
}
