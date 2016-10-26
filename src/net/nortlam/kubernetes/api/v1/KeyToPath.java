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
 * Maps a string key to a path within a volume.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "items")
@XmlAccessorType(XmlAccessType.FIELD)
public class KeyToPath implements Serializable {

    /**
     * The key to project.
     */
    @XmlElement(name="key", required = true, type = String.class)
    private String key;

    /**
     * The relative path of the file to map the key to. 
     * May not be an absolute path. May not contain the path element ... 
     * May not start with the string ...
     */
    @XmlElement(name="path", required = true, type = String.class)
    private String path;

    /**
     * Optional: mode bits to use on this file, must be a value between 0 
     * and 0777. If not specified, the volume defaultMode will be used. 
     * This might be in conflict with other options that affect the file mode, 
     * like fsGroup, and the result can be other mode bits set.
     */
    @XmlElement(name="mode", required = false, type = int.class)
    private int mode;
}
