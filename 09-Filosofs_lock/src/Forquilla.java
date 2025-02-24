package src;
import java.util.concurrent.locks.ReentrantLock;

public class Forquilla {
    private int index;
    private ReentrantLock bloqueig;    
    public Forquilla(int index){
        this.index = index;
        this.bloqueig = new ReentrantLock(true);
    }
    public int getIndex() {
        return index;
    }
    public void agafar(){
        bloqueig.lock();
    }
    public void deixar(){
        if(bloqueig.isHeldByCurrentThread()){
            bloqueig.unlock();
        }
    }
}
