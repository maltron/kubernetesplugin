package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * ContainerStatus contains details for the current status of this container. 
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "containerstatus")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContainerStatus implements Serializable {

    /**
     * This must be a DNS_LABEL. Each container in a pod must have a 
     * unique name. Cannot be updated.
     */
    @XmlElement(name="name", required = true, type = String.class)
    private String name;

    /**
     * Details about the container’s current condition.
     */
    @XmlElement(name="state", required = false, type = ContainerState.class)
    private ContainerState state;

    /**
     * Details about the container’s last termination condition
     */
    @XmlElement(name="lastState", required = false, type = ContainerState.class)
    private ContainerState lastState;

    /**
     * Specifies whether the container has passed its readiness probe
     */
    @XmlElement(name="ready", required = true, type = boolean.class, defaultValue = "false")
    private boolean ready;

    /**
     * The number of times the container has been restarted, currently 
     * based on the number of dead containers that have not yet been removed. 
     * Note that this is calculated from dead containers. But those containers 
     * are subject to garbage collection. This value will get capped at 5 by GC.
     */
    @XmlElement(name="restartCount", required = true, type = int.class)
    private int restartCount;

    /**
     * The image the container is running. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/images.md
     */
    @XmlElement(name="image", required = true, type = String.class)
    private String image;

    /**
     * ImageID of the container’s image.
     */
    @XmlElement(name="imageID", required = true, type = String.class)
    private String imageID;

    /**
     * Container’s ID in the format docker://<container_id>. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/container-environment.md#container-information
     */
    @XmlElement(name="containerID", required = false, type = String.class)
    private String containerID;
    
}
