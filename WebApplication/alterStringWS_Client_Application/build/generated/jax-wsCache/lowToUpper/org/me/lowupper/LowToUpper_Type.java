
package org.me.lowupper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de lowToUpper complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="lowToUpper"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="lowString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "lowToUpper", propOrder = {
    "lowString"
})
public class LowToUpper_Type {

    protected String lowString;

    /**
     * Obtém o valor da propriedade lowString.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLowString() {
        return lowString;
    }

    /**
     * Define o valor da propriedade lowString.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLowString(String value) {
        this.lowString = value;
    }

}
