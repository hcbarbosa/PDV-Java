
package br.edu.fatecriopreto.bean;

import java.io.Serializable;
import javax.persistence.*;
//mapeamento entre banco e orientado se faz aqui
@Entity
@Table(name="produtos")
public class Produto implements Serializable{
    @Id
    //@GeneratedValue (strategy = GenerationType.IDENTITY) //coloca auto_increment no banco
    @GeneratedValue
    @Column(name="id") // ao inves de chama a coluna da tabela de codigo coloca como sendo id
    private int codigo;
    
    @Column(length = 255, nullable = false, unique = true)
    private String nome; 
    
    private String descricao;
    
    @Column(precision = 2)    
    private float preco;
    
    private int estoque;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}
