/*
 * Created on Mar 10, 2005
 *
 * $Id: IntegerPropertyEditor.java,v 1.3 2006/11/24 20:38:44 cvs Exp $
 * 
 * $Log: IntegerPropertyEditor.java,v $
 * Revision 1.3  2006/11/24 20:38:44  cvs
 * *** empty log message ***
 *
 * Revision 1.2  2005/07/14 22:30:12  ou20487
 * correcoes
 *
 * Revision 1.1  2005/06/21 23:15:45  ou20487
 * commit inicial
 *
 * Revision 1.4  2005/04/07 19:41:26  felipe
 * Novo versionamento
 *
 * Revision 1.3
 * Faltava Else pra tratamento correto
 *
 * Revision 1.2
 * faltou um else, e agora funciona tamb�m para int
 *
 * Revision 1.1
 * property editor para integer, permitindo valores nulos
 *
 */
package br.com.hoepers.webtest.utils;

import java.beans.PropertyEditorManager;
import java.beans.PropertyEditorSupport;

/**
 *  
 *
 * @author rodrigo
 * @spring.bean id="integerPropertyEditor"
 */
public class IntegerPropertyEditor extends PropertyEditorSupport {
    static {
        PropertyEditorManager.registerEditor(Integer.class, IntegerPropertyEditor.class);
        PropertyEditorManager.registerEditor(int.class, IntegerPropertyEditor.class);
    }

    /* (non-Javadoc)
     * @see java.beans.PropertyEditor#getAsText()
     */
    public String getAsText() {
        return super.getAsText();
    }

    /* (non-Javadoc)
     * @see java.beans.PropertyEditor#setAsText(java.lang.String)
     */
    public void setAsText(String text) throws IllegalArgumentException {
        if (text == null || "".equals(text.trim()))
            setValue(null);
        else {
        	try {
        		setValue(Integer.valueOf(text));
        	} catch (NumberFormatException e) {
        		throw new IllegalArgumentException("Erro de convers�o num�rica.");
        	}
        }
    }
}