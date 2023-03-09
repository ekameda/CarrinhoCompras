package br.com.improving.carrinho;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Classe que representa o carrinho de compras de um cliente.
 */
public class CarrinhoCompras {
	

	List<Item> items = new ArrayList<Item>();

	private String identificacaoCliente;
		

	public String getIdentificacaoCliente() {
		return identificacaoCliente;
	}
	public void setIdentificacaoCliente(String identificacaoCliente) {
		this.identificacaoCliente = identificacaoCliente;
	}
	/**
     * Permite a adição de um novo item no carrinho de compras.
     *
     * Caso o item já exista no carrinho para este mesmo produto, as seguintes regras deverão ser seguidas:
     * - A quantidade do item deverá ser a soma da quantidade atual com a quantidade passada como parâmetro.
     * - Se o valor unitário informado for diferente do valor unitário atual do item, o novo valor unitário do item deverá ser
     * o passado como parâmetro.
     *
     * Devem ser lançadas subclasses de RuntimeException caso não seja possível adicionar o item ao carrinho de compras.
     *
     * @param produto
     * @param valorUnitario
     * @param quantidade
     */
    public void adicionarItem(Produto produto, BigDecimal valorUnitario, int quantidade) {
    	for (Item elemento : items) {
    		if (items.contains(produto))	{
    			System.out.println("Esse produto já foi adicionado a quantidade e atualizado o valorUnitario.");
    			elemento.setQuantidade(quantidade + elemento.getQuantidade());
    			elemento.setValorUnitario(valorUnitario);
    			
    		} else {	
    			try {
    				Item item = new Item(produto,valorUnitario,quantidade);
    				items.add(item);
    				System.out.println("Produto adicionado.");					
				} catch (RuntimeException e) {

    				System.out.println(e);
				}    			
    		}
    	}    	
    }
	/**
	 * Permite a remoção do item que representa este produto do carrinho de compras.
	 *
	 * @param produto
	 * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e
	 *         false caso o produto não exista no carrinho.
	 */
	public boolean removerItem(Produto produto) {
		for (Item elemento : items) {
    		if (items.contains(produto))	{
    			System.out.println("Produto removido do carrinho de compras.");
    			items.remove(produto);
    			return true;    			
    		} else {
    			return false;
    		}
    	}
		return false;   
	}
	
	/**
	 * Permite a remoção do item de acordo com a posição. Essa posição deve ser determinada pela
	 * ordem de inclusão do produto na coleção, em que zero representa o primeiro item.
	 *
	 * @return Retorna um boolean, tendo o valor true caso o produto exista no carrinho de compras e
	 *         false caso o produto não exista no carrinho.
	 */
	public boolean removerItem(int posicaoItem) {
		for (int i=0; i< items.size(); i++) {
    		if ( i == posicaoItem)	{
    			System.out.println("Produto removido do carrinho de compras.");
    			items.get(posicaoItem);
    			return true;    			
    		} else {
    			return false;
    		}
    	}
		return false;   
	}
	
	/**
	 * Retorna o valor total do carrinho de compras, que deve ser a soma dos valores totais de todos
	 * os itens que compõem o carrinho.
	 *
	 * @return BigDecimal
	 */
	public BigDecimal getValorTotal() {
		BigDecimal total =BigDecimal.ZERO;
		
		for (Item elemento : items) {
			BigDecimal valorUnitario = elemento.getValorUnitario();
			int qt = elemento.getQuantidade();
			BigDecimal temp = new BigDecimal(qt);
			return total = total.add(valorUnitario.multiply(temp));
    	} 
		return total;
	}

	/**
	 * Retorna a lista de itens do carrinho de compras.
	 *
	 * @return itens
	 */
	public Collection<Item> getItens() {

		items.forEach(System.out::println);
		return items;
	}
}