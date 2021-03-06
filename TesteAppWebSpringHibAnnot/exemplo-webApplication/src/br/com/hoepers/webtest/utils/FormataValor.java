package br.com.hoepers.webtest.utils;


import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author IMMEDIATE - C�ssio Dias
 *
 */
public class FormataValor {
	
	/**
	* verifica se nulo ou branco
	* @param string
	* @return boolean
	*/
	private static boolean nullOrBlank(String string) {
		if (string == null || "".equals(string)) {
			return true;
		}
		return false;

	}	
	/**
	 * Coloca uma mascara na string
	 * @param dado
	 * @param formato
	 * @return
	 */
	public static String maskString(String dado, String formato) {
		/* tipos de formato
		
		   ???? alinhado pela esquerda
		   %%%% alinhado pela esquerda, substituindo & por "&nbsp;" (espa�o html)
		   #### alinhado pela direita
		   ZZZZ alinhado pela direita, substituindo Z por branco
		   9999 alinhado pela direita, substituindo 9 por '0'
		   &&&& alinhado pela direita, substituindo & por "&nbsp;" (espa�o html)
		
		 */

		String retorno = "";
		int tamd = dado.length();
		int tamf = formato.length();
		int j = 0;
		int i;
		boolean direita = true;

		if ((formato.indexOf('?') > -1) || (formato.indexOf('%') > -1)) {
			direita = false;
		}

		if (direita) {
			for (i = 0; i < (tamf - tamd - 1); i++) {

				try {

					if ((formato.charAt(i) == 'Z')
						|| (formato.charAt(i) == '#')) {
						retorno = retorno + " ";
					} else {
						if (formato.charAt(i) == '9') {
							retorno = retorno + "0";
						} else {
							if (formato.charAt(i) == '&') {
								retorno = retorno + "&nbsp;";
							} else {
								retorno = retorno + formato.charAt(i);
							}
						}
					}

				} catch (Exception e) {
					retorno = retorno + "*";
					break;
				}
			}
			j = tamf - tamd - 1;
		}

		for (i = 0; i < tamd; i++) {

			try {

				if (j < tamf) {

					if ((formato.charAt(j) == '?')
						|| (formato.charAt(j) == '%')
						|| (formato.charAt(j) == '#')
						|| (formato.charAt(j) == 'Z')
						|| (formato.charAt(j) == '9')
						|| (formato.charAt(j) == '&')) {

						if (((formato.charAt(j) == '9')
							|| (formato.charAt(j) == '%')
							|| (formato.charAt(j) == '&'))
							&& (dado.charAt(i) == ' ')) {

							if ((formato.charAt(j) == '%')
								|| (formato.charAt(j) == '&')) {
								retorno = retorno + "&nbsp;";
							} else {
								retorno = retorno + '0';
							}

						} else {
							retorno = retorno + dado.charAt(i);
						}

					} else {
						retorno = retorno + formato.charAt(j);
						i--;
					}
					j++;

				} else {
					// dado > formato, copia o resto
					retorno = retorno + dado.substring(i);
					break;
				}

			} catch (Exception e) {
				retorno = retorno + "*";
				break;
			}
		}

		for (i = j; i < tamf; i++) {

			try {
				if ((formato.charAt(i) == '?')
					|| (formato.charAt(i) == '#')
					|| (formato.charAt(i) == '%')
					|| (formato.charAt(i) == 'Z')
					|| (formato.charAt(i) == '9')
					|| (formato.charAt(i) == '&')) {

					if ((formato.charAt(i) == '9')
						|| (formato.charAt(i) == '&')
						|| (formato.charAt(i) == '%')) {

						if ((formato.charAt(i) == '%')
							|| (formato.charAt(i) == '&')) {
							retorno = retorno + "&nbsp;";
						} else {
							retorno = retorno + '0';
						}

					} else {
						retorno = retorno + " ";
					}

				} else {
					retorno = retorno + formato.charAt(i);
				}

			} catch (Exception e) {
				retorno = retorno + "*";
				break;
			}
		}

		return retorno;
	}
	
	
	
