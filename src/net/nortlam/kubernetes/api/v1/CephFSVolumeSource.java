package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a Ceph Filesystem mount that lasts the lifetime of a pod Cephfs 
 * volumes do not support ownership management or SELinux relabeling.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "cephfs")
@XmlAccessorType(XmlAccessType.FIELD)
public class CephFSVolumeSource implements Serializable {
    
    /**
     * Required: Monitors is a collection of Ceph monitors 
     * 
     * More info: http://releases.k8s.io/release-1.4/examples/volumes/cephfs/README.md#how-to-use-it
     */
    @XmlElement(name="monitors", required = true, type = String[].class)
    private String[] monitors;
    
    /**
     * Optional: Used as the mounted root, rather than the full Ceph tree, 
     * default is /
     */
    @XmlElement(name="path", required = false, type = String.class)
    private String path;
    
    /**
     * Optional: User is the rados user name, default is admin 
     * 
     * More info: http://releases.k8s.io/release-1.4/examples/volumes/cephfs/README.md#how-to-use-it
     */
    @XmlElement(name="user", required = false, type = String.class)
    private String user;
    
    /**
     * Optional: SecretFile is the path to key ring for User, 
     * default is /etc/ceph/user.secret 
     * 
     * More info: http://releases.k8s.io/release-1.4/examples/volumes/cephfs/README.md#how-to-use-it
     */
    @XmlElement(name="secretFile", required = false, type = String.class)
    private String secretFile;
    
    /**
     * Optional: SecretRef is reference to the authentication secret for User, 
     * default is empty. 
     * 
     * More info: http://releases.k8s.io/release-1.4/examples/volumes/cephfs/README.md#how-to-use-it
     */
    @XmlElement(name="secretRef", required = false, type = LocalObjectReference.class)
    private LocalObjectReference secretRef;
    
    /**
     * Optional: Defaults to false (read/write). ReadOnly here will force the 
     * ReadOnly setting in VolumeMounts. 
     * 
     * More info: http://releases.k8s.io/release-1.4/examples/volumes/cephfs/README.md#how-to-use-it
     */
    @XmlElement(name="readOnly", required = false, type = boolean.class, defaultValue = "false")
    private boolean readOnly;
}
