package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents an NFS mount that lasts the lifetime of a pod. NFS volumes do 
 * not support ownership management or SELinux relabeling.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "nfs")
@XmlAccessorType(XmlAccessType.FIELD)
public class NFSVolumeSource implements Serializable {
    
    /**
     * Server is the hostname or IP address of the NFS server. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/volumes.md#nfs
     */
    @XmlElement(name="server", required = true, type = String.class)
    private String server;
    
    /**
     * Path that is exported by the NFS server. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/volumes.md#nfs
     */
    @XmlElement(name="path", required = true, type = String.class)
    private String path;
    
    /**
     * ReadOnly here will force the NFS export to be mounted with read-only 
     * permissions. Defaults to false. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/volumes.md#nfs
     */
    @XmlElement(name="readOnly", required = false, type = boolean.class, defaultValue = "false")
    private boolean readOnly;
}
