public class Produto {
    
    private int codigo;
    private String nome;
    private int qtdEstoque;
    private double preco;

    public Produto(){
    }

    public Produto(int codigo, String nome, int qtdEstoque, double preco){
        this.codigo = codigo;
        this.nome = nome;
        this.qtdEstoque = qtdEstoque;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
