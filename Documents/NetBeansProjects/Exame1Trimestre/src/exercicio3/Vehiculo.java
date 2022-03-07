/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio3;

import exercicio1.VehiculoException;
import exercicio2.Searchable;

/**
 *
 * @author xavi
 */
public class Vehiculo implements Searchable {
    private final String matricula;
    private String nome;
    private String marca;
    private String modelo;
    private String cor;
    
    public Vehiculo(String matricula,String nome,String marca,String modelo,String cor) throws VehiculoException {
        this.matricula=validaMatricula(matricula);
        this.nome=nome;
        this.marca=marca;
        this.modelo=modelo;
        this.cor=cor;
    }
    
    @Override
    public String toString() {
        return "Vehiculo "+matricula+": "+nome+" ("+marca+") modelo "+modelo+", "+cor;
    }
    
    private String validaMatricula(String mat) throws VehiculoException {
        String letras;
        
        try {
            if (mat.length()!=7) throw new VehiculoException("A Matrícula non é válida, debe ser da forma 9999XXX");
            letras=mat.toUpperCase().substring(4);
            for(int idx=0;idx<3;idx++)
                if ((letras.charAt(idx)<'A')||(letras.charAt(idx)>'Z'))
                    throw new VehiculoException("A Matrícula non é válida, debe ser da forma 9999XXX");
            Integer.parseInt(mat.substring(0,4));
        } catch(NumberFormatException e) {
            throw new VehiculoException("A Matrícula non é válida, debe ser da forma 9999XXX");
        }
        return mat;
    }

    @Override
    public String getId() {
        return matricula;
    }

    @Override
    public boolean is_this(String id) {
        return matricula.equals(id);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
    
    
}
