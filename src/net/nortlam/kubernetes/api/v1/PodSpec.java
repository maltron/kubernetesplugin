package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * PodSpec is a description of a pod.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "spec")
@XmlAccessorType(XmlAccessType.FIELD)
public class PodSpec implements Serializable {

    /**
     * List of volumes that can be mounted by containers belonging to the pod. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/volumes.md
     */
    @XmlElement(name="volumes", required = false, type = Volume[].class)
    private Volume[] volumes;

    /**
     * List of containers belonging to the pod. Containers cannot currently be 
     * added or removed. There must be at least one container in a Pod. 
     * Cannot be updated. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/containers.md
     */
    @XmlElement(name="containers", required = true, type = Container[].class)
    private Container[] containers;

    /**
     * Restart policy for all containers within the pod. One of Always, 
     * OnFailure, Never. Default to Always. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/pod-states.md#restartpolicy
     */
    @XmlElement(name="restartPolicy", required = false, type = String.class)
    private String restartPolicy;

    /**
     * Optional duration in seconds the pod needs to terminate gracefully. 
     * 
     * May be decreased in delete request. Value must be non-negative integer. 
     * The value zero indicates delete immediately. If this value is nil, the 
     * default grace period will be used instead. The grace period is the 
     * duration in seconds after the processes running in the pod are sent a 
     * termination signal and the time when the processes are forcibly halted 
     * with a kill signal. Set this value longer than the expected cleanup time 
     * for your process. Defaults to 30 seconds.
     */
    @XmlElement(name="terminationGracePeriodSeconds", required = false, type = long.class)
    private long terminationGracePeriodSeconds;

    /**
     * Optional duration in seconds the pod may be active on the node relative 
     * to StartTime before the system will actively try to mark it failed and 
     * kill associated containers. Value must be a positive integer.
     */
    @XmlElement(name="activeDeadlineSeconds", required = false, type = long.class)
    private long activeDeadlineSeconds;

    /**
     * Set DNS policy for containers within the pod. 
     * 
     * One of ClusterFirst or Default. Defaults to "ClusterFirst".
     */
    @XmlElement(name="dnsPolicy", required = false, type = String.class)
    private String dnsPolicy;

    /**
     * NodeSelector is a selector which must be true for the pod to fit on a 
     * node. Selector which must match a node’s labels for the pod to be 
     * scheduled on that node. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/node-selection/README.md
     */
    @XmlElement(name="nodeSelector", required = false, type = Object.class)
    private Object nodeSelector;

    /**
     * ServiceAccountName is the name of the ServiceAccount to use to run this 
     * pod. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/design/service_accounts.md
     */
    @XmlElement(name="serviceAccountName", required = false, type = String.class)
    private String serviceAccountName;

    /**
     * DeprecatedServiceAccount is a depreciated alias for ServiceAccountName. 
     * 
     * Deprecated: Use serviceAccountName instead.
     */
    @XmlElement(name="serviceAccount", required = false, type = String.class)
    private String serviceAccount;

    /**
     * NodeName is a request to schedule this pod onto a specific node. 
     * 
     * If it is non-empty, the scheduler simply schedules this pod onto that node, 
     * assuming that it fits resource requirements.
     */
    @XmlElement(name="nodeName", required = false, type = String.class)
    private String nodeName;

    /**
     * Host networking requested for this pod. Use the host’s network namespace. 
     * 
     * If this option is set, the ports that will be used must be specified. Default to false.
     */
    @XmlElement(name="hostNetwork", required = false, type = boolean.class)
    private boolean hostNetwork;

    /**
     * Use the host’s pid namespace. Optional: Default to false.
     */
    @XmlElement(name="hostPID", required = false, type = boolean.class)
    private boolean hostPID;

    /**
     * Use the host’s ipc namespace. Optional: Default to false
     */
    @XmlElement(name="hostIPC", required = false, type = boolean.class)
    private boolean hostIPC;

    /**
     * SecurityContext holds pod-level security attributes and common container 
     * 
     * settings. Optional: Defaults to empty. See type description for default values of each field.
     */
    @XmlElement(name="securityContext", required = false, type = PodSecurityContext.class)
    private PodSecurityContext securityContext;

    /**
     * ImagePullSecrets is an optional list of references to secrets in the same 
     * namespace to use for pulling any of the images used by this PodSpec. 
     * If specified, these secrets will be passed to individual puller implementations for them to use. For example, in the case of docker, only DockerConfig type secrets are honored. More info: http://releases.k8s.io/release-1.4/docs/user-guide/images.md#specifying-imagepullsecrets-on-a-pod
     */
    @XmlElement(name="imagePullSecrets", required = false, type = LocalObjectReference[].class)
    private LocalObjectReference[] imagePullSecrets;

    /**
     * Specifies the hostname of the Pod If not specified, the pod’s hostname 
     * will be set to a system-defined value.
     */
    @XmlElement(name="hostname", required = false, type = String.class)
    private String hostname;

    /**
     * If specified, the fully qualified Pod hostname will be 
     * "<hostname>.<subdomain>.<pod namespace>.svc.<cluster domain>". 
     * If not specified, the pod will not have a domainname at all
     */
    @XmlElement(name="subdomain", required = false, type = String.class)
    private String subdomain;
}
