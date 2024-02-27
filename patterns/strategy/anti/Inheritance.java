package strategy.anti;

public class Inheritance {
  public class Client {
    String name;
    String address;
    String phone;
    String email;

    public void emprestar() {
      System.out.println("Pô mano, implementa o `emprestar` ta ligago?");
    }
  }

  public class Estudante extends Client {
    String ra;
    String curso;

    @Override
    public void emprestar() {
      System.out.println("Eu n empresto, eu pego emprestado!");
    }
  }

  public class Common extends Client {
    public void emprestar() {
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Inheritance inheritance = new Inheritance();

    Inheritance.Client c = inheritance.new Client();
    System.out.println("Client emprestar:");
    c.emprestar();

    Inheritance.Estudante e = inheritance.new Estudante();
    System.out.println("Estudante emprestar:");
    e.emprestar();
  }
}
