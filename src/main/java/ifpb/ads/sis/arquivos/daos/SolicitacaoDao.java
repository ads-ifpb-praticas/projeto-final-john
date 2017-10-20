/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.sis.arquivos.daos;

import ifpb.ads.sis.arquivos.beans.Documento;
import ifpb.ads.sis.arquivos.beans.SolicitacaoDocumento;
import ifpb.ads.sis.arquivos.beans.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author john
 */
public class SolicitacaoDao implements ISolicitacaoDao{

    private final Connection con;
    
    public SolicitacaoDao() throws ClassNotFoundException, SQLException{
        this.con = Conexao.getConnection();
    }

    public Connection getCon() {
        return con;
    }
    
    @Override
    public void add(SolicitacaoDocumento obj) throws SQLException {
        PreparedStatement stmt = con.prepareStatement(
            "INSERT INTO solicitacaodocumento (remetente, destinatario, tipo)"
            + " VALUES (?,?,?)");
        
        stmt.setString(1, obj.getRemetente().getLog());
        stmt.setString(2, obj.getDestinatario().getLog());
        stmt.setInt(3, obj.getArquivo().getId());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void remove(SolicitacaoDocumento obj) throws SQLException {
        PreparedStatement stmt = con.prepareStatement(
                "DELETE FROM solicitacaodocumento WHERE id = ?");
        stmt.setInt(1, obj.getId());
        
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public void update(SolicitacaoDocumento obj) throws SQLException {
        PreparedStatement stmt = con.prepareStatement(
            "UPDATE solicitacaodocumento SET tipo=? WHERE id=?");
        stmt.setInt(1, obj.getId());
        stmt.executeUpdate();
        stmt.close();
    }

    @Override
    public List<SolicitacaoDocumento> list() throws SQLException {
        List<SolicitacaoDocumento> solicitacaodocumentos = null;
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM mensagem");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()){
            SolicitacaoDocumento soli = new SolicitacaoDocumento();
            Dao userDao =  null;
            try {
                userDao = new UserDao();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SolicitacaoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            User remetente = (User) userDao.get(rs.getString("remetente"));
            User destinatario = (User) userDao.get(rs.getString("destinatario"));
            
            soli.setRemetente(remetente);
            soli.setDestinatario(destinatario);
            
            Dao arquivoDao = null;
            try {
                arquivoDao = new FileDao();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SolicitacaoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            Integer identificador = rs.getInt("arquivo");
            Documento arquivo = (Documento) arquivoDao.get(identificador.toString());
            soli.setArquivo(arquivo);
            soli.setId(rs.getInt("id"));
            solicitacaodocumentos.add(soli);
        }
        stmt.close();
        return solicitacaodocumentos;
    }

    @Override
    public SolicitacaoDocumento get(String key) throws SQLException {
        SolicitacaoDocumento solicitacao = null;
        PreparedStatement stmt = con.prepareStatement(
                "SELECT * FROM solicitacaodocumento WHERE remetente=?");
        stmt.setString(1, key);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()){
            SolicitacaoDocumento soli = new SolicitacaoDocumento();
            Dao userDao =  null;
            try {
                userDao = new UserDao();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SolicitacaoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            User remetente = (User) userDao.get(rs.getString("remetente"));
            User destinatario = (User) userDao.get(rs.getString("destinatario"));
            
            soli.setRemetente(remetente);
            soli.setDestinatario(destinatario);
            
            Dao arquivoDao = null;
            try {
                arquivoDao = new FileDao();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SolicitacaoDao.class.getName()).log(Level.SEVERE, null, ex);
            }
            Integer identificador = rs.getInt("arquivo");
            Documento arquivo = (Documento) arquivoDao.get(identificador.toString());
            soli.setArquivo(arquivo);
            soli.setId(rs.getInt("id"));
        }
        stmt.close();
        return solicitacao;
    }
    
}
