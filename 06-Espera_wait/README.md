### 1. Per què s'atura l'execució al d'un temps?
~~~
En el moment que tots els fils intenten fer una reserva però ja no hi ha més places disponibles, aquests es queden en espera (wait()).
Un cop passa això, no es pot executar el notifyAll() que es troba a eliminaReserva().
~~~

### 2. Què passaria si en lloc de una probabilitat de 50%-50% fora 70%(ferReserves)-30%(cancel·lar)? I si fora al revés les probabilitats? -> Mostra la porció de codi i la sortida resultant en cada un dels 2  casos.

70-30
~~~bash
@Override
    public void run() {
        Random r = new Random(1000);
        while (true) {            
            if (Math.random() < 0.7) {
                esdeveniment.ferReserva(this);
            }else{
                esdeveniment.eliminaReserva(this);
            }
            try {
                Thread.sleep(r.nextInt());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

Al donar una probabilitat mes alata al fer reserves l'execució arriba al limit molt abans ja que els fils fan reserves de forma mes freqüent.
~~~

~~~~~bash
Assistent-2 ha fet una reserva. Places disponibles: 9
Assistent-4 ha fet una reserva. Places disponibles: 8
Assistent-5 ha fet una reserva. Places disponibles: 7
Assistent-3 ha fet una reserva. Places disponibles: 6
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-7 ha fet una reserva. Places disponibles: 5
Assistent-6 ha fet una reserva. Places disponibles: 4
Assistent-0 ha fet una reserva. Places disponibles: 3
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-4 ha fet una reserva. Places disponibles: 2
Assistent-0 ha fet una reserva. Places disponibles: 1
Assistent-8 ha fet una reserva. Places disponibles: 0
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-7 ha cancel·lat una reserva. Places disponibles: 1
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-3 ha fet una reserva. Places disponibles: 0
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-2 ha cancel·lat una reserva. Places disponibles: 1
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-0 ha fet una reserva. Places disponibles: 0
~~~~~

30-70
~~~bash
@Override
    public void run() {
        Random r = new Random(1000);
        while (true) {            
            if (Math.random() < 0.3) {
                esdeveniment.ferReserva(this);
            }else{
                esdeveniment.eliminaReserva(this);
            }
            try {
                Thread.sleep(r.nextInt());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

En aquest cas l'execució es molt més llarga ja que hi ha major disponibilitat de places, per la manca de reserves i un cop es dona el 
cas el molt probable que es doni una cancel·lació.
~~~
~~~~bash
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-7 ha fet una reserva. Places disponibles: 1
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-7 ha cancel·lat una reserva. Places disponibles: 2
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-2 ha cancel·lat una reserva. Places disponibles: 3
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-3 ha cancel·lat una reserva. Places disponibles: 4
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-4 ha fet una reserva. Places disponibles: 3
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-9 ha cancel·lat una reserva. Places disponibles: 4
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-3 ha cancel·lat una reserva. Places disponibles: 5
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-4 ha cancel·lat una reserva. Places disponibles: 6
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-8 ha fet una reserva. Places disponibles: 5
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-6 ha fet una reserva. Places disponibles: 4
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-4 ha cancel·lat una reserva. Places disponibles: 5
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-9 ha fet una reserva. Places disponibles: 4
Assistent-6 ha cancel·lat una reserva. Places disponibles: 5
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-6 ha cancel·lat una reserva. Places disponibles: 6
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-3 ha fet una reserva. Places disponibles: 5
Assistent-2 ha fet una reserva. Places disponibles: 4
Assistent-9 ha cancel·lat una reserva. Places disponibles: 5
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-0 ha fet una reserva. Places disponibles: 4
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-8 ha cancel·lat una reserva. Places disponibles: 5
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-4 ha cancel·lat una reserva. Places disponibles: 6
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-0 ha cancel·lat una reserva. Places disponibles: 7
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-2 ha cancel·lat una reserva. Places disponibles: 8
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-3 ha cancel·lat una reserva. Places disponibles: 9
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 9
Assistent-5 ha fet una reserva. Places disponibles: 8
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-1 ha fet una reserva. Places disponibles: 7
Assistent-1 ha cancel·lat una reserva. Places disponibles: 8
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-0 ha fet una reserva. Places disponibles: 7
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-7 ha fet una reserva. Places disponibles: 6
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-3 ha fet una reserva. Places disponibles: 5
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-5 ha cancel·lat una reserva. Places disponibles: 6
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-3 ha cancel·lat una reserva. Places disponibles: 7
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-0 ha fet una reserva. Places disponibles: 6
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-7 ha cancel·lat una reserva. Places disponibles: 7
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-3 ha cancel·lat una reserva. Places disponibles: 8
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-0 ha fet una reserva. Places disponibles: 7
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-7 ha fet una reserva. Places disponibles: 6
Assistent-5 ha fet una reserva. Places disponibles: 5
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-0 ha cancel·lat una reserva. Places disponibles: 6
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-7 ha cancel·lat una reserva. Places disponibles: 7
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-5 ha cancel·lat una reserva. Places disponibles: 8
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-0 ha cancel·lat una reserva. Places disponibles: 9
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 9
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 9
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 9
Assistent-0 ha fet una reserva. Places disponibles: 8
Assistent-3 ha fet una reserva. Places disponibles: 7
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-7 ha fet una reserva. Places disponibles: 6
Assistent-6 ha fet una reserva. Places disponibles: 5
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-7 ha fet una reserva. Places disponibles: 4
Assistent-8 ha fet una reserva. Places disponibles: 3
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-4 ha fet una reserva. Places disponibles: 2
Assistent-8 ha fet una reserva. Places disponibles: 1
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-7 ha fet una reserva. Places disponibles: 0
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-7 ha cancel·lat una reserva. Places disponibles: 1
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-9 ha fet una reserva. Places disponibles: 0
Assistent-0 ha cancel·lat una reserva. Places disponibles: 1
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-5 ha fet una reserva. Places disponibles: 0
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-0 ha cancel·lat una reserva. Places disponibles: 1
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-9 ha fet una reserva. Places disponibles: 0
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-8 ha cancel·lat una reserva. Places disponibles: 1
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-6 ha fet una reserva. Places disponibles: 0
Assistent-7 ha cancel·lat una reserva. Places disponibles: 1
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-4 ha fet una reserva. Places disponibles: 0
Assistent-7 ha cancel·lat una reserva. Places disponibles: 1
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-0 ha fet una reserva. Places disponibles: 0
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-0 ha cancel·lat una reserva. Places disponibles: 1
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-5 ha fet una reserva. Places disponibles: 0
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 ha cancel·lat una reserva. Places disponibles: 1
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-9 ha fet una reserva. Places disponibles: 0
Assistent-8 ha cancel·lat una reserva. Places disponibles: 1
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-5 ha fet una reserva. Places disponibles: 0
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-4 ha cancel·lat una reserva. Places disponibles: 1
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-1 ha fet una reserva. Places disponibles: 0
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-9 ha cancel·lat una reserva. Places disponibles: 1
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-3 ha fet una reserva. Places disponibles: 0
Assistent-9 ha cancel·lat una reserva. Places disponibles: 1
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-6 ha fet una reserva. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-3 ha cancel·lat una reserva. Places disponibles: 1
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-7 ha fet una reserva. Places disponibles: 0
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-5 ha cancel·lat una reserva. Places disponibles: 1
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-3 ha fet una reserva. Places disponibles: 0
Assistent-5 ha cancel·lat una reserva. Places disponibles: 1
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-3 ha cancel·lat una reserva. Places disponibles: 2
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-1 ha cancel·lat una reserva. Places disponibles: 3
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-4 ha cancel·lat una reserva. Places disponibles: 4
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-9 ha cancel·lat una reserva. Places disponibles: 5
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-6 ha cancel·lat una reserva. Places disponibles: 6
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-0 ha fet una reserva. Places disponibles: 5
Assistent-3 ha cancel·lat una reserva. Places disponibles: 6
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-5 ha cancel·lat una reserva. Places disponibles: 7
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-1 ha fet una reserva. Places disponibles: 6
Assistent-7 ha cancel·lat una reserva. Places disponibles: 7
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-1 ha cancel·lat una reserva. Places disponibles: 8
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-0 ha fet una reserva. Places disponibles: 7
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-5 ha fet una reserva. Places disponibles: 6
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-6 ha cancel·lat una reserva. Places disponibles: 7
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-7 ha fet una reserva. Places disponibles: 6
Assistent-5 ha cancel·lat una reserva. Places disponibles: 7
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-8 ha fet una reserva. Places disponibles: 6
Assistent-7 ha cancel·lat una reserva. Places disponibles: 7
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-4 ha fet una reserva. Places disponibles: 6
Assistent-3 ha fet una reserva. Places disponibles: 5
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-0 ha cancel·lat una reserva. Places disponibles: 6
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-8 ha fet una reserva. Places disponibles: 5
Assistent-8 ha cancel·lat una reserva. Places disponibles: 6
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-3 ha cancel·lat una reserva. Places disponibles: 7
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-8 ha cancel·lat una reserva. Places disponibles: 8
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-4 ha cancel·lat una reserva. Places disponibles: 9
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 9
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 9
Assistent-5 ha fet una reserva. Places disponibles: 8
Assistent-5 ha cancel·lat una reserva. Places disponibles: 9
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 9
Assistent-9 ha fet una reserva. Places disponibles: 8
Assistent-4 ha fet una reserva. Places disponibles: 7
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-3 ha fet una reserva. Places disponibles: 6
Assistent-0 ha fet una reserva. Places disponibles: 5
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-2 ha fet una reserva. Places disponibles: 4
Assistent-2 ha cancel·lat una reserva. Places disponibles: 5
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-1 ha fet una reserva. Places disponibles: 4
Assistent-9 ha cancel·lat una reserva. Places disponibles: 5
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-3 ha cancel·lat una reserva. Places disponibles: 6
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-3 ha fet una reserva. Places disponibles: 5
Assistent-8 ha fet una reserva. Places disponibles: 4
Assistent-5 ha fet una reserva. Places disponibles: 3
Assistent-5 ha cancel·lat una reserva. Places disponibles: 4
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-4 ha cancel·lat una reserva. Places disponibles: 5
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-1 ha cancel·lat una reserva. Places disponibles: 6
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-7 ha fet una reserva. Places disponibles: 5
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-0 ha cancel·lat una reserva. Places disponibles: 6
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-8 ha cancel·lat una reserva. Places disponibles: 7
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-3 ha cancel·lat una reserva. Places disponibles: 8
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-7 ha cancel·lat una reserva. Places disponibles: 9
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 9
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 9
Assistent-7 ha fet una reserva. Places disponibles: 8
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-7 ha cancel·lat una reserva. Places disponibles: 9
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 9
Assistent-3 ha fet una reserva. Places disponibles: 8
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 8
Assistent-4 ha fet una reserva. Places disponibles: 7
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 7
Assistent-0 ha fet una reserva. Places disponibles: 6
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-3 ha fet una reserva. Places disponibles: 5
Assistent-2 ha fet una reserva. Places disponibles: 4
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-8 ha fet una reserva. Places disponibles: 3
Assistent-2 ha cancel·lat una reserva. Places disponibles: 4
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-5 ha fet una reserva. Places disponibles: 3
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-5 ha fet una reserva. Places disponibles: 2
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-4 ha cancel·lat una reserva. Places disponibles: 3
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-5 ha cancel·lat una reserva. Places disponibles: 4
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-0 ha cancel·lat una reserva. Places disponibles: 5
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-2 ha fet una reserva. Places disponibles: 4
Assistent-4 ha fet una reserva. Places disponibles: 3
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-9 ha fet una reserva. Places disponibles: 2
Assistent-4 ha fet una reserva. Places disponibles: 1
Assistent-8 ha fet una reserva. Places disponibles: 0
Assistent-3 ha cancel·lat una reserva. Places disponibles: 1
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-0 ha fet una reserva. Places disponibles: 0
Assistent-5 ha cancel·lat una reserva. Places disponibles: 1
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-7 ha fet una reserva. Places disponibles: 0
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-8 ha cancel·lat una reserva. Places disponibles: 1
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-9 ha fet una reserva. Places disponibles: 0
Assistent-4 ha cancel·lat una reserva. Places disponibles: 1
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-1 ha fet una reserva. Places disponibles: 0
Assistent-4 ha cancel·lat una reserva. Places disponibles: 1
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-2 ha fet una reserva. Places disponibles: 0
Assistent-8 ha cancel·lat una reserva. Places disponibles: 1
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-4 ha fet una reserva. Places disponibles: 0
Assistent-0 ha cancel·lat una reserva. Places disponibles: 1
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-7 ha cancel·lat una reserva. Places disponibles: 2
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-5 ha fet una reserva. Places disponibles: 1
Assistent-3 ha cancel·lat una reserva. Places disponibles: 2
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-5 ha cancel·lat una reserva. Places disponibles: 3
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-2 ha cancel·lat una reserva. Places disponibles: 4
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-9 ha cancel·lat una reserva. Places disponibles: 5
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-4 ha cancel·lat una reserva. Places disponibles: 6
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-2 ha fet una reserva. Places disponibles: 5
Assistent-5 ha fet una reserva. Places disponibles: 4
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-1 ha fet una reserva. Places disponibles: 3
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-2 ha cancel·lat una reserva. Places disponibles: 4
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-0 ha fet una reserva. Places disponibles: 3
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-0 ha fet una reserva. Places disponibles: 2
Assistent-6 ha fet una reserva. Places disponibles: 1
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-1 ha cancel·lat una reserva. Places disponibles: 2
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-5 ha cancel·lat una reserva. Places disponibles: 3
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-9 ha cancel·lat una reserva. Places disponibles: 4
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-2 ha fet una reserva. Places disponibles: 3
Assistent-6 ha cancel·lat una reserva. Places disponibles: 4
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-2 ha fet una reserva. Places disponibles: 3
Assistent-1 ha fet una reserva. Places disponibles: 2
Assistent-8 ha fet una reserva. Places disponibles: 1
Assistent-1 ha fet una reserva. Places disponibles: 0
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-0 ha cancel·lat una reserva. Places disponibles: 1
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-8 ha fet una reserva. Places disponibles: 0
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-2 ha cancel·lat una reserva. Places disponibles: 1
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-6 ha fet una reserva. Places disponibles: 0
Assistent-2 ha cancel·lat una reserva. Places disponibles: 1
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-6 ha fet una reserva. Places disponibles: 0
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-8 ha cancel·lat una reserva. Places disponibles: 1
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-1 ha fet una reserva. Places disponibles: 0
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-8 ha cancel·lat una reserva. Places disponibles: 1
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-6 ha fet una reserva. Places disponibles: 0
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 ha cancel·lat una reserva. Places disponibles: 1
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-0 ha fet una reserva. Places disponibles: 0
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 ha cancel·lat una reserva. Places disponibles: 1
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-5 ha fet una reserva. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-0 ha cancel·lat una reserva. Places disponibles: 1
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-2 ha fet una reserva. Places disponibles: 0
Assistent-0 ha cancel·lat una reserva. Places disponibles: 1
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-7 ha fet una reserva. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-5 ha cancel·lat una reserva. Places disponibles: 1
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-6 ha fet una reserva. Places disponibles: 0
Assistent-2 ha cancel·lat una reserva. Places disponibles: 1
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-3 ha fet una reserva. Places disponibles: 0
Assistent-7 ha cancel·lat una reserva. Places disponibles: 1
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-1 ha fet una reserva. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-1 ha cancel·lat una reserva. Places disponibles: 1
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-4 ha fet una reserva. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-4 ha cancel·lat una reserva. Places disponibles: 1
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-9 ha fet una reserva. Places disponibles: 0
Assistent-0 ha cancel·lat una reserva. Places disponibles: 1
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-2 ha fet una reserva. Places disponibles: 0
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-2 ha cancel·lat una reserva. Places disponibles: 1
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-3 ha fet una reserva. Places disponibles: 0
Assistent-6 ha cancel·lat una reserva. Places disponibles: 1
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-1 ha fet una reserva. Places disponibles: 0
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-1 ha cancel·lat una reserva. Places disponibles: 1
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-9 ha fet una reserva. Places disponibles: 0
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-3 ha cancel·lat una reserva. Places disponibles: 1
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-5 ha fet una reserva. Places disponibles: 0
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-2 ha cancel·lat una reserva. Places disponibles: 1
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-6 ha fet una reserva. Places disponibles: 0
Assistent-9 ha cancel·lat una reserva. Places disponibles: 1
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-7 ha fet una reserva. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-3 ha cancel·lat una reserva. Places disponibles: 1
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-7 ha fet una reserva. Places disponibles: 0
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-1 ha cancel·lat una reserva. Places disponibles: 1
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-8 ha fet una reserva. Places disponibles: 0
Assistent-6 ha cancel·lat una reserva. Places disponibles: 1
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-8 ha cancel·lat una reserva. Places disponibles: 2
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-6 ha fet una reserva. Places disponibles: 1
Assistent-9 ha cancel·lat una reserva. Places disponibles: 2
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-2 ha fet una reserva. Places disponibles: 1
Assistent-5 ha fet una reserva. Places disponibles: 0
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-1 ha cancel·lat una reserva. Places disponibles: 1
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-7 ha cancel·lat una reserva. Places disponibles: 2
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-9 ha fet una reserva. Places disponibles: 1
Assistent-0 ha fet una reserva. Places disponibles: 0
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-9 ha cancel·lat una reserva. Places disponibles: 1
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-6 ha cancel·lat una reserva. Places disponibles: 2
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-7 ha fet una reserva. Places disponibles: 1
Assistent-6 ha cancel·lat una reserva. Places disponibles: 2
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-9 ha fet una reserva. Places disponibles: 1
Assistent-2 ha cancel·lat una reserva. Places disponibles: 2
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-1 ha cancel·lat una reserva. Places disponibles: 3
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-5 ha cancel·lat una reserva. Places disponibles: 4
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-7 ha fet una reserva. Places disponibles: 3
Assistent-1 ha fet una reserva. Places disponibles: 2
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-0 ha fet una reserva. Places disponibles: 1
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-9 ha cancel·lat una reserva. Places disponibles: 2
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-0 ha fet una reserva. Places disponibles: 1
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-6 ha fet una reserva. Places disponibles: 0
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-1 ha cancel·lat una reserva. Places disponibles: 1
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-5 ha cancel·lat una reserva. Places disponibles: 2
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-7 ha fet una reserva. Places disponibles: 1
Assistent-4 ha fet una reserva. Places disponibles: 0
Assistent-1 ha cancel·lat una reserva. Places disponibles: 1
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-6 ha cancel·lat una reserva. Places disponibles: 2
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-2 ha fet una reserva. Places disponibles: 1
Assistent-0 ha fet una reserva. Places disponibles: 0
Assistent-2 ha cancel·lat una reserva. Places disponibles: 1
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-7 ha fet una reserva. Places disponibles: 0
Assistent-4 ha cancel·lat una reserva. Places disponibles: 1
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-0 ha fet una reserva. Places disponibles: 0
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-7 ha cancel·lat una reserva. Places disponibles: 1
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-6 ha fet una reserva. Places disponibles: 0
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 ha cancel·lat una reserva. Places disponibles: 1
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-1 ha fet una reserva. Places disponibles: 0
Assistent-7 ha cancel·lat una reserva. Places disponibles: 1
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-9 ha fet una reserva. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-1 ha cancel·lat una reserva. Places disponibles: 1
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-8 ha fet una reserva. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-9 ha cancel·lat una reserva. Places disponibles: 1
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-3 ha fet una reserva. Places disponibles: 0
Assistent-7 ha cancel·lat una reserva. Places disponibles: 1
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-8 ha fet una reserva. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-8 ha cancel·lat una reserva. Places disponibles: 1
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-0 ha fet una reserva. Places disponibles: 0
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-0 ha cancel·lat una reserva. Places disponibles: 1
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-6 ha fet una reserva. Places disponibles: 0
Assistent-6 ha cancel·lat una reserva. Places disponibles: 1
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-8 ha fet una reserva. Places disponibles: 0
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-8 ha cancel·lat una reserva. Places disponibles: 1
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-3 ha fet una reserva. Places disponibles: 0
Assistent-8 ha cancel·lat una reserva. Places disponibles: 1
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-0 ha fet una reserva. Places disponibles: 0
Assistent-3 ha cancel·lat una reserva. Places disponibles: 1
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-4 ha fet una reserva. Places disponibles: 0
Assistent-3 ha cancel·lat una reserva. Places disponibles: 1
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-1 ha fet una reserva. Places disponibles: 0
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-1 ha cancel·lat una reserva. Places disponibles: 1
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-7 ha fet una reserva. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-0 ha cancel·lat una reserva. Places disponibles: 1
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-6 ha fet una reserva. Places disponibles: 0
Assistent-6 ha cancel·lat una reserva. Places disponibles: 1
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-1 ha fet una reserva. Places disponibles: 0
Assistent-7 ha cancel·lat una reserva. Places disponibles: 1
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-9 ha fet una reserva. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-0 ha cancel·lat una reserva. Places disponibles: 1
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-3 ha fet una reserva. Places disponibles: 0
Assistent-1 ha cancel·lat una reserva. Places disponibles: 1
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-5 ha fet una reserva. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-7 ha cancel·lat una reserva. Places disponibles: 1
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-4 ha fet una reserva. Places disponibles: 0
Assistent-3 ha cancel·lat una reserva. Places disponibles: 1
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-1 ha fet una reserva. Places disponibles: 0
Assistent-9 ha cancel·lat una reserva. Places disponibles: 1
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-2 ha fet una reserva. Places disponibles: 0
Assistent-5 ha cancel·lat una reserva. Places disponibles: 1
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-6 ha fet una reserva. Places disponibles: 0
Assistent-7 ha cancel·lat una reserva. Places disponibles: 1
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-0 ha fet una reserva. Places disponibles: 0
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-2 ha cancel·lat una reserva. Places disponibles: 1
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-1 ha cancel·lat una reserva. Places disponibles: 2
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-8 ha fet una reserva. Places disponibles: 1
Assistent-6 ha cancel·lat una reserva. Places disponibles: 2
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-0 ha cancel·lat una reserva. Places disponibles: 3
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-4 ha cancel·lat una reserva. Places disponibles: 4
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-2 ha fet una reserva. Places disponibles: 3
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-1 ha fet una reserva. Places disponibles: 2
Assistent-8 ha fet una reserva. Places disponibles: 1
Assistent-7 ha fet una reserva. Places disponibles: 0
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-0 ha cancel·lat una reserva. Places disponibles: 1
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-9 ha fet una reserva. Places disponibles: 0
Assistent-4 ha cancel·lat una reserva. Places disponibles: 1
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-7 ha fet una reserva. Places disponibles: 0
Assistent-1 ha cancel·lat una reserva. Places disponibles: 1
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-6 ha fet una reserva. Places disponibles: 0
Assistent-9 ha cancel·lat una reserva. Places disponibles: 1
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-5 ha fet una reserva. Places disponibles: 0
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 ha cancel·lat una reserva. Places disponibles: 1
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-2 ha fet una reserva. Places disponibles: 0
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-7 ha cancel·lat una reserva. Places disponibles: 1
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-5 ha fet una reserva. Places disponibles: 0
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-7 ha cancel·lat una reserva. Places disponibles: 1
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-4 ha fet una reserva. Places disponibles: 0
Assistent-4 ha cancel·lat una reserva. Places disponibles: 1
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-0 ha fet una reserva. Places disponibles: 0
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-2 ha cancel·lat una reserva. Places disponibles: 1
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-8 ha fet una reserva. Places disponibles: 0
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-2 ha cancel·lat una reserva. Places disponibles: 1
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-9 ha fet una reserva. Places disponibles: 0
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-0 ha cancel·lat una reserva. Places disponibles: 1
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-7 ha fet una reserva. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-7 ha cancel·lat una reserva. Places disponibles: 1
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-0 ha fet una reserva. Places disponibles: 0
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-0 ha cancel·lat una reserva. Places disponibles: 1
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-5 ha fet una reserva. Places disponibles: 0
Assistent-8 ha cancel·lat una reserva. Places disponibles: 1
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-4 ha fet una reserva. Places disponibles: 0
Assistent-9 ha cancel·lat una reserva. Places disponibles: 1
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-2 ha fet una reserva. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-5 ha cancel·lat una reserva. Places disponibles: 1
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-1 ha fet una reserva. Places disponibles: 0
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-2 ha cancel·lat una reserva. Places disponibles: 1
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-6 ha fet una reserva. Places disponibles: 0
Assistent-0 ha cancel·lat una reserva. Places disponibles: 1
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-0 ha fet una reserva. Places disponibles: 0
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-8 ha cancel·lat una reserva. Places disponibles: 1
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-9 ha fet una reserva. Places disponibles: 0
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-4 ha cancel·lat una reserva. Places disponibles: 1
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-6 ha cancel·lat una reserva. Places disponibles: 2
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-1 ha cancel·lat una reserva. Places disponibles: 3
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-5 ha cancel·lat una reserva. Places disponibles: 4
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-3 ha fet una reserva. Places disponibles: 3
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-0 ha cancel·lat una reserva. Places disponibles: 4
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-4 ha fet una reserva. Places disponibles: 3
Assistent-8 ha cancel·lat una reserva. Places disponibles: 4
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-9 ha fet una reserva. Places disponibles: 3
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-9 ha cancel·lat una reserva. Places disponibles: 4
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 4
Assistent-5 ha cancel·lat una reserva. Places disponibles: 5
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-4 ha cancel·lat una reserva. Places disponibles: 6
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-0 ha fet una reserva. Places disponibles: 5
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-3 ha cancel·lat una reserva. Places disponibles: 6
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 6
Assistent-0 ha fet una reserva. Places disponibles: 5
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 5
Assistent-9 ha fet una reserva. Places disponibles: 4
Assistent-1 ha fet una reserva. Places disponibles: 3
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 3
Assistent-1 ha fet una reserva. Places disponibles: 2
Assistent-3 ha fet una reserva. Places disponibles: 1
Assistent-4 ha fet una reserva. Places disponibles: 0
Assistent-4 ha cancel·lat una reserva. Places disponibles: 1
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-1 ha fet una reserva. Places disponibles: 0
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-9 ha cancel·lat una reserva. Places disponibles: 1
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-6 ha fet una reserva. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-1 ha cancel·lat una reserva. Places disponibles: 1
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-0 ha fet una reserva. Places disponibles: 0
Assistent-6 ha cancel·lat una reserva. Places disponibles: 1
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-4 ha fet una reserva. Places disponibles: 0
Assistent-9 ha cancel·lat una reserva. Places disponibles: 1
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-5 ha fet una reserva. Places disponibles: 0
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-0 ha cancel·lat una reserva. Places disponibles: 1
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-7 ha fet una reserva. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-4 ha cancel·lat una reserva. Places disponibles: 1
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-1 ha fet una reserva. Places disponibles: 0
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-1 ha cancel·lat una reserva. Places disponibles: 1
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-5 ha fet una reserva. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-7 ha cancel·lat una reserva. Places disponibles: 1
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-0 ha fet una reserva. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-5 ha cancel·lat una reserva. Places disponibles: 1
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-2 ha fet una reserva. Places disponibles: 0
Assistent-5 ha cancel·lat una reserva. Places disponibles: 1
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-3 ha fet una reserva. Places disponibles: 0
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-2 ha cancel·lat una reserva. Places disponibles: 1
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-7 ha fet una reserva. Places disponibles: 0
Assistent-7 ha cancel·lat una reserva. Places disponibles: 1
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-1 ha fet una reserva. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-3 ha cancel·lat una reserva. Places disponibles: 1
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-3 ha cancel·lat una reserva. Places disponibles: 2
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 2
Assistent-1 ha fet una reserva. Places disponibles: 1
Assistent-2 ha fet una reserva. Places disponibles: 0
Assistent-0 ha cancel·lat una reserva. Places disponibles: 1
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-1 ha fet una reserva. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-0 ha cancel·lat una reserva. Places disponibles: 1
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-5 ha fet una reserva. Places disponibles: 0
Assistent-0 ha cancel·lat una reserva. Places disponibles: 1
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-3 ha fet una reserva. Places disponibles: 0
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-2 ha cancel·lat una reserva. Places disponibles: 1
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-6 ha fet una reserva. Places disponibles: 0
Assistent-5 ha cancel·lat una reserva. Places disponibles: 1
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-1 ha fet una reserva. Places disponibles: 0
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-9 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-3 ha cancel·lat una reserva. Places disponibles: 1
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-0 ha fet una reserva. Places disponibles: 0
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-0 ha cancel·lat una reserva. Places disponibles: 1
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-7 ha fet una reserva. Places disponibles: 0
Assistent-6 ha cancel·lat una reserva. Places disponibles: 1
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-8 ha fet una reserva. Places disponibles: 0
Assistent-0 ha cancel·lat una reserva. Places disponibles: 1
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-7 ha fet una reserva. Places disponibles: 0
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-7 ha cancel·lat una reserva. Places disponibles: 1
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-9 ha fet una reserva. Places disponibles: 0
Assistent-8 ha cancel·lat una reserva. Places disponibles: 1
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-6 ha fet una reserva. Places disponibles: 0
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 ha cancel·lat una reserva. Places disponibles: 1
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-1 ha fet una reserva. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-0 ha cancel·lat una reserva. Places disponibles: 1
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-3 ha fet una reserva. Places disponibles: 0
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-3 ha cancel·lat una reserva. Places disponibles: 1
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-2 ha fet una reserva. Places disponibles: 0
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-1 ha cancel·lat una reserva. Places disponibles: 1
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-8 ha fet una reserva. Places disponibles: 0
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-7 ha cancel·lat una reserva. Places disponibles: 1
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-6 ha fet una reserva. Places disponibles: 0
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-8 ha cancel·lat una reserva. Places disponibles: 1
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-9 ha fet una reserva. Places disponibles: 0
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 ha cancel·lat una reserva. Places disponibles: 1
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-1 ha fet una reserva. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-7 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-2 ha cancel·lat una reserva. Places disponibles: 1
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-9 ha fet una reserva. Places disponibles: 0
Assistent-4 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-1 ha cancel·lat una reserva. Places disponibles: 1
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-2 ha fet una reserva. Places disponibles: 0
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-2 ha cancel·lat una reserva. Places disponibles: 1
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-5 ha fet una reserva. Places disponibles: 0
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-5 ha cancel·lat una reserva. Places disponibles: 1
Assistent-5 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-6 ha fet una reserva. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-1 ha cancel·lat una reserva. Places disponibles: 1
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-7 ha fet una reserva. Places disponibles: 0
Assistent-1 ha cancel·lat una reserva. Places disponibles: 1
Assistent-1 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-0 ha fet una reserva. Places disponibles: 0
Assistent-0 ha cancel·lat una reserva. Places disponibles: 1
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-4 ha fet una reserva. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 ha cancel·lat una reserva. Places disponibles: 1
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 1
Assistent-9 ha fet una reserva. Places disponibles: 0
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-3 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-0 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-2 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-8 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
Assistent-6 no ha pogut cancel·lar una reserva inexistent. Places disponibles: 0
~~~~

### 3. Perquè creus que fa falta la llista i no valdria només amb una variable sencera de reserves? 
~~~~
El problema principal radica en el fet que no es podria saber quin dels fils ha fet la cancel·lació o la reserva. A més, en el mètode d’eliminació,
cal validar si aquest assistent té una reserva per permetre-li cancel·lar-la.
~~~~