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
public class Motocicleta extends Vehiculo {
    private int cilindrada;
    
    public Motocicleta(String matricula,String nome,String marca,String modelo,String cor,int cilindrada) throws VehiculoException {
        super(matricula,nome,marca,modelo,cor);
        this.cilindrada=cilindrada;
    }
    
    @Override
    public String toString() {
        String str=super.toString();
        str+=" "+cilindrada+"cc";
        return str;
    }
}
