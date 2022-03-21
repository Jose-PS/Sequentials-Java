/*
 * Esta clase permitirá ler e interpretar o comando do usuario
 */
package commander;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author xavi
 */
public class Commander {

    private String actual_path;

    // Crea o "Commander" na carpeta actual
    public Commander() throws IOException {
        // "." representa a carpeta actual
        File f = new File(".");
        actual_path = f.getCanonicalPath();
    }

    // Crea o "Commander" na carpeta que lle digamos
    public Commander(String path) {
        this.actual_path = path;
    }

    public String getPath() {
        return actual_path;
    }
    
    

    // Interpreta e leva a cabo o comando cmd
    /*
    e nos permita:
        movernos mediante o comando cd, 
        crear directorios co comando md
        crear arquivos co comando create 
        listar os arquivos mediante o comando ls
        renomear arquivos co comando ren
        eliminar arquivos co comando rm.
        Tamén debe permitir obter o tamaño e a data de modificación dun arquivo ou directorio co comando info
    
        Sería por exemplo:
            cd /hola
            md misdocs
            create documento.txt
            ls
            ren documento.txt documento.old
            rm documento.old
            info documento.txt
            
     */
    public Commander execute(String cmd) throws IOException {
        // Debemos separar o comando en comando e parámetros.
        String[] command = cmd.split("\\s+");
        if (command.length > 0) {
            switch (command[0].toUpperCase()) {
                case "LS":
                    listFiles();
                    break;
                case "CD":
                    if (command.length != 2) {
                        System.out.println("Respeta o formato: CD directorio");
                    } else {
                        actual_path = (command[1]);
                    }
                    break;
                case "MD":  
                    if (command.length!=2) System.out.println("Respeta o formato: MD nomeDirectorio");
                    else{
                        if (new File(actual_path+"/"+command[1]).mkdir())System.out.println("Directorio creado");
                        else System.out.println("Directorio non creado");
                    }
                    break;
                case "CREATE":
                    if (command.length!=2) System.out.println("Respeta o formato: CREATE nomeArquivo");
                    else {
                        if (new File(actual_path+"/"+command[1]).createNewFile())System.out.println("Documento creado");
                        else System.out.println("Houbo un erro");
                    }
                    break;
                case "REN":
                    if (command.length!=3)System.out.println("Respeta o formato: REN nomeArquivo nomeNovo");
                    else {
                        if ((new File(actual_path+"/"+command[2]).createNewFile())&&(new File(actual_path+"/"+command[1]).delete())){
                        System.out.println("Operacion realizada con exito");
                        }else System.out.println("Houbo un erro");  
                        }
                    break;
                case "INFO":
                    if (command.length!=2)System.out.println("Respeta o formato: INFO nomeArquivo");
                    else {
                        File f=new File(actual_path+"/"+command[1]);
                        System.out.println("Arquivo "+f.getName()+"Tamano "+f.length()+" Ultma modificacion: "+new Date(f.lastModified()));
                    }
                    break;
                case "RM":
                    if (command.length!=2)System.out.println("Respeta o formato: RM nomeArquivo");
                    else {
                        if (new File(actual_path+"/"+command[1]).delete()) System.out.println("Operacion realizada con exito");
                        else System.out.println("Houbo un erro");
            }
                    break;
                default:
                    throw new IllegalArgumentException("Command " + cmd + " not found");
            }

        }
        return this;
    }

    private void listFiles() {
        File[] files = new File(actual_path).listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.print("[d] ");
            }
            System.out.println(file.getName());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String cmd;
        try {
            Commander commander = new Commander();
            for (;;) {
                // TODO code application logic here
                System.out.print(commander.getPath() + "> ");
                cmd = scn.nextLine();
                if (cmd.equals("quit")) {
                    break;
                }
                commander = commander.execute(cmd);
            }
        } catch (IOException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

}
