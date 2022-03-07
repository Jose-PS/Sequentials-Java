/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio2;

/**
 *
 * @author xavi
 */
public class Store {
    private Searchable[] store; // Almacén de obxectos Searchable
    private int nels; // Número de elmentos actualmente no almacén

    // Crea un Store cun espazo de almacenamento de un máximo de max elementos
    public Store(int max) {
        store=new Searchable[max];
        nels=0;
    }
    
    // Engade un obxecto Searchable a store (1 pto)
    public int addSearchable(Searchable obj) throws StoreException {
        // Si non cabe lanza StoreException
        if (nels>=store.length) throw new StoreException("Store is Full");
        store[nels]=obj;
        nels++;
        return (nels-1);
    }
    
    // Devolve o obxecto Searchable da posición idx de store. (1 pto)
    public Searchable getSearchable(int idx) throws StoreException {
        // Si idx >= nels lanza StoreException
        if ((idx<0)||(idx>=nels)) throw new StoreException("Element "+idx+" not exists");
        return store[idx];
    }
    
    
    // Pon o obxecto Searchable na posición idx de store (1 pto)
    public void setSearchable(int idx,Searchable v) throws StoreException {
        // Si idx >= nels lanza un StoreException
        if ((idx<0)||(idx>=nels)) throw new StoreException("Element "+idx+" not exists");
        store[idx]=v;
    }
    
    // Elimina o obxecto Searchable da posición idx do store movendo os elementos seguintes para ocupar o espazo.
    // Devolve o obxecto eliminado (1.5 pts)
    public Searchable removeSearchable(int idx) throws StoreException {
        // Si idx >= nels lanza un StoreException
        Searchable obj;
        
        if ((idx<0)||(idx>=nels)) throw new StoreException("Element "+idx+" not exists");
        obj=store[idx];
        remove(idx);
        return obj;
    }
    
    // Elimina o obxecto Searchable de store movendo os elementos seguintes para ocupar o espazo.
    // Devolve o obxecto eliminado (1pts)
    public Searchable removeSearchable(Searchable s) throws StoreException {
        // Si s non existe lanza un StoreException
        int idx=searchID(s.getId());
        return removeSearchable(idx);
    }
    
    // Devolve o obxecto Searchable correspondente co identificador id da lista ou null si non existe (1.5 pts)
    public Searchable search(String id) {
        // Si non está devolve null
        int idx=searchID(id);
        if (idx>=0) return store[idx];
        return null;
    }

    private void remove(int idx) {
        for(int x=idx;x<nels-1;x++) store[x]=store[x+1];
        store[nels-1]=null;
        nels--;
    }
    
    private int searchID(String id) {
        for(int idx=0;idx<nels;idx++)
            if (store[idx].is_this(id)) return idx;
        return -1;
    }
   
}
