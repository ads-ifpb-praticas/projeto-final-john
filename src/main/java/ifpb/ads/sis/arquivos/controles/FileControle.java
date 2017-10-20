/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.sis.arquivos.controles;

import ifpb.ads.sis.arquivos.beans.Documento;
import ifpb.ads.sis.arquivos.daos.IFileDao;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

/**
 *
 * @author recursive
 */
@RequestScoped
@Named
public class FileControle implements Serializable{
    
    @Inject
    private IFileDao dao;
    @Inject
    private List<Documento> arquivo;
    
//    public void add(Documento arquivo) throws SQLException{
//        dao.add(arquivo);
//    }
//    
//    public void remove(Documento arquivo) throws SQLException{
//        dao.remove(arquivo);
//    }
//    
//    public void update(Documento arquivo) throws SQLException{
//        dao.update(arquivo);
//    }
//    
//    public Documento get(Documento arquivo) throws SQLException{
//        Integer identificador = arquivo.getId();
//        return dao.get(identificador.toString());
//    }
//    
//    public List<File> list() throws SQLException{
//        return dao.list();
//    }

    public IFileDao getDao() {
        return dao;
    }

    public void setDao(IFileDao dao) {
        this.dao = dao;
    }

    public List<Documento> getArquivo() {
        return arquivo;
    }

    public void setArquivo(List<Documento> arquivo) {
        this.arquivo = arquivo;
    }

    public String salvarArquivo(Part part){
        try {
            GerenciadorArquivos.montarArquivo(part);
        } catch (IOException ex) {
            Logger.getLogger(FileControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "home?faces-redirect=true";
    }
}
