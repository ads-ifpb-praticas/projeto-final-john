/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.sis.arquivos.daos;

import ifpb.ads.sis.arquivos.beans.File;
import ifpb.ads.sis.arquivos.beans.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author john
 */
public class FileDao implements Dao<File>{

    private final Connection con;
    
    public FileDao()throws ClassNotFoundException, SQLException{
        this.con = Conexao.getConnection();
    }
    
    @Override
    public void add(File obj)throws SQLException {
        PreparedStatement stmt = con.prepareStatement(
            "INSERT INTO file (nome, tipo, arquivo, dono)"
            + " VALUES (?,?,?)");
        stmt.setString(1, obj.getNome());
        stmt.setString(2, obj.getTipo());
        stmt.setString(3, obj.getArquivo());
        stmt.setDouble(4, obj.getTamanho());
        stmt.setString(5, obj.getDono().getLog());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void remove(File obj)throws SQLException {
        PreparedStatement stmt = con.prepareStatement(
                "DELETE FROM file WHERE id = ?");
        stmt.setInt(1, obj.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void update(File obj)throws SQLException {
        PreparedStatement stmt = con.prepareStatement(
            "UPDATE file SET nome=?, tipo=?, tamanho=?, arquivo=?, dono=? WHERE id=?");
        stmt.setString(1, obj.getNome());
        stmt.setString(2, obj.getTipo());
        stmt.setDouble(3, obj.getTamanho());
        stmt.setString(4, obj.getArquivo());
        stmt.setString(5, obj.getDono().getLog());
        stmt.setInt(6, obj.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<File> list()throws SQLException {
        
        List<File> files = new ArrayList<>();
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM file");
        ResultSet rs = stmt.executeQuery();
        File file;
        while(rs.next()){
            file = new File();
            file.setNome(rs.getString("nome"));
            file.setTipo(rs.getString("tipo"));
            file.setArquivo(rs.getString("arquivo"));
            file.setTamanho(rs.getDouble("tamanho"));
            file.setId(rs.getInt("id"));
            User user = new User();
            Dao dao = null;
            try {
                dao = new UserDao();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FileDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            file.setDono((User) dao.get(rs.getString("dono")));
            file.setArquivo(rs.getString("arquivo"));
            files.add(file);
        }
        return files;
    }

    @Override
    public File get(String key)throws SQLException {
        File file = null;
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM file WHERE id = ?");
        stmt.setString(1, key);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()){
            file = new File();
            file.setNome(rs.getString("nome"));
            file.setTipo(rs.getString("tipo"));
            file.setArquivo(rs.getString("arquivo"));
            file.setTamanho(rs.getDouble("tamanho"));
            file.setId(rs.getInt("id"));
            User user = new User();
            Dao dao = null;
            try {
                dao = new UserDao();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FileDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            file.setDono((User) dao.get(rs.getString("dono")));
            file.setArquivo(rs.getString("arquivo"));
        }
        stmt.close();
        return file;

    }
    
}
