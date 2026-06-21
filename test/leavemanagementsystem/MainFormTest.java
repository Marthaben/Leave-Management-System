/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leavemanagementsystem;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author New
 */
public class MainFormTest {
    
    public MainFormTest() {
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
     * Test of Load_Leaves method, of class MainForm.
     */
    @Test
    public void testLoad_Leaves() {
        System.out.println("Load_Leaves");
        MainForm instance = new MainForm();
        instance.Load_Leaves();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Load_Statistics method, of class MainForm.
     */
    @Test
    public void testLoad_Statistics() {
        System.out.println("Load_Statistics");
        MainForm instance = new MainForm();
        instance.Load_Statistics();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Load_MyRequests method, of class MainForm.
     */
    @Test
    public void testLoad_MyRequests() {
        System.out.println("Load_MyRequests");
        MainForm instance = new MainForm();
        instance.Load_MyRequests();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Load_Users method, of class MainForm.
     */
    @Test
    public void testLoad_Users() {
        System.out.println("Load_Users");
        MainForm instance = new MainForm();
        instance.Load_Users();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Check_Login method, of class MainForm.
     */
    @Test
    public void testCheck_Login() {
        System.out.println("Check_Login");
        String username = "";
        String password = "";
        MainForm instance = new MainForm();
        boolean expResult = false;
        boolean result = instance.Check_Login(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class MainForm.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        MainForm.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
