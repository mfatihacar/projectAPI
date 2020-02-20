package com.cucumber.step_definitions;

import com.cucumber.utilities.Driver;
import io.cucumber.java.After;

public class Hooks {

    @After
    public void teardown() {
        Driver.closeDriver();
    }
}
