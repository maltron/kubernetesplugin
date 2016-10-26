package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents an empty directory for a pod. Empty directory volumes support 
 * ownership management and SELinux relabeling.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "emptyDir")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmptyDirVolumeSource implements Serializable {

    /**
     * What type of storage medium should back this directory. 
     * The default is "" which means to use the node’s default medium. 
     * Must be an empty string (default) or Memory. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/volumes.md#emptydir
     */
    @XmlElement(name="medium", required = false, type = String.class)
    private String medium;
    
}
