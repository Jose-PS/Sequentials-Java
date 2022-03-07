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
public class Turismo extends Vehiculo {
    private int portas;
    private int kilometros;
    
    public Turismo(String matricula,String nome,String marca,String modelo,String cor,int portas,int kms) throws VehiculoException {
        super(matricula,nome,marca,modelo,cor);
        this.portas=portas;
        this.kilometros=kms;
    }
    
    @Override
    public String toString() {
        String str=super.toString();
        str+=" "+portas+" portas "+kilometros+"Kms";
        return str;
    }
}
