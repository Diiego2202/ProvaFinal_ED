public class No {
    
    Produto prod;
    No esq, dir;

    public No(){
    }

    public No(Produto prod){
        this.prod = prod;
    }

    public void inserirNo(Produto aux){
        if(aux.getPreco() > prod.getPreco()){
            if(dir == null){
                dir = new No(aux);
            } else{
                dir.inserirNo(aux);
            }
        } else{
            if(aux.getPreco() < prod.getPreco()){
                if(esq == null){
                    esq = new No(prod);
                } else{
                    esq.inserirNo(aux);
                }
            }
        }
    }

}
