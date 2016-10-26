package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * EventSource contains information for an event.

 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "source")
@XmlAccessorType(XmlAccessType.FIELD)
public class EventSource implements Serializable {

    /**
     * Component from which the event is generated.
     */
    @XmlElement(name="component", required = false, type = String.class)
    private String component;

    /**
     * Host name on which the event is generated
     */
    @XmlElement(name="host", required = false, type = String.class)
    private String host;

    
}
