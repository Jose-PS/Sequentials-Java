/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio3;

import java.util.Scanner;

/**
 *
 * @author xavi
 */
public class Menu {

    enum Direccion { HORIZONTAL, VERTICAL };
    
    private final String title;
    private final String[] options;
    private final String permitidos;
    private final Direccion direccion;
    
    Menu(String title, String[] options, String permitidos, Direccion direccion) {
        this.title=title;
        this.options=options;
        this.permitidos=permitidos;
        this.direccion=direccion;
    }
    
    public char getOption() {
        String opt;
        Scanner scn=new Scanner(System.in);
        do {
            System.out.print(title);
            next();
            for(int idx=0;idx<options.length;idx++) {
                System.out.print(options[idx]);
                next();
            }
            opt=scn.nextLine();
        } while (permitidos.indexOf(opt)<0);
        return opt.charAt(0);
    }
    
    private void next() {
        if (direccion==Direccion.HORIZONTAL) System.out.print(" ");
        else System.out.println();
    }
    
}
