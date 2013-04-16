package br.com.hoepers.webtest.modulo1.dto;

import java.io.Serializable;

import br.com.hoepers.webtest.model.Pessoa;

public class PessoaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	public PessoaDTO() {
		super();
	}

	private Pessoa pessoa;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}