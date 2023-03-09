package br.com.improving.carrinho;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pela criação e recuperação dos carrinhos de compras.
 */
public class CarrinhoComprasFactory {

	CarrinhoCompras carrinhoCompras = new CarrinhoCompras();
	
	public CarrinhoComprasFactory() {
	}

    /**
     * Cria e retorna um novo carrinho de compras para o cliente passado como parâmetro.
     *
     * Caso já exista um carrinho de compras para o cliente passado como parâmetro, este carrinho deverá ser retornado.
     *
     * @param identificacaoCliente
     * @return CarrinhoCompras
     */
    public CarrinhoCompras criar(String identificacaoCliente) {
    	
    	carrinhoCompras.getIdentificacaoCliente().equals(identificacaoCliente); {
    		return carrinhoCompras;
    	}
    }

    /**
     * Retorna o valor do ticket médio no momento da chamada ao método.
     * O valor do ticket médio é a soma do valor total de todos os carrinhos de compra dividido
     * pela quantidade de carrinhos de compra.
     * O valor retornado deverá ser arredondado com duas casas decimais, seguindo a regra:
     * 0-4 deve ser arredondado para baixo e 5-9 deve ser arredondado para cima.
     *
     * @return BigDecimal
     */
    public BigDecimal getValorTicketMedio() {
    	
    	int quantidade = 0;  
    	BigDecimal temp = BigDecimal.ZERO;
    	BigDecimal valor = BigDecimal.ZERO;
    	List<Item> items = (List<Item>) carrinhoCompras.getItens();
    	Item item;
    	  	
    	for (int posicao = 0; posicao > carrinhoCompras.items.size(); posicao++) {    		
    		item = items.get(posicao);
    		BigDecimal valorUnitario = item.getValorUnitario();
    		quantidade = quantidade + item.getQuantidade();
    		temp = new BigDecimal(item.getQuantidade());
    		valor = valor.add(valorUnitario.multiply(temp));
    	}
    	
    	temp = new BigDecimal(quantidade);
    	valor = valor.add(valor.divide(temp));
    	valor = valor.setScale(2,RoundingMode.HALF_EVEN);
    	
		return valor;

    }

    /**
     * Invalida um carrinho de compras quando o cliente faz um checkout ou sua sessão expirar.
     * Deve ser efetuada a remoção do carrinho do cliente passado como parâmetro da listagem de carrinhos de compras.
     *
     * @param identificacaoCliente
     * @return Retorna um boolean, tendo o valor true caso o cliente passado como parämetro tenha um carrinho de compras e
     * e false caso o cliente não possua um carrinho.
     */
    public boolean invalidar(String identificacaoCliente) {
    	if(carrinhoCompras.getIdentificacaoCliente().equals(identificacaoCliente)){
    		carrinhoCompras.items.clear();
    		carrinhoCompras.setIdentificacaoCliente(null);
    		   		
    		return true;
    	}
    	
    	return false;

    }
}
