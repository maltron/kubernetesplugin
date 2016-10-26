package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * ResourceFieldSelector represents container resources (cpu, memory) 
 * and their output format
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "resourceFieldRef")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResourceFieldSelector implements Serializable {

    /**
     * Container name: required for volumes, optional for env vars
     */
    @XmlElement(name="containerName", required = false, type = String.class)
    private String containerName;

    /**
     * Required: resource to select
     */
    @XmlElement(name="resource", required = true, type = String.class)
    private String resource;

    /**
     * Specifies the output format of the exposed resources, defaults to "1"
     */
    @XmlElement(name="divisor", required = false, type = String.class)
    private String divisor;
}
