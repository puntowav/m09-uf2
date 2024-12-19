public class Principal {
    public static void  main(String[] args) throws InterruptedException{
        Fil juan = new Fil();
        Fil pepe = new Fil();

        juan.setName("Juan");
        pepe.setName("Pepe");

        juan.start();
        pepe.start();

        juan.join();
        pepe.join();
    }
}