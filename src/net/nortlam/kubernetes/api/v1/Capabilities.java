package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Adds and removes POSIX capabilities from running containers.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "capabilities")
@XmlAccessorType(XmlAccessType.FIELD)
public class Capabilities implements Serializable {

    /**
     * Added capabilities
     */
    @XmlElement(name="add", required = false, type = Capability[].class)
    private Capability[] add;

    /**
     * Removed capabilities
     */
    @XmlElement(name="drop", required = false, type = Capability[].class)
    private Capability[] drop;
}
