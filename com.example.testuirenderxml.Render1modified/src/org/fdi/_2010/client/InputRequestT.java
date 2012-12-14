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
 * This type specifies a request sent from an FDI Server to an FDI Client when the user needs modify a value during an Action. Once the user has finished modifying the value, the FDI Client sends an InputResponse back to the FDI Server.
 * 
 * <p>Java class for InputRequestT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InputRequestT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Prompt" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="InputValue" type="{http://fdi.org/2010/client}InputValueT"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InputRequestT", propOrder = {
    "prompt",
    "inputValue"
})
public class InputRequestT {

    @XmlElement(name = "Prompt", required = true)
    protected String prompt;
    @XmlElement(name = "InputValue", required = true)
    protected InputValueT inputValue;

    /**
     * Gets the value of the prompt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrompt() {
        return prompt;
    }

    /**
     * Sets the value of the prompt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrompt(String value) {
        this.prompt = value;
    }

    /**
     * Gets the value of the inputValue property.
     * 
     * @return
     *     possible object is
     *     {@link InputValueT }
     *     
     */
    public InputValueT getInputValue() {
        return inputValue;
    }

    /**
     * Sets the value of the inputValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link InputValueT }
     *     
     */
    public void setInputValue(InputValueT value) {
        this.inputValue = value;
    }

}
