/*
 * Created on Mar 8, 2005
 *
 * $Id: RedirectView.java,v 1.1 2006/06/23 21:01:55 cvs Exp $
 * 
 * $Log: RedirectView.java,v $
 * Revision 1.1  2006/06/23 21:01:55  cvs
 * *** empty log message ***
 *
 * Revision 1.1  2006/06/23 12:55:31  cvs
 * *** empty log message ***
 *
 * Revision 1.1  2006/06/16 18:46:56  cvs
 * *** empty log message ***
 *
 * Revision 1.1  2005/06/21 23:15:45  ou20487
 * commit inicial
 *
 * Revision 1.3  2005/04/07 19:41:26  felipe
 * Novo versionamento
 *
 * Revision 1.2
 * corre��o erro p�gina n�o encontrada quando utilizando internet explorer e salvando pedido nacional brasil
 *
 * Revision 1.1
 * altera��es finais para primeiro deploy com sucesso no IAS
 *
 */
package br.com.hoepers.webtest.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractUrlBasedView;

/**
 * <p>View that redirects to an absolute, context relative, or current request
 * relative URL, exposing all model attributes as HTTP query parameters.
 *
 * <p>A URL for this view is supposed to be a HTTP redirect URL, .e.
 * suitable for HttpServletResponse's <code>sendRedirect</code> method, which
 * is what actually does the redirect if the HTTP 1.0 flag is on, or via sending
 * back an HTTP 303 code - if the HTTP 1.0 compatibility flag is off.
 * 
 * <p>Note that while the default value for the "contextRelative" flag is off,
 * you will probably want to almost always set it to true. With the flag off,
 * URLs starting with "/" are considered relative to the web server root, while
 * with the flag on, they are considered relative to the web application root.
 * Since most web apps will never know or care what their context path actually
 * is, they are much better off setting this flag to true, and submitting paths
 * which are to be considered relative to the web application root.
 * 
 * <p>Note that in a Servlet 2.2 environment, i.e. a servlet container which
 * is only compliant to the limits of this spec, this class will probably fail
 * when feeding in URLs which are not fully absolute, or relative to the current
 * request (no leading "/"), as these are the only two types of URL that
 * <code>sendRedirect</code> supports in a Servlet 2.2 environment.
 * 
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @author Colin Sampaleanu
 * @see #setContextRelative
 * @see #setHttp10Compatible
 * @see javax.servlet.http.HttpServletResponse#sendRedirect
 */
public class RedirectView extends AbstractUrlBasedView {

	public static final String DEFAULT_ENCODING_SCHEME = "UTF-8";

	private boolean contextRelative = false;

	private boolean http10Compatible = true;

	private String encodingScheme = DEFAULT_ENCODING_SCHEME;


	/**
	 * Constructor for use as a bean.
	 */
	public RedirectView() {
	}

	/**
	 * Create a new RedirectView with the given URL.
	 * <p>The given URL will be considered as relative to the web server,
	 * not as relative to the current ServletContext.
	 * @param url the URL to redirect to
	 * @see #RedirectView(String, boolean)
	 */
	public RedirectView(String url) {
		setUrl(url);
	}

	/**
	 * Create a new RedirectView with the given URL.
	 * @param url the URL to redirect to
	 * @param contextRelative whether to interpret the given URL as
	 * relative to the current ServletContext
	 */
	public RedirectView(String url, boolean contextRelative) {
		setUrl(url);
		this.contextRelative = contextRelative;
	}

	/**
	 * Create a new RedirectView with the given URL.
	 * @param url the URL to redirect to
	 * @param contextRelative whether to interpret the given URL as
	 * relative to the current ServletContext
	 * @param http10Compatible whether to stay compatible with HTTP 1.0 clients
	 */
	public RedirectView(String url, boolean contextRelative, boolean http10Compatible) {
		setUrl(url);
		this.contextRelative = contextRelative;
		this.http10Compatible = http10Compatible;
	}

	/**
	 * Set whether to interpret a given URL that starts with a slash ("/")
	 * as relative to the current ServletContext, i.e. as relative to the
	 * web application root.
	 * <p>Default is false: A URL that starts with a slash will be interpreted
	 * as absolute, i.e. taken as-is. If true, the context path will be
	 * prepended to the URL in such a case.
	 * @see javax.servlet.http.HttpServletRequest#getContextPath
	 */
	public void setContextRelative(boolean contextRelative) {
		this.contextRelative = contextRelative;
	}

