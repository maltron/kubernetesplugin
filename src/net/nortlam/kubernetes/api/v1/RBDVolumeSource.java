package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a Rados Block Device mount that lasts the lifetime of a pod. 
 * RBD volumes support ownership management and SELinux relabeling.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "rbd")
@XmlAccessorType(XmlAccessType.FIELD)
public class RBDVolumeSource implements Serializable {
    
    /**
     * A collection of Ceph monitors. 
     * 
     * More info: http://releases.k8s.io/release-1.4/examples/volumes/rbd/README.md#how-to-use-it
     */
    @XmlElement(name="monitors", required = true, type = String[].class)
    private String[] monitors;
    
    /**
     * The rados image name. 
     * 
     * More info: http://releases.k8s.io/release-1.4/examples/volumes/rbd/README.md#how-to-use-it
     */
    @XmlElement(name="image", required = true, type = String.class)
    private String image;
    
    /**
     * Filesystem type of the volume that you want to mount. 
     * 
     * Tip: Ensure that the filesystem type is supported by the host operating 
     * system. Examples: "ext4", "xfs", "ntfs". Implicitly inferred to be "ext4" 
     * if unspecified. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/volumes.md#rbd
     */
    @XmlElement(name="fsType", required = false, type = String.class)
    private String fsType;
    
    /**
     * The rados pool name. Default is rbd. 
     * 
     * More info: http://releases.k8s.io/release-1.4/examples/volumes/rbd/README.md#how-to-use-it.
     */
    @XmlElement(name="pool", required = false, type = String.class)
    private String pool;
    
    /**
     * The rados user name. Default is admin. 
     * 
     * More info: http://releases.k8s.io/release-1.4/examples/volumes/rbd/README.md#how-to-use-it
     */
    @XmlElement(name="user", required = false, type = String.class)
    private String user;
    
    /**
     * Keyring is the path to key ring for RBDUser. 
     * Default is /etc/ceph/keyring. 
     * 
     * More info: http://releases.k8s.io/release-1.4/examples/volumes/rbd/README.md#how-to-use-it
     */
    @XmlElement(name="keyring", required = false, type = String.class)
    private String keyring;
    
    /**
     * SecretRef is name of the authentication secret for RBDUser. 
     * If provided overrides keyring. Default is nil. 
     * 
     * More info: http://releases.k8s.io/release-1.4/examples/volumes/rbd/README.md#how-to-use-it
     */
    @XmlElement(name="secretRef", required = false, type = LocalObjectReference.class)
    private LocalObjectReference secretRef;
    
    /**
     * ReadOnly here will force the ReadOnly setting in VolumeMounts. 
     * Defaults to false. 
     * 
     * More info: http://releases.k8s.io/release-1.4/examples/volumes/rbd/README.md#how-to-use-it
     */
    @XmlElement(name="readOnly", required = false, type = boolean.class, defaultValue = "false")
    private boolean readOnly;
}
