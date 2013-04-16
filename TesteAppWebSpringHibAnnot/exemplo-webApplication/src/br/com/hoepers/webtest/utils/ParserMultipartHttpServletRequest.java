package br.com.hoepers.webtest.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * Classe utilitária para fazer o parser dos atributos na request quando for MultiPart (File upload).
 * 
 * Exemplo de uso na classe br.com.immediate.webgesad.expedicao.web.controller.UpLoadExpedicaoController.java
 * 
 * @author IMMEDIATE - Cássio Dias
 */
public class ParserMultipartHttpServletRequest {
	
	public static MultipartFile[] parse(MultipartHttpServletRequest request){
		Map map      = request.getFileMap();
		Collection c = map.values();
		//***
		List<MultipartFile> list    = new ArrayList<MultipartFile>();
		for (Iterator iter = c.iterator(); iter.hasNext();) {
			list.add( (MultipartFile) iter.next() );
		}
		//***
		return (MultipartFile[]) list.toArray( new MultipartFile[list.size()] );
	}
}