	/**
	 * formata valor no padr�o grava��o postgresql 9999999.99
	 * @param valor
	 * @return String
	 */
	public static String formataValorBD(String valor) {
		if (nullOrBlank(valor)) valor ="0.0";
		int tam = valor.length();
		int virgula = 0;
		int ponto = 0;
		
		for (int i = 0; i < tam; i++) {
			if (valor.charAt(i) == ',')
				virgula++;
			if (valor.charAt(i) == '.')
				ponto++;

		}
		
		if (ponto==1 && virgula==0){
		   //
		}else if (ponto==1 && virgula==1){
		
				valor = valor.replaceAll("[.]", "");
				valor = valor.replaceAll("[,]", ".");
	         
		  
		} else {
			if (ponto > 1)
				valor = valor.replaceAll("[.]", "");
			if (virgula == 1)
				valor = valor.replaceAll("[,]", ".");
		}
		return valor;

	}

	
	/**
	 * formata valor numerico para tela
	 * @param valor
	 * @return String
	 */
	public static String formataValorTL(String valor){
		
		if(valor == null || "0.00".equals(valor) || "0.0000".equals(valor) || "0".equals(valor) || "0.0".equals(valor) || "0,00".equals(valor)){
			return "";
		} else { 
			DecimalFormat d = new DecimalFormat("###,###,###.00");
			String retorno = d.format(Double.parseDouble(valor));
			return retorno;
		}
				
	}

	/**
	 * Formata valor numerico para tela em padrao Brasil.
	 * @param valor
	 * @return String
	 */
	public static String formataValorBR(double valor){
		return formatCurrency(Double.valueOf(valor+""), ",", 2);
	}

	/**
	 * Formata valor numerico para tela em padrao Estados Unidos.
	 * @param valor
	 * @return String
	 */
	public static String formataValorUS(double valor){
		return formatCurrency(Double.valueOf(valor+""), ".", 2);
	}
	
	/**
	 * Para formatacao em portugues 0.000,00 colocar no segundo parametro o caracter virgula (,) <br>
	 * Para formatacao em ingles 0,000.00 colocar no segundo parametro o caracter ponto (.);
	 * @param valor
	 * @param separator
	 * @param nCharacter - Numero de caracteres ap�s a virgula.
	 * @return
	 */
	public static String formatCurrency(Double valor, String separator, int nCharacter){
        String retorno = "";
        if ( valor != null ) {
            NumberFormat nf = NumberFormat.
            	getInstance(separator.equals(",") ?	new Locale("pt","BR") : new Locale("en","US"));
            //***
            nf.setMaximumFractionDigits(nCharacter);
            nf.setMinimumFractionDigits(nCharacter);
            retorno = nf.format(valor.doubleValue());
        }
        return retorno;
    }

	/**
	 * retira a mascara
	 * @param valor
	 * @param formato
	 * @return
	 */
	public static String retiraMask(String valor, String formato){
		valor = valor.replaceAll("["+formato.trim()+"]", "");
		return valor.trim();
		
	}
	
	/**
	* formata numero com zeros a esquerda
	* @param number, mascara
	* @return string
	*/
	public static String maskNumber(String number, String mascara) {
			number = number.trim();
			int tamNumber = number.length();
		    int tamMascara = mascara.length();
		    for(; tamNumber < tamMascara; tamNumber++){
		    	number="0"+number;
		    	
		    }
			return number;
	}

	public static String brancosDireita(String palavra,int tamanho){
		int x = 0;
		String word = new String(palavra);
		int tamanhoTotal = tamanho -palavra.length();
		while(x < tamanhoTotal){
			word = word+" "; 
			x++;
		}
		return word;
	}
	
	public static String brancosEsquerda(String palavra,int tamanho){
		int x = 0;
		String word = new String(palavra);
		int tamanhoTotal = tamanho - palavra.length();
		while(x < tamanhoTotal){
			word = " "+word; 
			x++;
		}
		return word;
	}
	public static String zerosEsquerda(String palavra,int tamanho){
		int x = 0;
		String word = new String(palavra);
		int tamanhoTotal = tamanho - palavra.length();
		while(x < tamanhoTotal){
			word = "0"+word; 
			x++;
		}
		return word;
	}
	
	public static String zerosDireita(String palavra,int tamanho){
		int x = 0;
		String word = new String(palavra);
		int tamanhoTotal = tamanho - palavra.length();
		while(x < tamanhoTotal){
			word = word+"0"; 
			x++;
		}
		return word;
	}
	
	/**
	 * Converte o valor informado na web com padrao brasileiro para
	 * formatacao aceita no banco de dados.
	 * @param valor
	 * @return
	 */
	public static String parseToFloatFormat(String valor) {
		if ( valor == null || valor.trim().equals("") ) return "0.0f";
		
		if ( valor.indexOf(".") > 0 && valor.indexOf(",") > 0 )
			valor = StringUtils.replace(valor, ".", "");
		
		if ( valor.indexOf(",") > 0 )
			valor = StringUtils.replace(valor, ",", ".");
		
		return valor.trim();
	}
	
	
	
}
