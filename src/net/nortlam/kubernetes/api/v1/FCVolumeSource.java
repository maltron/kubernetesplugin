/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a Fibre Channel volume. Fibre Channel volumes can only be mounted 
 * as read/write once. Fibre Channel volumes support ownership management and 
 * SELinux relabeling.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "fc")
@XmlAccessorType(XmlAccessType.FIELD)
public class FCVolumeSource implements Serializable {
    
    /**
     * Required: FC target worldwide names (WWNs)
     */
    @XmlElement(name="targetWWNs", required = true, type = String[].class)
    private String[] targetWWNs;
    
    /**
     * Required: FC target lun number
     */
    @XmlElement(name="lun", required = true, type = int.class)
    private int lun;
    
    /**
     * Filesystem type to mount. Must be a filesystem type supported by the host 
     * operating system. Ex. "ext4", "xfs", "ntfs". Implicitly inferred to be 
     * "ext4" if unspecified.
     */
    @XmlElement(name="fsType", required = false, type = String.class)
    private String fsType;
    
    /**
     * Optional: Defaults to false (read/write). ReadOnly here will force the 
     * ReadOnly setting in VolumeMounts
     */
    @XmlElement(name="readOnly", required = false, type = boolean.class, defaultValue = "false")
    private boolean readOnly;
}
