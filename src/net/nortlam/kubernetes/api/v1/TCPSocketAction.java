package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * TCPSocketAction describes an action based on opening a socket
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "tcpsocketaction")
@XmlAccessorType(XmlAccessType.FIELD)
public class TCPSocketAction implements Serializable {

    /**
     * Number or name of the port to access on the container. 
     * Number must be in the range 1 to 65535. Name must be an IANA_SVC_NAME.
     */
    @XmlElement(name="port", required = true, type = String.class)
    private String port;
}