	/**
	 * Set whether to stay compatible with HTTP 1.0 clients.
	 * <p>In the default implementation, this will enforce HTTP status code 302
	 * in any case, i.e. delegate to <code>HttpServletResponse.sendRedirect</code>.
	 * Turning this off will send HTTP status code 303, which is the correct
	 * code for HTTP 1.1 clients, but not understood by HTTP 1.0 clients.
	 * <p>Many HTTP 1.1 clients treat 302 just like 303, not making any
	 * difference. However, some clients depend on 303 when redirecting
	 * after a POST request; turn this flag off in such a scenario.
	 * @see javax.servlet.http.HttpServletResponse#sendRedirect
	 */
	public void setHttp10Compatible(boolean http10Compatible) {
		this.http10Compatible = http10Compatible;
	}

	/**
	 * Set the encoding scheme for this view.
	 */
	public void setEncodingScheme(String encodingScheme) {
		this.encodingScheme = encodingScheme;
	}


	/**
	 * Convert model to request parameters and redirect to the given URL.
	 * @see #appendQueryProperties
	 * @see #sendRedirect
	 */
	protected final void renderMergedOutputModel(
			Map model, HttpServletRequest request, HttpServletResponse response) throws IOException {

		// prepare target URL
		StringBuffer targetUrl = new StringBuffer();
		if (this.contextRelative && getUrl().startsWith("/")) {
			// do not apply context path to relative URLs
			targetUrl.append(request.getContextPath());
		}
		targetUrl.append(getUrl());
		appendQueryProperties(targetUrl, model, this.encodingScheme);

		sendRedirect(request, response, targetUrl.toString(), this.http10Compatible);
	}

	/**
	 * Append query properties to the redirect URL.
	 * Stringifies, URL-encodes and formats model attributes as query properties.
	 * @param targetUrl the StringBuffer to append the properties to
	 * @param model Map that contains model attributes
	 * @param encodingScheme the encoding scheme to use
	 * @throws UnsupportedEncodingException if string encoding failed
	 * @see #queryProperties
	 */
	protected void appendQueryProperties(StringBuffer targetUrl, Map model, String encodingScheme)
			throws UnsupportedEncodingException {

		// if there are not already some parameters, we need a ?
		boolean first = (getUrl().indexOf('?') < 0);
		Iterator entries = queryProperties(model).entrySet().iterator();
		while (entries.hasNext()) {
			if (first) {
				targetUrl.append('?');
				first = false;
			}
			else {
				targetUrl.append('&');
			}
			Map.Entry entry = (Map.Entry) entries.next();
			String encodedKey = entry.getKey().toString();
			if(entry.getValue()!=null && (entry.getValue().getClass().getName().startsWith("com.jdeere") || entry.getValue() instanceof Collection || entry.getValue() instanceof Map))
			    continue;
			String encodedValue = (entry.getValue() != null ? entry.getValue().toString() : "");
			targetUrl.append(new String(encodedKey.getBytes(encodingScheme), encodingScheme));
			targetUrl.append("=");
			targetUrl.append(new String(encodedValue.getBytes(encodingScheme), encodingScheme));
		}
	}

	/**
	 * Determine name-value pairs for query strings, which will be stringified,
	 * URL-encoded and formatted by appendQueryProperties.
	 * <p>This implementation returns all model elements as-is.
	 * @see #appendQueryProperties
	 */
	protected Map queryProperties(Map model) {
		return model;
	}

	/**
	 * Send a redirect back to the HTTP client
	 * @param request current HTTP request (allows for reacting to request method)
	 * @param response current HTTP response (for sending response headers)
	 * @param targetUrl the target URL to redirect to
	 * @param http10Compatible whether to stay compatible with HTTP 1.0 clients
	 * @throws IOException if thrown by response methods
	 */
	protected void sendRedirect(
			HttpServletRequest request, HttpServletResponse response, String targetUrl, boolean http10Compatible)
			throws IOException {
		/*if (http10Compatible) {
			// always send status code 302
			response.sendRedirect(response.encodeRedirectURL(targetUrl));
		}
		else {
			// correct HTTP status code is 303, in particular for POST requests
			response.setStatus(303);
			response.setHeader("Location", response.encodeRedirectURL(targetUrl));
		}*/
	    response.setContentType("text/html");
	    response.setHeader("Location",response.encodeRedirectURL(targetUrl));
	    PrintWriter pw = response.getWriter();
	    pw.println("<html><head><meta http-equiv=\"Refresh\" content=\"0;url=" + response.encodeRedirectURL(targetUrl) + "\"/></head><body><a href=\"" + response.encodeRedirectURL(targetUrl) + "\">" + targetUrl + "</a></body></html>");
	    
	}

}
