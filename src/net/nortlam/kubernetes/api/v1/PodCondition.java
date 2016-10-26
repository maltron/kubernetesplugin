package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import java.time.Instant;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * PodCondition contains details for the current condition of this pod.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "podcontition")
@XmlAccessorType(XmlAccessType.FIELD)
public class PodCondition implements Serializable {

    /**
     * Type is the type of the condition. Currently only Ready. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/pod-states.md#pod-conditions
     */
    @XmlElement(name="type", required = true, type = String.class)
    private String type;

    /**
     * Status is the status of the condition. Can be True, False, Unknown. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/pod-states.md#pod-conditions
     */
    @XmlElement(name="status", required = true, type = String.class)
    private String status;

    /**
     * Last time we probed the condition.
     */
    @XmlElement(name="lastProbeTime", required = false, type = Instant.class)
    private Instant lastProbeTime;

    /**
     * Last time the condition transitioned from one status to another.
     */
    @XmlElement(name="lastTransitionTime", required = false, type = Instant.class)
    private Instant lastTransitionTime;

    /**
     * Unique, one-word, CamelCase reason for the condition’s last transition.
     */
    @XmlElement(name="reason", required = false, type = String.class)
    private String reason;

    /**
     * Human-readable message indicating details about last transition.
     */
    @XmlElement(name="message", required = false, type = String.class)
    private String message;
}
