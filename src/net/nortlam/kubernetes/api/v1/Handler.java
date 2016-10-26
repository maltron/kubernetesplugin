package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Handler defines a specific action that should be taken
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "handler")
@XmlAccessorType(XmlAccessType.FIELD)
public class Handler implements Serializable {
    
    /**
     * One and only one of the following should be specified. 
     * Exec specifies the action to take
     */
    @XmlElement(name="exec", required = false, type = ExecAction.class)
    private ExecAction exec;
    
    /**
     * HTTPGet specifies the http request to perform
     */
    @XmlElement(name="httpGet", required = false, type = HTTPGetAction.class)
    private HTTPGetAction httpGet;
    
    /**
     * TCPSocket specifies an action involving a TCP port. 
     * TCP hooks not yet supported
     */
    @XmlElement(name="tcpSocket", required = false, type = TCPSocketAction.class)
    private TCPSocketAction tcpSocket;
}
