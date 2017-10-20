/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.sis.arquivos.validadores;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author recursive
 */
public class UsuarioValidadorTest {
    
    public UsuarioValidadorTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testValidarNomeNotnumber() {
        String log = "98989898";
        boolean teste = UsuarioValidador.validarNome(log);
        Assert.assertFalse(teste);
        
    }
    
    @Test
    public void testValidarNomeCharcaterSpecial() {
        String log = "@#%#@@$#";
        boolean teste = UsuarioValidador.validarNome(log);
        Assert.assertFalse(teste);
    }
    
    @Test
    public void testValidarNomeEndNumber() {
        String log = "asassas89898";
        boolean teste = UsuarioValidador.validarNome(log);
        Assert.assertFalse(teste);
    }

    @Test
    public void testValidarNomeEndSpecialCharactes() {
        String log = "#$@#$@#$@aaaaaaa";
        boolean teste = UsuarioValidador.validarNome(log);
        Assert.assertFalse(teste);
    }
}
