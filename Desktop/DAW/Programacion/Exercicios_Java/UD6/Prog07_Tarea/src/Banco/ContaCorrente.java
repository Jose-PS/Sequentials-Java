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
public abstract class ContaCorrente extends ContaBancaria {

    private String[] listaEntidades;

    public ContaCorrente(Persoa titular, double saldo, String numCuenta, TipoConta tipoConta) {
        super(titular, saldo, numCuenta, tipoConta);
    }

    

}
