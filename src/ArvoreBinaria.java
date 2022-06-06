import javax.lang.model.util.ElementScanner14;
import javax.swing.JOptionPane;

public class ArvoreBinaria {
    
     // verificar direção filho e atribuir a variavel antes ex : aux = dir -> if pai.dir = aux
    private No raiz;
    private No pai = null;
    private int altura;
    private int AlturaTotal = 0;

    public No getRaiz() {
        return raiz;
    }

    public void inserir(Produto prod){
        altura = 0;
        if(raiz == null){
            raiz = new No(prod);
        } else{    
            altura = raiz.inserirNo(prod,altura);
        }

        if (altura>=AlturaTotal){
            AlturaTotal = altura;
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
        imprimirEmOrdem(raiz);
    }
    private void imprimirEmOrdem(No raiz){
        if(raiz == null){
            return;
        }        
        imprimirEmOrdem(raiz.esq);
        JOptionPane.showMessageDialog(null,raiz.prod);
        imprimirEmOrdem(raiz.dir);
    }

 //  public void remover(int codigo){
 //      No aux = pesquisarRecursivo(codigo, raiz);

 //          if(pai==null && aux.dir == null && aux.esq == null){
 //              raiz = null;
 //          }else if(aux.dir == null && aux.esq == null){
 //                  if(pai.dir == aux){
 //                      pai.dir = null;
 //                  }else{
 //                      pai.esq = null;
 //                  }
 //          }else if (aux.dir != null && aux.esq == null){
 //                 if(pai.dir == aux){
 //                     pai.dir = aux.dir;
 //                 }else{
 //                     pai.esq = aux.dir;
 //                 }
 //          }else if (aux.dir == null && aux.esq != null){
 //                 if(pai.dir == aux){
 //                     pai.dir = aux.esq;
 //                 }else{
 //                     pai.esq = aux.esq;
 //                 }
 //          }else {   
 //                  No posi;
 //                  if(pai == null){
 //                       posi = null;   
 //                  }else if(pai.dir == aux){
 //                       posi = pai.dir;
 //                  }else{
 //                      posi = pai.esq; 
 //                  }

 //                  No filho = aux;
 //                  No paidofilho = null;
 //                  while (aux.esq != null){
 //                      paidofilho = aux;
 //                      aux = aux.esq;
 //                  }          
 //                    paidofilho.esq = null;        
 //                    aux.esq = filho.esq;
 //                    aux.dir = filho.dir; 
 //                    if (posi != null){
 //                      posi = aux;
 //                    }
 //                            
 //          }       
 //  }

    //teste remover
    public boolean teste(int codigo){
        No atual = this.raiz;
        No pai = null;

        while(atual != null){
            if(atual.prod.getCodigo() == codigo){
                break;
            } else if(codigo < atual.prod.getCodigo()){
                pai = atual;
                atual = atual.esq;
            } else{
                pai = atual;
                atual = atual.dir;
            }
        }
        //verifica se o elemento existe
        if(atual != null){
            if(atual.dir != null){ //2 filhos ou somentes filhos à direita
                No aux = atual.dir;
                No paiAux = atual;
                while(aux.esq != null){
                    paiAux = aux;
                    aux = aux.esq;
                }
                aux.esq = atual.esq;
                if(pai != null){
                    if(atual.prod.getCodigo() < pai.prod.getCodigo()){
                        pai.esq = aux;
                    } else{
                        pai.dir = aux;
                    }
                } else{
                    this.raiz = aux;
                    this.raiz.dir = aux.dir;
                    this.raiz.esq = atual.esq;
                }

                if(aux.prod.getCodigo() < paiAux.prod.getCodigo()){
                    paiAux.esq = null;
                } else{
                    paiAux.dir = null;
                }

            } else if(atual.esq != null){ //filho só à esquerda
                No aux = atual.esq;
                No paiAux = atual;
                while(aux.dir != null){
                    paiAux = aux;
                    aux = aux.dir;
                }

                if(pai != null){
                    if(atual.prod.getCodigo() < pai.prod.getCodigo()){
                        pai.esq = aux;
                    } else{
                        pai.dir = aux;
                    }
                } else{
                    this.raiz = aux;
                }

                //removeu o elemento da árvore
                if(aux.prod.getCodigo() < paiAux.prod.getCodigo()){
                    paiAux.esq = null;
                } else{
                    paiAux.dir = null;
                }
            } else{ //não tem filho
                if(pai != null){
                    if(atual.prod.getCodigo() < pai.prod.getCodigo()){
                        pai.esq = null;
                    } else{
                        pai.dir = null;
                    }
                } else{
                    this.raiz = null;
                } 
            }

            return true;
        } else{
            return false;
        }
    }

    public void altura(){
		JOptionPane.showMessageDialog(null, AlturaTotal);
	}

}
