/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio1;

/**
 *
 * @author xavi
 */
public class Camion extends Vehiculo {
    private int tara;
    private int kilometros;
    
    public Camion(String matricula,String nome,String marca,String modelo,String cor,int tara,int kms) throws VehiculoException {
        super(matricula,nome,marca,modelo,cor);
        this.tara=tara;
        this.kilometros=kms;
    }
    
    @Override
    public String toString() {
        String str=super.toString();
        str+=" Tara: "+tara+" kgs "+kilometros+"Kms";
        return str;
    }
    
}
