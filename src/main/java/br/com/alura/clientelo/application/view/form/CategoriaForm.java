package br.com.alura.clientelo.application.view.form;

import javax.validation.constraints.NotEmpty;

import br.com.alura.clientelo.application.model.categoriaEntity.Categoria;

public class CategoriaForm {

    @NotEmpty
    private String nome;

    public Categoria toEntity() {
        return new Categoria(this.getNome());
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}