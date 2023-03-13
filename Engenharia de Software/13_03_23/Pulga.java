public class Pulga {
    String nome;
    int fome;

    Cachorro cachorro;

    public Pulga (String nome) {
        this.nome = nome;
    }

    public boolean sugar () {
        if (cachorro == null) return false;
        if (fome < 1) return false;
        fome -= 1;
        return true;
    }

    public void pular () {
        System.out.println(nome + "pulou");
    }
}