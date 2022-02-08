/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Banco;

/**
 *
 * @author DAW
 */
public class Banco {

    private ContaBancaria[] contas = new ContaBancaria[100];
    private int pos;

    /**
     * Inserta unha conta bancaria no banco. Maximo 100 contas.
     *
     * @param cb
     * @return Devolve true ou false en funcion de se tivo exito.
     */
    public boolean abrirConta(ContaBancaria cb) {
        if (pos > contas.length) {
            return false;
        }
        contas[pos] = cb;
        pos++;
        return true;
    }

    /**
     * Lista as contas que hai no banco
     *
     * @return Devolve un array coa informacion de cada conta
     */
    public String[] listadoContas() {
        String[] lisContas = new String [pos];
        for (int i = 0; i < pos; i++) {
            lisContas [i] = contas [i].devolverInfoString();
        }
        return lisContas;
    }

    /**
     * Recibe un iban pra dar a informacion da conta.
     *
     * @param iban
     * @return Devolve un String coa informacion da conta ou null se non existe.
     */
    public String informacionConta(String iban) {
        String info = null;
        for (int i = 0; i < pos; i++) {
            if (contas [i].getIban().equals(iban)){
            return contas[i].devolverInfoString();
            }
        }
        return info;
    }

    /**
     * Introducindo o iban e a cantidade, fai o ingreso na conta indicada.
     *
     * @param iban
     * @param cant
     * @return devolve true ou false en funcion de como saiu a operacion.
     */
    public boolean ingresoConta(String iban, double cant) {
        for (int i = 0; i < pos; i++) {
            if (contas [i].getIban().equals(iban)){
            contas[i].setSaldo(contas[i].getSaldo()+cant);
            return true;          
            }
        }
        return false;
    }

    /**
     * Introducindo o iban e a cantidade, retira os cartos da conta indicada.
     *
     * @param iban
     * @param cant
     * @return Devolve true ou false en funcion de como saiu a operacion.
     */
    public boolean retiradaConta(String iban, double cant) {
        for (int i = 0; i < pos; i++) {
            if (contas [i].getIban().equals(iban)){
            contas[i].setSaldo(contas[i].getSaldo()-cant);
            return true;          
            }
        }
        return false;
    }

}
