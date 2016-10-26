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
 * Represents a volume that is populated with the contents of a git repository. 
 * Git repo volumes do not support ownership management. Git repo volumes 
 * support SELinux relabeling.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
@XmlRootElement(name = "gitRepo")
@XmlAccessorType(XmlAccessType.FIELD)
public class GitRepoVolumeSource implements Serializable {
    
    /**
     * Repository URL
     */
    @XmlElement(name="repository", required = true, type = String.class)
    private String repository;
    
    /**
     * Commit hash for the specified revision
     */
    @XmlElement(name="revision", required = false, type = String.class)
    private String revision;
    
    /**
     * Target directory name. Must not contain or start with ... 
     * If . is supplied, the volume directory will be the git repository. 
     * Otherwise, if specified, the volume will contain the git repository 
     * in the subdirectory with the given name.
     */
    @XmlElement(name="directory", required = false, type = String.class)
    private String directory;
}
