public class Administracio {
    private int num_poblacio_activa = 50;
    private Treballador[] poblacio_activa = new Treballador[num_poblacio_activa];
    public Administracio(){
        for(int i = 0; i<poblacio_activa.length; i++){
            poblacio_activa[i] = new Treballador(String.valueOf(i), 25000, 20, 65);
        }
    }
    public  String mostra(String name, int edat, float cobrat){
        return String.format("%nCiutadà-%s -> edat %d / total: %.2f", name, edat, cobrat);
    }
    public static void main(String[] args)throws InterruptedException{
        Administracio a = new Administracio();

        for (Treballador t : a.poblacio_activa) {
            t.start();  
        }

        for (Treballador t : a.poblacio_activa) {
            t.join();
            System.out.print(a.mostra(t.getName(), t.getEdat(), t.getCobrat()));
        }
    }
}
