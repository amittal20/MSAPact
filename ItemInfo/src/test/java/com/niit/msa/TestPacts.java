package com.niit.msa;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;

@RunWith(PactRunner.class)
@Provider("Item_Review_Service")
@PactFolder("target\\pacts")
public class TestPacts {
    private static ConfigurableApplicationContext application;
    
    @TestTarget
    public final Target target = new HttpTarget(7580);
     
    @BeforeClass
    public static void startSpring(){
        application = SpringApplication.run(ItemInfoApplication.class);
    }
 
    @Test
    public void myTest(){
    	assertTrue(true);
    }
    
    @AfterClass
    public static void kill(){
        application.stop();
    }
}
