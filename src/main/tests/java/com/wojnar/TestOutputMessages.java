package com.wojnar;

import com.wojnar.IOstrems.OutputController;
import org.testng.annotations.Test;

/**
 * Created by paul on 04.07.17.
 */
public class TestOutputMessages {

    @Test
    public void printWelcomeMessage(){
        OutputController out = new OutputController(System.out);
                out.printWelcomeMessage();
    }
}
