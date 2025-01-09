public class Motor extends Thread {
    private int potencia;
    public Motor(){
        setPotencia(0);
    }

    public int getPotencia(){return potencia;}

    public void setPotencia(int potencia){
        if(potencia >= 0) this.potencia = potencia;
    }
}