package src;

import java.util.Random;

public class Futbolista extends Thread{
    private static final int NUM_JUGADORS = 11;
    private static final int NUM_TIRADES = 20;
    private static final float PROBABILITAT = 0.5f;

    private static Random r = new Random();

    private int ngols;
    private int ntirades;

    public Futbolista(){
        ngols = 0;
        ntirades = 0;
    }

    @Override
    public void start(){
        if(ntirades < NUM_TIRADES){
            ntirades += 1;
            if(r.nextFloat() <= PROBABILITAT) ngols += 1;
        }
    }

    public static void main(String[] args) throws InterruptedException{
        String[] names = {
                        "Piqué", "Vinicius","Torres","Ramos",
                        "Ronaldo", "Lewan","Belli", "Arnau",
                        "Aspas","Messi", "MBapé"
                    };

        Futbolista[] futbolistes = new Futbolista[NUM_JUGADORS];

        for (int i = 0; i < names.length; i++) {
            futbolistes[i] = new Futbolista();
            futbolistes[i].setName(names[i]);
        }

        System.out.println("Inici dels xuts --------------------");
        for (Futbolista f : futbolistes) {
            for(int i = 0; i < NUM_TIRADES; i++){
                f.start();
            }
            f.join();
        }
        System.out.println("Fi dels xuts -----------------------");
        System.out.println("--- Estadístiques ------");
        for (Futbolista f2 : futbolistes) {
            System.out.println(String.format("%-10s-> %d gols", f2.getName(), f2.ngols));
        }
    }
}