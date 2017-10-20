/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.sis.arquivos.controles;

import ifpb.ads.sis.arquivos.beans.Documento;
import ifpb.ads.sis.arquivos.daos.IFileDao;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;
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
    private Documento arquivo;
    private Part part;
    private List<Documento> meusDocumentos;
    private List<Documento> documentos;
    

    private static final Logger logger = Logger.getLogger("FileControler");
    
    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }
    
    
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

    public Documento getArquivo() {
        return arquivo;
    }

    public void setArquivo(Documento arquivo) {
        this.arquivo = arquivo;
    }

    
    public void downloadArquivo(int id, String nome, String dono){
        File arquivo = new File("/Users/rponte/minha-foto.png");
        
        int tamanho = (int) arquivo.length();

        //response.setContentType("image/png"); // tipo do conteúdo
        //response.setContentLength(tamanho);  // opcional
        //response.setHeader("Content-Disposition", "attachment; filename=\"" + nome + "\"");

        //OutputStream output = response.getOutputStream();
        //Files.copy(path, output);
    }

    public String salvarArquivo(){
        try {
            logger.info("iniciando upload do arquivo");
            //logger.info("iniciando upload do arquivo"+ this.part.getName());
            Documento doc = GerenciadorArquivos.montarArquivo(this.part);
            logger.info("iniciando upload do arquivo 111");
            this.dao.add(doc);
        } catch (IOException | SQLException ex) {
            Logger.getLogger(FileControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "home?faces-redirect=true";
    }
    
    public String getMeusDocumentos(){
        try {
            this.meusDocumentos = GerenciadorListaArquivos.meusAquivos(this.dao);
        } catch (SQLException ex) {
            Logger.getLogger(FileControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "meusarquivos?faces-redirect=true";
    }
    
    public String Todosdocumentos(){
        try {
            this.documentos = GerenciadorListaArquivos.Aquivos(this.dao);
        } catch (SQLException ex) {
            Logger.getLogger(FileControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "meusarquivos?faces-redirect=true";
    }
    
}
