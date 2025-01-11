import java.util.Scanner;

public class Coet {
    public Motor[] motors;

    public Coet(Motor[] motors){
        this.motors = motors;
    }

    public void arrenca(){
        for(Motor m : motors){
            m.start();
        }
    }

    public void passaAPotencia(int p){
        if(p < 0 || p > 10){
            System.out.println("Potencia no vàlida");   
        }else{
            for(Motor m: motors){
                m.setPotenciaGoal(p);
            }
        }
    }

    public boolean motorsApagats(){
        for (Motor motor : motors) {
            if (motor.getCurr() != 0 || motor.getGoal() != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        Motor[] m = new Motor[4]; 

        for(int i = 0; i < m.length; i++){
            m[i] = new Motor();
            m[i].setName(String.valueOf(i));
        }
        Coet c = new Coet(m);
        
        c.arrenca();

        try (Scanner s = new Scanner(System.in)) {
            while (true) {
                int p = s.nextInt();
                c.passaAPotencia(p);

                if(p == 0) break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}