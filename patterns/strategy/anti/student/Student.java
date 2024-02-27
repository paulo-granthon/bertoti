package strategy.anti.student;

import strategy.anti.client.Client;

public class Student extends Client {
  String ra;
  String curso;

  public void emprestar() {
    System.out.println("Eu n empresto, eu pego emprestado!");
  }
}
