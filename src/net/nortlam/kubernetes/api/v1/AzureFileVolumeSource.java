package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * AzureFile represents an Azure File Service mount on the host and bind mount 
 * to the pod.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "azureFile")
@XmlAccessorType(XmlAccessType.FIELD)
public class AzureFileVolumeSource implements Serializable {
    
    /**
     * the name of secret that contains Azure Storage Account Name and Key
     */
    @XmlElement(name="secretName", required = true, type = String.class)
    private String secretName;
    
    /**
     * Share Name
     */
    @XmlElement(name="shareName", required = true, type = String.class)
    private String shareName;
    
    /**
     * Defaults to false (read/write). ReadOnly here will force the ReadOnly 
     * setting in VolumeMounts.
     */
    @XmlElement(name="readOnly", required = false, type = boolean.class, defaultValue = "false")
    private boolean readOnly;
}
