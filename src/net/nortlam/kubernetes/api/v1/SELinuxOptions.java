package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * SELinuxOptions are the labels to be applied to the container
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "selinuxoptions")
@XmlAccessorType(XmlAccessType.FIELD)
public class SELinuxOptions implements Serializable {

    /**
     * User is a SELinux user label that applies to the container.
     */
    @XmlElement(name="user", required = false, type = String.class)
    private String user;

    /**
     * Role is a SELinux role label that applies to the container.
     */
    @XmlElement(name="role", required = false, type = String.class)
    private String role;

    /**
     * Type is a SELinux type label that applies to the container.
     */
    @XmlElement(name="type", required = false, type = String.class)
    private String type;

    /**
     * Level is SELinux level label that applies to the container.
     */
    @XmlElement(name="level", required = false, type = String.class)
    private String level;
}
