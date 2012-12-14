//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.11.19 at 03:00:30 PM MEZ 
//


package org.fdi._2010.client;

import java.util.ArrayList;
import java.util.List;
import ae.javax.xml.bind.JAXBElement;
import ae.javax.xml.bind.annotation.XmlAccessType;
import ae.javax.xml.bind.annotation.XmlAccessorType;
import ae.javax.xml.bind.annotation.XmlElementRef;
import ae.javax.xml.bind.annotation.XmlElementRefs;
import ae.javax.xml.bind.annotation.XmlSeeAlso;
import ae.javax.xml.bind.annotation.XmlType;


/**
 * This optional element specifies the base content of the WindowT,
 *                 DialogT, PageT, GroupT, MenuT, or TableT.
 * 
 * <p>Java class for LayoutItemsT complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LayoutItemsT">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;choice>
 *           &lt;element name="Window" type="{http://fdi.org/2010/client}WindowT"/>
 *           &lt;element name="Dialog" type="{http://fdi.org/2010/client}DialogT"/>
 *           &lt;element name="Page" type="{http://fdi.org/2010/client}PageT"/>
 *           &lt;element name="Group" type="{http://fdi.org/2010/client}GroupT"/>
 *           &lt;element name="Menu" type="{http://fdi.org/2010/client}MenuT"/>
 *           &lt;element name="Table" type="{http://fdi.org/2010/client}TableT"/>
 *           &lt;element name="Chart" type="{http://fdi.org/2010/client}ChartT"/>
 *           &lt;element name="Graph" type="{http://fdi.org/2010/client}GraphT"/>
 *           &lt;element name="Grid" type="{http://fdi.org/2010/client}GridT"/>
 *           &lt;element name="Image" type="{http://fdi.org/2010/client}ImageT"/>
 *           &lt;element name="Text" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *           &lt;element name="Parameter" type="{http://fdi.org/2010/client}ParameterT"/>
 *           &lt;element name="Plugin" type="{http://fdi.org/2010/client}PluginT"/>
 *           &lt;element name="Action" type="{http://fdi.org/2010/client}ActionT"/>
 *           &lt;element name="EditDisplay" type="{http://fdi.org/2010/client}EditDisplayT"/>
 *           &lt;element name="RowBreak" type="{http://fdi.org/2010/client}BreakT"/>
 *           &lt;element name="ColumnBreak" type="{http://fdi.org/2010/client}BreakT"/>
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
@XmlType(name = "LayoutItemsT", propOrder = {
    "windowOrDialogOrPage"
})
@XmlSeeAlso({
    MenuT.ItemList.class,
    PageT.ItemList.class,
    GroupT.ItemList.class,
    DialogT.ItemList.class,
    TableT.ItemList.class,
    WindowT.ItemList.class,
    ImageT.Link.class
})
public class LayoutItemsT {

    @XmlElementRefs({
        @XmlElementRef(name = "Group", namespace = "http://fdi.org/2010/client", type = JAXBElement.class),
        @XmlElementRef(name = "Plugin", namespace = "http://fdi.org/2010/client", type = JAXBElement.class),
        @XmlElementRef(name = "Image", namespace = "http://fdi.org/2010/client", type = JAXBElement.class),
        @XmlElementRef(name = "Separator", namespace = "http://fdi.org/2010/client", type = JAXBElement.class),
        @XmlElementRef(name = "Window", namespace = "http://fdi.org/2010/client", type = JAXBElement.class),
        @XmlElementRef(name = "Grid", namespace = "http://fdi.org/2010/client", type = JAXBElement.class),
        @XmlElementRef(name = "Chart", namespace = "http://fdi.org/2010/client", type = JAXBElement.class),
        @XmlElementRef(name = "EditDisplay", namespace = "http://fdi.org/2010/client", type = JAXBElement.class),
        @XmlElementRef(name = "Parameter", namespace = "http://fdi.org/2010/client", type = JAXBElement.class),
        @XmlElementRef(name = "Page", namespace = "http://fdi.org/2010/client", type = JAXBElement.class),
        @XmlElementRef(name = "Menu", namespace = "http://fdi.org/2010/client", type = JAXBElement.class),
        @XmlElementRef(name = "RowBreak", namespace = "http://fdi.org/2010/client", type = JAXBElement.class),
        @XmlElementRef(name = "Text", namespace = "http://fdi.org/2010/client", type = JAXBElement.class),
        @XmlElementRef(name = "Dialog", namespace = "http://fdi.org/2010/client", type = JAXBElement.class),
        @XmlElementRef(name = "Action", namespace = "http://fdi.org/2010/client", type = JAXBElement.class),
        @XmlElementRef(name = "ColumnBreak", namespace = "http://fdi.org/2010/client", type = JAXBElement.class),
        @XmlElementRef(name = "Graph", namespace = "http://fdi.org/2010/client", type = JAXBElement.class),
        @XmlElementRef(name = "Table", namespace = "http://fdi.org/2010/client", type = JAXBElement.class)
    })
    protected List<JAXBElement<?>> windowOrDialogOrPage;

    /**
     * Gets the value of the windowOrDialogOrPage property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the windowOrDialogOrPage property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWindowOrDialogOrPage().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link GroupT }{@code >}
     * {@link JAXBElement }{@code <}{@link PluginT }{@code >}
     * {@link JAXBElement }{@code <}{@link ImageT }{@code >}
     * {@link JAXBElement }{@code <}{@link BreakT }{@code >}
     * {@link JAXBElement }{@code <}{@link WindowT }{@code >}
     * {@link JAXBElement }{@code <}{@link GridT }{@code >}
     * {@link JAXBElement }{@code <}{@link EditDisplayT }{@code >}
     * {@link JAXBElement }{@code <}{@link ChartT }{@code >}
     * {@link JAXBElement }{@code <}{@link ParameterT }{@code >}
     * {@link JAXBElement }{@code <}{@link MenuT }{@code >}
     * {@link JAXBElement }{@code <}{@link PageT }{@code >}
     * {@link JAXBElement }{@code <}{@link BreakT }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link DialogT }{@code >}
     * {@link JAXBElement }{@code <}{@link BreakT }{@code >}
     * {@link JAXBElement }{@code <}{@link ActionT }{@code >}
     * {@link JAXBElement }{@code <}{@link GraphT }{@code >}
     * {@link JAXBElement }{@code <}{@link TableT }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getWindowOrDialogOrPage() {
        if (windowOrDialogOrPage == null) {
            windowOrDialogOrPage = new ArrayList<JAXBElement<?>>();
        }
        return this.windowOrDialogOrPage;
    }

}
