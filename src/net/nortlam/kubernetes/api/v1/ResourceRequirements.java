package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * ResourceRequirements describes the compute resource requirements.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "port")
@XmlAccessorType(XmlAccessType.FIELD)
public class ResourceRequirements implements Serializable {

    /**
     * imits describes the maximum amount of compute resources allowed. 
     * 
     * More info: http://kubernetes.io/docs/user-guide/compute-resources/
     */
    @XmlElement(name="limits", required = false, type = Object.class)
    private String limits;

    /**
     * Requests describes the minimum amount of compute resources required. 
     * If Requests is omitted for a container, it defaults to Limits if that 
     * is explicitly specified, otherwise to an implementation-defined value. 
     * 
     * More info: http://kubernetes.io/docs/user-guide/compute-resources/
     */
    @XmlElement(name="requests", required = false, type = Object.class)
    private String requests;
}
