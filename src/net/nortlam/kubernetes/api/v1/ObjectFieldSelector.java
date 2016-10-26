package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * ObjectFieldSelector selects an APIVersioned field of an object.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "items")
@XmlAccessorType(XmlAccessType.FIELD)
public class ObjectFieldSelector implements Serializable {
    
    /**
     * Version of the schema the FieldPath is written in terms of, 
     * defaults to "v1".
     */
    @XmlElement(name="apiVersion", required = false, type = String.class)
    private String apiVersion;

    /**
     * Path of the field to select in the specified API version.
     */
    @XmlElement(name="fieldPath", required = true, type = String.class)
    private String fieldPath;
}
