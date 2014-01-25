package com.cybercom.demo.logging.ejb;


import static org.junit.Assert.*;

import java.util.logging.Level;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cybercom.demo.logging.base.IMyBean;
import com.cybercom.demo.logging.base.MyScript;

public class MyEjbBeanTest {
	
	private static EJBContainer ejbContainer;

    private IMyBean myBean;

    @BeforeClass
    public static void startTheContainer() {
    	java.util.logging.Logger.getLogger("com.cybercom.logging.EntryExitMethodLogger").setLevel(Level.ALL);
        ejbContainer = EJBContainer.createEJBContainer();
    }
    
    @Before
    public void lookupABean() throws NamingException {
        Object object = ejbContainer.getContext().lookup("java:global/demo-logging-ejb/MyEjbBean");

        assertTrue(object instanceof MyEjbBean);

        myBean = (MyEjbBean) object;
    }

    @AfterClass
    public static void stopTheContainer() {
        if (ejbContainer != null) {
            ejbContainer.close();
        }
    }

	@Test
	public void test() {
		new MyScript().executeScript(myBean);
	}

}
