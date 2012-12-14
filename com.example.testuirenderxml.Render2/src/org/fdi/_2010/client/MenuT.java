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
 * This element specifies a user interace element that presents the user
 *                 with a list of options.
 * 
 * <p>Java class for MenuT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="MenuT">
 *   &lt;complexContent>
 *     &lt;extension base="{http://fdi.org/2010/client}LayoutT">
 *       &lt;sequence minOccurs="0">
 *         &lt;element name="ItemList">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://fdi.org/2010/client}LayoutItemsT">
 *                 &lt;sequence maxOccurs="unbounded">
 *                   &lt;choice>
 *                     &lt;element name="Window" type="{http://fdi.org/2010/client}WindowT"/>
 *                     &lt;element name="Dialog" type="{http://fdi.org/2010/client}DialogT"/>
 *                     &lt;element name="Menu" type="{http://fdi.org/2010/client}MenuT"/>
 *                     &lt;element name="Table" type="{http://fdi.org/2010/client}TableT"/>
 *                     &lt;element name="Plugin" type="{http://fdi.org/2010/client}PluginT"/>
 *                     &lt;element name="Action" type="{http://fdi.org/2010/client}ActionT"/>
 *                     &lt;element name="Separator" type="{http://fdi.org/2010/client}BreakT"/>
 *                   &lt;/choice>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MenuT", propOrder = {
    "itemList"
})
public class MenuT
    extends LayoutT
{

    @XmlElement(name = "ItemList")
    protected MenuT.ItemList itemList;

    /**
     * Gets the value of the itemList property.
     * 
     * @return
     *     possible object is
     *     {@link MenuT.ItemList }
     *     
     */
    public MenuT.ItemList getItemList() {
        return itemList;
    }

    /**
     * Sets the value of the itemList property.
     * 
     * @param value
     *     allowed object is
     *     {@link MenuT.ItemList }
     *     
     */
    public void setItemList(MenuT.ItemList value) {
        this.itemList = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://fdi.org/2010/client}LayoutItemsT">
     *       &lt;sequence maxOccurs="unbounded">
     *         &lt;choice>
     *           &lt;element name="Window" type="{http://fdi.org/2010/client}WindowT"/>
     *           &lt;element name="Dialog" type="{http://fdi.org/2010/client}DialogT"/>
     *           &lt;element name="Menu" type="{http://fdi.org/2010/client}MenuT"/>
     *           &lt;element name="Table" type="{http://fdi.org/2010/client}TableT"/>
     *           &lt;element name="Plugin" type="{http://fdi.org/2010/client}PluginT"/>
     *           &lt;element name="Action" type="{http://fdi.org/2010/client}ActionT"/>
     *           &lt;element name="Separator" type="{http://fdi.org/2010/client}BreakT"/>
     *         &lt;/choice>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class ItemList
        extends LayoutItemsT
    {


    }

}