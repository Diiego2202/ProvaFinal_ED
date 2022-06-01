import javax.swing.JOptionPane;

public class ArvoreBinaria {
    
    private No raiz;

    public void inserir(Produto prod){
        
        if(raiz == null){
            raiz = new No(prod);
        } else{
            raiz.inserirNo(prod);
        }
    }

    public void pesquisar(int codigo){
        No aux = pesquisarRecursivo(codigo, raiz);
        JOptionPane.showMessageDialog(null,aux.prod);
    }

    private No pesquisarRecursivo(int codigo, No raiz){
        if(raiz == null){
            return null;
        } else if(raiz.prod.getCodigo() == codigo){
            return raiz;
        }
        
        if(codigo > raiz.prod.getCodigo()){
            pesquisarRecursivo(codigo, raiz.dir);
        } else if(codigo < raiz.prod.getCodigo()){
            pesquisarRecursivo(codigo, raiz.esq);
        }
        return null;       
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


}
