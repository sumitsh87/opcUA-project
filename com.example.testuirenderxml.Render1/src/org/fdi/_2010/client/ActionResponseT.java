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
 * <p>Java class for ActionResponseT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ActionResponseT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="AcknowledgementResponse" type="{http://fdi.org/2010/client}ResponseT"/>
 *         &lt;element name="AbortResponse" type="{http://fdi.org/2010/client}ResponseT"/>
 *         &lt;element name="UIDResponse" type="{http://fdi.org/2010/client}ResponseT"/>
 *         &lt;element name="SelectionResponse" type="{http://fdi.org/2010/client}SelectionResponseT"/>
 *         &lt;element name="InputResponse" type="{http://fdi.org/2010/client}InputResponseT"/>
 *         &lt;element name="InfoResponse" type="{http://fdi.org/2010/client}ResponseT"/>
 *         &lt;element name="DelayMessageResponse" type="{http://fdi.org/2010/client}ResponseT"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ActionResponseT", propOrder = {
    "acknowledgementResponse",
    "abortResponse",
    "uidResponse",
    "selectionResponse",
    "inputResponse",
    "infoResponse",
    "delayMessageResponse"
})
public class ActionResponseT {

    @XmlElement(name = "AcknowledgementResponse")
    protected ResponseT acknowledgementResponse;
    @XmlElement(name = "AbortResponse")
    protected ResponseT abortResponse;
    @XmlElement(name = "UIDResponse")
    protected ResponseT uidResponse;
    @XmlElement(name = "SelectionResponse")
    protected SelectionResponseT selectionResponse;
    @XmlElement(name = "InputResponse")
    protected InputResponseT inputResponse;
    @XmlElement(name = "InfoResponse")
    protected ResponseT infoResponse;
    @XmlElement(name = "DelayMessageResponse")
    protected ResponseT delayMessageResponse;

    /**
     * Gets the value of the acknowledgementResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseT }
     *     
     */
    public ResponseT getAcknowledgementResponse() {
        return acknowledgementResponse;
    }

    /**
     * Sets the value of the acknowledgementResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseT }
     *     
     */
    public void setAcknowledgementResponse(ResponseT value) {
        this.acknowledgementResponse = value;
    }

    /**
     * Gets the value of the abortResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseT }
     *     
     */
    public ResponseT getAbortResponse() {
        return abortResponse;
    }

    /**
     * Sets the value of the abortResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseT }
     *     
     */
    public void setAbortResponse(ResponseT value) {
        this.abortResponse = value;
    }

    /**
     * Gets the value of the uidResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseT }
     *     
     */
    public ResponseT getUIDResponse() {
        return uidResponse;
    }

    /**
     * Sets the value of the uidResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseT }
     *     
     */
    public void setUIDResponse(ResponseT value) {
        this.uidResponse = value;
    }

    /**
     * Gets the value of the selectionResponse property.
     * 
     * @return
     *     possible object is
     *     {@link SelectionResponseT }
     *     
     */
    public SelectionResponseT getSelectionResponse() {
        return selectionResponse;
    }

    /**
     * Sets the value of the selectionResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link SelectionResponseT }
     *     
     */
    public void setSelectionResponse(SelectionResponseT value) {
        this.selectionResponse = value;
    }

    /**
     * Gets the value of the inputResponse property.
     * 
     * @return
     *     possible object is
     *     {@link InputResponseT }
     *     
     */
    public InputResponseT getInputResponse() {
        return inputResponse;
    }

    /**
     * Sets the value of the inputResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link InputResponseT }
     *     
     */
    public void setInputResponse(InputResponseT value) {
        this.inputResponse = value;
    }

    /**
     * Gets the value of the infoResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseT }
     *     
     */
    public ResponseT getInfoResponse() {
        return infoResponse;
    }

    /**
     * Sets the value of the infoResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseT }
     *     
     */
    public void setInfoResponse(ResponseT value) {
        this.infoResponse = value;
    }

    /**
     * Gets the value of the delayMessageResponse property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseT }
     *     
     */
    public ResponseT getDelayMessageResponse() {
        return delayMessageResponse;
    }

    /**
     * Sets the value of the delayMessageResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseT }
     *     
     */
    public void setDelayMessageResponse(ResponseT value) {
        this.delayMessageResponse = value;
    }

}
