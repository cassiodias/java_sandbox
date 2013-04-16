package br.com.hoepers.webtest.modulo1.business.pojo;

import java.util.Iterator;
import java.util.List;

import br.com.hoepers.webtest.model.Endereco;
import br.com.hoepers.webtest.model.Pessoa;
import br.com.hoepers.webtest.modulo1.business.HoepersBO;
import br.com.hoepers.webtest.modulo1.dao.PessoaDAO;

public class HoepersPOJO implements HoepersBO {
	
	private PessoaDAO pessoaDAO;

	public Pessoa loadPessoa() {
		Pessoa p = pessoaDAO.findObjectById(1);
		if (p!=null) {
			List<Endereco> end = p.getEndereco();

			for (Iterator iterator = end.iterator(); iterator.hasNext();) {
				Endereco element = (Endereco) iterator.next();
				System.out.println( element.getEnd_rua() );
				
			}
			return p;
			
		} else
			return null;
	}
	
	public void setPessoaDAO(PessoaDAO pessoaDAO) {
		this.pessoaDAO = pessoaDAO;
	}
}
