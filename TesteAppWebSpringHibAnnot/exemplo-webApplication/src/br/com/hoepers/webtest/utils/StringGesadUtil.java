package br.com.hoepers.webtest.utils;

public class StringGesadUtil {

	public StringGesadUtil() {
		super();
	}
	
	public static String configuraTamanho(String s, int limite){
		if ( s == null ){
			return "";
		} else {
			return s.trim().length() > limite ? 
					s.trim().substring(0,limite) : s.trim();
		}			
	}
	
	public static String arrayToString(String[] arr){
		
		if ( arr != null ) {
			StringBuffer sb = new StringBuffer();
			for (int i=0; i<arr.length; i++){
				sb.append(arr[i]);
			}
			//***
			return sb.toString();
		} else 
			return null;
		
	}

}
