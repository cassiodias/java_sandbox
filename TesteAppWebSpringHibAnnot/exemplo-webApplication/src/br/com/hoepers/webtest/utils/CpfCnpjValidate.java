package br.com.hoepers.webtest.utils;

public class CpfCnpjValidate {

	/** 
	 * Realiza a valida��o do CPF e CNPJ. 
	 */
   public static boolean validaCPF(String strCpf)
   {
      int     d1, d2;
      int     digito1, digito2, resto;
      int     digitoCPF;
      String  nDigResult;

      d1 = d2 = 0;
      digito1 = digito2 = resto = 0;

      for (int nCount = 1; nCount < strCpf.length() -1; nCount++)
      {
         digitoCPF = Integer.valueOf (strCpf.substring(nCount -1, nCount)).intValue();

         //multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.
         d1 = d1 + ( 11 - nCount ) * digitoCPF;

         //para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.
         d2 = d2 + ( 12 - nCount ) * digitoCPF;
      };

      //Primeiro resto da divis�o por 11.
      resto = (d1 % 11);

      //Se o resultado for 0 ou 1 o digito � 0 caso contr�rio o digito � 11 menos o resultado anterior.
      if (resto < 2)
         digito1 = 0;
      else
         digito1 = 11 - resto;

      d2 += 2 * digito1;

      //Segundo resto da divis�o por 11.
      resto = (d2 % 11);

      //Se o resultado for 0 ou 1 o digito � 0 caso contr�rio o digito � 11 menos o resultado anterior.
      if (resto < 2)
         digito2 = 0;
      else
         digito2 = 11 - resto;

      //Digito verificador do CPF que est� sendo validado.
      String nDigVerific = strCpf.substring (strCpf.length()-2, strCpf.length());

      //Concatenando o primeiro resto com o segundo.
      nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

      //comparar o digito verificador do cpf com o primeiro resto + o segundo resto.
      return nDigVerific.equals(nDigResult);
   }

   public static boolean validaCNPJ( String str_cnpj ){
      int soma = 0, dig;
      String cnpj_calc = str_cnpj.substring(0,12);

      if ( str_cnpj.length() != 14 )
        return false;

      char[] chr_cnpj = str_cnpj.toCharArray();

      /* Primeira parte */
      for( int i = 0; i < 4; i++ )
        if ( chr_cnpj[i]-48 >=0 && chr_cnpj[i]-48 <=9 )
          soma += (chr_cnpj[i] - 48) * (6 - (i + 1)) ;
      for( int i = 0; i < 8; i++ )
        if ( chr_cnpj[i+4]-48 >=0 && chr_cnpj[i+4]-48 <=9 )
          soma += (chr_cnpj[i+4] - 48) * (10 - (i + 1)) ;
      dig = 11 - (soma % 11);

      cnpj_calc += ( dig == 10 || dig == 11 ) ?
                     "0" : Integer.toString(dig);

      /* Segunda parte */
      soma = 0;
      for ( int i = 0; i < 5; i++ )
        if ( chr_cnpj[i]-48 >=0 && chr_cnpj[i]-48 <=9 )
          soma += (chr_cnpj[i] - 48) * (7 - (i + 1)) ;
      for ( int i = 0; i < 8; i++ )
        if ( chr_cnpj[i+5]-48 >=0 && chr_cnpj[i+5]-48 <=9 )
          soma += (chr_cnpj[i+5] - 48) * (10 - (i + 1)) ;
      dig = 11 - (soma % 11);
      cnpj_calc += ( dig == 10 || dig == 11 ) ?
                     "0" : Integer.toString(dig);

      return str_cnpj.equals(cnpj_calc);
   }
   
   /*public static boolean doDecimal(String pStr, String pLang){
	   String reDecimalPt = "^[+-]?((\d+|\d{1,3}(\.\d{3})+)(\,\d*)?|\,\d+)$";
	   String reDecimalEn = /^[+-]?((\d+|\d{1,3}(\,\d{3})+)(\.\d*)?|\.\d+)$";
	   String reDecimal = reDecimalPt;
   alert(1);
   	charDec = ( pLang != "En"? ",": "." );
   	eval("reDecimal = reDecimal" + pLang);
   	if (reDecimal.test(pStr)) {
   		pos = pStr.indexOf(charDec);
   		decs = pos == -1? 0: pStr.length - pos - 1;
   		//alert(pStr + " � um float v�lido (" + pLang + ") com " + decs + " decimais.");
   	} else if (pStr != null && pStr != "") {
   		//alert(pStr + " N�O � um float v�lido.");
   		alert(pStr + " N�O � um valor v�lido.");
   		obj.focus();
   	}
   } // doDecimal
*/}
