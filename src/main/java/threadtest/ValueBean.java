
package threadtest;

/**
 *
 * @author rapnik
 */
public class ValueBean {
    private int value;
    
    public void addValue(int valueToAdd){
        //uncomment one of the 3 methods here to play with the effect
        
        addValueUnsynchronized1(valueToAdd);
//        addValueUnsynchronized2(valueToAdd);
//        addValueSynchronized(valueToAdd);
    }
    
    private void addValueUnsynchronized1(int valueToAdd) {
        int localValue = value;
        sleep();
        /* Between assigning value to localValue and setting 
        value = localValue+valueToAdd;
        value is likely to change if this block isn't synchronized,
        causing a race condition.
        However, even value+=valueToAdd isn't atomic, just the 
        probability is smaller, so more threads and a bigger loopsize 
        are required to trigger the problem reliably
        */
        value = localValue+valueToAdd;   
    }

    private void sleep() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
            //do nothing
        }
    }
    private void addValueUnsynchronized2(int valueToAdd) {
        /* This also has the same problem, but with a lower probability,   
        as the duration of the critical block is smaller.
        On my i7 processor the race condition occurred like 
        260 times out of 100000 with 1000 Threads and a loopSize of 100 
        */
         value+=valueToAdd;
    }
    
    private synchronized void addValueSynchronized(int valueToAdd){
        /*this is safe, only a single thread has the permission to modify 
          the member variable
        */
        value+=valueToAdd;
    }
    
    
    public int getValue(){
        return value;
    }
    
}
