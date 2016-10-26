package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Adapts a ConfigMap into a volume.
 * The contents of the target ConfigMap’s Data field will be presented in a 
 * volume as files using the keys in the Data field as the file names,  
 * unless the items element is populated with specific mappings of keys to paths. 
 * ConfigMap volumes support ownership management and SELinux relabeling.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "configMap")
@XmlAccessorType(XmlAccessType.FIELD)
public class ConfigMapVolumeSource implements Serializable {
    
    /**
     * Name of the referent. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/identifiers.md#names
     */
    @XmlElement(name="name", required = false, type = String.class)
    private String name;
    
    /**
     * If unspecified, each key-value pair in the Data field of the referenced 
     * ConfigMap will be projected into the volume as a file whose name is the 
     * key and content is the value. If specified, the listed keys will be 
     * projected into the specified paths, and unlisted keys will not be 
     * present. If a key is specified which is not present in the ConfigMap, 
     * the volume setup will error. Paths must be relative and may not contain 
     * the .. path or start with ...
     */
    @XmlElement(name="items", required = false, type = KeyToPath[].class)
    private KeyToPath[] items;
    
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
