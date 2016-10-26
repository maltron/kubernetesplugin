package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import java.time.Instant;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * ContainerStateTerminated is a terminated state of a container.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "containerstateterminated")
@XmlAccessorType(XmlAccessType.FIELD)
public class ContainerStateTerminated implements Serializable {

    /**
     * Exit status from the last termination of the container
     */
    @XmlElement(name="exitCode", required = true, type = int.class)
    private int exitCode;

    /**
     * Signal from the last termination of the container
     */
    @XmlElement(name="signal", required = false, type = int.class)
    private int signal;

    /**
     * (brief) reason from the last termination of the container
     */
    @XmlElement(name="reason", required = false, type = String.class)
    private String reason;

    /**
     * Message regarding the last termination of the container
     */
    @XmlElement(name="message", required = false, type = String.class)
    private String message;

    /**
     * Time at which previous execution of the container started
     */
    @XmlElement(name="startedAt", required = false, type = Instant.class)
    private Instant startedAt;

    /**
     * Time at which the container last terminated
     */
    @XmlElement(name="finishedAt", required = false, type = Instant.class)
    private Instant finishedAt;

    /**
     * Container’s ID in the format docker://<container_id>
     */
    @XmlElement(name="containerID", required = false, type = String.class)
    private String containerID;
}
