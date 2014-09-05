
package threadtest;

/**
 *
 * @author rapnik
 */
public class ThreadClass extends Thread{
    private final ValueBean valueBean;
    private final int loopSize;

    public ThreadClass(ValueBean valueBean,int loopsize) {
        this.valueBean = valueBean;
        this.loopSize = loopsize;
    }

    @Override
    public void run() {
        for (int i = 0; i<loopSize;i++){
            valueBean.addValue(1);
        }
    }
    
    
}
