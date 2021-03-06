package br.com.hoepers.webtest.modulo1.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import br.com.hoepers.webtest.modulo1.business.HoepersBO;

/**
 * <code>MultiActionController</code>
 *
 * @author C�ssio Dias
 */
public class MultiAcaoController extends MultiActionController implements InitializingBean {

	private HoepersBO hoepersBO;
	
	public void afterPropertiesSet() {
		if ( this.hoepersBO == null ) {
			throw new IllegalArgumentException("Deve ser 'setado' o bean" +
					" hoepersBO em " + getClass() );
		}
	}

	/**
	 * 
	 * @param request current HTTP request
	 * @param response current HTTP response
	 * @return a ModelAndView to render the response
	 */
	public ModelAndView metodo1(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("teste","pessoa",hoepersBO.loadPessoa());
	}

	/**
	 * 
	 * @param request current HTTP request
	 * @param response current HTTP response
	 * @return a ModelAndView to render the response
	 */
	public ModelAndView metodo2(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("teste","pessoa",hoepersBO.loadPessoa());
	}

	/**
	 * 
	 * @param request current HTTP request
	 * @param response current HTTP response
	 * @return a ModelAndView to render the response
	 */
	public ModelAndView metodo3(HttpServletRequest request, HttpServletResponse response) {
		return new ModelAndView("teste","pessoa",hoepersBO.loadPessoa());
	}

	public void setHoepersBO(HoepersBO objectBusiness) {
		this.hoepersBO = objectBusiness;
	}

}
