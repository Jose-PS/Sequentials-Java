package Noticia;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author DAW
 */
public class Noticia {
    private String titular;
    private String entradilla;
    private String corpo;
    private int pos;

    public Noticia(String titular, String entradilla, String corpo) {
        this.titular = titular;
        this.entradilla = entradilla;
        this.corpo = corpo;
    }
    
    public Noticia(){}

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }   

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getEntradilla() {
        return entradilla;
    }

    public void setEntradilla(String entradilla) {
        this.entradilla = entradilla;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    @Override
    public String toString() {
        return "["+pos+"]"+" "+titular+"\n"+entradilla;
    }
    
    
    
    
}
