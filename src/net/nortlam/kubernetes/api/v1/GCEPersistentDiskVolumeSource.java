package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a Persistent Disk resource in Google Compute Engine.
 * 
 * A GCE PD must exist before mounting to a container. 
 * The disk must also be in the same GCE project and zone as the kubelet. 
 * A GCE PD can only be mounted as read/write once or read-only many times. 
 * GCE PDs support ownership management and SELinux relabeling.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "gcePersistentDisk")
@XmlAccessorType(XmlAccessType.FIELD)
public class GCEPersistentDiskVolumeSource implements Serializable {

    /**
     * Unique name of the PD resource in GCE. Used to identify the disk in GCE. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/volumes.md#gcepersistentdisk
     */
    @XmlElement(name="pdName", required = true, type = String.class)
    private String pdName;

    /**
     * Filesystem type of the volume that you want to mount. 
     * 
     * Tip: Ensure that the filesystem type is supported by the host operating 
     * system. Examples: "ext4", "xfs", "ntfs". Implicitly inferred to be "ext4" 
     * if unspecified. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/volumes.md#gcepersistentdisk
     */
    @XmlElement(name="fsType", required = false, type = String.class)
    private String fsType;

    /**
     * The partition in the volume that you want to mount. If omitted, the 
     * default is to mount by volume name. Examples: For volume /dev/sda1, you 
     * specify the partition as "1". Similarly, the volume partition for 
     * /dev/sda is "0" (or you can leave the property empty). 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/volumes.md#gcepersistentdisk
     */
    @XmlElement(name="partition", required = false, type = int.class)
    private int partition;

    /**
     * ReadOnly here will force the ReadOnly setting in VolumeMounts. 
     * 
     * Defaults to false. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/volumes.md#gcepersistentdisk
     */
    @XmlElement(name="readOnly", required = false, type = boolean.class, defaultValue = "false")
    private boolean readOnly;
}
