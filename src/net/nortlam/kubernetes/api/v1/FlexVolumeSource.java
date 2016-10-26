package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * FlexVolume represents a generic volume resource that is provisioned/attached 
 * using an exec based plugin. This is an alpha feature and may change in 
 * future.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "flexVolume")
@XmlAccessorType(XmlAccessType.FIELD)
public class FlexVolumeSource implements Serializable {
    
    /**
     * Driver is the name of the driver to use for this volume.
     */
    @XmlElement(name="driver", required = true, type = String.class)
    private String driver;
    
    /**
     * Filesystem type to mount. Must be a filesystem type supported by the 
     * host operating system. Ex. "ext4", "xfs", "ntfs". The default filesystem 
     * depends on FlexVolume script.
     * 
     */
    @XmlElement(name="fsType", required = false, type = String.class)
    private String fsType;
    
    /**
     * Optional: SecretRef is reference to the secret object containing 
     * sensitive information to pass to the plugin scripts. This may be empty 
     * if no secret object is specified. If the secret object contains more 
     * than one secret, all secrets are passed to the plugin scripts.
     * 
     */
    @XmlElement(name="secretRef", required = false, type = LocalObjectReference.class)
    private LocalObjectReference secretRef;
    
    /**
     * Optional: Defaults to false (read/write). ReadOnly here will force the 
     * ReadOnly setting in VolumeMounts
     * 
     */
    @XmlElement(name="readOnly", required = false, type = boolean.class, defaultValue = "false")
    private boolean readOnly;

    /**
     * Optional: Extra command options if any.
     */
    @XmlElement(name="options", required = false, type = Object.class)
    private Object options;
}
