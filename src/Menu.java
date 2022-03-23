
import Noticia.ArquivoNoticias;
import Noticia.Noticia;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author DAW
 */
public class Menu  {

    
    
    static Noticia creaNoticia (){
        Scanner lec = new Scanner(System.in);
        String titular;
        String entradilla;
        String corpo;
        System.out.println("Introduce o titulo: ");
        titular=lec.nextLine();
        System.out.println("Introduce a entradilla: ");
        entradilla=lec.nextLine();
        System.out.println("Introduce o corpo: ");
        corpo=lec.nextLine();
        return new Noticia(titular, entradilla, corpo);
    }

    public static void main(String[] args) {
        try {
            ArquivoNoticias a=new ArquivoNoticias();
            Noticia n;
            int opt = 0;
            do{
                try {
                    Scanner lec = new Scanner(System.in);
                    System.out.println("1.-Engadir Noticia");
                    System.out.println("2.-Ver Noticias");
                    System.out.println("3.-Sair");
                    opt = Integer.parseInt(lec.nextLine());
                    switch (opt) {
                        case 1:
                            n=creaNoticia();
                            a.add(n, n.getCorpo());
                            break;
                        case 2:
                            Noticia[] list=a.listaNoticias();
                            for(Noticia ne:list){
                                System.out.println(ne);
                            }
                            System.out.println("Que noticia queres ver?");
                            mostraNoticia(Integer.parseInt(lec.nextLine()));
                            break;
                        case 3:
                            break;
                    }
                } catch (IOException ex) {
                    ex.getMessage();
                } catch (Exception ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }while(opt!=3);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
}

    private static void mostraNoticia(int pos) throws FileNotFoundException {
        Noticia n=new ArquivoNoticias().getNoticia(pos);
        System.out.println(n.getTitular()+"\n"+n.getEntradilla()+"\n"+n.getCorpo());  
    }
}
