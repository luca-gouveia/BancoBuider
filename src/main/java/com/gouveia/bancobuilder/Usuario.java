package com.gouveia.bancobuilder;

import javax.persistence.*;

@Entity
@Table(name = "tb_usuario")
public class Usuario {
    private static final long serialVersionUID = 1L;

    @Id
    private int id;
    private String nome;
    private String nomeDaMae;
    private String nomeDoPai;
    private int idade;
    private String email;
    private String endereco;
    private String cpf;
    private boolean casado;
    private String nomeConjuge;

    public static class UsuarioBuilder{
        private int id;
        private String nome;
        private String nomeDaMae;
        private String nomeDoPai;
        private int idade;
        private String email;
        private String endereco;
        private String cpf;
        private boolean casado = false;
        private String nomeConjuge;

        public UsuarioBuilder() {
        }

        public UsuarioBuilder id (int id){
            this.id = id;
            return this;
        }

        public UsuarioBuilder DeNome (String nome){
            this.nome = nome;
            return this;
        }

        public UsuarioBuilder possuiOEmail (String email){
            this.email = email;
            return this;
        }
        public UsuarioBuilder comONomeDoPai (String nomeDoPai){
            this.nomeDoPai = nomeDoPai;
            return this;
        }
        public UsuarioBuilder comONomeDaMae (String nomeDaMae){
            this.nomeDaMae = nomeDaMae;
            return this;
        }
        public UsuarioBuilder casadoCom (String nomeConjuge){
            this.nomeConjuge = nomeConjuge;
            return this;
        }
        public UsuarioBuilder comIdade (int idade){
            this.idade = idade;
            return this;
        }
        public UsuarioBuilder ComOcpf (String cpf){
            this.cpf = cpf;
            return this;
        }
        public UsuarioBuilder moraNoEndereco (String endereco){
            this.endereco = endereco;
            return this;
        }
        public UsuarioBuilder casado (){
            this.casado = true;
            return this;
        }
        public Usuario criarUsuario () {
            return new Usuario(this);
        }

    }

    public Usuario(UsuarioBuilder builder) {
        this.id = builder.id;
        this.nome = builder.nome;
        this.nomeDaMae = builder.nomeDaMae;
        this.nomeDoPai = builder.nomeDoPai;
        this.idade = builder.idade;
        this.email = builder.email;
        this.endereco = builder.endereco;
        this.cpf = builder.cpf;
        this.casado = builder.casado;
        this.nomeConjuge = builder.nomeConjuge;
    }

    private Usuario(){

    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNomeDaMae() {
        return nomeDaMae;
    }

    public String getNomeDoPai() {
        return nomeDoPai;
    }

    public int getIdade() {
        return idade;
    }

    public String getEmail() {
        return email;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public boolean isCasado() {
        return casado;
    }

    public String getNomeConjuge() {
        return nomeConjuge;
    }
}
