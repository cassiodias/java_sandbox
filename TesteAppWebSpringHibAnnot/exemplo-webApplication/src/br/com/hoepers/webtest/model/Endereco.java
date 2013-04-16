package br.com.hoepers.webtest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="testeendereco")
public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer end_id;
	
	private String end_rua;
	
	private Pessoa pessoa;
	
	@Id 
	@SequenceGenerator( name = "SEQ_TESTE_ENDERECO", sequenceName = "SEQ_TESTE_ENDERECO", allocationSize = 1 )
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "SEQ_TESTE_ENDERECO" )
	@Column( name = "end_id", nullable = false )
	public Integer getEnd_id() {
		return end_id;
	}

	public void setEnd_id(Integer end_id) {
		this.end_id = end_id;
	}

	@Column (name = "end_rua", nullable=false, length=50, unique=false)
	public String getEnd_rua() {
		return end_rua;
	}

	public void setEnd_rua(String end_rua) {
		this.end_rua = end_rua;
	}

	@ManyToOne
	@JoinColumn(name="end_pes_id")
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
