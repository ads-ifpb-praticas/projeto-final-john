/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.sis.arquivos.controles;

import ifpb.ads.sis.arquivos.beans.Documento;
import ifpb.ads.sis.arquivos.beans.User;
import ifpb.ads.sis.arquivos.daos.IFileDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author recursive
 */
public class GerenciadorListaArquivos {
    
    public static List<Documento> meusAquivos(IFileDao dao) throws SQLException{
        //captura dono
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(true);
        User dono = (User)session.getAttribute("user");
        List<Documento> documentos = dao.list();
        List<Documento> meusDocumentos = new ArrayList<>();
        for(int i=0;documentos.size()>i;i++){
            if(documentos.get(i).getDono().getLog()==dono.getLog()){
                meusDocumentos.add(documentos.get(i));
            }
        }
        return meusDocumentos;
    }
    
    public static List<Documento> Aquivos(IFileDao dao) throws SQLException{
        //captura dono
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(true);
        User dono = (User)session.getAttribute("user");
        List<Documento> documentos = dao.list();
        return documentos;
    }
}
