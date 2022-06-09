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
        if(catalogo.getRaiz() == null){
            JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado");
        } else{
            int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Codigo do produto: "));
            catalogo.pesquisar(codigo);
        } 
    }

    public static void listarProduto(){
        if(catalogo.getRaiz() == null){
            JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado");
        } else{
            catalogo.imprimir();
        } 
        
    }

    public static void removerProduto(){
        if(catalogo.getRaiz() == null){
            JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado");
        } else{
            int codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Codigo do produto: "));
            catalogo.teste(codigo);
        }      
    }

    public static void altura(){
        catalogo.altura();
    }

}
