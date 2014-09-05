package threadtest;

/**
 *
 * @author rapnik
 */
public class MainClass {

    public static void main(String[] args) throws InterruptedException {
        ValueBean valueBean = new ValueBean();
        int numberOfThreads = 1000;
        int loopSize = 100;
        ThreadClass[] threadArray = createThreads(numberOfThreads, valueBean,loopSize);
        startThreads(threadArray);
        joinThreads(threadArray);
        
        
        System.out.println("Value of ValueBean should be:"+numberOfThreads*loopSize+" and it is:"+valueBean.getValue());
    }

    static ThreadClass[] createThreads(int numberOfThreads, ValueBean tb,int loopsize) {
        ThreadClass[] threadArray=new ThreadClass[numberOfThreads];
        for (int i =0;i<threadArray.length;i++){
            threadArray[i]=new ThreadClass(tb, loopsize);
        }
        return threadArray;
    }
    static void startThreads(ThreadClass[] threadArray) {
        for (ThreadClass tc :threadArray){
            tc.start();
        }
    }
    static void joinThreads(ThreadClass[] threadArray) throws InterruptedException {
        for (ThreadClass tc :threadArray){
            tc.join();
        }
    }
    
}
