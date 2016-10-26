package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Represents a Flocker volume mounted by the Flocker agent. 
 * Flocker volumes do not support ownership management or SELinux relabeling.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "flocker")
@XmlAccessorType(XmlAccessType.FIELD)
public class FlockerVolumeSource implements Serializable {
    
    /**
     * Required: the volume name. This is going to be store on 
     * metadata → name on the payload for Flocker
     */
    @XmlElement(name="datasetName", required = true, type = String.class)
    private String datasetName;
}
