import javax.lang.model.util.ElementScanner14;
import javax.swing.JOptionPane;

public class ArvoreBinaria {
    
     // verificar direÃ§Ã£o filho e atribuir a variavel antes ex : aux = dir -> if pai.dir = aux
    private No raiz;
    private No pai = null;
    private int altura;
    private int AlturaTotal = 0;

    public No getRaiz() {
        return raiz;
    }

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
            JOptionPane.showMessageDialog(null,"Produto nÃ£o encontrado");
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
            if(atual.dir != null){ //2 filhos ou somentes filhos Ã  direita
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

            } else if(atual.esq != null){ //filho sÃ³ Ã  esquerda
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

                //removeu o elemento da Ã¡rvore
                if(aux.prod.getCodigo() < paiAux.prod.getCodigo()){
                    paiAux.esq = null;
                } else{
                    paiAux.dir = null;
                }
            } else{ //nÃ£o tem filho
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
        int altura= CalculaAltura(raiz); 
		JOptionPane.showMessageDialog(null, "A altura máxima da arvore é : " +altura);    
    }

    private int CalculaAltura(No raiz){
    int esq, dir;   
         if(raiz == null) {
             return -1; 
         } else {       
    
             esq = CalculaAltura(raiz.esq);
             dir = CalculaAltura(raiz.dir);
    
             if(esq > dir) {
                 return esq + 1;
             } else {
                 return dir + 1;
             }
         }
    }
    
 

}
