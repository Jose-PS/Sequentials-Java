/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio3;

import exercicio1.VehiculoException;
import exercicio2.Store;
import exercicio2.StoreException;
import java.util.Scanner;

/**
 *
 * @author xavi
 */
public class Aplicacion {
    private Store store;
    
    Aplicacion(int maxnum) {
        store=new Store(maxnum);
    }
    
    void run() {
        char op;
        Menu m=new Menu("Menu Principal",new String[] {"1.-Alta de Vehiculo","2.-Xestión de Vehículo","3.-Sair"},"123",Menu.Direccion.HORIZONTAL);
        
        do {
            op=m.getOption();
            switch(op) {
                case '1': 
                    try {
                        altaVehiculo();
                    } catch (StoreException | VehiculoException ex) {
                        System.out.println("ERROR: "+ex.getMessage());
                    }                    
                    break;

                case '2':
                    xestionVehiculo();
                    break;
            }
            
        } while(op!='3');
    }
    
    void altaVehiculo() throws VehiculoException, StoreException {
        String matricula;
        Vehiculo v;
        Scanner scn=new Scanner(System.in);    
        System.out.println("Alta de Vehiculo");
        System.out.print("Matricula: ");
        matricula=scn.nextLine();
        v=new Vehiculo(matricula,null,null,null,null);
        modificaVehiculo(v);
        store.addSearchable(v);
    }
    
    public void modificaVehiculo(Vehiculo v) {
        Scanner scn=new Scanner(System.in);
        String info;
        
        System.out.print("Nome ["+v.getNome()+"]: ");
        info=scn.nextLine();
        if (info.length()>0) v.setNome(info);
        
        System.out.print("Marca ["+v.getMarca()+"]: ");
        info=scn.nextLine();
        if (info.length()>0) v.setMarca(info);
        
        System.out.print("Modelo ["+v.getModelo()+"]: ");
        info=scn.nextLine();
        if (info.length()>0) v.setModelo(info);
        
        System.out.print("Cor ["+v.getCor()+"]: ");
        info=scn.nextLine();
        if (info.length()>0) v.setCor(info);
    }

    
    void xestionVehiculo() {
        Scanner scn=new Scanner(System.in);
        String matricula;
        Vehiculo v;
        char op;
        Menu m=new Menu("Qué queres facer?: ",new String[] {"(m)odificar","(e)liminar","(c)ontinuar"},"mecMEC",Menu.Direccion.HORIZONTAL);
    
        System.out.print("Matricula do Vehiculo: ");
        matricula=scn.nextLine();
        v=(Vehiculo)store.search(matricula);
        if (v!=null) {
            System.out.println("Atopado: "+v);
            try {
                op=m.getOption();
                switch(op) {
                    case 'm':
                    case 'M':
                        System.out.println("Modificación do Vehículo con matrícula "+matricula);
                        modificaVehiculo(v);
                        break;
                    case 'e':
                    case 'E':
                        store.removeSearchable(v);
                        break;
                }
            } catch (StoreException ex) {
                System.out.println("ERROR: "+ex.getMessage());
            }
        } else System.out.println("O vehículo con matrícula "+matricula+" non existe");
    }
    
    public static void main(String[] args) {
        Aplicacion app=new Aplicacion(10);
        app.run();
    }
}
