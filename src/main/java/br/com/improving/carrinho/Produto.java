package br.com.improving.carrinho;

import java.util.Objects;

/**
 * Classe que representa um produto que pode ser adicionado
 * como item ao carrinho de compras.
 *
 * Importante: Dois produtos são considerados iguais quando ambos possuem o
 * mesmo código.
 */
public class Produto {

    private Long codigo;
    private String descricao;

    /**
     * Construtor da classe Produto.
     *
     * @param codigo
     * @param descricao
     */
    public Produto(Long codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
	}

	/**
     * Retorna o código da produto.
     *
     * @return Long
     */
    public Long getCodigo() {
    	return this.codigo;    	
    }

    /**
     * Retorna a descrição do produto.
     *
     * @return String
     */
    public String getDescricao() {
    	return this.descricao;
    }    
    
    /**
     * seta o código da produto.
     *
     * @return Long
     */
    public void setCodigo(Long codigo) {
    	this.codigo = codigo;
    }

    /**
     * seta a descrição do produto.
     *
     * @return String
     */
    public void setDescricao(String descricao) {
    	this.descricao = descricao;
    }
}