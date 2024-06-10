package strategy.anti;

import com.util.List;

public class Inheritance {
  public class Pessoa {
    public String emprestar(String item) {
      System.out.println("Não tenho, foi mal :/");
    }
  }

  public class Professor {
    public List<String> itensNãoEmprestáveis = new List<String>();

    @Override
    public String emprestar(String item) {
      return super.emprestar(item);
    }
  }

  public class Estudante extends Client {
    public List<String> estojo = new List<String>();

    public Estudante() {
      estojo.add("caneta");
      estojo.add("lápis");
      estojo.add("borracha");
    }

    @Override
    public String emprestar(String item) {
      if (estojo.contains(item)) {
        return "Empresto o " + item + " pra você sim, meu mano!";
      }

      super.emprestar(item);
    }
  }

  public static void main(String[] args) {
    Inheritance inheritance = new Inheritance();

    Professor professor = inheritance.new Professor();
    Estudante estudante = inheritance.new Estudante();

    System.out.println(professor.emprestar("caneta"));
    System.out.println(estudante.emprestar("caneta"));
  }
}
