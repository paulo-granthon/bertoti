package pulgas;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static Random random;
    private static Yard yard;
    private static Stock stock;
    private static Scanner scanner;
    private static int day = 0;
    private static int actions;
    private static final int ACTIONS_PER_DAY = 6;

    public static void main (String[] args) {

        random = new Random();
        yard = new Yard(random);
        stock = new Stock(random);

        scanner = new Scanner(System.in);

        while (true) {

            newDay();
            
            while (actions > 0) checkInput();

            System.out.println("Puxa vida, já está tão tarde!\n*Você está cansado e foi dormir...*");

        }
    }

    private static void newDay () {

        yard.update(random);
        day++;
        actions = ACTIONS_PER_DAY;

        System.out.println("Dia " + day + "\t|\tCachorros: " + yard.getDogs().size() + "\t|\tPulgas: " + yard.getFleas().size());

        int overallHappiness = 0;
        for (Dog dog : yard.getDogs()) overallHappiness += dog.getHappiness();
        overallHappiness /= yard.getDogs().size();

        System.out.println(
            "No geral os cachorros estão " + Happiness.overallHappiness(overallHappiness, false, true) + " e as pulgas estão com fome!"
        );
    }

    private static void checkInput () {
        System.out.println("O que gostaria de fazer?\n1 - Ver Cachorros.\n2 - Ver estoque.\n3- Ir à Loja.\n0 - Nada.");
        try {
            switch (scanner.nextInt()) {
                case 0: break;
                case 1: checkDogs(); break;
                case 2: checkStock(); break;
                case 3: goShopping(); break;
                default: throw new Exception("Comando Inválido");
            }
        } catch (Exception e) {
            System.out.println("Comando inválido");
            checkInput();
        }
    }

    private static void checkDogs () {
        StringBuilder sb = new StringBuilder("Qual cachorro gostaria de dar atenção?");
        List<Dog> dogs = yard.getDogs();
        for (int i = 0; i < dogs.size(); i++) {
            sb.append("\n").append(i + 1).append(" - ").append(dogs.get(i).getName());
        }
        System.out.println(sb.append("\n0 - Nenhum").toString());
        try {
            int choice = scanner.nextInt();
            if (choice < 0 || choice > dogs.size() + 1) throw new Exception("Comando Inválido");
            
            if (choice != 0) checkDog(dogs.get(choice - 1));

        } catch (Exception e) {
            checkDogs();
        }
    }

    private static void checkStock () {
        // TODO
    }

    private static void goShopping () {
        // TODO
    }

    private static void checkDog (Dog dog) {
        System.out.println(
            new StringBuilder("Nome: ").append(dog.getName()).append("\tRaça: ").append(dog.getRace())
        .toString());
        System.out.println(Ascii.dog(dog.getRace()));
        System.out.println(
            new StringBuilder("O que gostaria de fazer?")
            .append("\n1 - Fazer carinho em ").append(dog.getName())
            .append("\n2 - Dar banho em ").append(dog.getName())
            .append("\n0 - Voltar")
        .toString());
        try {
            switch (scanner.nextInt()) {
                case 0: actions--; break;
                case 1: giveBath(dog); break;
                case 2: pet(dog); break;
                // case 3: goShopping(); break;
                default: throw new Exception("Comando Inválido");
            }
        } catch (Exception e) {
            checkInput();
        }
    }

    private static void giveBath (Dog dog) {
        Optional<Shampoo> shampoo = chooseShampoo();
        int uses = shampoo.isPresent() ? chooseNumber("Quanto gostaria de usar?", 1, 4) : 1;
        dog.takeBath(shampoo, uses, yard, random);
        actions--;
    }

    private static Optional<Shampoo> chooseShampoo () {
        StringBuilder sb = new StringBuilder("Qual shampoo gostaria de usar?");
        List<Shampoo> shampoos = stock.getShampoos();
        for (int i = 0; i < shampoos.size(); i++) {
            sb.append("\n").append(i + 1).append(" - ").append(shampoos.get(i).getName());
        }
        System.out.println(sb.append("\n0 - Nenhum.").toString());
        try {
            int choice = scanner.nextInt();
            if (choice < 0 || choice > shampoos.size() + 1) throw new Exception("Comando Inválido");
            if (choice == 0) return Optional.empty();
            return Optional.of(shampoos.get(choice - 1));

        } catch (Exception e) {
            return chooseShampoo();
        }
    }

    private static int chooseNumber (String prompt, int min, int max) {
        System.out.println(
            new StringBuilder(prompt).append(" (").append(min).append(" ~ ").append(max).append("): ")
        );
        try {
            int choice = scanner.nextInt();
            if (choice < min || choice > max) throw new Exception("Comando Inválido");
            return choice;
        } catch (Exception e) {
            System.out.println(
                new StringBuilder("Quantidade inváliad, por favor insira um número entre ")
                .append(min).append(" e ").append(max).toString()
            );
            return chooseNumber(prompt, min, max);
        }
    }

    private static void pet (Dog dog) {
        dog.bePetted();
        actions--;
    }


}
