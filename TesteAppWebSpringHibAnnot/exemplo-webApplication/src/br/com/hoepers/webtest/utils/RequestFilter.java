package br.com.hoepers.webtest.utils;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.support.RequestContext;

/**
 * Classe responsável em implementar o filtro de todas as<br>
 * requisições da aplicação.
 * 
 * @author Cássio
 */
public class RequestFilter implements Filter {

	private WebApplicationContext ctx;

	private ServletContext servletContext;

	public void init(FilterConfig config) throws ServletException {
		this.servletContext = config.getServletContext();
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
		throws IOException, ServletException {
		
		HttpServletRequest request   = (HttpServletRequest)  req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		//> Executa o Filter uma vez para cada requisição HTML (Nao processa .js, .css, etc).
		if ( request.getRequestURI().indexOf(".html") > 0 ) {
			
			synchronized ( this ) {
				if ( ctx == null ) {
					ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
					ContextUtils.setServletContext(servletContext);
					ContextUtils.setContext(new RequestContext(	(HttpServletRequest) req, 
							servletContext,	new HashMap()));
					//integracaoGesadViagemDAO = (IntegracaoGesadViagemDAO) ctx.getBean("integracaoGesadViagemDAO");
				}
			}
			//***
			
			ContextUtils.setRequestResponse(request, response);
			
			/*//>Valida usuário logado.
			UsuarioFiergs usuario = (UsuarioFiergs) request.getSession().getAttribute(USUARIO);
			//***
			if ( usuario == null ) {
				usuario = new UsuarioFiergs();
				//***
				usuario.setNm_login("ACORREA");
				usuario.setNome("Antonio Correa");
				
				String u = request.getRemoteUser();
				if ( u == null ) {
					//throw new WebTestException("ATENÇÃO, USUARIO NÃO ENCONTRADO! - ENTRE EM CONTATO COM O ADMINISTRADOR DA REDE");
					u = "ACORREA";
				}	
				//***
				List l = integracaoGesadViagemDAO.carregaFuncionarioFiergs(u);
				if(l != null && l.size() > 0)
					usuario = (UsuarioFiergs)l.get(0);
				else
					throw new WebTestException("ATENÇÃO, USUARIO DE REDE NÃO ENCONTRADO! - ENTRE EM CONTATO COM O ADMINISTRADOR DA REDE");
				
				request.getSession().setAttribute(USUARIO, usuario);
				ContextUtils.setUsuarioLogado(usuario);
			} else
				ContextUtils.setUsuarioLogado(usuario);
			
			//> Implementacoes de seguranca da aplicacao.
			SegurancaBusiness seg = (SegurancaBusiness) ctx.getBean("segurancaBusiness");
			//***
			Integer idSolicitacao = null;
			String sIdSolicitacao = request.getParameter("idSolicitacao");
			
			if(sIdSolicitacao != null && !"".equals(sIdSolicitacao)){
				idSolicitacao = new Integer(sIdSolicitacao);
			}
			Integer idPrevisao     = request.getParameter("idPrevisao")!=null?new Integer(request.getParameter("idPrevisao")):null;
			Integer idParticipante = request.getParameter("idParticipante")!=null?new Integer(request.getParameter("idParticipante")):null;
			Integer idPrestacao    = request.getParameter("idPrestacao")!=null?new Integer(request.getParameter("idPrestacao")):null;
			Integer id             = request.getParameter("id")!=null?new Integer(request.getParameter("id")):null;
			String  acao           = request.getParameter("acao");
			//> Pega a página que o usuário esta acessando.
			String pagina      = request.getRequestURI();
			String[] paginaSpl = pagina.split("\\/");
			pagina             = paginaSpl[paginaSpl.length-1]; 
			//***
			seg.verificaPermissao(id, ContextUtils.getUsuarioLogado().getNm_login(), idSolicitacao, idPrevisao, idParticipante,
					idPrestacao, pagina, acao);*/
		}
		chain.doFilter(request, response);
	}

	public void destroy() {
	}

}