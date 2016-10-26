package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * APIResource specifies the name of a resource and whether it is namespaced.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "capability")
@XmlAccessorType(XmlAccessType.FIELD)
public class Capability implements Serializable {

    /**
     * name is the name of the resource.
     */
    @XmlElement(name="name", required = true, type = String.class)
    private String name;

    /**
     * namespaced indicates if a resource is namespaced or not.
     */
    @XmlElement(name="namespaced", required = true, type = boolean.class, defaultValue = "false")
    private boolean namespaced;

    /**
     * kind is the kind for the resource (e.g. Foo is the kind for a 
     * resource foo)
     */
    @XmlElement(name="kind", required = true, type = String.class)
    private String kind;
}
