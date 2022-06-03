import javax.swing.JOptionPane;

public class ArvoreBinaria {
    
    private No raiz;
    private No pai = null;

    public void inserir(Produto prod){
        
        if(raiz == null){
            raiz = new No(prod);
        } else{
            raiz.inserirNo(prod);
        }
    }

    public void pesquisar(int codigo){

        No aux = pesquisarRecursivo(codigo, raiz);
        if(aux!=null){
            JOptionPane.showMessageDialog(null,aux.prod);
        }else{
            JOptionPane.showMessageDialog(null,"Produto não encontrado");
        }
       
        
    }

    private No pesquisarRecursivo(int codigo, No raiz){

        if(raiz == null){
            return null;
        } else if(raiz.prod.getCodigo() == codigo){
            return raiz;
        }
        
        pai = raiz;
        if(codigo > raiz.prod.getCodigo()){
          return  pesquisarRecursivo(codigo, raiz.dir);
        } else{
           return pesquisarRecursivo(codigo, raiz.esq);
        }
     
    }

    public void imprimir(){
        if(raiz == null){
            JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado");
        }else{
            imprimirEmOrdem(raiz);
        }

    }
    private void imprimirEmOrdem(No raiz){
        if(raiz == null){
            return;
        }        
        imprimirEmOrdem(raiz.esq);
        JOptionPane.showMessageDialog(null,raiz.prod);
        imprimirEmOrdem(raiz.dir);
    }

    public void remover(int codigo){
        No aux = pesquisarRecursivo(codigo, raiz);

            if(pai==null){
                raiz = null;
            }else if(aux.dir == null && aux.esq == null){
                    if(pai.dir == aux){
                        pai.dir = null;
                    }else{
                        pai.esq = null;
                    }
            }else if (aux.dir != null && aux.esq == null){
                   if(pai.dir == aux){
                       pai.dir = aux.dir;
                   }else{
                       pai.esq = aux.dir;
                   }
            }else if (aux.dir == null && aux.esq != null){
                   if(pai.dir == aux){
                       pai.dir = aux.esq;
                   }else{
                       pai.esq = aux.esq;
                   }
            }else {
                    pai.dir = aux.dir;              
            }       
    }


}
