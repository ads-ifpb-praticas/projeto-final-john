/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template user, choose Tools | Templates
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

/**
 *
 * @author john
 */
public class UserDao implements Dao<User>{

    private final Connection con;
    
    public UserDao()throws ClassNotFoundException, SQLException{
        this.con = Conexao.getConnection();
    }

    @Override
    public void add(User obj) throws SQLException {
        PreparedStatement stmt = con.prepareStatement(
            "INSERT INTO user (log, password, email)"
            + " VALUES (?,?)");
        stmt.setString(1, obj.getLog());
        stmt.setString(2, obj.getPassWord());
        stmt.setString(3, obj.getEmail());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void remove(User obj) throws SQLException {
        PreparedStatement stmt = con.prepareStatement(
                "DELETE FROM user WHERE log = ?");
        stmt.setString(1, obj.getLog());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void update(User obj) throws SQLException {
        PreparedStatement stmt = con.prepareStatement(
            "UPDATE user SET password=?, email=? WHERE log=?");
        stmt.setString(1, obj.getPassWord());
        stmt.setString(2, obj.getEmail());
        stmt.setString(3, obj.getLog());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<User> list() throws SQLException {
        List<User> users = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM user");
        ResultSet rs = stmt.executeQuery();
        User user;
        while(rs.next()){
            user = new User();
            user.setLog(rs.getString("log"));
            user.setPassWord(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            users.add(user);
        }
        return users;
    }

    @Override
    public User get(String key) throws SQLException {
        User user = null;
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM user WHERE id = ?");
        stmt.setString(1, key);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()){
            user = new User();
            user.setLog(rs.getString("log"));
            user.setPassWord(rs.getString("password"));
            user.setEmail(rs.getString("email"));
        }
        stmt.close();
        return user;
    }

}
