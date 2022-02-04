/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Banco;

import Interfaz.Imprimible;
import Persoa.Persoa;

/**
 *
 * @author DAW
 */
public abstract class ContaBancaria implements Imprimible {
    public enum TipoConta {AFORRO, EMPRESA, PERSOAL}
    protected Persoa titular;
    protected double saldo;
    protected String numCuenta;
    protected TipoConta tipoConta;

    public ContaBancaria(Persoa titular, double saldo, String numCuenta, TipoConta tipoConta) {
        this.titular = titular;
        this.saldo = saldo;
        this.numCuenta = numCuenta;
        this.tipoConta = tipoConta;
    }

    

}
