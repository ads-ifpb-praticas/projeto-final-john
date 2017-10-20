/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template usuario, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.sis.arquivos.daos;

import ifpb.ads.sis.arquivos.beans.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 *
 * @author john
 */
@Stateless
@Local(IUserDao.class)
public class UserDao implements IUserDao{

    private final Connection con;
    
    public UserDao()throws ClassNotFoundException, SQLException{
        this.con = Conexao.getConnection();
    }

    public Connection getCon() {
        return con;
    }

    @Override
    public void add(User obj) throws SQLException {
    
        PreparedStatement stmt = con.prepareStatement(
            "INSERT INTO usuario (log, senha, email)"
            + " VALUES (?,?,?)");
        stmt.setString(1, obj.getLog());
        stmt.setString(2, obj.getPassWord());
        stmt.setString(3, obj.getEmail());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void remove(User obj) throws SQLException {
        PreparedStatement stmt = con.prepareStatement(
                "DELETE FROM usuario WHERE log = ?");
        stmt.setString(1, obj.getLog());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void update(User obj) throws SQLException {
        PreparedStatement stmt = con.prepareStatement(
            "UPDATE usuario SET senha=?, email=? WHERE log=?");
        stmt.setString(1, obj.getPassWord());
        stmt.setString(2, obj.getEmail());
        stmt.setString(3, obj.getLog());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<User> list() throws SQLException {
        List<User> usuarios = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM usuario");
        ResultSet rs = stmt.executeQuery();
        User usuario;
        while(rs.next()){
            usuario = new User();
            usuario.setLog(rs.getString("log"));
            usuario.setPassWord(rs.getString("senha"));
            usuario.setEmail(rs.getString("email"));
            usuarios.add(usuario);
        }
        return usuarios;
    }

    @Override
    public User get(String key) throws SQLException {
        User usuario = null;
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM usuario WHERE log = ?");
        stmt.setString(1, key);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()){
            usuario = new User();
            usuario.setLog(rs.getString("log"));
            usuario.setPassWord(rs.getString("senha"));
            usuario.setEmail(rs.getString("email"));
        }
        stmt.close();
        return usuario;
    }

}
