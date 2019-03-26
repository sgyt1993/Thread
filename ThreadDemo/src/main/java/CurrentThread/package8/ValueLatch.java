package CurrentThread.package8;

import java.util.concurrent.CountDownLatch;

/**
 * @Author:sgyt
 * @Description:
 * @Date:2019/3/25 13:01
 */
public class ValueLatch<T> {

    private T value = null;
    private final CountDownLatch done = new CountDownLatch(1);

    public boolean isSet(){
        return (done.getCount() == 0);
    }

    public synchronized void setValue(T newValue){
        if(!isSet()){
            value = newValue;
            done.countDown();
        }
    }

    public T getValue() throws InterruptedException {
        done.await();
        synchronized (this){
            return value;
        }
    }
}
