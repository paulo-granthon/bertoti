package pulgas;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;


public class Quintal {

    static int PULGAS_INIT = 25;
    static int DOGS_INIT = 6;

    static int addPulgaCD = 60;
    int addPulgaTimer = 0;

    public List<Cachorro> cachorros = new LinkedList<Cachorro>();
    public List<Pulga> pulgas = new LinkedList<Pulga>();

    static  String[] NAMES = new String[] {
        "Miguel",
        "Gael",
        "Maria Alice",
        "Arthur",
        "Helena",
        "Heitor",
        "Alice",
        "Theo",
        "Laura",
        "Davi",
        "Samuel",
        "Bernardo",
        "Gabriel",
        "Ravi",
        "João Miguel",
        "Noah",
        "Maria Cecilia",
        "Cecilia",
        "Maite",
        "Heloisa",
    };
    public static String randomName (Random random) {
        return NAMES[random.nextInt(NAMES.length)];
    }

    public Quintal (Random random) {
        for (int i = 0; i < PULGAS_INIT; i++) {
            addPulga(new Pulga(randomName(random)));
        }
        
        for (int i = 0; i < DOGS_INIT; i++) {
            addCachorro(new Cachorro(randomName(random)));
        }
    }

    public static void main (String[] args) {

        Random random = new Random();
        Quintal quintal = new Quintal(random);

        final int FPS_LIMIT = 2; // Desired FPS limit
        final long FRAME_TIME = 1000 / FPS_LIMIT; // Time per frame in milliseconds

        long previousTime = System.currentTimeMillis();


        int day = 0;

        while (true) {

            day += 1;

            System.out.println("Dia " + day + "\t|\tCachorros: " + quintal.cachorros.size() + "\t|\tPulgas" + quintal.pulgas.size());

            if (quintal.addPulgaTimer >= addPulgaCD) {
                System.out.println("Nova Pulga adicionada! |  Pulgas " + (quintal.pulgas.size() - 1) + " -> " + quintal.pulgas.size());
                quintal.addPulga(new Pulga(randomName(random)));
                quintal.addPulgaTimer -= addPulgaCD;
            }
            
            else quintal.addPulgaTimer += 1;
            
            for (int i = 0; i < quintal.pulgas.size(); i++) {
                Pulga pulga = quintal.pulgas.get(i);
                if (pulga.update(quintal)) continue;
                System.out.println("Uma pulga morreu de fome | Pulgas " + quintal.pulgas.size() + " -> " + (quintal.pulgas.size() - 1));
                quintal.removePulga(pulga);
                i--;
            }
            
            for (int i = 0; i < quintal.cachorros.size(); i++) {
                Cachorro cachorro = quintal.cachorros.get(i);
                if (cachorro.update(quintal, random)) continue;
                System.out.println("Uma cachorro estava infeliz e fugiu! | Cachorros " + quintal.cachorros.size() + " -> " + (quintal.cachorros.size() - 1));
                quintal.removeCachorro(cachorro);
                i--;
            }

            long currentTime = System.currentTimeMillis();
            long elapsedTime = currentTime - previousTime;

            if (elapsedTime < FRAME_TIME) {
                try {
                    Thread.sleep(FRAME_TIME - elapsedTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            previousTime = currentTime;

        }

    }

    public void addPulga (Pulga pulga) {
        pulgas.add(pulga);
    }

    public boolean removePulga (Pulga p) {
        for (Pulga pulga : pulgas) {
            if (pulga != p) continue;
            pulgas.remove(p);
            return true;
        }
        return false;
    }

    public void addCachorro (Cachorro cachorro) {
        cachorros.add(cachorro);
    }

    public boolean removeCachorro (Cachorro p) {
        for (Cachorro cachorro : cachorros) {
            if (cachorro != p) continue;
            cachorros.remove(p);
            return true;
        }
        return false;
    }

}
