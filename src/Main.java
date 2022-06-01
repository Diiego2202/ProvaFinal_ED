import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        
        String opcao;

        do{
            opcao = JOptionPane.showInputDialog(menu());
                try{   
                    if("".equals(opcao)){               
                    }else if ("1".equals(opcao)){
                        Processo.cadastrarProduto();
                    }else if ("2".equals(opcao)){
                        Processo.pesquisarProduto();
                    }else if ("3".equals(opcao)){
                        Processo.listarProduto();
                    }else if ("4".equals(opcao)){
                        Processo.removerProduto();
                    } else if("5".equals(opcao)){
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null,"Opção inválido! \nDigite um numero entre 1 e 5");
                        throw new UnsupportedOperationException();
                    }
                
                    }  catch (UnsupportedOperationException e) {
                        e.printStackTrace();
                    }
        }while (opcao != "5");

    }

    private static String menu(){
        String aux = "Marketplace Di-Be-Jo-LLa-Z's";
            aux += "\n1. Cadastrar produto";
            aux += "\n2. Pesquisar produto";
            aux += "\n3. Listar produtos";
            aux += "\n4. Remover produto";
            aux += "\n5. Finalizar";

        return aux;
    }
}
