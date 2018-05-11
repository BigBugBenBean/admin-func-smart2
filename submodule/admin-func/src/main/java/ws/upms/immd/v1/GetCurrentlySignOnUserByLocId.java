
package ws.upms.immd.v1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getCurrentlySignOnUserByLocId complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCurrentlySignOnUserByLocId"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="locID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="isWithUserDetail" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCurrentlySignOnUserByLocId", propOrder = {
    "locID",
    "isWithUserDetail"
})
public class GetCurrentlySignOnUserByLocId {

    protected String locID;
    protected Boolean isWithUserDetail;

    /**
     * Gets the value of the locID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocID() {
        return locID;
    }

    /**
     * Sets the value of the locID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocID(String value) {
        this.locID = value;
    }

    /**
     * Gets the value of the isWithUserDetail property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsWithUserDetail() {
        return isWithUserDetail;
    }

    /**
     * Sets the value of the isWithUserDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsWithUserDetail(Boolean value) {
        this.isWithUserDetail = value;
    }

}
