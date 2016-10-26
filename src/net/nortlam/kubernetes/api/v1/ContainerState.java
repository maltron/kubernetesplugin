package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * ContainerState holds a possible state of container. 
 * Only one of its members may be specified. If none of them is specified, 
 * the default one is ContainerStateWaiting.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "containerstate")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContainerState implements Serializable {

    /**
     * Details about a waiting container
     */
    @XmlElement(name="waiting", required = false, type = ContainerStateWaiting.class)
    private ContainerStateWaiting waiting;

    /**
     * Details about a running container
     */
    @XmlElement(name="running", required = false, type = ContainerStateRunning.class)
    private ContainerStateRunning running;

    /**
     * Details about a terminated container
     */
    @XmlElement(name="terminated", required = false, type = ContainerStateTerminated.class)
    private ContainerStateTerminated terminated;
}
