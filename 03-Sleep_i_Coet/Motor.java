import java.util.Random;

public class Motor extends Thread {
    private int curr;
    private int goal;

    public Motor(){
        setPotenciaCurr(0);
    }

    public int getCurr(){return curr;}
    public void setPotenciaCurr(int potencia){ 
        curr = potencia; 
    }
    public int getGoal(){return goal;}
    public synchronized void setPotenciaGoal(int potencia){ 
        goal = potencia; 
        notify();
    }

    public String mostra(String s){ return String.format("%nMotor %s: %s Objectiu: %d Actual %d%n", getName(), s, goal, curr);}

    @Override
    public void run(){
        Random r = new Random();

        try {
            while (true) {
                synchronized(this){
                    while (curr == goal) {
                        wait();
                        if(curr == 0 && goal == 0) break;
                    }
                }

                if(curr <= goal){
                    curr++;
                    System.out.print(mostra("Incre."));
                }else if(curr >= goal){
                    curr--;  
                    System.out.print(mostra("Decre."));
                }else{
                    System.out.print(mostra("FerRes"));   
                }
                Thread.sleep(r.nextInt(1000)+1000);
                
                if(curr == 0 && goal == 0) break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}