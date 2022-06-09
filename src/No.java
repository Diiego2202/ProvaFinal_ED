public class No {
    
    Produto prod;
    No esq, dir;

    public No(){
    }

    public No(Produto prod){
        this.prod = prod;
    }

    public void inserirNo(Produto aux){
  
        if(aux.getCodigo() > prod.getCodigo()){
            if(dir == null){            
                dir = new No(aux);
            } else{
               dir.inserirNo(aux);
            }
        } else{
                if(esq == null){
                     esq = new No(aux);
                } else{
                    esq.inserirNo(aux);
                }
            }      
        }
}
