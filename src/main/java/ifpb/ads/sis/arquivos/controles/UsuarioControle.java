/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.sis.arquivos.controles;

import ifpb.ads.sis.arquivos.beans.User;
import ifpb.ads.sis.arquivos.daos.Dao;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author recursive
 */
@SessionScoped
@Named("gerenciadorUsuario")
public class UsuarioControle implements Serializable{
    
    @Inject
    private Dao<User> dao;
    @Inject
    private User user;
    
    public void add(User user) throws SQLException{
        dao.add(user);
    }
    
    public void remove(User user) throws SQLException{
        dao.remove(user);
    }
    
    public void update(User user) throws SQLException{
        dao.update(user);
    }
    
    public User get(User user) throws SQLException{
        return dao.get(user.getLog());
    }
    
    public List<User> list() throws SQLException{
        return dao.list();
    }
    
}
