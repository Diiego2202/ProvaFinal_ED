import javax.swing.JOptionPane;

public class Processo {

    static ArvoreBinaria catalogo = new ArvoreBinaria();

    public static void cadastrarProduto(){
        int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Codigo do produto: "));
        String nome = JOptionPane.showInputDialog(null, "Nome do produto: ");
        int qtdEstoque = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantidade em estoque: "));
        double preco = Double.parseDouble(JOptionPane.showInputDialog(null, "Preço do produto: "));

        Produto prod = new Produto(codigo, nome, qtdEstoque, preco);
        catalogo.inserir(prod);

    }

    public static void pesquisarProduto(){
        int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Codigo do produto: "));
        //catalogo.pesquisar(codigo);
    }

    public static void listarProduto(){
        catalogo.imprimir();
    }

    public static void removerProduto(){
        //catalogo.remover(codigo);
    }

}
