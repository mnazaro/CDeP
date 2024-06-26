
package org.me.uppertolow;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.me.uppertolow package. 
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

    private final static QName _UpperToLow_QNAME = new QName("http://upperToLow.me.org/", "upperToLow");
    private final static QName _UpperToLowResponse_QNAME = new QName("http://upperToLow.me.org/", "upperToLowResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.me.uppertolow
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpperToLow_Type }
     * 
     */
    public UpperToLow_Type createUpperToLow_Type() {
        return new UpperToLow_Type();
    }

    /**
     * Create an instance of {@link UpperToLowResponse }
     * 
     */
    public UpperToLowResponse createUpperToLowResponse() {
        return new UpperToLowResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpperToLow_Type }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpperToLow_Type }{@code >}
     */
    @XmlElementDecl(namespace = "http://upperToLow.me.org/", name = "upperToLow")
    public JAXBElement<UpperToLow_Type> createUpperToLow(UpperToLow_Type value) {
        return new JAXBElement<UpperToLow_Type>(_UpperToLow_QNAME, UpperToLow_Type.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpperToLowResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpperToLowResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://upperToLow.me.org/", name = "upperToLowResponse")
    public JAXBElement<UpperToLowResponse> createUpperToLowResponse(UpperToLowResponse value) {
        return new JAXBElement<UpperToLowResponse>(_UpperToLowResponse_QNAME, UpperToLowResponse.class, null, value);
    }

}
