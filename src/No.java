public class No {
    
    Produto prod;
    No esq, dir;

    public No(){
    }

    public No(Produto prod){
        this.prod = prod;
    }

    public int inserirNo(Produto aux,int altura){
  
        if(aux.getCodigo() > prod.getCodigo()){
            if(dir == null){            
                dir = new No(aux);
                return altura +1 ;
            } else{
                altura++;
                return dir.inserirNo(aux,altura);
            }
        } else{
                if(esq == null){
                    esq = new No(aux);
                    return altura + 1;
                } else{
                    altura++;
                    return esq.inserirNo(aux,altura);
                }
            }
       
      
        }
}
