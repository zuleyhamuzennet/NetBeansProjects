/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import rastgeleKisi.IMEI;
import rastgeleKisi.Telefon;
import rastgeleKisi.KimlikNo;
import rastgeleKisi.Kisi;
import rastgeleKisi.rastgeleKisi;
/**
 *
 * @author zuleyha -ilayda

 */

public class JavaApplication8 { 
    static void dosyaYaz(String deger){
        try{
                  File dosya = new File(deger);
                  FileWriter yazici = new FileWriter("Kisiler.txt",true);
                  
                  try (BufferedWriter yaz = new BufferedWriter(yazici)) {
                       yaz.write(deger); 
                       yaz.newLine();
                       
                  }
                  
            }
            catch (IOException hata){
                System.out.println("Dosya Yazma Islemi Basarisiz..: " + hata.getMessage());
            }
    }
    static void dosyaOku(){
        IMEI imei = new IMEI();
        KimlikNo kimlik = new KimlikNo();
        String Okunan ="";
        String dizim [] ;
        String Imeideger ="";
        int dogruImei=0;
        int yanlisImei=0;
        int dogruTc=0;
        int yanlisTc=0;
        int dizi [] = new int [15];
        File fileRead = new File("Kisiler.txt");
           try
           {
               Scanner dosya = new Scanner(fileRead);
               int i =0;
               while(dosya.hasNextLine()) {
                   Okunan = dosya.nextLine();
                   String trim = Okunan.trim();
                   String Imeitrim=trim.substring(trim.length()-16,trim.length()-1);
                 
                   if(imei.Check(Imeitrim))
                       dogruImei++;
                   else
                       yanlisImei++;
                   
                   String Kimliktrim=trim.substring(0,11);
                   if(kimlik.kimlikDogrula(Kimliktrim))
                       dogruTc++;
                   else
                       yanlisTc++;
               }
           }catch(FileNotFoundException File){
                System.out.println("Dosya Okunamadı ..: "+File.getMessage());
           }  
           System.out.println("IMEI KONTROL\n"+"Gecerli " + dogruImei + "\n" + "Gecersiz " + yanlisImei);
           System.out.println("Kimlik KONTROL\n"+"Gecerli " + dogruTc + "\n" + "Gecersiz " + yanlisTc);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int secim=0;
        // TODO code application logic here
        do
        {
            
            System.out.println("1-Rastgele Kişi Uret");
            System.out.println("2-Uretilmis Dosya Kontrol Et");
            System.out.println("3-Cıkıs");
            Scanner s = new Scanner(System.in);
            rastgeleKisi rastgeleKisi = new rastgeleKisi();

            secim = s.nextInt();
            if(secim==1)
            {
                System.out.println("Kişi Sayısı .. : ");
                int kisi = s.nextInt();
                for(int i = 0 ;i<kisi;i++ ) 
                {
                    String kisiler="";
                    kisiler=rastgeleKisi.rastgeleKisi();
                    dosyaYaz(kisiler);
                }
                System.out.println("Kisiler.txt olusturuldu");
            }
            else if(secim==2)
            {

                dosyaOku();
            }
        }while(secim!=3);
        
            
        
        
            
        
    }
    
}
