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
 * This type specifies the type of a date/time value.
 * 
 * <p>Java class for DateTimeT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DateTimeT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DataType" type="{http://fdi.org/2010/client}DateTimeDataT"/>
 *         &lt;element name="PresetValueList" type="{http://fdi.org/2010/client}PresetValueListT" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DateTimeT", propOrder = {
    "dataType",
    "presetValueList"
})
public class DateTimeT {

    @XmlElement(name = "DataType", required = true)
    protected DateTimeDataT dataType;
    @XmlElement(name = "PresetValueList")
    protected PresetValueListT presetValueList;

    /**
     * Gets the value of the dataType property.
     * 
     * @return
     *     possible object is
     *     {@link DateTimeDataT }
     *     
     */
    public DateTimeDataT getDataType() {
        return dataType;
    }

    /**
     * Sets the value of the dataType property.
     * 
     * @param value
     *     allowed object is
     *     {@link DateTimeDataT }
     *     
     */
    public void setDataType(DateTimeDataT value) {
        this.dataType = value;
    }

    /**
     * Gets the value of the presetValueList property.
     * 
     * @return
     *     possible object is
     *     {@link PresetValueListT }
     *     
     */
    public PresetValueListT getPresetValueList() {
        return presetValueList;
    }

    /**
     * Sets the value of the presetValueList property.
     * 
     * @param value
     *     allowed object is
     *     {@link PresetValueListT }
     *     
     */
    public void setPresetValueList(PresetValueListT value) {
        this.presetValueList = value;
    }

}
