//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.11.29 at 09:24:44 PM ECT 
//


package ec.edu.espe.arqsoftware.examen.zuniga.bridge.soap;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LocalidadS" type="{http://espe.edu.ec/arqsoftware/examen/zuniga/server/ws}LocalidadRS" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "localidadS"
})
@XmlRootElement(name = "obtenerLocalidadesResponse")
public class ObtenerLocalidadesResponse {

    @XmlElement(name = "LocalidadS")
    protected List<LocalidadRS> localidadS;

    /**
     * Gets the value of the localidadS property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the localidadS property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLocalidadS().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LocalidadRS }
     * 
     * 
     */
    public List<LocalidadRS> getLocalidadS() {
        if (localidadS == null) {
            localidadS = new ArrayList<LocalidadRS>();
        }
        return this.localidadS;
    }

}