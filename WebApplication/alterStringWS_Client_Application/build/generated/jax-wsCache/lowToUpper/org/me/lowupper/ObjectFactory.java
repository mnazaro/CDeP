
package org.me.lowupper;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.me.lowupper package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _LowToUpper_QNAME = new QName("http://lowupper.me.org/", "lowToUpper");
    private final static QName _LowToUpperResponse_QNAME = new QName("http://lowupper.me.org/", "lowToUpperResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.me.lowupper
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link LowToUpper_Type }
     * 
     */
    public LowToUpper_Type createLowToUpper_Type() {
        return new LowToUpper_Type();
    }

    /**
     * Create an instance of {@link LowToUpperResponse }
     * 
     */
    public LowToUpperResponse createLowToUpperResponse() {
        return new LowToUpperResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LowToUpper_Type }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LowToUpper_Type }{@code >}
     */
    @XmlElementDecl(namespace = "http://lowupper.me.org/", name = "lowToUpper")
    public JAXBElement<LowToUpper_Type> createLowToUpper(LowToUpper_Type value) {
        return new JAXBElement<LowToUpper_Type>(_LowToUpper_QNAME, LowToUpper_Type.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LowToUpperResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link LowToUpperResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://lowupper.me.org/", name = "lowToUpperResponse")
    public JAXBElement<LowToUpperResponse> createLowToUpperResponse(LowToUpperResponse value) {
        return new JAXBElement<LowToUpperResponse>(_LowToUpperResponse_QNAME, LowToUpperResponse.class, null, value);
    }

}
