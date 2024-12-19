## Comportament 1

#### CODE
~~~bash
public class Principal {
    public static void  main(String[] args){
        Fil juan = new Fil();
        Fil pepe = new Fil();

        juan.setName("Juan");
        pepe.setName("Pepe");

        juan.start();
        pepe.start();
    }
}

public class Fil extends Thread {
    @Override
    public void run() {
        for(int  i = 0; i < 10; i++){
            System.out.println(getName() + " " + i);
        }
        System.out.println("Termina el fil "+getName());
    }
}    
~~~

~~~bash
Juan 1
Juan 2
Pepe 1
Pepe 2
Pepe 3
Pepe 4
Pepe 5
Pepe 6
Pepe 7
Juan 3
Juan 4
Pepe 8
Juan 5
Juan 6
Juan 7
Juan 8
Termina el fil Pepe
Termina el fil Juan
~~~

## Comportament 2

#### CODE
~~~bash
public class Principal {
    public static void  main(String[] args)throws InterruptedException{
        Fil juan = new Fil();
        Fil pepe = new Fil();

        juan.setName("Juan");
        pepe.setName("Pepe");
        
        juan.start();
        juan.join();

        pepe.start();
        pepe.join();

        System.out.println("Termina el fil "+juan.getName());
        System.out.println("Termina el fil "+pepe.getName());
    }
}

public class Fil extends Thread {
    @Override
    public void run() {
        for(int  i = 1; i <= 9; i++){
            System.out.println(getName() + " " + i);
        }
    }
}    
~~~

~~~bash
Juan 1
Juan 2
Juan 3
Juan 4
Juan 5
Juan 6
Juan 7
Juan 8
Juan 9
Pepe 1
Pepe 2
Pepe 3
Pepe 4
Pepe 5
Pepe 6
Pepe 7
Pepe 8
Pepe 9
Termina el fil Juan
Termina el fil Pepe
~~~

## Comportament 3

#### CODE
~~~bash
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

public class Fil extends Thread {
    @Override
    public void run() {
        for(int  i = 1; i <= 9; i++){
            System.out.println(getName() + " " + i);
            Thread.yield();
        }
        System.out.println("Termina el fil "+getName());
    }
}      
~~~

~~~bash
Juan 1
Pepe 1
Juan 2
Pepe 2
Pepe 3
Juan 3
Pepe 4
Juan 4
Juan 5
Juan 6
Pepe 5
Juan 7
Juan 8
Pepe 6
Juan 9
Pepe 7
Pepe 8
Pepe 9
Termina el fil Pepe
Termina el fil Juan
~~~