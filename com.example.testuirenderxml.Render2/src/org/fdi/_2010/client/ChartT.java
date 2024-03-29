//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.11.19 at 03:00:30 PM MEZ 
//


package org.fdi._2010.client;

import java.math.BigInteger;
import ae.javax.xml.bind.annotation.XmlAccessType;
import ae.javax.xml.bind.annotation.XmlAccessorType;
import ae.javax.xml.bind.annotation.XmlElement;
import ae.javax.xml.bind.annotation.XmlSchemaType;
import ae.javax.xml.bind.annotation.XmlType;


/**
 * This type specifies a chart that graphically displays data from a device. The data is read from the device periodically and continuously. As new data arrives, it is displayed.
 * 
 * <p>Java class for ChartT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ChartT">
 *   &lt;complexContent>
 *     &lt;extension base="{http://fdi.org/2010/client}LayoutObjectExtT">
 *       &lt;sequence>
 *         &lt;element name="Height" type="{http://fdi.org/2010/client}SizeT" minOccurs="0"/>
 *         &lt;element name="Width" type="{http://fdi.org/2010/client}SizeT" minOccurs="0"/>
 *         &lt;element name="Length" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="Type" type="{http://fdi.org/2010/client}ChartTypeT" minOccurs="0"/>
 *         &lt;element name="CycleTime" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" minOccurs="0"/>
 *         &lt;element name="SourceList" type="{http://fdi.org/2010/client}SourceListT"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChartT", propOrder = {
    "height",
    "width",
    "length",
    "type",
    "cycleTime",
    "sourceList"
})
public class ChartT
    extends LayoutObjectExtT
{

    @XmlElement(name = "Height")
    protected SizeT height;
    @XmlElement(name = "Width")
    protected SizeT width;
    @XmlElement(name = "Length")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger length;
    @XmlElement(name = "Type")
    protected ChartTypeT type;
    @XmlElement(name = "CycleTime")
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger cycleTime;
    @XmlElement(name = "SourceList", required = true)
    protected SourceListT sourceList;

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
     * Gets the value of the length property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getLength() {
        return length;
    }

    /**
     * Sets the value of the length property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setLength(BigInteger value) {
        this.length = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link ChartTypeT }
     *     
     */
    public ChartTypeT getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link ChartTypeT }
     *     
     */
    public void setType(ChartTypeT value) {
        this.type = value;
    }

    /**
     * Gets the value of the cycleTime property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCycleTime() {
        return cycleTime;
    }

    /**
     * Sets the value of the cycleTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCycleTime(BigInteger value) {
        this.cycleTime = value;
    }

    /**
     * Gets the value of the sourceList property.
     * 
     * @return
     *     possible object is
     *     {@link SourceListT }
     *     
     */
    public SourceListT getSourceList() {
        return sourceList;
    }

    /**
     * Sets the value of the sourceList property.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceListT }
     *     
     */
    public void setSourceList(SourceListT value) {
        this.sourceList = value;
    }

}
