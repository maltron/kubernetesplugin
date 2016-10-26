package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * ContainerPort represents a network port in a single container.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "port")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContainerPort implements Serializable {

    /**
     * If specified, this must be an IANA_SVC_NAME and unique within the pod. 
     * Each named port in a pod must have a unique name. Name for the port that 
     * can be referred to by services.
     */
    @XmlElement(name="name", required = false, type = String.class)
    private String name;

    /**
     * Number of port to expose on the host. If specified, this must be a valid 
     * port number, 0 < x < 65536. 
     * If HostNetwork is specified, this must match ContainerPort. 
     * Most containers do not need this.
     */
    @XmlElement(name="hostPort", required = false, type = int.class)
    private int hostPort;

    /**
     * Number of port to expose on the pod’s IP address. 
     * This must be a valid port number, 0 < x < 65536.
     */
    @XmlElement(name="containerPort", required = true, type = int.class)
    private int containerPort;

    /**
     * Protocol for port. Must be UDP or TCP. Defaults to "TCP".
     */
    @XmlElement(name="protocol", required = false, type = String.class)
    private String protocol;

    /**
     * What host IP to bind the external port to
     */
    @XmlElement(name="hostIP", required = false, type = String.class)
    private String hostIP;
}
