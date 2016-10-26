package net.nortlam.openshift.resource;

public enum Kind {
    UNKNOWN("Unknown"), POD("Pod"), DEPLOYMENT_CONFIG("DeploymentConfig"), 
    REPLICATION_CONTROLLER("ReplicationController");
    
    private String value;
    
    Kind(String value) {
        this.value = value;
    }
    
    public static Kind parse(String value) {
        if(value == null) throw new IllegalArgumentException("enum value cannot be null");
        
        Kind result = null;
        if(value.trim().equalsIgnoreCase(POD.toString()))
            result = POD;
        else if (value.trim().equalsIgnoreCase(DEPLOYMENT_CONFIG.toString()))
            result = DEPLOYMENT_CONFIG;
        else if(value.trim().equalsIgnoreCase(REPLICATION_CONTROLLER.toString()))
            result = REPLICATION_CONTROLLER;
        
        if(result == null)
            throw new IllegalArgumentException("No enum constant Kind."+value);
        
        return result;
    }
    
    @Override
    public String toString() {
        return value;
    }
}