package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * ExecAction describes a "run in container" action.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "execaction")
@XmlAccessorType(XmlAccessType.FIELD)
public class ExecAction implements Serializable {

    /**
     * Command is the command line to execute inside the container, 
     * the working directory for the command is root (/) in the container’s 
     * filesystem. The command is simply exec’d, it is not run inside a shell, 
     * so traditional shell instructions ('', etc) won’t work. To use a shell, 
     * you need to explicitly call out to that shell. Exit status of 0 is 
     * treated as live/healthy and non-zero is unhealthy.
     */
    @XmlElement(name="command", required = false, type = String[].class)
    private String[] command;
}
