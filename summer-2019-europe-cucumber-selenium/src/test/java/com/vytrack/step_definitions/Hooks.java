package com.vytrack.step_definitions;

import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp(){
        System.out.println("\tThis is coming from BEFORE");
    }

    @After
    public void tearDown(){
        Driver.closeDriver();
    }

    @Before("@db")
    public void setUpDatabase(){
        System.out.println("\tESTABLISHING DATABASE CONNECTION\n");
    }

    @After("@db")
    public void tearDownDatabase(){
        System.out.println("\tCLOSING DATABASE CONNECTION\n");
    }


}
