/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Dell
 */
public class NameHelper {
    public static String GetName(){
        String name="gu_";
        Random ran=new Random();
        name+=ran.GetRandomNum(5);
        return name;
    }
}
