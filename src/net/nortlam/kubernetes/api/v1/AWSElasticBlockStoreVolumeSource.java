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
 *
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "awsElasticBlockStore")
@XmlAccessorType(XmlAccessType.FIELD)
public class AWSElasticBlockStoreVolumeSource implements Serializable {
    
    /**
     * Unique ID of the persistent disk resource in AWS (Amazon EBS volume). 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/volumes.md#awselasticblockstore
     */
    @XmlElement(name="volumeID", required = true, type = String.class)
    private String volumeID;
    
    /**
     * Filesystem type of the volume that you want to mount. 
     * 
     * Tip: Ensure that the filesystem type is supported by the host operating 
     * system. Examples: "ext4", "xfs", "ntfs". Implicitly inferred to be 
     * "ext4" if unspecified. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/volumes.md#awselasticblockstore
     */
    @XmlElement(name="fsType", required = false, type = String.class)
    private String fsType;
    
    /**
     * The partition in the volume that you want to mount. 
     * If omitted, the default is to mount by volume name. 
     * Examples: For volume /dev/sda1, you specify the partition as "1". 
     * Similarly, the volume partition for /dev/sda is "0" (or you can 
     * leave the property empty).
     * 
     */
    @XmlElement(name="partition", required = false, type = int.class)
    private int partition;
    
    /**
     * Specify "true" to force and set the ReadOnly property in VolumeMounts 
     * to "true". If omitted, the default is "false". 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/volumes.md#awselasticblockstore
     */
    @XmlElement(name="readOnly", required = false, type = boolean.class, defaultValue = "false")
    private String readOnly;
    
}
