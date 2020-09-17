/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rastgeleKisi;

import java.util.Random;

/**
 *
 * @author muhammed
 */
public class Telefon {
    
    private String telefonNo;
    private String telNo;
    private String [] alanKodu= {"501","502","503","504","505","506","507","530",
                         "531","532","533","534","535","536","537","538",
                         "539","541","542","543","544","545","546","549",
                         "551","552","553","554","555","556"};
    
    public Telefon()
    {
      
    }
    public String  TelUret(){
        telefonNo="";
        telefonNo+="0";
      
        Random rastgele = new Random();
        telefonNo+=alanKodu[rastgele.nextInt(29)];
        for(int i = 2 ; i<9;i++)
        {
            int sayi =rastgele.nextInt(9);
            telefonNo+=String.valueOf(sayi);
        }    
        return telefonNo;
    }
}
