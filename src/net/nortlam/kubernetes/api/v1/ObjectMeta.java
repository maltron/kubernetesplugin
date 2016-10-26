package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import java.time.Instant;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * ObjectMeta is metadata that all persisted resources must have, 
 * which includes all objects users must create.
 * 
 * @author Mauricio "Maltron" Leal */
@XmlRootElement(name = "metadata")
@XmlAccessorType(XmlAccessType.FIELD)
public class ObjectMeta implements Serializable {

    /**
     * Name must be unique within a namespace. Is required when creating 
     * resources, although some resources may allow a client to request the 
     * generation of an appropriate name automatically. Name is primarily 
     * intended for creation idempotence and configuration definition. 
     * 
     * Cannot be updated. 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/identifiers.md#names
     */
    @XmlElement(name = "name", required = false, type = String.class)
    private String name;
    
    /**
     * If this field is specified and the generated name exists, the server will 
     * NOT return a 409 - instead, it will either return 201 Created or 500 
     * with Reason ServerTimeout indicating a unique name could not be found 
     * in the time allotted, and the client should retry (optionally after the 
     * time indicated in the Retry-After header).
     * 
     * Applied only if Name is not specified. 
     * More info: http://releases.k8s.io/release-1.4/docs/devel/api-conventions.md#idempotency
     */
    @XmlElement(name = "generateName", required = false, type=String.class)
    private String generateName;
    
    /**
     * Namespace defines the space within each name must be unique. 
     * An empty namespace is equivalent to the "default" namespace, 
     * but "default" is the canonical representation. Not all objects are 
     * required to be scoped to a namespace - the value of this field for 
     * those objects will be empty.
     * 
     * Must be a DNS_LABEL. Cannot be updated. 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/namespaces.md
     */
    @XmlElement(name = "namespace", required = false, type=String.class)
    private String namespace;

    /**
     * SelfLink is a URL representing this object. Populated by the system. Read-only.
     */
    @XmlElement(name = "selfLink", required = false, type=String.class)
    private String selfLink;
    
    /**
     * UID is the unique in time and space value for this object. 
     * It is typically generated by the server on successful creation of a 
     * resource and is not allowed to change on PUT operations.
     * 
     * Populated by the system. Read-only. 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/identifiers.md#uids
     */
    @XmlElement(name = "uid", required = false, type=String.class)
    private String uid;
    
    /**
     * An opaque value that represents the internal version of this object 
     * that can be used by clients to determine when objects have changed. 
     * May be used for optimistic concurrency, change detection, and the watch 
     * operation on a resource or set of resources. Clients must treat these 
     * values as opaque and passed unmodified back to the server. 
     * 
     * They may only be valid for a particular resource or set of resources.
     * 
     * Populated by the system. Read-only. 
     * Value must be treated as opaque by clients and . 
     * More info: http://releases.k8s.io/release-1.4/docs/devel/api-conventions.md#concurrency-control-and-consistency
     */
    @XmlElement(name = "resourceVersion", required = false, type=String.class)
    private String resourceVersion;
    
    /**
     * A sequence number representing a specific generation of the desired state. 
     * 
     * Populated by the system. Read-only.
     */
    @XmlElement(name = "generation", required = false, type=long.class)
    private long generation;
    
    /**
     * CreationTimestamp is a timestamp representing the server time when this 
     * object was created. It is not guaranteed to be set in happens-before 
     * order across separate operations. Clients may not set this value. 
     * It is represented in RFC3339 form and is in UTC.
     * 
     * Populated by the system. Read-only. Null for lists. 
     * More info: http://releases.k8s.io/release-1.4/docs/devel/api-conventions.md#metadata
     */
    @XmlElement(name = "creationTimestamp", required = false, type=Instant.class)
    private Instant creationTimestamp;
    
    /**
     * DeletionTimestamp is RFC 3339 date and time at which this resource 
     * will be deleted. This field is set by the server when a graceful 
     * deletion is requested by the user, and is not directly settable by a 
     * client. The resource will be deleted (no longer visible from resource 
     * lists, and not reachable by name) after the time in this field. 
     * Once set, this value may not be unset or be set further into the future, 
     * although it may be shortened or the resource may be deleted prior to 
     * this time. For example, a user may request that a pod is deleted in 
     * 30 seconds. The Kubelet will react by sending a graceful termination 
     * signal to the containers in the pod. Once the resource is deleted in the API, 
     * the Kubelet will send a hard termination signal to the container. 
     * If not set, graceful deletion of the object has not been requested.
     * Populated by the system when a graceful deletion is requested. Read-only. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/devel/api-conventions.md#metadata
     */
    @XmlElement(name = "deletionTimestamp", required = false, type=Instant.class)
    private Instant deletionTimestamp;
    
    /**
     * Number of seconds allowed for this object to gracefully terminate before 
     * it will be removed from the system. Only set when deletionTimestamp 
     * is also set. May only be shortened. Read-only.
     */
    @XmlElement(name = "deletionGracePeriodSeconds", required = false, type=long.class)
    private long deletionGracePeriodSeconds;
    
    /**
     * Map of string keys and values that can be used to organize and 
     * categorize (scope and select) objects. May match selectors of 
     * replication controllers and services. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/labels.md
     */
    @XmlElement(name = "labels", required = false, type=Object.class)
    private Object labels;
    
    /**
     * Annotations is an unstructured key value map stored with a resource that 
     * may be set by external tools to store and retrieve arbitrary metadata. 
     * They are not queryable and should be preserved when modifying objects. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/annotations.md
     */
    @XmlElement(name = "annotations", required = false, type=Object.class)
    private Object annotations;
    
    /**
     * List of objects depended by this object. If ALL objects in the list have 
     * been deleted, this object will be garbage collected. If this object is 
     * managed by a controller, then an entry in this list will point to this 
     * controller, with the controller field set to true. 
     * There cannot be more than one managing controller.
     */
    @XmlElement(name = "ownerReferences", required = false, type=OwnerReference.class)
    private OwnerReference ownerReferences;
    
    /**
     * Must be empty before the object is deleted from the registry. 
     * Each entry is an identifier for the responsible component that will 
     * remove the entry from the list. If the deletionTimestamp of the object 
     * is non-nil, entries in this list can only be removed.
     */
    @XmlElement(name = "finalizers", required = false, type=String[].class)
    private String[] finalizers;
    
    /**
     * The name of the cluster which the object belongs to. This is used to 
     * distinguish resources with same name and namespace in different clusters. 
     * This field is not set anywhere right now and apiserver is going to 
     * ignore it if set in create or update request.
     */
    @XmlElement(name = "clusterName", required = false, type=String.class)
    private String clusterName;
}