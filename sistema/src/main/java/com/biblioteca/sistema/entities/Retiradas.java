package com.biblioteca.sistema.entities;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "retiradas")
public class Retiradas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date data_retirada;
    private Date data_devolucao;
    private String livro_id;
    private String pessoa_id;
    private Boolean pagamento_efetuado;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Date getData_retirada() {
        return data_retirada;
    }
    public void setData_retirada(Date data_retirada) {
        this.data_retirada = data_retirada;
    }
    public Date getData_devolucao() {
        return data_devolucao;
    }
    public void setData_devolucao(Date data_devolucao) {
        this.data_devolucao = data_devolucao;
    }
    public String getLivro_id() {
        return livro_id;
    }
    public void setLivro_id(String livro_id) {
        this.livro_id = livro_id;
    }
    public String getPessoa_id() {
        return pessoa_id;
    }
    public void setPessoa_id(String pessoa_id) {
        this.pessoa_id = pessoa_id;
    }
    public Boolean getPagamento_efetuado() {
        return pagamento_efetuado;
    }
    public void setPagamento_efetuado(Boolean pagamento_efetuado) {
        this.pagamento_efetuado = pagamento_efetuado;
    }

    
}
