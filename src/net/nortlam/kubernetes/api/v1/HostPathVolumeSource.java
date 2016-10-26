package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "hostPath")
@XmlAccessorType(XmlAccessType.FIELD)
public class HostPathVolumeSource implements Serializable {
    
    /**
     * Path of the directory on the host. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/volumes.md#hostpath
     */
    @XmlElement(name="path", required = true, type = String.class)
    private String path;
}
