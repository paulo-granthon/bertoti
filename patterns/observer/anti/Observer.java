package observer.anti;

public class Observer {
  public class ChatRoom {
    private List<Computer> computers;
    private List<Smartphone> smartphones;

    public void addComputer(Computer computer) {
      computers.add(computer);
    }

    public void addSmartphone(Smartphone smartphone) {
      smartphones.add(smartphone);
    }

    public void sendMessageFromComputer(Computer computer, String message) {
      for (Computer c : computers) {
        if (c == computer) continue;
        c.receiveMessage(message);
      }
      for (Smartphone s : smartphones) {
        s.receiveMessage(message);
      }
    }

    public void sendMessageFromSmartphone(Smartphone smartphone, String message) {
      for (Smartphone s : smartphones) {
        if (s == smartphone) continue;
        s.receiveMessage(message);
      }
      for (Computer c : computers) {
        c.receiveMessage(message);
      }
    }
  }

  public class Computer {
    private String name;

    public Computer(String name) {
      this.name = name;
    }

    public void receiveMessage(String message) {
      System.out.println("Computer " + name + " received: " + message);
    }
  }

  public class Smartphone {
    private String name;

    public Smartphone(String name) {
      this.name = name;
    }

    public void receiveMessage(String message) {
      System.out.println("Smartphone " + name + " received: " + message);
    }
  }

  public static void main(String[] args) {
    ChatRoom chatRoom = new ChatRoom();

    Computer computer = new Computer("Desktop_1");
    Smartphone smartphone = new Smartphone("Smartphone_1");

    chatRoom.addComputer(computer);
    chatRoom.addSmartphone(smartphone);

    chatRoom.sendMessageFromComputer(computer, "Hello World!"); // Computer_1 and Smartphone_1 received: Hello World!
    chatRoom.sendMessageFromSmartphone(smartphone, "Hello Desktop_1!"); // Smartphone_1 received: Hello Desktop_1!
  }
}
