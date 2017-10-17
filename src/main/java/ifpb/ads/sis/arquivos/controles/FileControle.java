/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.sis.arquivos.controles;

import ifpb.ads.sis.arquivos.beans.File;
import ifpb.ads.sis.arquivos.daos.Dao;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author recursive
 */
@RequestScoped
@Named("gerenciadorAquivos")
public class FileControle implements Serializable{
    
    @Inject
    private Dao<File> dao;
    @Inject
    private File arquivo;
    
    public void add(File arquivo) throws SQLException{
        dao.add(arquivo);
    }
    
    public void remove(File arquivo) throws SQLException{
        dao.remove(arquivo);
    }
    
    public void update(File arquivo) throws SQLException{
        dao.update(arquivo);
    }
    
    public File get(File arquivo) throws SQLException{
        Integer identificador = arquivo.getId();
        return dao.get(identificador.toString());
    }
    
    public List<File> list() throws SQLException{
        return dao.list();
    }
    
}
