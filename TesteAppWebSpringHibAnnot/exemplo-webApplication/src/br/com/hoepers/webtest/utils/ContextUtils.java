/*
 * Created on Feb 21, 2005
 *
 * $Id: ContextUtils.java,v 1.3 2006/08/10 18:58:38 cvs Exp $
 * 
 * $Log: ContextUtils.java,v $
 * Revision 1.3  2006/08/10 18:58:38  cvs
 * *** empty log message ***
 *
 * Revision 1.2  2006/06/28 13:20:43  cvs
 * *** empty log message ***
 *
 * Revision 1.1  2006/06/23 21:01:55  cvs
 * *** empty log message ***
 *
 * Revision 1.1  2006/06/23 12:55:31  cvs
 * *** empty log message ***
 *
 * Revision 1.1  2006/06/16 18:46:56  cvs
 * *** empty log message ***
 *
 * Revision 1.9  2006/03/27 16:42:20  cvs
 * *** empty log message ***
 *
 * Revision 1.8  2006/03/09 13:37:02  cvs
 * *** empty log message ***
 *
 * Revision 1.7  2006/03/07 19:14:06  cvs
 * Organize imports
 *
 * Revision 1.6  2006/03/07 17:06:43  cvs
 * atualizacao de projeto
 *
 * Revision 1.5  2006/02/17 18:20:54  cvs
 * telas de iniciar/reiniciar, parar, finalizar
 *
 * Revision 1.4  2006/02/15 20:08:36  cvs
 * finaliza��o da Solicita��o
 *
 * Revision 1.3  2006/02/13 10:37:24  cvs
 * Correções de imports
 *
 * Revision 1.2  2006/02/10 18:24:19  cvs
 * altera��o para ler criar o Pool de conex�es no contexto e para pegar o arquivo de properties do diret�rio WEB-INF
 *
 * Revision 1.1  2006/02/10 12:34:11  cvs
 * finaliza��o da arquitetura
 *
 * Revision 1.3  2005/09/05 04:25:13  ou20487
 * correcoes
 *
 * Revision 1.2  2005/06/28 10:30:57  ou20487
 * alteracoes de integracao
 *
 * Revision 1.1  2005/06/21 23:15:45  ou20487
 * commit inicial
 *
 * Revision 1.14  2005/06/16 12:53:47  cvs
 * correções e adicionado metodos
 *
 * Revision 1.13  2005/06/07 18:12:07  cvs
 * alteracoes para entrada manual
 *
 * Revision 1.12  2005/06/01 22:43:40  cvs
 * foi criado o metodo setContext para ser usado quando vier de webservice
 *
 * Revision 1.11  2005/05/31 21:47:26  cvs
 * correcao
 *
 * Revision 1.9  2005/05/28 21:27:00  cvs
 * correções
 *
 * Revision 1.8  2005/05/11 14:59:14  felipe
 * disponibilizei o context para os fontes da aplica��o
 *
 * Revision 1.7  2005/05/11 14:44:44  felipe
 * disponibilizei o context para os fontes da aplica��o
 *
 * Revision 1.6  2005/04/07 19:41:26  felipe
 * Novo versionamento
 *
 * Revision 1.5
 * mapeamentos, funcionamento de interceptors, ....
 *
 * Revision 1.4
 * altera��o no funcionamento de ContextUtils, adicionado atalho para acesso a empresa
 *
 * Revision 1.3
 * Property editors para facilitar a vida e possibilitar setar propriedades como objeto
 *
 * Revision 1.2
 * atualiza��es diversas, remo��o de imports inuteis, e finaliza��o do mapeamento dos VOs
 *
 * Revision 1.1
 * Commit inicial do modulo de perfil do usu�rio
 * quase todos os objetos b�sicos prontos, faltam os templates Velocity, e o modelo de dados para que o modulo seja concluido.
 *
 */
package br.com.hoepers.webtest.utils;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.support.RequestContext;

/**
 * Classe utilit�ria para armazenar objetos no contexto do request
 */
public final class ContextUtils {

	private static final String CONTEXT = "request_context";

	private static final String RESPONSE = "response";

	private static final String REQUEST = "request";

	private static final String SERVLET_CONTEXT = "servletContext";

	private static final ThreadLocal<HashMap> tl = new ThreadLocal<HashMap>();

	private ContextUtils() {
	}

	public synchronized static Map getMap() {
		if (tl.get() == null) {
			tl.set(new HashMap());
		}
		return (Map) tl.get();
	}

	public static ServletContext getServletContext() {
		return (ServletContext) getMap().get(SERVLET_CONTEXT);
	}

	public static void setServletContext(ServletContext servletContext) {
		getMap().put(SERVLET_CONTEXT, servletContext);
	}

	public static HttpServletRequest getRequest() {
		return (HttpServletRequest) getMap().get(REQUEST);
	}

	public static HttpServletResponse getResponse() {
		return (HttpServletResponse) getMap().get(RESPONSE);
	}

	public static void setRequestResponse(HttpServletRequest request, HttpServletResponse response){ 
		getMap().put(REQUEST, request);
		getMap().put(RESPONSE, response);
	}

	public static synchronized RequestContext getContext() {
		RequestContext ctx = (RequestContext) getMap().get(CONTEXT);
		if (ctx == null) {
			getMap().put(CONTEXT,
					new RequestContext(getRequest(), new HashMap()));
			ctx = (RequestContext) getMap().get(CONTEXT);
		}
		return ctx;
	}

	public static void setContext(RequestContext ctx) {
		getMap().put(CONTEXT, ctx);
	}


}
