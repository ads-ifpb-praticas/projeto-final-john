/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.sis.arquivos.controles;

import ifpb.ads.sis.arquivos.beans.SolicitacaoDocumento;
import ifpb.ads.sis.arquivos.daos.ISolicitacaoDao;
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
@Named
public class SolicitacaoControle implements Serializable{
    
    @Inject
    private ISolicitacaoDao dao;
    @Inject
    private SolicitacaoDocumento soliDocumento;
    
//    public void add(SolicitacaoDocumento soliDocumento) throws SQLException{
//        dao.add(soliDocumento);
//    }
//    
//    public void remove(SolicitacaoDocumento soliDocumento) throws SQLException{
//        dao.remove(soliDocumento);
//    }
//    
//    public void update(SolicitacaoDocumento soliDocumento) throws SQLException{
//        dao.update(soliDocumento);
//    }
//    
//    public SolicitacaoDocumento get(SolicitacaoDocumento soliDocumento) throws SQLException{
//        Integer identificador = soliDocumento.getId();
//        return dao.get(identificador.toString());
//    }
//    
//    public List<SolicitacaoDocumento> list() throws SQLException{
//        return dao.list();
//    }

    public ISolicitacaoDao getDao() {
        return dao;
    }

    public void setDao(ISolicitacaoDao dao) {
        this.dao = dao;
    }

    public SolicitacaoDocumento getSoliDocumento() {
        return soliDocumento;
    }

    public void setSoliDocumento(SolicitacaoDocumento soliDocumento) {
        this.soliDocumento = soliDocumento;
    }
    
    public String enviarSolicitacao(String remetente, String destinatario, int id){
        
    }
    
}
