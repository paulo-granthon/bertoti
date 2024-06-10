package observer.pattern;

import java.util.List;

public class Observer {
  public class ChatRoom {
    private List<Device> devices;

    public void addDevice(Device device) {
      devices.add(device);
    }

    public void sendMessage(Device device, String message) {
      for (Device d : devices) {
        if (d == device) continue;
        d.receiveMessage(message);
      }
    }
  }

  public interface Device {
    String getName();
    void receiveMessage(String message);
  }

  public class Computer implements Device {
    public Device(String name) {
      this.name = name;
    }

    public void receiveMessage(String message) {
      System.out.println("Computer " + name + " received: " + message);
    }
  }

  public class Smartphone implements Device {
    public Device(String name) {
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

    chatRoom.addDevice(computer);
    chatRoom.addDevice(smartphone);

    chatRoom.sendMessage(null, "Hello World!"); // Computer_1 and Smartphone_1 received: Hello World!
    chatRoom.sendMessage(computer, "Hello Smartphone_1!"); // Computer_1 received: Hello Smartphone_1!
    chatRoom.sendMessage(smartphone, "Hello Desktop_1!"); // Smartphone_1 received: Hello Desktop_1!
  }
}
