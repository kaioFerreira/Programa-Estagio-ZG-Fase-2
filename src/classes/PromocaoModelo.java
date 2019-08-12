package classes;

public class PromocaoModelo {

    private String nomePromocao;
    private int produtoRelacionado;
    private int quantidadeLeva;
    private Double valorUnidade;
    private Double valorTotal;

    public String getNomePromocao() {
        return nomePromocao;
    }

    public void setNomePromocao(String nomePromocao) {
        this.nomePromocao = nomePromocao;
    }

    public int getProdutoRelacionado() {
        return produtoRelacionado;
    }

    public void setProdutoRelacionado(int produtoRelacionado) {
        this.produtoRelacionado = produtoRelacionado;
    }

    public int getQuantidadeLeva() {
        return quantidadeLeva;
    }

    public void setQuantidadeLeva(int quantidadeLeva) {
        this.quantidadeLeva = quantidadeLeva;
    }

    public Double getValorUnidade() {
        return valorUnidade;
    }

    public void setValorUnidade(Double valorUnidade) {
        this.valorUnidade = valorUnidade;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
