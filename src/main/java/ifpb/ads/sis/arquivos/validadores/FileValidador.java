/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.sis.arquivos.validadores;

import ifpb.ads.sis.arquivos.beans.File;
import ifpb.ads.sis.arquivos.beans.User;
import ifpb.ads.sis.arquivos.daos.Dao;
import ifpb.ads.sis.arquivos.daos.FileDao;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author recursive
 */

public class FileValidador {
    
    public static boolean validarNome(String nome){
        if(nome==null||nome.isEmpty()) return false;
        Pattern pattern = Pattern.compile("[a-zA-Z]_!_#_-");
        Matcher matcher = pattern.matcher(nome);
        return matcher.matches();
    }
    
    public static boolean existi(String nome, User dono) throws ClassNotFoundException, SQLException{
        return identificadorFile(nome, dono.getLog()) != 0;
    }
    
    
    public static int identificadorFile(String nome, String dono) throws ClassNotFoundException, SQLException{
        Dao dao = new FileDao();
        List<File> arquivos = dao.list();
        for(File file: arquivos){
            if((file.getNome()==nome) && (file.getDono().getLog() == dono)){
                return file.getId();
            }
        }
        return 0;
    }
    
    
    
    
}
