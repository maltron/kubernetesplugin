package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * SecurityContext holds security configuration that will be applied to a 
 * container. Some fields are present in both SecurityContext and 
 * PodSecurityContext. When both are set, the values in SecurityContext 
 * take precedence.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "securitycontext")
@XmlAccessorType(XmlAccessType.FIELD)
public class SecurityContext implements Serializable {

    /**
     * The capabilities to add/drop when running containers. 
     * Defaults to the default set of capabilities granted by the container 
     * runtime.
     */
    @XmlElement(name="capabilities", required = false, type = Capabilities.class)
    private Capabilities capabilities;

    /**
     * Run container in privileged mode. Processes in privileged containers 
     * are essentially equivalent to root on the host. Defaults to false.
     */
    @XmlElement(name="privileged", required = false, type = boolean.class)
    private boolean privileged;

    /**
     * The SELinux context to be applied to the container. If unspecified, 
     * the container runtime will allocate a random SELinux context for each 
     * container. May also be set in PodSecurityContext. If set in both 
     * SecurityContext and PodSecurityContext, the value specified in 
     * SecurityContext takes precedence.
     */
    @XmlElement(name="seLinuxOptions", required = false, type = SELinuxOptions.class)
    private SELinuxOptions seLinuxOptions;

    /**
     * The UID to run the entrypoint of the container process. Defaults to user 
     * specified in image metadata if unspecified. May also be set in 
     * PodSecurityContext. If set in both SecurityContext and 
     * PodSecurityContext, the value specified in SecurityContext 
     * takes precedence.
     */
    @XmlElement(name="runAsUser", required = false, type = long.class)
    private long runAsUser;

    /**
     * Indicates that the container must run as a non-root user. If true, 
     * the Kubelet will validate the image at runtime to ensure that it does 
     * not run as UID 0 (root) and fail to start the container if it does. If 
     * unset or false, no such validation will be performed. May also be set in 
     * PodSecurityContext. If set in both SecurityContext and 
     * PodSecurityContext, the value specified in SecurityContext takes 
     * precedence.
     */
    @XmlElement(name="runAsNonRoot", required = false, type = boolean.class, defaultValue = "false")
    private boolean runAsNonRoot;

    /**
     * Whether this container has a read-only root filesystem. Default is false.
     */
    @XmlElement(name="readOnlyRootFilesystem", required = false, type = boolean.class, defaultValue = "false")
    private boolean readOnlyRootFilesystem;
}
