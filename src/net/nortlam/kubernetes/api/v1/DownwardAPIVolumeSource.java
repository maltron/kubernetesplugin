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
 * DownwardAPIVolumeSource represents a volume containing downward API info. 
 * Downward API volumes support ownership management and SELinux relabeling.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "downwardAPI")
@XmlAccessorType(XmlAccessType.FIELD)
public class DownwardAPIVolumeSource implements Serializable {
    
    /**
     * Items is a list of downward API volume file
     */
    @XmlElement(name="items", required = false, type = DownwardAPIVolumeFile[].class)
    private DownwardAPIVolumeFile[] items;
    
    /**
     * Optional: mode bits to use on created files by default. 
     * Must be a value between 0 and 0777. Defaults to 0644. 
     * Directories within the path are not affected by this setting. 
     * This might be in conflict with other options that affect the file mode, 
     * like fsGroup, and the result can be other mode bits set.
     */
    @XmlElement(name="defaultMode", required = false, type = int.class)
    private int defaultMode;
}
