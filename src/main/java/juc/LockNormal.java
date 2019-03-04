package juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author liaowm5
 * @version 1.0
 * @description TODO
 * @date 2019-02-27 21:24
 **/
public class LockNormal {
    public static void main(String[] args){
        Lock lock = new ReentrantLock();

        if(lock.tryLock()){
            try{

            }finally {

            }
        }
    }
}
