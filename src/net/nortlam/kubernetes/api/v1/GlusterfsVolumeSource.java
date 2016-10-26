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
 * Represents a Glusterfs mount that lasts the lifetime of a pod. Glusterfs 
 * volumes do not support ownership management or SELinux relabeling.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "glusterfs")
@XmlAccessorType(XmlAccessType.FIELD)
public class GlusterfsVolumeSource implements Serializable {
    
    /**
     * EndpointsName is the endpoint name that details Glusterfs topology. 
     * 
     * More info: http://releases.k8s.io/release-1.4/examples/volumes/glusterfs/README.md#create-a-pod
     */
    @XmlElement(name="endpoints", required = true, type = String.class)
    private String endpoints;
    
    /**
     * Path is the Glusterfs volume path. 
     * 
     * More info: http://releases.k8s.io/release-1.4/examples/volumes/glusterfs/README.md#create-a-pod
     */
    @XmlElement(name="path", required = true, type = String.class)
    private String path;
    
    /**
     * ReadOnly here will force the Glusterfs volume to be mounted with 
     * read-only permissions. Defaults to false. 
     * 
     * More info: http://releases.k8s.io/release-1.4/examples/volumes/glusterfs/README.md#create-a-pod
     */
    @XmlElement(name="readOnly", required = false, type = boolean.class, defaultValue = "false")
    private boolean readOnly;
}
