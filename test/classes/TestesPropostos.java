package classes;

import org.junit.Before;
import org.junit.Test;
import view.Caixa;
import view.Distribuidora;
import view.Estoque;
import view.Promocao;

public class TestesPropostos {
    @Before
    public void PreparandoBanco() {
        
        Distribuidora.adicionarDistribuidora("LV LOCACAO FERRAGISTA", "6235124169", "lvlocacaoferragista@hotmail.com");
        
        Estoque.cadastrarProdutoEstoque("A", 29.0, 50.0, 10, 1);
        Estoque.cadastrarProdutoEstoque("B", 17.0, 30.0, 10, 1);
        Estoque.cadastrarProdutoEstoque("C", 12.0, 20.0, 10, 1);
        Estoque.cadastrarProdutoEstoque("D", 9.0, 15.0, 10, 1);
        
        Promocao.adicionarPromocao("3 por 130", 1, 3, 130.0);
        Promocao.adicionarPromocao("2 por 45", 2, 2, 45.0);
        Promocao.adicionarPromocao("leve 3, pague 2", 3, 3, 40.0);
        
        System.out.println("BANCO PREPARADO COM SUCESSO!\n");
    }
    @Test
    public void Test1 (){
        Caixa.add("A");
        System.out.println("Add: A");
        System.out.println("TotalPrice: " + Caixa.getTotalPrice());
        System.out.println("TotalDiscount: " + Caixa.getTotalDiscount());
        
        Caixa.add("A");
        System.out.println("Add: A");
        System.out.println("TotalPrice: " + Caixa.getTotalPrice());
        System.out.println("TotalDiscount: " + Caixa.getTotalDiscount());
        
        Caixa.add("A");
        System.out.println("Add: A");
        System.out.println("TotalPrice: " + Caixa.getTotalPrice());
        System.out.println("TotalDiscount: " + Caixa.getTotalDiscount());
        
        Caixa.add("A");
        System.out.println("Add: A");
        System.out.println("TotalPrice: " + Caixa.getTotalPrice());
        System.out.println("TotalDiscount: " + Caixa.getTotalDiscount());
        
        Caixa.add("A");
        System.out.println("Add: A");
        System.out.println("TotalPrice: " + Caixa.getTotalPrice());
        System.out.println("TotalDiscount: " + Caixa.getTotalDiscount());
        
        Caixa.add("A");
        System.out.println("Add: A");
        System.out.println("TotalPrice: " + Caixa.getTotalPrice());
        System.out.println("TotalDiscount: " + Caixa.getTotalDiscount());
        
        Caixa.remove("A");
        System.out.println("Remove: A");
        System.out.println("TotalPrice: " + Caixa.getTotalPrice());
        System.out.println("TotalDiscount: " + Caixa.getTotalDiscount());
    }
    @Test
    public void Test2 (){
        Caixa.add("D");
        System.out.println("Add: D");
        System.out.println("TotalPrice: " + Caixa.getTotalPrice());
        System.out.println("TotalDiscount: " + Caixa.getTotalDiscount());
        
        Caixa.add("A");
        System.out.println("Add: A");
        System.out.println("TotalPrice: " + Caixa.getTotalPrice());
        System.out.println("TotalDiscount: " + Caixa.getTotalDiscount());
        
        Caixa.add("B");
        System.out.println("Add: B");
        System.out.println("TotalPrice: " + Caixa.getTotalPrice());
        System.out.println("TotalDiscount: " + Caixa.getTotalDiscount());
        
        Caixa.add("A");
        System.out.println("Add: A");
        System.out.println("TotalPrice: " + Caixa.getTotalPrice());
        System.out.println("TotalDiscount: " + Caixa.getTotalDiscount());
        
        Caixa.add("B");
        System.out.println("Add: B");
        System.out.println("TotalPrice: " + Caixa.getTotalPrice());
        System.out.println("TotalDiscount: " + Caixa.getTotalDiscount());
        
        Caixa.add("A");
        System.out.println("Add: A");
        System.out.println("TotalPrice: " + Caixa.getTotalPrice());
        System.out.println("TotalDiscount: " + Caixa.getTotalDiscount());
        
        Caixa.remove("A");
        System.out.println("Remove: A");
        System.out.println("TotalPrice: " + Caixa.getTotalPrice());
        System.out.println("TotalDiscount: " + Caixa.getTotalDiscount());
        
        Caixa.remove("B");
        System.out.println("Remove: B");
        System.out.println("TotalPrice: " + Caixa.getTotalPrice());
        System.out.println("TotalDiscount: " + Caixa.getTotalDiscount());
    }
    @Test
    public void Test3(){
        Caixa.add("C");
        System.out.println("Add: C");
        System.out.println("TotalPrice: " + Caixa.getTotalPrice());
        System.out.println("TotalDiscount: " + Caixa.getTotalDiscount());
        
        Caixa.add("C");
        System.out.println("Add: C");
        System.out.println("TotalPrice: " + Caixa.getTotalPrice());
        System.out.println("TotalDiscount: " + Caixa.getTotalDiscount());
        
        Caixa.add("C");
        System.out.println("Add: C");
        System.out.println("TotalPrice: " + Caixa.getTotalPrice());
        System.out.println("TotalDiscount: " + Caixa.getTotalDiscount());
        
        Caixa.add("C");
        System.out.println("Add: C");
        System.out.println("TotalPrice: " + Caixa.getTotalPrice());
        System.out.println("TotalDiscount: " + Caixa.getTotalDiscount());
        
        Caixa.remove("C");
        System.out.println("Remove: C");
        System.out.println("TotalPrice: " + Caixa.getTotalPrice());
        System.out.println("TotalDiscount: " + Caixa.getTotalDiscount());
        
        Caixa.remove("C");
        System.out.println("Remove: C");
        System.out.println("TotalPrice: " + Caixa.getTotalPrice());
        System.out.println("TotalDiscount: " + Caixa.getTotalDiscount());
    }
    @Test
    public void Test4(){
        Caixa.add("C");
        System.out.println("Add: C");
        System.out.println("TotalPrice: " + Caixa.getTotalPrice());
        System.out.println("TotalDiscount: " + Caixa.getTotalDiscount());
        
        Caixa.add("B");
        System.out.println("Add: B");
        System.out.println("TotalPrice: " + Caixa.getTotalPrice());
        System.out.println("TotalDiscount: " + Caixa.getTotalDiscount());
        
        Caixa.add("B");
        System.out.println("Add: B");
        System.out.println("TotalPrice: " + Caixa.getTotalPrice());
        System.out.println("TotalDiscount: " + Caixa.getTotalDiscount());
        
        Caixa.remove("B");
        System.out.println("Remove: B");
        System.out.println("TotalPrice: " + Caixa.getTotalPrice());
        System.out.println("TotalDiscount: " + Caixa.getTotalDiscount());
    }
}
