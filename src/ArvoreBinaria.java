public class ArvoreBinaria {
    
    private No raiz;

    public void inserir(Produto prod){
        No aux = new No(prod);
        if(raiz == null){
            raiz = aux;
        }
    }

}
