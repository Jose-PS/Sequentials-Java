/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio2;

public interface Searchable {
    public String getId();  // Devolve o ID do Searchable
    public boolean is_this(String id); // Devolve true, si o String id corresponde co identificador do obxecto.
}

