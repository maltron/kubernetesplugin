package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * OwnerReference contains enough information to let you identify an owning 
 * object. Currently, an owning object must be in the same namespace, 
 * so there is no namespace field.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "ownerReference")
@XmlAccessorType(XmlAccessType.FIELD)
public class OwnerReference implements Serializable {

    /**
     * API version of the referent.
     */
    @XmlElement(name="apiVersion", required = true, type = String.class)
    private String apiVersion;

    /**
     * Kind of the referent. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/devel/api-conventions.md#types-kinds
     */
    @XmlElement(name="kind", required = true, type = String.class)
    private String kind;

    /**
     * Name of the referent. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/identifiers.md#names
     */
    @XmlElement(name="name", required = true, type = String.class)
    private String name;

    /**
     * UID of the referent. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/identifiers.md#uids
     */
    @XmlElement(name="uid", required = true, type = String.class)
    private String uid;

    /**
     * if true, this reference points to the managing controller.
     */
    @XmlElement(name="controller", required = false, type = boolean.class, defaultValue = "false")
    private boolean controller;
    

}
