package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * PodSecurityContext holds pod-level security attributes and common container 
 * settings. Some fields are also present in container.securityContext. 
 * Field values of container.securityContext take precedence over field 
 * values of PodSecurityContext.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "podsecuritycontext")
@XmlAccessorType(XmlAccessType.FIELD)
public class PodSecurityContext implements Serializable {

    /**
     * The SELinux context to be applied to all containers. 
     * If unspecified, the container runtime will allocate a random SELinux 
     * context for each container. May also be set in SecurityContext. If set 
     * in both SecurityContext and PodSecurityContext, the value specified in 
     * SecurityContext takes precedence for that container.
     */
    @XmlElement(name="seLinuxOptions", required = false, type = SELinuxOptions.class)
    private SELinuxOptions seLinuxOptions;

    /**
     * The UID to run the entrypoint of the container process. Defaults to 
     * user specified in image metadata if unspecified. May also be set in 
     * SecurityContext. If set in both SecurityContext and PodSecurityContext, 
     * the value specified in SecurityContext takes precedence for that 
     * container.
     */
    @XmlElement(name="runAsUser", required = false, type = long.class)
    private long runAsUser;

    /**
     * Indicates that the container must run as a non-root user. If true, the 
     * Kubelet will validate the image at runtime to ensure that it does not 
     * run as UID 0 (root) and fail to start the container if it does. If unset 
     * or false, no such validation will be performed. May also be set in 
     * SecurityContext. If set in both SecurityContext and PodSecurityContext, 
     * the value specified in SecurityContext takes precedence.
     */
    @XmlElement(name="runAsNonRoot", required = false, type = boolean.class, defaultValue = "false")
    private boolean runAsNonRoot;

    /**
     * A list of groups applied to the first process run in each container, 
     * in addition to the container’s primary GID. If unspecified, no groups 
     * will be added to any container
     */
    @XmlElement(name="supplementalGroups", required = false, type = int.class)
    private int supplementalGroups;

    /**
     * A special supplemental group that applies to all containers in a pod. 
     * Some volume types allow the Kubelet to change the ownership of that 
     * volume to be owned by the pod:
     * 
     * 
     * 1. The owning GID will be the FSGroup 
     * 2. The setgid bit is set (new files created in the volume will be 
     * owned by FSGroup) 
     * 3. The permission bits are OR’d with rw-rw
     */
    @XmlElement(name="fsGroup", required = false, type = long.class)
    private long fsGroup;
}
