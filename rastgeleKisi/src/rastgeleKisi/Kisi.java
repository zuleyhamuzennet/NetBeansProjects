/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rastgeleKisi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author muhammed
 */
public class Kisi {
    
    KimlikNo kimlik ;
    Telefon tel;
    IMEI imei ;
    String isimler;
    String Kisi;
 
    public Kisi(){
        dosyaOkuma();
        kimlik = new KimlikNo();
        tel = new Telefon();
        imei = new IMEI();
    }
    
    private void dosyaOkuma(){
        isimler ="";
        File fileRead = new File("random_isimler.txt");
           try
           {
               Scanner dosya = new Scanner(fileRead);
               int i =0;
               while(dosya.hasNextLine()) {
                   isimler+= dosya.nextLine()+"1";
               }
           }catch(FileNotFoundException File){
                System.out.println("Dosya Okunamadı ..: "+File.getMessage());
           }  
    }
    public String KisiOlustur(){
       Kisi="";
       Random random = new Random();
       String isim [] = isimler.split("1");
       Kisi += kimlik.kimlikNoOlustur()+" ";
       Kisi += isim[random.nextInt(isim.length-1)]+" ";
       Kisi += random.nextInt(99)+1+" ";
       Kisi += tel.TelUret()+"(";
       Kisi += imei.generateIMEI()+")";
       return Kisi;
    }
    
}
