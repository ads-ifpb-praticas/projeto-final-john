/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ifpb.ads.sis.arquivos.controles;

import ifpb.ads.sis.arquivos.beans.User;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author recursive
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
    @org.junit.Test
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
    @org.junit.Test
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
    @org.junit.Test
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
    @org.junit.Test
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
    @org.junit.Test
    public void testList() throws Exception {
        System.out.println("list");
        UsuarioControle instance = new UsuarioControle();
        List<User> expResult = null;
        List<User> result = instance.list();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
