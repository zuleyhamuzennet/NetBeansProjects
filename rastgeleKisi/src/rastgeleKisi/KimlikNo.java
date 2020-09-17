/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rastgeleKisi;

import java.util.Random;
import java.util.Vector;

/**
 *
 * @author muhammed
 */
public class KimlikNo {
    public String kimlikNoOlustur(){
          
            Vector<Integer> array = new Vector<Integer>();
            Random randomGenerator = new Random();

            array.add(new Integer(1 + randomGenerator.nextInt(9)));

            for (int i=1;i<9;i++) array.add(randomGenerator.nextInt(10));
            
            int t1 = 0;
            for (int i=0;i<9;i+=2) t1 += array.elementAt(i);

            int t2 = 0;
            for (int i=1;i<8;i+=2) t2 += array.elementAt(i);

            int x = (t1 * 7 - t2) % 10;

            array.add(new Integer(x));

            x=0;
            for(int i=0;i<10;i++) x+= array.elementAt(i);

            x= x % 10;
            array.add(new Integer(x));

            String res = "";
            for(int i=0;i<11;i++) res = res + Integer.toString(array.elementAt(i));

            return res;
    }
   public boolean kimlikDogrula(String kimlikNo) {
     if (kimlikNo.length() != 11)
          return false;
     int[] hane = new int[11];
     int toplam = 0;
     for (int i = 0; i < 11; i++) {
          hane[i] = Integer.parseInt(String.valueOf(kimlikNo.charAt(i)));
          toplam += hane[i];
     }
     toplam -= hane[10];
     if ((toplam % 10) != hane[10])
          return false;
     if (((hane[0] + hane[2] + hane[4] + hane[6] + hane[8]) * 7 + (hane[1] + hane[3] + hane[5] + hane[7]) * 9) % 10 != hane[9])
          return false;
     if (((hane[0] + hane[2] + hane[4] + hane[6] + hane[8]) * 8) % 10 != hane[10])
          return false;
     return true;
   }
}
