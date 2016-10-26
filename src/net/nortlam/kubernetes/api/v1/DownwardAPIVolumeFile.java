package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * DownwardAPIVolumeFile represents information to create the file containing 
 * the pod field
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "items")
@XmlAccessorType(XmlAccessType.FIELD)
public class DownwardAPIVolumeFile implements Serializable {

    /**
     * Required: Path is the relative path name of the file to be created. 
     * Must not be absolute or contain the .. path. Must be utf-8 encoded. 
     * The first item of the relative path must not start with .
     */
    @XmlElement(name="path", required = true, type = String.class)
    private String path;
    
    /**
     * Required: Selects a field of the pod: only annotations, labels, 
     * name and namespace are supported.
     */
    @XmlElement(name="fieldRef", required = false, type = ObjectFieldSelector.class)
    private ObjectFieldSelector fieldRef;
    
    /**
     * Selects a resource of the container: only resources limits and requests 
     * (limits.cpu, limits.memory, requests.cpu and requests.memory) 
     * are currently supported.
     */
    @XmlElement(name="resourceFieldRef", required = false, type = ResourceFieldSelector.class)
    private ResourceFieldSelector resourceFieldRef;
    
    /**
     * Optional: mode bits to use on this file, must be a value 
     * between 0 and 0777. If not specified, the volume defaultMode 
     * will be used. This might be in conflict with other options that 
     * affect the file mode, like fsGroup, and the result can be other 
     * mode bits set
     */
    @XmlElement(name="mode", required = false, type = int.class)
    private int mode;

}
