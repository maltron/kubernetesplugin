package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Probe describes a health check to be performed against a container to 
 * determine whether it is alive or ready to receive traffic.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "probe")
@XmlAccessorType(XmlAccessType.FIELD)
public class Probe implements Serializable {

    /**
     * One and only one of the following should be specified. 
     * Exec specifies the action to take
     */
    @XmlElement(name="exec", required = false, type = ExecAction.class)
    private ExecAction exec;

    /**
     * TTPGet specifies the http request to perform.
     */
    @XmlElement(name="httpGet", required = false, type = HTTPGetAction.class)
    private HTTPGetAction httpGet;

    /**
     * TCPSocket specifies an action involving a TCP port. 
     * TCP hooks not yet supported
     */
    @XmlElement(name="tcpSocket", required = false, type = TCPSocketAction.class)
    private TCPSocketAction tcpSocket;

    /**
     * Number of seconds after the container has started before liveness probes 
     * are initiated. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/pod-states.md#container-probes
     */
    @XmlElement(name="initialDelaySeconds", required = false, type = int.class)
    private int initialDelaySeconds;

    /**
     * Number of seconds after which the probe times out. 
     * Defaults to 1 second. Minimum value is 1. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/pod-states.md#container-probes
     */
    @XmlElement(name="timeoutSeconds", required = false, type = int.class)
    private int timeoutSeconds;

    /**
     * How often (in seconds) to perform the probe. 
     * Default to 10 seconds. Minimum value is 1.
     */
    @XmlElement(name="periodSeconds", required = false, type = int.class)
    private int periodSeconds;

    /**
     * Minimum consecutive successes for the probe to be considered successful 
     * after having failed. Defaults to 1. Must be 1 for liveness. Minimum value is 1.
     */
    @XmlElement(name="successThreshold", required = false, type = int.class)
    private int successThreshold;

    /**
     * Minimum consecutive failures for the probe to be considered failed 
     * after having succeeded. Defaults to 3. Minimum value is 1.
     */
    @XmlElement(name="failureThreshold", required = false, type = int.class)
    private int failureThreshold;
}

