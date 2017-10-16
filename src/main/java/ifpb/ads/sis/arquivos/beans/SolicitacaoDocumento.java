/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.sis.arquivos.beans;

import java.io.Serializable;

/**
 *
 * @author john
 */
public class SolicitacaoDocumento implements Serializable{
    
    private int id;
    private User remetente;
    private User destinatario;
    private File arquivo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getRemetente() {
        return remetente;
    }

    public void setRemetente(User remetente) {
        this.remetente = remetente;
    }

    public User getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(User destinatario) {
        this.destinatario = destinatario;
    }

    public File getArquivo() {
        return arquivo;
    }

    public void setArquivo(File arquivo) {
        this.arquivo = arquivo;
    }

}
