package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * SecretKeySelector selects a key of a Secret.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "secretkeyselector")
@XmlAccessorType(XmlAccessType.FIELD)
public class SecretKeySelector implements Serializable {

    /**
     * Name of the referent. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/identifiers.md#names
     */
    @XmlElement(name="name", required = false, type = String.class)
    private String name;

    /**
     * The key of the secret to select from. Must be a valid secret key.
     */
    @XmlElement(name="key", required = true, type = String.class)
    private String key;
}
