<%@ include file="/WEB-INF/jsp/include/includes.jsp" %>
<!--
	Página responsável em mostrar todos os erros lançados na aplicação.
	Erro recebido através da exceção javax.servlet.error.exception.
	
	Customização: Cássio Dias 01.12.2007
-->
<html>
	<head>
		<title>Hoepers S.A.</title>
		<style type="text/css">
		<!--
			td { padding:3px; }
			div#top {
				position:absolute; 
				top: 0px; 
				left: 0px; background-color: #E4EFF3;
				background-position: 100px 1px;
				background-repeat: no-repeat; 
				height: 50px; 
				width:100%; 
				padding:0px; 
				border: none;
				margin: 0;
			}
			
		// -->
		</style>	
		<link href="../styles/hoepers.css" rel="stylesheet" type="text/css">
	</head>

	<body class="text_black">
		<div id="top">
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
			  <tr> 
		    <td height="61" class="fundo_cinza"><img src="../img/logoHoepersNovo.gif"></td>
			  </tr>
			</table>
			<table width="100%" border="0" cellpadding="0" cellspacing="0">
			  <tr> 
			    <td height="2" bgcolor="#004B90"></td>
			  </tr>
			</table>
		</div>
		<br clear="all">
		<p>&nbsp;</p>


		<H2>
			<br>
			<img src="../img/alert.gif"><font class="text_red_bold">&nbsp;Atenção, falha encontrada...</font>
		</H2>
		
		<P>
	
		<% 
		try {
	
			Throwable exception = (Throwable) request.getAttribute("javax.servlet.error.exception"); 
		
			if ( exception != null ) {
				if ( exception instanceof ServletException ) {
					
					//> Quando for ServletException: Deve-se extrair o 'root cause'.
					ServletException sex = (ServletException) exception;
					Throwable rootCause = sex.getRootCause();
					if ( rootCause == null )
						rootCause = sex;
					//***
					out.println("<font class=\"text_red_bold\">Classe   ["+exception.getClass()+"]</font><br>");
					out.println("<font class=\"text_red_bold\">Mensagem ["+rootCause.getMessage()+"]</font><br>");
					out.println("<br><font class=\"text_black_bold\">Descrição da falha:</font><br><hr>");
					
					rootCause.printStackTrace(new java.io.PrintWriter(out)); 
					
				} else {
					out.println("<font class=\"text_red_bold\">Classe   ["+exception.getClass()+"]</font><br>");
					out.println("<font class=\"text_red_bold\">Mensagem ["+exception.getMessage()+"]</font><br>");
					out.println("<br><font class=\"text_black_bold\">Descrição da falha:</font><br><hr>");
					exception.printStackTrace( new java.io.PrintWriter( out ) ); 
				}
				
			} else  {
				out.println("<font class=\"text_red_bold\">Atenção, foi detectado falha no processo, porém, a descrição da falha não é disponível.</font><br>");
				out.println("<font class=\"text_red_bold\">ENTRE EM CONTATO COM O DEPARTAMENTO DE SISTEMAS.</font><br>");			
			} 
		
			// Display cookies
			out.println("<br><br>\n<font class=\"text_black_bold\">Cookies:\n");
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
		    	for (int i = 0; i < cookies.length; i++) {
		      		out.println(cookies[i].getName() + "=[" + cookies[i].getValue() + "]");
				}
			}
			out.println("</font>");
			    
		} catch (Exception ex) { 
			ex.printStackTrace(new java.io.PrintWriter(out));
		}
		%>

		</P>
		
		<hr>
		<table style="width:100%">
			<tr>
				<td class="text_black_bold15" style="text-align:right;">
					Hoepers S.A.
				</td>
			</tr>
		</table>
		<hr>	
	</body>
</html>