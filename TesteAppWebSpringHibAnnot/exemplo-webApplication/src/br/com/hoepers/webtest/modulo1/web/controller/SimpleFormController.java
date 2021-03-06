package br.com.hoepers.webtest.modulo1.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;

import br.com.hoepers.webtest.modulo1.business.HoepersBO;
import br.com.hoepers.webtest.modulo1.web.formcontroller.PessoaForm;

public class SimpleFormController extends org.springframework.web.servlet.mvc.SimpleFormController 
	implements InitializingBean {

	private HoepersBO hoepersBO;

	public SimpleFormController() {
		setFormView    ("teste");
		setSuccessView ("teste");
		setCommandName ("pessoaForm");
		setCommandClass(PessoaForm.class);
	}

	/*
	 * M�todo chamado para carregar e recarregar a tela.
	 */
	protected Map referenceData(HttpServletRequest request, Object command, Errors errors) throws Exception {
		Map<String,String> map = new HashMap<String,String>();
		//***
		map.put("mensagem", "Mensagem do SimpleFormController." );
		return map;
	}

	/*
	 * M�todo chamado ap�s o submit do form html. Executa a valida��o dos campos
	 * enviados.
	 */
	protected void onBindAndValidate(HttpServletRequest request,
			Object command, BindException errors) throws Exception {

		try {
			
		} catch (Exception e){
			errors.reject("Erro", e.getMessage());	
		}
	}

	/*
	 * M�todo chamado ap�s passar no m�todo onBindAndValidate e a resposta for
	 * v�lida.
	 */
	protected ModelAndView onSubmit(Object command) {
		return new ModelAndView( getSuccessView() );
	}

	public void afterPropertiesSet() throws Exception {
		if ( this.hoepersBO == null ) {
			throw new IllegalArgumentException("Deve ser 'setado' o bean" +
					" hoepersBO em " + getClass() );
		}
	}

	public void setHoepersBO(HoepersBO objectBusiness) {
		this.hoepersBO = objectBusiness;
	}

}
