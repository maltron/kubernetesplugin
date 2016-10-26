package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * AzureDisk represents an Azure Data Disk mount on the host and bind mount 
 * to the pod.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "azureDisk")
@XmlAccessorType(XmlAccessType.FIELD)
public class AzureDiskVolumeSource implements Serializable {
    
    /**
     * The Name of the data disk in the blob storage
     */
    @XmlElement(name="diskName", required = true, type = String.class)
    private String diskName;
    
    /**
     * The URI the data disk in the blob storage
     */
    @XmlElement(name="diskURI", required = true, type = String.class)
    private String diskURI;
    
    /**
     * Host Caching mode: None, Read Only, Read Write
     */
    @XmlElement(name="cachingMode", required = false, type = AzureDataDiskCachingMode.class)
    private AzureDataDiskCachingMode cachingMode;
    
    /**
     * Filesystem type to mount. Must be a filesystem type supported by the host 
     * operating system. Ex. "ext4", "xfs", "ntfs". Implicitly inferred to be 
     * "ext4" if unspecified.
     */
    @XmlElement(name="fsType", required = false, type = String.class)
    private String fsType;
    
    /**
     * Defaults to false (read/write). ReadOnly here will force the ReadOnly 
     * setting in VolumeMounts.
     */
    @XmlElement(name="readOnly", required = false, type = boolean.class, defaultValue = "false")
    private boolean readOnly;
}
