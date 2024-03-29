//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.11.19 at 03:00:30 PM MEZ 
//


package org.fdi._2010.client;

import ae.javax.xml.bind.annotation.XmlAccessType;
import ae.javax.xml.bind.annotation.XmlAccessorType;
import ae.javax.xml.bind.annotation.XmlElement;
import ae.javax.xml.bind.annotation.XmlType;



/**
 * This type specifies a request sent from an FDI Server to an FDI Client when the user needs to acknowledge a condition or state within an Action. Upon acknowledgement from the user, the FDI Client sends an AcknowledgementResponse back to the FDI Server. An AcknowledgementRequest shall only be used to acknowledge normal operating conditions. An AbortRequest shall be used to acknowledge a condition that leads to the Action being aborted.
 * 
 * <p>Java class for AcknowledgementRequestT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AcknowledgementRequestT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AcknowledgementSeverity" type="{http://fdi.org/2010/client}AcknowledgementSeverityT" minOccurs="0"/>
 *         &lt;element name="Message" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AcknowledgementRequestT", propOrder = {
    "acknowledgementSeverity",
    "message"
})
public class AcknowledgementRequestT {

    @XmlElement(name = "AcknowledgementSeverity")
    protected AcknowledgementSeverityT acknowledgementSeverity;
    @XmlElement(name = "Message", required = true)
    protected String message;

    /**
     * Gets the value of the acknowledgementSeverity property.
     * 
     * @return
     *     possible object is
     *     {@link AcknowledgementSeverityT }
     *     
     */
    public AcknowledgementSeverityT getAcknowledgementSeverity() {
        return acknowledgementSeverity;
    }

    /**
     * Sets the value of the acknowledgementSeverity property.
     * 
     * @param value
     *     allowed object is
     *     {@link AcknowledgementSeverityT }
     *     
     */
    public void setAcknowledgementSeverity(AcknowledgementSeverityT value) {
        this.acknowledgementSeverity = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

}
