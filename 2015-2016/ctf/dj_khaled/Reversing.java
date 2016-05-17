package dj_khaled;

import java.util.Base64;
import java.util.Scanner;

public class Reversing 
{
    public static String confuse(String w) 
    {
        String string = "";
        String[] bits = w.split("");
        for(int i = 0; i < bits.length; i++) 
        {
            char y = bits[i].charAt(0);
            y = (char)(Math.pow(y, 2) / 120);
            bits[i] = y + "";
            string += bits[i];
        }
        return string;
    }

    public static String confuse2(String w) 
    {
        byte[] b = w.getBytes();
        return Base64.getEncoder().encodeToString(b);
    }

    public static void check(String key) {
        String ans = confuse2(confuse(key));
        if(!ans.equals("TmRmcFpVbEtmZFU=")) {
            System.out.println("DJ Khaled is not impressed.");
        }
        else 
        {
            System.out.println("You have achieved the key to success! The flag is '" + key + "'");
        }
    }

    public static void main(String[]args) 
    {
        Scanner k = new Scanner(System.in);
        String ans = k.nextLine();
        check(ans);
    }
}
