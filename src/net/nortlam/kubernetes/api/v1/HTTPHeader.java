package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * HTTPHeader describes a custom header to be used in HTTP probes
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "httpheader")
@XmlAccessorType(XmlAccessType.FIELD)
public class HTTPHeader implements Serializable {

    /**
     * The header field name
     */
    @XmlElement(name="name", required = true, type = String.class)
    private String name;

    /**
     * The header field value
     */
    @XmlElement(name="value", required = true, type = String.class)
    private String value;
}
