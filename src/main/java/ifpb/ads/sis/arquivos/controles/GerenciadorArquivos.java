/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.sis.arquivos.controles;

import ifpb.ads.sis.arquivos.beans.Documento;
import ifpb.ads.sis.arquivos.beans.User;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Base64;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author recursive
 */
public class GerenciadorArquivos implements Serializable{
    
    private static final String PATHNAME = "";
    
    public static Documento montarArquivo(Part part) throws IOException{
        byte[] bytes = new byte[(int)part.getSize()];
        new BufferedInputStream(part.getInputStream()).read(bytes);
        String fotoBase64 = Base64.getEncoder().encodeToString(bytes);
        Documento arquivo = new Documento();
        arquivo.setArquivo(fotoBase64);
        arquivo.setTamanho((int)part.getSize());
        arquivo.setTipo(part.getContentType());
        arquivo.setNome(part.getName());
        //captura dono
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) externalContext.getSession(true);
        User dono = (User)session.getAttribute("user");
        arquivo.setDono(dono);
        return arquivo;
    }
    
    public static File desmontarArquivo(Documento file) throws FileNotFoundException, IOException{
        byte[] fotoBytes = Base64.getDecoder().decode(file.getArquivo());
        new FileOutputStream((PATHNAME) + file.getArquivo().hashCode()+file.getTipo()).write(fotoBytes);
        File foto = new File(PATHNAME + file.getArquivo().hashCode());
        return foto;
    }
    
}
