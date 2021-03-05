/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descricao;
    private Long valor;
    private Long qtdeEstoque;

    @ManyToOne
    @JoinColumn(name="categoria_id")
    private Categoria categoria;

    public Produto(Long id, String descricao, Long valor, Long qtdeEstoque, Categoria categoria) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.qtdeEstoque = qtdeEstoque;
        this.categoria = categoria;
    }

    public Produto(String descricao, Long valor, Long qtdeEstoque, Categoria categoria) {
        this.descricao = descricao;
        this.valor = valor;
        this.qtdeEstoque = qtdeEstoque;
        this.categoria = categoria;
    }

    public Produto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getValor() {
        return valor;
    }

    public void setValor(Long valor) {
        this.valor = valor;
    }

    public Long getQtdeEstoque() {
        return qtdeEstoque;
    }

    public void setQtdeEstoque(Long qtdeEstoque) {
        this.qtdeEstoque = qtdeEstoque;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Produto{" + "id=" + id + ", descricao=" + descricao + ", valor=" + valor + ", qtdeEstoque=" + qtdeEstoque + ", categoria=" + categoria + '}';
    }

}
