/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package threadtest;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rapnik
 */
public class MainClassTest {
    
    public MainClassTest() {
    }

    @Test
    public void testRaceCondition() throws InterruptedException {
        int numberOfThreads = 1000;
        int loopsize = 100;
        ValueBean valueBean = new ValueBean();
        ThreadClass[] threadArray = MainClass.createThreads(numberOfThreads, valueBean, loopsize);
        MainClass.startThreads(threadArray);
        MainClass.joinThreads(threadArray);
        //edit the ValueBean.addValue(int valueToAdd) method to see the 
        //different behaviours
        assertEquals("This is a race condition",loopsize*numberOfThreads, valueBean.getValue());
        
    }
    
}
