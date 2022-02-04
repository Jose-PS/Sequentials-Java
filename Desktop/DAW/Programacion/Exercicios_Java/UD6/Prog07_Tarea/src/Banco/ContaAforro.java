/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Banco;

import Persoa.Persoa;

/**
 *
 * @author DAW
 */
public class ContaAforro extends ContaBancaria {

    private double tipoInteres;

    public ContaAforro(Persoa titular, double saldo, String numCuenta, double tipoInteres, TipoConta tipoConta) {
        super(titular, saldo, numCuenta, tipoConta);
        this.tipoInteres = tipoInteres;
    }

    @Override
    public String devolverInfoString() {
        return "Titular: " + titular.devolverInfoString() + "\n"
                + "Numero: " + numCuenta + ", Tipo Interes: " + tipoInteres+ "Tipo de conta: " + tipoConta+", Saldo: "+saldo;
    }

}
