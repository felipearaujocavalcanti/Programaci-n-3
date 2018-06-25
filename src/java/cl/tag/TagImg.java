/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.tag;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import org.apache.xml.security.utils.Base64;

/**
 *
 * @author 25597723-7
 */
public class TagImg extends SimpleTagSupport {

    private Object arreglo;
    private int entero;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();
        
        try {
            // TODO: insert code to write html before writing the body content.
            // e.g.:
            //
            // out.println("<strong>" + attribute_1 + "</strong>");
            // out.println("    <blockquote>");

            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }

           
            byte[] data = (byte[]) arreglo;
            out.println("<img class='materialboxed' width='"+ entero + "' src='data:image/*;base64,"+ Base64.encode(data)+ "' />");
            
        } catch (java.io.IOException ex) {
            throw new JspException("Error in TagImg tag", ex);
        }
    }

    public void setArreglo(Object arreglo) {
        this.arreglo = arreglo;
    }

    public void setEntero(int entero) {
        this.entero = entero;
    }
    
}
