package br.com.improving.carrinho;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Classe que representa um item no carrinho de compras.
 */
public class Item {

    private Produto produto;
    private BigDecimal valorUnitario;
    private int quantidade;
    
    /**
     * Construtor da classe Item.
     * 
     * @param produto
     * @param valorUnitario
     * @param quantidade
     * @param valorTotal
     */
    
    public Item(Produto produto, BigDecimal valorUnitario, int quantidade) {
		super();
		this.produto = produto;
		this.valorUnitario = valorUnitario;
		this.quantidade = quantidade;
	}

	/**
     * Retorna o produto.
     *
     * @return Produto
     */
    public Produto getProduto() {
    	return this.produto;
    }

    /**
     * Retorna o valor unitário do item.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorUnitario() {
    	return this.valorUnitario;
    }

    /**
     * Retorna a quantidade dos item.
     *
     * @return int
     */
    public int getQuantidade() {
    	return this.quantidade;
    }

    
    /**
     * Seta o produto do item.
     *
     * @return BigDecimal
     */
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
    /**
     * Seta o valor Unitario do item.
     *
     * @return BigDecimal
     */
	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	/**
     * Seta o quantidade do item.
    *
    * @return BigDecimal
    */
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(produto);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return Objects.equals(produto, other.produto);
	}   
	
	


    
}
