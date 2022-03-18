
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author DAW
 */
public class Menu  {

    static void creaArquivos() throws IOException {
        File news = new File("News.dat");
        File newsDetails = new File("NewsDetails.dat");
        if (!news.exists()) {
            news.createNewFile();
        }
        if (!newsDetails.exists()) {
            newsDetails.createNewFile();
        }
    }
    
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
        BufferedWriter bw=null;
        BufferedReader br=null;
        Noticia n;
        int opt = 0;
        do{
        try {
            creaArquivos();
            Scanner lec = new Scanner(System.in);
            System.out.println("1.-Engadir Noticia");
            System.out.println("2.-Ver Noticias");
            System.out.println("3.-Sair");
            opt = Integer.parseInt(lec.nextLine());
            switch (opt) {
                case 1:
                    n=creaNoticia();
                    bw=new BufferedWriter(new FileWriter("news.dat"));
                    bw.write(n.getTitular()+"\n");
                    bw.write(n.getEntradilla()+"\n");
                    bw.flush();
                    bw.close();
                    break;
                case 2:
                    br=new BufferedReader(new FileReader("news.dat"));
                    System.out.println(br.readLine());
                    break;
                case 3:
                    break;
            }
        } catch (IOException ex) {
            ex.getMessage();
        } 
    }while(opt!=3);
}
}
