package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * HTTPGetAction describes an action based on HTTP Get requests.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "httpgetaction")
@XmlAccessorType(XmlAccessType.FIELD)
public class HTTPGetAction implements Serializable {

    /**
     * Path to access on the HTTP server.
     */
    @XmlElement(name="path", required = false, type = String.class)
    private String path;

    /**
     * Name or number of the port to access on the container. 
     * Number must be in the range 1 to 65535. Name must be an IANA_SVC_NAME.
     */
    @XmlElement(name="port", required = true, type = String.class)
    private String port;

    /**
     * Host name to connect to, defaults to the pod IP. 
     * You probably want to set "Host" in httpHeaders instead.
     */
    @XmlElement(name="host", required = false, type = String.class)
    private String host;

    /**
     * Scheme to use for connecting to the host. Defaults to HTTP.
     */
    @XmlElement(name="scheme", required = false, type = String.class)
    private String scheme;

    /**
     * Custom headers to set in the request. HTTP allows repeated headers.
     */
    @XmlElement(name="httpHeaders", required = false, type = HTTPHeader[].class)
    private HTTPHeader httpHeaders;
}