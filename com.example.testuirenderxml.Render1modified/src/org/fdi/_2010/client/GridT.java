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
 * This type specifies a grid that displays data in a table-like grid.
 * 
 * <p>Java class for GridT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GridT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Handling" type="{http://fdi.org/2010/client}HandlingT" minOccurs="0"/>
 *         &lt;element name="Height" type="{http://fdi.org/2010/client}SizeT" minOccurs="0"/>
 *         &lt;element name="Width" type="{http://fdi.org/2010/client}SizeT" minOccurs="0"/>
 *         &lt;element name="Orientation" type="{http://fdi.org/2010/client}OrientationT" minOccurs="0"/>
 *         &lt;element name="VectorList" type="{http://fdi.org/2010/client}VectorListT"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GridT", propOrder = {
    "handling",
    "height",
    "width",
    "orientation",
    "vectorList"
})
public class GridT {

    @XmlElement(name = "Handling")
    protected HandlingT handling;
    @XmlElement(name = "Height")
    protected SizeT height;
    @XmlElement(name = "Width")
    protected SizeT width;
    @XmlElement(name = "Orientation")
    protected OrientationT orientation;
    @XmlElement(name = "VectorList", required = true)
    protected VectorListT vectorList;

    /**
     * Gets the value of the handling property.
     * 
     * @return
     *     possible object is
     *     {@link HandlingT }
     *     
     */
    public HandlingT getHandling() {
        return handling;
    }

    /**
     * Sets the value of the handling property.
     * 
     * @param value
     *     allowed object is
     *     {@link HandlingT }
     *     
     */
    public void setHandling(HandlingT value) {
        this.handling = value;
    }

    /**
     * Gets the value of the height property.
     * 
     * @return
     *     possible object is
     *     {@link SizeT }
     *     
     */
    public SizeT getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     * 
     * @param value
     *     allowed object is
     *     {@link SizeT }
     *     
     */
    public void setHeight(SizeT value) {
        this.height = value;
    }

    /**
     * Gets the value of the width property.
     * 
     * @return
     *     possible object is
     *     {@link SizeT }
     *     
     */
    public SizeT getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     * 
     * @param value
     *     allowed object is
     *     {@link SizeT }
     *     
     */
    public void setWidth(SizeT value) {
        this.width = value;
    }

    /**
     * Gets the value of the orientation property.
     * 
     * @return
     *     possible object is
     *     {@link OrientationT }
     *     
     */
    public OrientationT getOrientation() {
        return orientation;
    }

    /**
     * Sets the value of the orientation property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrientationT }
     *     
     */
    public void setOrientation(OrientationT value) {
        this.orientation = value;
    }

    /**
     * Gets the value of the vectorList property.
     * 
     * @return
     *     possible object is
     *     {@link VectorListT }
     *     
     */
    public VectorListT getVectorList() {
        return vectorList;
    }

    /**
     * Sets the value of the vectorList property.
     * 
     * @param value
     *     allowed object is
     *     {@link VectorListT }
     *     
     */
    public void setVectorList(VectorListT value) {
        this.vectorList = value;
    }

}