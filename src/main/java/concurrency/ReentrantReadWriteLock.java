package concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

public class ReentrantReadWriteLock {
    ReadWriteLock lock = new ReadWriteLock() {
        @Override
        public Lock readLock() {
            return null;
        }

        @Override
        public Lock writeLock() {
            return null;
        }
    };
    Lock readLock = lock.readLock();
    Lock writeLock = lock.writeLock();

    public void write(int key, int value){
        try{
            writeLock.lock();
            // writeTask
        }
        finally{
            writeLock.unlock();
        }
    }

    public void read(int key){
        try{
            readLock.lock();
            // readTask
        }
        finally{
            readLock.unlock();
        }
    }
}

