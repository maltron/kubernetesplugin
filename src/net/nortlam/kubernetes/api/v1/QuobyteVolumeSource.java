package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a Quobyte mount that lasts the lifetime of a pod. 
 * Quobyte volumes do not support ownership management or SELinux relabeling.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "quobyte")
@XmlAccessorType(XmlAccessType.FIELD)
public class QuobyteVolumeSource implements Serializable {
    
    /**
     * Registry represents a single or multiple Quobyte Registry services 
     * specified as a string as host:port pair (multiple entries are separated 
     * with commas) which acts as the central registry for volumes
     */
    @XmlElement(name="registry", required = true, type = String.class)
    private String registry;
    
    /**
     * Volume is a string that references an already created Quobyte volume 
     * by name.
     */
    @XmlElement(name="volume", required = true, type = String.class)
    private String volume;
    
    /**
     * ReadOnly here will force the Quobyte volume to be mounted with 
     * read-only permissions. Defaults to false.
     */
    @XmlElement(name="readOnly", required = false, type = boolean.class, defaultValue = "false")
    private boolean readOnly;
    
    /**
     * User to map volume access to Defaults to serivceaccount use
     */
    @XmlElement(name="user", required = false, type = String.class)
    private String user;
    
    /**
     * Group to map volume access to Default is no group
     */
    @XmlElement(name="group", required = false, type = String.class)
    private String group;
}
