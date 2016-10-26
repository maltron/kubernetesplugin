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
 * PersistentVolumeClaimVolumeSource references the user’s PVC in the same 
 * namespace. This volume finds the bound PV and mounts that volume for the pod. 
 * A PersistentVolumeClaimVolumeSource is, essentially, a wrapper around another 
 * type of volume that is owned by someone else (the system).
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "persistentVolumeClaim")
@XmlAccessorType(XmlAccessType.FIELD)
public class PersistentVolumeClaimVolumeSource implements Serializable {
    
    /**
     * ClaimName is the name of a PersistentVolumeClaim in the same namespace 
     * as the pod using this volume. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/persistent-volumes.md#persistentvolumeclaims
     */
    @XmlElement(name="claimName", required = false, type = String.class)
    private String claimName;
    
    /**
     * Will force the ReadOnly setting in VolumeMounts. Default false.
     */
    @XmlElement(name="readOnly", required = false, type = boolean.class, defaultValue = "false")
    private boolean readOnly;
}
