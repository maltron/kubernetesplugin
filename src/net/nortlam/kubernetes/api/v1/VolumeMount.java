package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * VolumeMount describes a mounting of a Volume within a container.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "volumemount")
@XmlAccessorType(XmlAccessType.FIELD)
public class VolumeMount implements Serializable {

    /**
     * This must match the Name of a Volume.
     */
    @XmlElement(name="name", required = true, type = String.class)
    private String name;

    /**
     * Mounted read-only if true, read-write otherwise (false or unspecified). 
     * Defaults to false.
     */
    @XmlElement(name="readOnly", required = false, type = boolean.class, defaultValue = "false")
    private boolean readOnly;

    /**
     * Path within the container at which the volume should be mounted. 
     * Must not contain :.
     */
    @XmlElement(name="mountPath", required = true, type = String.class)
    private String mountPath;

    /**
     * Path within the volume from which the container’s volume should be 
     * mounted. Defaults to "" (volume’s root).
     */
    @XmlElement(name="subPath", required = false, type = String.class)
    private String subPath;
}
