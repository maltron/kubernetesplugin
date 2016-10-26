package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * EnvVarSource represents a source for the value of an EnvVar.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "envvarsource")
@XmlAccessorType(XmlAccessType.FIELD)
public class EnvVarSource implements Serializable {

    /**
     * Selects a field of the pod: supports metadata.name, metadata.namespace, 
     * metadata.labels, metadata.annotations, spec.nodeName, 
     * spec.serviceAccountName, status.podIP.
     */
    @XmlElement(name="fieldRef", required = false, type = ObjectFieldSelector.class)
    private ObjectFieldSelector fieldRef;

    /**
     * Selects a resource of the container: only resources limits and requests 
     * (limits.cpu, limits.memory, requests.cpu and requests.memory) 
     * are currently supported.
     */
    @XmlElement(name="resourceRef", required = false, type = ResourceFieldSelector.class)
    private ResourceFieldSelector resourceRef;

    /**
     * Selects a key of a ConfigMap.
     */
    @XmlElement(name="configMapKeyRef", required = false, type = ConfigMapKeySelector.class)
    private ConfigMapKeySelector configMapKeyRef;

    /**
     * Selects a key of a secret in the pod’s namespace
     */
    @XmlElement(name="secretKeyRef", required = false, type = SecretKeySelector.class)
    private SecretKeySelector secretKeyRef;

}
