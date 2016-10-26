package net.nortlam.kubernetes.api.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;

/**
 * Volume represents a named volume in a pod that may be accessed by any 
 * container in the pod.
 * 
 * @author Mauricio "Maltron" Leal <maltron@gmail.com> */
public class Volume implements Serializable {

    /**
     * Volume’s name. Must be a DNS_LABEL and unique within the pod. 
     * 
     * More info: http://releases.k8s.io/release-1.4/docs/user-guide/identifiers.md#names
     */
    @XmlElement(name="name", required = true, type = String.class)
    private String name;

    /**
     * HostPath represents a pre-existing file or directory on the host machine that is directly exposed to the container. This is generally used for system agents or other privileged things that are allowed to see the host machine. Most containers will NOT need this. More info: http://releases.k8s.io/release-1.4/docs/user-guide/volumes.md#hostpath
     */
    @XmlElement(name="hostPath", required = false, type = HostPathVolumeSource.class)
    private HostPathVolumeSource hostPath;

    /**
     * EmptyDir represents a temporary directory that shares a pod’s lifetime. More info: http://releases.k8s.io/release-1.4/docs/user-guide/volumes.md#emptydir
     */
    @XmlElement(name="emptyDir", required = false, type = EmptyDirVolumeSource.class)
    private EmptyDirVolumeSource emptyDir;

    /**
     * GCEPersistentDisk represents a GCE Disk resource that is attached to a kubelet’s host machine and then exposed to the pod. More info: http://releases.k8s.io/release-1.4/docs/user-guide/volumes.md#gcepersistentdisk
     */
    @XmlElement(name="gcePersistentDisk", required = false, type = GCEPersistentDiskVolumeSource.class)
    private GCEPersistentDiskVolumeSource gcePersistentDisk;

    /**
     * AWSElasticBlockStore represents an AWS Disk resource that is attached to a kubelet’s host machine and then exposed to the pod. More info: http://releases.k8s.io/release-1.4/docs/user-guide/volumes.md#awselasticblockstore
     */
    @XmlElement(name="awsElasticBlockStore", required = false, type = AWSElasticBlockStoreVolumeSource.class)
    private AWSElasticBlockStoreVolumeSource awsElasticBlockStore;

    /**
     * GitRepo represents a git repository at a particular revision.
     */
    @XmlElement(name="gitRepo", required = false, type = GitRepoVolumeSource.class)
    private GitRepoVolumeSource gitRepo;

    /**
     * Secret represents a secret that should populate this volume. More info: http://releases.k8s.io/release-1.4/docs/user-guide/volumes.md#secrets
     */
    @XmlElement(name="secret", required = false, type = SecretVolumeSource.class)
    private SecretVolumeSource secret;

    /**
     * NFS represents an NFS mount on the host that shares a pod’s lifetime More info: http://releases.k8s.io/release-1.4/docs/user-guide/volumes.md#nfs
     */
    @XmlElement(name="nfs", required = false, type = NFSVolumeSource.class)
    private NFSVolumeSource nfs;

    /**
     * ISCSI represents an ISCSI Disk resource that is attached to a kubelet’s host machine and then exposed to the pod. More info: http://releases.k8s.io/release-1.4/examples/volumes/iscsi/README.md
     */
    @XmlElement(name="iscsi", required = false, type = ISCSIVolumeSource.class)
    private ISCSIVolumeSource iscsi;

    /**
     * Glusterfs represents a Glusterfs mount on the host that shares a pod’s lifetime. More info: http://releases.k8s.io/release-1.4/examples/volumes/glusterfs/README.md
     */
    @XmlElement(name="glusterfs", required = false, type = GlusterfsVolumeSource.class)
    private GlusterfsVolumeSource glusterfs;

    /**
     * PersistentVolumeClaimVolumeSource represents a reference to a PersistentVolumeClaim in the same namespace. More info: http://releases.k8s.io/release-1.4/docs/user-guide/persistent-volumes.md#persistentvolumeclaims
     */
    @XmlElement(name="persisteVolumeClaim", required = false, type = PersistentVolumeClaimVolumeSource.class)
    private PersistentVolumeClaimVolumeSource persisteVolumeClaim;

    /**
     * RBD represents a Rados Block Device mount on the host that shares a pod’s lifetime. More info: http://releases.k8s.io/release-1.4/examples/volumes/rbd/README.md
     */
    @XmlElement(name="rbd", required = false, type = RBDVolumeSource.class)
    private RBDVolumeSource rbd;

    /**
     * FlexVolume represents a generic volume resource that is provisioned/attached using an exec based plugin. This is an alpha feature and may change in future.
     */
    @XmlElement(name="flexVolume", required = false, type = FlexVolumeSource.class)
    private FlexVolumeSource flexVolume;

    /**
     * Cinder represents a cinder volume attached and mounted on kubelets host machine More info: http://releases.k8s.io/release-1.4/examples/mysql-cinder-pd/README.md
     */
    @XmlElement(name="cinder", required = false, type = CinderVolumeSource.class)
    private CinderVolumeSource cinder;

    /**
     * CephFS represents a Ceph FS mount on the host that shares a pod’s lifetime
     */
    @XmlElement(name="cephfs", required = false, type = CephFSVolumeSource.class)
    private CephFSVolumeSource cephfs;

    /**
     * Flocker represents a Flocker volume attached to a kubelet’s host machine. This depends on the Flocker control service being running
     */
    @XmlElement(name="flocker", required = false, type = FlockerVolumeSource.class)
    private FlockerVolumeSource flocker;

    /**
     * DownwardAPI represents downward API about the pod that should populate this volume
     */
    @XmlElement(name="downwardAPI", required = false, type = DownwardAPIVolumeSource.class)
    private DownwardAPIVolumeSource downwardAPI;

    /**
     * FC represents a Fibre Channel resource that is attached to a kubelet’s host machine and then exposed to the pod.
     */
    @XmlElement(name="fc", required = false, type = FCVolumeSource.class)
    private FCVolumeSource fc;

    /**
     * AzureFile represents an Azure File Service mount on the host and bind mount to the pod.
     */
    @XmlElement(name="azureFile", required = false, type = AzureFileVolumeSource.class)
    private AzureFileVolumeSource azureFile;

    /**
     * ConfigMap represents a configMap that should populate this volume
     */
    @XmlElement(name="configMap", required = false, type = ConfigMapVolumeSource.class)
    private ConfigMapVolumeSource configMap;

    /**
     * VsphereVolume represents a vSphere volume attached and mounted on kubelets host machine
     */
    @XmlElement(name="vsphereVolume", required = false, type = VsphereVirtualDiskVolumeSource.class)
    private VsphereVirtualDiskVolumeSource vsphereVolume;

    /**
     * Quobyte represents a Quobyte mount on the host that shares a pod’s lifetime
     */
    @XmlElement(name="quobyte", required = false, type = QuobyteVolumeSource.class)
    private QuobyteVolumeSource quobyte;

    /**
     * AzureDisk represents an Azure Data Disk mount on the host and bind mount to the pod
     */
    @XmlElement(name="azureDisk", required = false, type = AzureDiskVolumeSource.class)
    private AzureDiskVolumeSource azureDisk;
}