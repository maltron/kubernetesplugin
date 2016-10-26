package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Lifecycle describes actions that the management system should take in 
 * response to container lifecycle events. For the PostStart and PreStop 
 * lifecycle handlers, management of the container blocks until the action is 
 * complete, unless the container process fails, in which case the handler is 
 * aborted.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "lifecycle")
@XmlAccessorType(XmlAccessType.FIELD)
public class Lifecycle implements Serializable {

    /**
     * PostStart is called immediately after a container is created. 
     * If the handler fails, the container is terminated and restarted 
     * according to its restart policy. Other management of the container 
     * blocks until the hook completes. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/container-environment.md#hook-details
     */
    @XmlElement(name="postStart", required = false, type = Handler.class)
    private Handler postStart;

    /**
     * PreStop is called immediately before a container is terminated. 
     * The container is terminated after the handler completes. The reason for 
     * termination is passed to the handler. Regardless of the outcome of the 
     * handler, the container is eventually terminated. Other management of 
     * the container blocks until the hook completes. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/container-environment.md#hook-details
     */
    @XmlElement(name="preStop", required = false, type = Handler.class)
    private Handler preStop;
}
