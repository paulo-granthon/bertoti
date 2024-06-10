package strategy.anti;

import com.sun.tools.javac.util.List;

public class Inheritance {
  public interface Emprestar {
    String emprestar(String item);
  }

  public class Professor implements Emprestar {
    public List<String> itensNãoEmprestáveis = new List<String>();

    @Override
    public String emprestar(String item) {
      return "Não tenho, foi mal :/";
    }
  }

  public class Estudante implements Emprestar {
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

      return "Não tenho, foi mal :/";
    }
  }

  public class Pessoa {
    private Emprestar emprestarBehavior;

    public void setEmprestarBehavior(Emprestar emprestarBehavior) {
      this.emprestarBehavior = emprestarBehavior;
    }

    public String emprestar(String item) {
      if (emprestarBehavior == null) {
        System.out.println("Não possuo o conceito de emprestar, foi mal :/");
      }

      return emprestarBehavior.emprestar(item);
    }
  }

  public static void main(String[] args) {
    Inheritance inheritance = new Inheritance();

    Pessoa professor = inheritance.new Pessoa();
    professor.setEmprestarBehavior(inheritance.new Professor());

    Pessoa estudante = inheritance.new Pessoa();
    estudante.setEmprestarBehavior(inheritance.new Estudante());

    System.out.println(professor.emprestar("caneta"));
    System.out.println(estudante.emprestar("caneta"));
  }
}
