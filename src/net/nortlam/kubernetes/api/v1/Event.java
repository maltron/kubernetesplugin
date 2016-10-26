package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import java.time.Instant;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Event is a report of an event somewhere in the cluster.
 * 
 * @author mauricio
 */
@XmlRootElement(name = "event")
@XmlAccessorType(XmlAccessType.FIELD)
public class Event implements Serializable {
    
    /**
     * Kind is a string value representing the REST resource this object 
     * represents. Servers may infer this from the endpoint the client submits 
     * requests to. Cannot be updated. In CamelCase. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/devel/api-conventions.md#types-kinds
     */
    @XmlElement(name="kind", required = false, type = String.class)
    private String kind;
    
    /**
     * APIVersion defines the versioned schema of this representation of an 
     * object. 
     * 
     * Servers should convert recognized schemas to the latest internal value, 
     * and may reject unrecognized values. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/devel/api-conventions.md#resources
     */
    @XmlElement(name="apiVersion", required = false, type = String.class)
    private String apiVersion;
    
    /**
     * Standard object’s metadata. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/devel/api-conventions.md#metadata
     */
    @XmlElement(name="metadata", required = true, type = ObjectMeta.class)
    private ObjectMeta metadata;
    
    /**
     * The object that this event is about.
     */
    @XmlElement(name="involvedObject", required = true, type = ObjectReference.class)
    private ObjectReference involvedObject;
    
    /**
     * This should be a short, machine understandable string that gives the 
     * 
     * reason for the transition into the object’s current status.
     */
    @XmlElement(name="reason", required = false, type = String.class)
    private String reason;
    
    /**
     * A human-readable description of the status of this operation.
     */
    @XmlElement(name="message", required = false, type = String.class)
    private String message;
    
    /**
     * The component reporting this event. 
     * 
     * Should be a short machine understandable string.
     */
    @XmlElement(name="source", required = false, type = EventSource.class)
    private EventSource source;
    
    /**
     * The time at which the event was first recorded. 
     * (Time of server receipt is in TypeMeta.)
     */
    @XmlElement(name="firstTimestamp", required = false, type = Instant.class)
    private Instant firstTimestamp;
    
    /**
     * The time at which the most recent occurrence of this event was recorded.
     */
    @XmlElement(name="lastTimestamp", required = false, type = Instant.class)
    private Instant lastTimestamp;
    
    /**
     * The number of times this event has occurred.
     */
    @XmlElement(name="count", required = false, type = String.class)
    private int count;
    
    /**
     * Type of this event (Normal, Warning), new types could be 
     * added in the future
     */
    @XmlElement(name="type", required = false, type = String.class)
    private String type;
}
