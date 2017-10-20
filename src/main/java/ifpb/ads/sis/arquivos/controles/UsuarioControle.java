/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.sis.arquivos.controles;

import ifpb.ads.sis.arquivos.beans.User;
import ifpb.ads.sis.arquivos.daos.Dao;
import ifpb.ads.sis.arquivos.daos.IUserDao;
import ifpb.ads.sis.arquivos.validadores.Usuariovalidador;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author recursive
 */
@SessionScoped
@Named
public class UsuarioControle implements Serializable{
    
    @Inject
    private IUserDao dao;
    @Inject
    private User user;
    
    public static final Logger logger = Logger.getLogger(UsuarioControle.class);
    
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

    public Dao<User> getDao() {
        return dao;
    }

    public void setDao(IUserDao dao) {
        this.dao = dao;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public String logar(String log, String senha){
        logger.info("iniciando login do usuario");
        try {
            this.user = dao.get(log);
            logger.info("log feito com susseso");
            return "home?faces-redirect=true";
        } catch (SQLException ex) {
            logger.info("erro ao logar usuario");
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "index?faces-redirect=true";
    }
    
    public String cadastrar(String log, String email, String senha){
        logger.info("iniciando cadastro do usuario");
        if(log==null || email==null || senha==null)return "cadastro?faces-redirect=true";
        else{
            try {
                if(Usuariovalidador.existe(log)){
                    return "cadastro?faces-redirect=true";
                }else {
                    User novoUsuario = new User();
                    novoUsuario.setLog(log);
                    novoUsuario.setEmail(email);
                    novoUsuario.setPassWord(senha);
                    this.dao.add(novoUsuario);
                    this.setUser(novoUsuario);
                    logger.info("cadastro feito com susseso");
                    return "home?faces-redirect=true";
                    
                }
            } catch (ClassNotFoundException | SQLException ex) {
                logger.info("erro ao inicia cadastro");
                Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        logger.info("erro ao inicia cadastro");
        return "cadastro?faces-redirect=true";
    }
    
    public String atulizar(String email, String senha){
        logger.info("atulizando usuario");
        this.user.setEmail(email);
        this.user.setPassWord(senha);
        try {
            this.dao.update(user);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioControle.class.getName()).log(Level.SEVERE, null, ex);
        }
        logger.info("atualizacao efetuada com susseso");
        return "home?faces-redirect=true";
    }
    
    public String criaCadastro(){
        return "cadastro?faces-redirect=true";
    }

}
