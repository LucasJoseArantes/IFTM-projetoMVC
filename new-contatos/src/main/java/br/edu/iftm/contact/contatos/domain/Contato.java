package br.edu.iftm.contact.contatos.domain;

import lombok.Data;

@Data
public class Contato {

    private String nome;
    private String email;
    private String cpf_cnpj;

    public Contato() {
        
    }
    public Contato(String nome, String email, String cpf_cnpj) {
        this.nome = nome;
        this.email = email;
        this.cpf_cnpj = cpf_cnpj;
    }

    
    
}