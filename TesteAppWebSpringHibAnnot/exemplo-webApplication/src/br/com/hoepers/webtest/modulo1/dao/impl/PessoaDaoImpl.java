package br.com.hoepers.webtest.modulo1.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import br.com.hoepers.webtest.model.Pessoa;
import br.com.hoepers.webtest.modulo1.dao.PessoaDAO;

public class PessoaDaoImpl extends HibernateDaoSupport implements PessoaDAO {

	public Pessoa findObjectById(int id) {
		List list = getHibernateTemplate().find("from Pessoa where pes_id=?",id);
		if ( list.size() > 0 ){
			return (Pessoa) list.get(0);
		} else {
			
			return null;
		}
	}
}
