package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a cinder volume resource in Openstack. 
 * A Cinder volume must exist before mounting to a container. 
 * The volume must also be in the same region as the kubelet. 
 * Cinder volumes support ownership management and SELinux relabeling.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "cinder")
@XmlAccessorType(XmlAccessType.FIELD)
public class CinderVolumeSource implements Serializable {
    
    /**
     * volume id used to identify the volume in cinder 
     * 
     * More info: http://releases.k8s.io/release-1.4/examples/mysql-cinder-pd/README.md
     */
    @XmlElement(name="volumeID", required = true, type = String.class)
    private String volumeID;
    
    /**
     * Filesystem type to mount. Must be a filesystem type supported by the 
     * host operating system. Examples: "ext4", "xfs", "ntfs". Implicitly 
     * inferred to be "ext4" if unspecified. 
     * 
     * More info: http://releases.k8s.io/release-1.4/examples/mysql-cinder-pd/README.md
     */
    @XmlElement(name="fsType", required = false, type = String.class)
    private String fsType;
    
    /**
     * Optional: Defaults to false (read/write). ReadOnly here will force 
     * the ReadOnly setting in VolumeMounts. 
     * 
     * More info: http://releases.k8s.io/release-1.4/examples/mysql-cinder-pd/README.md
     */
    @XmlElement(name="readOnly", required = false, type = boolean.class, defaultValue = "false")
    private String readOnly;
}
