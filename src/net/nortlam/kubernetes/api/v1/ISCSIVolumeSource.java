package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents an ISCSI disk. ISCSI volumes can only be mounted as read/write 
 * once. ISCSI volumes support ownership management and SELinux relabeling.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "iscsi")
@XmlAccessorType(XmlAccessType.FIELD)
public class ISCSIVolumeSource implements Serializable {
    
    /**
     * iSCSI target portal. The portal is either an IP or ip_addr:port if the 
     * port is other than default (typically TCP ports 860 and 3260).
     */
    @XmlElement(name="targetPortal", required = true, type = String.class)
    private String targetPortal;
    
    /**
     * Target iSCSI Qualified Name.
     */
    @XmlElement(name="iqn", required = true, type = String.class)
    private String iqn;
    
    /**
     * iSCSI target lun number.
     */
    @XmlElement(name="lun", required = true, type = int.class)
    private int lun;
    
    /**
     * Optional: Defaults to default (tcp). iSCSI interface name that uses an 
     * iSCSI transport.
     */
    @XmlElement(name="iscsiInterface", required = false, type = String.class)
    private String iscsiInterface;
    
    /**
     * Filesystem type of the volume that you want to mount. 
     * Tip: Ensure that the filesystem type is supported by the host operating 
     * system. Examples: "ext4", "xfs", "ntfs". 
     * Implicitly inferred to be "ext4" if unspecified. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/volumes.md#iscsi
     */
    @XmlElement(name="fsType", required = false, type = String.class)
    private String fsType;
    
    /**
     * ReadOnly here will force the ReadOnly setting in VolumeMounts. 
     * Defaults to false
     */
    @XmlElement(name="readOnly", required = false, type = boolean.class, defaultValue = "false")
    private boolean readOnly;
}
