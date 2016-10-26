package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * EnvVar represents an environment variable present in a Container.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "envvar")
@XmlAccessorType(XmlAccessType.FIELD)
public class EnvVar implements Serializable {

    /**
     * Name of the environment variable. Must be a C_IDENTIFIER.
     */
    @XmlElement(name="name", required = true, type = String.class)
    private String name;

    /**
     * Variable references $(VAR_NAME) are expanded using the previous defined 
     * environment variables in the container and any service environment 
     * variables. If a variable cannot be resolved, the reference in the 
     * input string will be unchanged. The $(VAR_NAME) syntax can be escaped 
     * with a double $$, ie: $$(VAR_NAME). Escaped references will never be 
     * expanded, regardless of whether the variable exists or not. 
     * Defaults to "".
     */
    @XmlElement(name="value", required = false, type = String.class)
    private String value;

    /**
     * Source for the environment variable’s value. Cannot be used if value 
     * is not empty.
     */
    @XmlElement(name="valueFrom", required = false, type = EnvVarSource.class)
    private EnvVarSource valueFrom;
}
