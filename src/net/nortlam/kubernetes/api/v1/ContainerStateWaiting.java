package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * ContainerStateWaiting is a waiting state of a container.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "containerstatewaiting")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContainerStateWaiting implements Serializable {

    /**
     * (brief) reason the container is not yet running.
     */
    @XmlElement(name="reason", required = false, type = String.class)
    private String reason;

    /**
     * Message regarding why the container is not yet running.
     */
    @XmlElement(name="message", required = false, type = String.class)
    private String message;
}
