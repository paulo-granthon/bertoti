package pulgas;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import pulgas.data.AcceptedContract;
import pulgas.data.Contract;
import pulgas.data.ContractResult;
import pulgas.entities.Dog;
import pulgas.main.Stock;
import pulgas.main.Yard;
import pulgas.products.ProductData;
import pulgas.products.Shampoo;
import pulgas.products.Shop;
import pulgas.utils.Ascii;
import pulgas.utils.Happiness;
import pulgas.utils.RandGen;
import pulgas.utils.Reputation;

public class Main {

    private static RandGen randGen;
    private static Yard yard;
    private static Stock stock;

    private static LinkedList<AcceptedContract> contracts;

    private static Shop shop;

    private static int reputation;

    private static int day = 0;

    private static int actions;
    private static final int ACTIONS_PER_DAY = 6;

    private static Scanner scanner;

    public static void main (String[] args) {

        newGame();
    }

    private static boolean newGame () {
        randGen = new RandGen();
        yard = new Yard(randGen);
        stock = new Stock(randGen);
        contracts = new LinkedList<>();
        day = 0;
        reputation = 50;

        shop = new Shop(randGen);

        scanner = new Scanner(System.in);
    
        Contract contract = Contract.random(randGen);
        if (proposeContract(contract)) contracts.add(new AcceptedContract(contract));;

        while (true) {
            if (!newDay()) break;
            while (actions > 0) checkInput();
            System.out.println("\nPuxa vida, já está tão tarde!\n*Você está cansado e foi dormir...*\n");
        }

        return false;
    }

    private static boolean newDay () {

        yard.update(randGen);
        day++;

        handleContracts(randGen);

        System.out.println("No geral sua reputação está " + Reputation.overallReputation(reputation));

        if (reputation <= 0) return gameOver();

        actions = ACTIONS_PER_DAY;

        int dogCount = yard.getDogs().size();

        System.out.println("Dia " + day + "\t|\tCachorros: " + dogCount + "\t|\tPulgas: " + yard.getFleas().size());

        int overallHappiness = 0;
        for (Dog dog : yard.getDogs()) overallHappiness += dog.getHappiness();
        overallHappiness /= dogCount > 0 ? dogCount : 1;

        System.out.println(
            "No geral os cachorros estão " + Happiness.overallHappiness(overallHappiness, false, true) + " e as pulgas estão com fome!"
        );

        return true;
    }

    private static void handleContracts (RandGen randGen) {

        for (int i = 0; i < contracts.size(); i ++) {
            AcceptedContract contract = contracts.get(i);

            if (!contract.count()) continue;

            ContractResult result = contract.getResult();

            int contractPayment = result.getPayment();
            int contractReputation = result.getReputation();

            System.out.println(
                new StringBuilder("O contrato com ").append(contract.getOwner())
                .append(" foi concluído. Você ganhou ").append(contractPayment)
                .append(" dinheiro e sua reputação ficou ").append(Reputation.factorAdjective(contractReputation))
            );

            stock.addMoney(contractPayment);
            reputation += contractReputation;

            contracts.remove(contract);
            i--;
        }

        handleNewContracts();
    }

    private static void handleNewContracts() {
        Contract[] contractOffers = Contract.randomArray(randGen);

        for (Contract contract : contractOffers) {
            if (!proposeContract(contract)) continue;

            contracts.add(new AcceptedContract(contract));
        }
    }

    private static boolean proposeContract (Contract contract) {
        Dog dog = contract.getDog();
        System.out.println(
            new StringBuilder(contract.getOwner()).append(" gostaria de deixar ").append(dog.getName())
            .append(" em seus cuidados por ").append(contract.getDays()).append(" dias. ").append(dog.getName())
            .append(" aparenta estar ").append(Happiness.overallHappiness(dog.getHappiness(), true, false))
            .append(" Aceitas cuidar de ").append(dog.getName()).append("?\n1 - Sim.\n2 - Não")
        );
        try {
            switch (scanner.nextInt()) {
                case 1: return true;
                case 2: return false;
                default: throw new Exception("Comando Inválido");
            }
        } catch (Exception e) {
            System.out.println("Comando inválido");
            return proposeContract(contract);
        }

    }

