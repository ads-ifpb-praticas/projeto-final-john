/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.sis.arquivos.validadores;

import ifpb.ads.sis.arquivos.beans.User;
import ifpb.ads.sis.arquivos.daos.Dao;
import ifpb.ads.sis.arquivos.daos.UserDao;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author recursive
 */
public class Usuariovalidador {
    
    public static boolean validarNome(String log){
        if(log==null|| log.isEmpty()) return false;
        Pattern pattern = Pattern.compile("[a-zA-Z]_!_#_-");
        Matcher matcher = pattern.matcher(log);
        return matcher.matches();
    }
    
    public static boolean existe(String log) throws ClassNotFoundException, SQLException{
        Dao dao = new UserDao();
        User user = (User) dao.get(log);
        return user!=null;
    }
    
}
