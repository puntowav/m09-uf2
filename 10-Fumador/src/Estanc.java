import java.util.ArrayList;
import java.util.Random;

public class Estanc extends Thread{
    private static Random r = new Random();
    private boolean obert;
    private ArrayList<Tabac> tabac;
    private ArrayList<Llumi> llumins;
    private ArrayList<Paper> papers;
    public Estanc(){
        tabac = new ArrayList<Tabac>();
        llumins = new ArrayList<Llumi>();
        papers = new ArrayList<Paper>();
        obert =  true;
    }
    public void nouSubministrament(){
        int rInt = r.nextInt(1, 4);
        switch (rInt) {
            case 1:
                addTabac();
                break;
            case 2:
                addLlumins();
                break;
            case 3:
                addPapers();
                break;
        }
    }
    public synchronized void addTabac(){
        tabac.add(new Tabac());
        System.out.println("Afegint tabac");
        notifyAll();
    }
    public synchronized void addLlumins(){
        llumins.add(new Llumi());
        System.out.println("Afegint llumi");
        notifyAll();
    }
    public synchronized void addPapers(){
        papers.add(new Paper());
        System.out.println("Afegint paper");
        notifyAll();
    }
    
    public synchronized Tabac venTabac() throws InterruptedException{
        while(tabac.isEmpty()) wait(); 
        return tabac.remove(0);
    }
    public synchronized Llumi venLlumi() throws InterruptedException{
        while(llumins.isEmpty()) wait();
        return llumins.remove(0);
    }
    public synchronized Paper venPaper() throws InterruptedException{
        while(papers.isEmpty()) wait();
        return papers.remove(0);
    }
    public void tencarEstanc(){
        obert = false;
        System.out.println("Estanc tencat");
    }
    @Override
    public void run() {
        while (obert) {
            nouSubministrament();
            try {
                Thread.sleep(500 + r.nextInt(1001));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}