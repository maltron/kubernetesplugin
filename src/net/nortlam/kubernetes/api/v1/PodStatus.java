package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import java.time.Instant;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * PodStatus represents information about the status of a pod. 
 * Status may trail the actual state of a system.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "podstatus")
@XmlAccessorType(XmlAccessType.FIELD)
public class PodStatus implements Serializable {

    /**
     * Current condition of the pod. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/pod-states.md#pod-phase
     */
    @XmlElement(name="phase", required = false, type = String.class)
    private String phase;

    /**
     * Current service state of pod. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/pod-states.md#pod-conditions
     */
    @XmlElement(name="conditions", required = false, type = PodCondition[].class)
    private PodCondition[] conditions;

    /**
     * A human readable message indicating details about why the pod is in 
     * this condition.
     */
    @XmlElement(name="message", required = false, type = String.class)
    private String message;

    /**
     * A brief CamelCase message indicating details about why the pod is in 
     * this state. e.g. OutOfDisk
     */
    @XmlElement(name="reason", required = false, type = String.class)
    private String reason;

    /**
     * IP address of the host to which the pod is assigned. 
     * Empty if not yet scheduled.
     */
    @XmlElement(name="hostIP", required = false, type = String.class)
    private String hostIP;

    /**
     * IP address allocated to the pod. Routable at least within the cluster. 
     * Empty if not yet allocated.
     */
    @XmlElement(name="podIP", required = false, type = String.class)
    private String podIP;

    /**
     * RFC 3339 date and time at which the object was acknowledged by 
     * the Kubelet. This is before the Kubelet pulled the container image(s) 
     * for the pod.
     */
    @XmlElement(name="startTime", required = false, type = Instant.class)
    private Instant startTime;

    /**
     * The list has one entry per container in the manifest. 
     * Each entry is currently the output of docker inspect. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/pod-states.md#container-statuses
     */
    @XmlElement(name="containerStatus", required = false, type = ContainerStatus[].class)
    private ContainerStatus[] containerStatus;
}
