package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * A single application container that you want to run within a pod.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "container")
@XmlAccessorType(XmlAccessType.FIELD)
public class Container implements Serializable {
    
    /**
     * Name of the container specified as a DNS_LABEL. Each container in a pod 
     * must have a unique name (DNS_LABEL). Cannot be updated
     */
    @XmlElement(name="name", required = true, type = String.class)
    private String name;
    
    /**
     * Docker image name. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/images.md
     */
    @XmlElement(name="image", required = false, type = String.class)
    private String image;
    
    /**
     * Entrypoint array. Not executed within a shell. 
     * The docker image’s ENTRYPOINT is used if this is not provided. 
     * Variable references $(VAR_NAME) are expanded using the container’s 
     * environment. If a variable cannot be resolved, the reference in the 
     * input string will be unchanged. The $(VAR_NAME) syntax can be escaped 
     * with a double $$, ie: $$(VAR_NAME). Escaped references will never be 
     * expanded, regardless of whether the variable exists or not. 
     * Cannot be updated. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/containers.md#containers-and-commands
     */
    @XmlElement(name="command", required = false, type = String[].class)
    private String[] command;
    
    /**
     * Arguments to the entrypoint. The docker image’s CMD is used if this is 
     * not provided. Variable references $(VAR_NAME) are expanded using the 
     * container’s environment. If a variable cannot be resolved, the reference 
     * in the input string will be unchanged. The $(VAR_NAME) syntax can be 
     * escaped with a double $$, ie: $$(VAR_NAME). Escaped references will never 
     * be expanded, regardless of whether the variable exists or not. 
     * Cannot be updated. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/containers.md#containers-and-commands
     */
    @XmlElement(name="args", required = false, type = String[].class)
    private String[] args;
    
    /**
     * Container’s working directory. If not specified, the container 
     * runtime’s default will be used, which might be configured in the 
     * container image. Cannot be updated.
     */
    @XmlElement(name="workingDir", required = false, type = String.class)
    private String workingDir;
    
    /**
     * List of ports to expose from the container. Exposing a port here gives 
     * the system additional information about the network connections a 
     * container uses, but is primarily informational. Not specifying a port 
     * here DOES NOT prevent that port from being exposed. Any port which is 
     * listening on the default "0.0.0.0" address inside a container will be 
     * accessible from the network. Cannot be updated.
     */
    @XmlElement(name="ports", required = false, type = ContainerPort[].class)
    private ContainerPort[] ports;
    
    /**
     * List of environment variables to set in the container. Cannot be updated.
     */
    @XmlElement(name="env", required = false, type = EnvVar[].class)
    private EnvVar[] env;
    
    /**
     * Compute Resources required by this container. Cannot be updated. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/persistent-volumes.md#resources
     */
    @XmlElement(name="resources", required = false, type = ResourceRequirements.class)
    private ResourceRequirements resources;
    
    /**
     * Pod volumes to mount into the container’s filesystem. Cannot be updated.
     */
    @XmlElement(name="volumeMounts", required = false, type = VolumeMount[].class)
    private VolumeMount[] volumeMounts;
    
    /**
     * Periodic probe of container liveness. Container will be restarted if the 
     * probe fails. Cannot be updated. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/pod-states.md#container-probes
     */
    @XmlElement(name="livenessProbe", required = false, type = Probe.class)
    private Probe livenessProbe;
    
    /**
     * Periodic probe of container service readiness. Container will be removed 
     * from service endpoints if the probe fails. Cannot be updated. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/pod-states.md#container-probes
     */
    @XmlElement(name="readinessProbe", required = false, type = Probe.class)
    private Probe readinessProbe;
    
    /**
     * Actions that the management system should take in response to container 
     * lifecycle events. Cannot be updated.
     */
    @XmlElement(name="lifecycle", required = false, type = Lifecycle.class)
    private Lifecycle lifecycle;
    
    /**
     * Optional: Path at which the file to which the container’s termination 
     * message will be written is mounted into the container’s filesystem. 
     * Message written is intended to be brief final status, such as an 
     * assertion failure message. Defaults to /dev/termination-log. 
     * Cannot be updated.
     */
    @XmlElement(name="terminationMessagePath", required = false, type = String.class)
    private String terminationMessagePath;
    
    /**
     * Image pull policy. One of Always, Never, IfNotPresent. 
     * Defaults to Always if :latest tag is specified, or IfNotPresent 
     * otherwise. Cannot be updated. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/images.md#updating-images
     */
    @XmlElement(name="imagePullPolicy", required = false, type = String.class)
    private String imagePullPolicy;
    
    /**
     * Security options the pod should run with. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/design/security_context.md
     */
    @XmlElement(name="securityContext", required = false, type = SecurityContext.class)
    private SecurityContext securityContext;
    
    /**
     * Whether this container should allocate a buffer for stdin in the 
     * container runtime. If this is not set, reads from stdin in the 
     * container will always result in EOF. Default is false
     */
    @XmlElement(name="stdin", required = false, type = boolean.class, defaultValue = "false")
    private boolean stdin;
    
    /**
     * Whether the container runtime should close the stdin channel after it 
     * has been opened by a single attach. When stdin is true the stdin stream 
     * will remain open across multiple attach sessions. If stdinOnce is set to 
     * true, stdin is opened on container start, is empty until the first 
     * client attaches to stdin, and then remains open and accepts data until 
     * the client disconnects, at which time stdin is closed and remains closed 
     * until the container is restarted. If this flag is false, a container 
     * processes that reads from stdin will never receive an EOF. 
     * Default is false
     */
    @XmlElement(name="stdinOnce", required = false, type = boolean.class, defaultValue = "false")
    private boolean stdinOnce;
    
    /**
     * Whether this container should allocate a TTY for itself, also requires 
     * stdin to be true. Default is false
     */
    @XmlElement(name="tty", required = false, type = boolean.class, defaultValue = "false")
    private boolean tty;
}
