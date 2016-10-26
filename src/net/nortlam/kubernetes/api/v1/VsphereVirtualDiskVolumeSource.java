package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a vSphere volume resource.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "vsphereVolume")
@XmlAccessorType(XmlAccessType.FIELD)
public class VsphereVirtualDiskVolumeSource implements Serializable {
    
    /**
     * Path that identifies vSphere volume vmdk
     */
    @XmlElement(name="volumePath", required = true, type = String.class)
    private String volumePath;
    
    /**
     * Filesystem type to mount. Must be a filesystem type supported by the 
     * host operating system. Ex. "ext4", "xfs", "ntfs". 
     * Implicitly inferred to be "ext4" if unspecified.
     */
    @XmlElement(name="fsType", required = false, type = String.class)
    private String fsType;
}
