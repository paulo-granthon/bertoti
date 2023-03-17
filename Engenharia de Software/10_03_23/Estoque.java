import java.util.List;
import java.util.ArrayList;

public class Estoque {
    private List<Produto> produtos = new ArrayList<Produto>();

    public void addProduto (Produto produto) {
        produtos.add(produto);
    }
    public List<Produto> buscaProdutoNome (String nome) {
        List<Produto> result = new ArrayList<Produto>();
        for (Produto produto : produtos) {
            if (produto.getName().equals(nome)) { 
                result.add(produto);
            }
        }
        return result;
    }

    public static void main(String[] args) {
    
    }
}
