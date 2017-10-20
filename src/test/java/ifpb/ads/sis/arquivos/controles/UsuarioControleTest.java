/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.sis.arquivos.controles;

import ifpb.ads.sis.arquivos.beans.User;
import ifpb.ads.sis.arquivos.daos.Dao;
import ifpb.ads.sis.arquivos.daos.IUserDao;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author john
 */
public class UsuarioControleTest {
    
    public UsuarioControleTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class UsuarioControle.
     */
    @Test
    public void testAdd() throws Exception {
        System.out.println("add");
        User user = null;
        UsuarioControle instance = new UsuarioControle();
        instance.add(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class UsuarioControle.
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        User user = null;
        UsuarioControle instance = new UsuarioControle();
        instance.remove(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class UsuarioControle.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        User user = null;
        UsuarioControle instance = new UsuarioControle();
        instance.update(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class UsuarioControle.
     */
    @Test
    public void testGet() throws Exception {
        System.out.println("get");
        User user = null;
        UsuarioControle instance = new UsuarioControle();
        User expResult = null;
        User result = instance.get(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of list method, of class UsuarioControle.
     */
    @Test
    public void testList() throws Exception {
        System.out.println("list");
        UsuarioControle instance = new UsuarioControle();
        List<User> expResult = null;
        List<User> result = instance.list();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDao method, of class UsuarioControle.
     */
    @Test
    public void testGetDao() {
        System.out.println("getDao");
        UsuarioControle instance = new UsuarioControle();
        Dao<User> expResult = null;
        Dao<User> result = instance.getDao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDao method, of class UsuarioControle.
     */
    @Test
    public void testSetDao() {
        System.out.println("setDao");
        IUserDao dao = null;
        UsuarioControle instance = new UsuarioControle();
        instance.setDao(dao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class UsuarioControle.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        UsuarioControle instance = new UsuarioControle();
        User expResult = null;
        User result = instance.getUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUser method, of class UsuarioControle.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        User user = null;
        UsuarioControle instance = new UsuarioControle();
        instance.setUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logar method, of class UsuarioControle.
     */
    @Test
    public void testLogar() {
        System.out.println("logar");
        String log = "";
        String senha = "";
        UsuarioControle instance = new UsuarioControle();
        String expResult = "";
        String result = instance.logar(log, senha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cadastrar method, of class UsuarioControle.
     */
    @Test
    public void testCadastrar() {
        System.out.println("cadastrar");
        String log = "";
        String email = "";
        String senha = "";
        UsuarioControle instance = new UsuarioControle();
        String expResult = "";
        String result = instance.cadastrar(log, email, senha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atulizar method, of class UsuarioControle.
     */
    @Test
    public void testAtulizar() {
        System.out.println("atulizar");
        String email = "";
        String senha = "";
        UsuarioControle instance = new UsuarioControle();
        String expResult = "";
        String result = instance.atulizar(email, senha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of criaCadastro method, of class UsuarioControle.
     */
    @Test
    public void testCriaCadastro() {
        System.out.println("criaCadastro");
        UsuarioControle instance = new UsuarioControle();
        String expResult = "";
        String result = instance.criaCadastro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
