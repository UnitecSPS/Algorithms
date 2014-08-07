package alg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ideras
 */
public class Util {

    public static SecureRandom sr = null;

    public static Integer[] GenerateRandomArray(int size, int min, int max) 
    {
        if (sr == null) {
            return null;
        }

        Integer[] result = new Integer[size];
        
        int n = (max - min) + 1;
        for (int i = 0; i < size; i++) {
            result[i] = (Math.abs(sr.nextInt()) % n) + min;
        }

        return result;
    }
    
    public static Integer StringToInt(String snumber) {
        int number = 0;
        
        try {
            number = Integer.parseInt(snumber, 10);
        } catch (NumberFormatException ex) {
            return null;
        }
        
        return new Integer(number);
    }

    public static void PrintArray(Comparable[] items) 
    {
        int count = 0;
        
        for (Comparable item : items) {
            System.out.print(item.toString());
            count ++;
            if (count == 64)
                System.out.println();
            else
                System.out.print(" ");
        }
    }
    
    public static Integer[] readArrayFromFile(String inFilePath) throws FileNotFoundException, IOException {
        Integer[] result;
        
        FileReader fr = new FileReader(new File(inFilePath));
        BufferedReader in = new BufferedReader(fr);
        
        String str = in.readLine();
        int arraySize = Integer.parseInt(str);
        
        result = new Integer[arraySize];
        
        for (int i=0; i<arraySize; i++) {
            str = in.readLine();
            int n = Integer.parseInt(str);
            result[i] = n;
        }
        
        return result;
    }

    static {
        try {
            sr = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException ex) {
            sr = null;
            System.out.println(ex.getMessage());
        }
    }
}
