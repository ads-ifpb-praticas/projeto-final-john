/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.sis.arquivos.daos;

/**
 *
 * @author john
 */
public interface Dao <T>{
    
    void add(T obj);
    void remove (T obj);
    void update (T obj);
    void list();
    void get(String key);
    
}
