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
public class Random {
    public String GetOrderID() {
        java.util.Random random = new java.util.Random();
        String xau = "0123456789";
        String res = "O";
        for (int i = 0; i <= 5; i++) {
            res += xau.charAt(random.nextInt(10));
        }
        return res;
    }
    public String GetOrderDetailsID() {
        java.util.Random random = new java.util.Random();
        String xau = "0123456789";
        String res = "D";
        for (int i = 0; i <= 5; i++) {
            res += xau.charAt(random.nextInt(10));
        }
        return res;
    }
    public String GetRandomNum(int n){
        java.util.Random random = new java.util.Random();
        String xau = "0123456789";
        String res = "";
        for (int i = 0; i <= n; i++) {
            res += xau.charAt(random.nextInt(xau.length()));
        }
        return res;
    }
    public String Getcode(){
        java.util.Random random = new java.util.Random();
        String xau = "0123456789QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvnbm";
        String res = "";
        for (int i = 0; i <= 5; i++) {
            res += xau.charAt(random.nextInt(xau.length()));
        }
        return res;
    }
}
