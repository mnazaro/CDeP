
package org.me.uppertolow;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de upperToLow complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="upperToLow"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="upperString" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "upperToLow", propOrder = {
    "upperString"
})
public class UpperToLow_Type {

    protected String upperString;

    /**
     * Obtém o valor da propriedade upperString.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpperString() {
        return upperString;
    }

    /**
     * Define o valor da propriedade upperString.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpperString(String value) {
        this.upperString = value;
    }

}
