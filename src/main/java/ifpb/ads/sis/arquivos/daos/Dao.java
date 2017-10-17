/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.sis.arquivos.daos;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author john
 * @param <T>
 */
public interface Dao <T> extends Serializable{
    
    void add(T obj) throws SQLException;
    void remove (T obj)throws SQLException;
    void update (T obj)throws SQLException;
    List<T> list()throws SQLException;
    T get(String key)throws SQLException;
    
}