    private static void checkInput () {
        System.out.println("O que gostaria de fazer?\n1 - Ver Cachorros.\n2 - Ver estoque.\n3 - Ir à Loja.\n0 - Nada.");
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
        StringBuilder sb = new StringBuilder("Você possui ")
            .append(stock.getMoney()).append(" dinheiros e os seguintes items em estoque no momento:"
        );
        List<Shampoo> shampoos = stock.getShampoos();
        for (int i = 0; i < shampoos.size(); i++) {
            sb.append("\n ").append(shampoos.get(i).getName());
        }
        System.out.println(sb.append("\n0 - Voltar").toString());
        try {
            if (scanner.nextInt() != 0) throw new Exception("Comando Inválido");
        } catch (Exception e) {}
    }

    private static void goShopping () {
        StringBuilder sb = new StringBuilder("Bem vindo a loja, você possui ").append(stock.getMoney())
            .append(" dinheiros. O que gostaria de adquirir?");
        List<ProductData> products = shop.getProducts();
        for (int i = 0; i < products.size(); i++) {
            ProductData product = products.get(i);
            sb.append("\n").append(i + 1).append(" - ").append(product.getName())
            .append(" (Ð$: ").append(product.getProduct().getPrice()).append(") ")
            .append(" | ").append(product.getStock()).append(" em estoque");
        }
        System.out.println(sb.append("\n0 - Nenhum").toString());
        try {
            int choice = scanner.nextInt();
            if (choice < 0 || choice > products.size() + 1) throw new Exception("Comando Inválido");
            if (choice == 0) return;
            
            int amount = chooseNumber("Quantos gostaria de comprar? ", 0, products.get(choice).getStock());
            shop.buyProduct(choice, amount);

        } catch (Exception e) {
            e.printStackTrace();
            goShopping();
        }
    }

    private static void checkDog (Dog dog) {
        System.out.println(
            new StringBuilder("Nome: ").append(dog.getName()).append("\tRaça: ").append(dog.getRace())
        .toString());
        System.out.println(Ascii.dog(dog.getRace()));
        System.out.println(
            new StringBuilder("O que gostaria de fazer?")
            .append("\n1 - Dar banho em ").append(dog.getName())
            .append("\n2 - Fazer carinho em ").append(dog.getName())
            .append("\n0 - Voltar")
        .toString());
        try {
            switch (scanner.nextInt()) {
                case 0: actions--; break;
                case 1: giveBath(dog); break;
                case 2: pet(dog); break;
                default: throw new Exception("Comando Inválido");
            }
        } catch (Exception e) {
            checkInput();
        }
    }

    private static void giveBath (Dog dog) {
        Optional<Shampoo> shampooOptional = chooseShampoo();
        int actualUses = 1;
        double shampooQuality = 0.5;
        double shampooSmell = 0.5;
        if (shampooOptional.isPresent()) {
            Shampoo shampoo = shampooOptional.get();
            shampooQuality = shampoo.getQuality();
            shampooSmell = shampoo.getSmell();
            int shampooUses = chooseNumber("Quanto gostaria de usar?", 1, Math.min(4, shampoo.getUses()));
            actualUses = shampoo.use(shampooUses);
            if (shampoo.getUses() == 0) System.out.println("O Shampoo " + shampoo.getName() + " acabou!");
            if (actualUses != shampooUses) System.out.println(
                "Não tinha Shampoo suficiente para " + shampooUses + 
                " usos! Usando " + actualUses + " de Shampoo."
            );
            System.out.println("Usando " + actualUses + " de Shampoo.");
        }

        dog.takeBath(shampooQuality * actualUses, shampooSmell * actualUses, yard, randGen);
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

    private static boolean gameOver() {
        System.out.println("Sua reputação chegou a zero e seu PetSpa faliu! Quer jogar novamente?\n1 - Sim\n2 - Não");
        try {
            switch (scanner.nextInt()) {
                case 1: return newGame();
                case 2: 
                    System.out.println("Obrigado por jogar :)");
                    return false;
                default: throw new Exception("Comando Inválido");
            }
        } catch (Exception e) {
            System.out.println("Comando inválido");
            return gameOver();
        }
    }
}
