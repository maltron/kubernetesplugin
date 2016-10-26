package net.nortlam.openshift.resource;

/**
 *
 * @author mauricio
 */
public enum Reason {
    UNKNOWN("Unknown"), PULLED("Pulled"), CREATED("Created"), STARTED("Started"), PULLING("Pulling"),
    BACKOFF("BackOff"), FAILED_SYNC("FailedSync"), DEPLOYMENT_SCALED("DeploymentScaled"),
    SUCCESSFUL_DELETE("SuccessfulDelete"), SCHEDULED("Scheduled");
    
    private String value;
    
    Reason(String value) {
        this.value = value;
    }
    
    public static Reason parse(String value) {
        if(value == null) throw new IllegalArgumentException("enum value cannot be null");
        
        Reason result = null;
        if(value.trim().equalsIgnoreCase(PULLED.toString()))
            result = PULLED;
        else if (value.trim().equalsIgnoreCase(CREATED.toString()))
            result = CREATED;
        else if(value.trim().equalsIgnoreCase(STARTED.toString()))
            result = STARTED;
        else if(value.trim().equalsIgnoreCase(PULLING.toString()))
            result = PULLING;
        else if(value.trim().equalsIgnoreCase(BACKOFF.toString()))
            result = BACKOFF;
        else if(value.trim().equalsIgnoreCase(FAILED_SYNC.toString()))
            result = FAILED_SYNC;
        else if(value.trim().equalsIgnoreCase(DEPLOYMENT_SCALED.toString()))
            result = DEPLOYMENT_SCALED;
        else if(value.trim().equalsIgnoreCase(SUCCESSFUL_DELETE.toString()))
            result = SUCCESSFUL_DELETE;
        else if(value.trim().equalsIgnoreCase(SCHEDULED.toString()))
            result = SCHEDULED;
        
        if(result == null)
            throw new IllegalArgumentException("No enum constant Reason."+value);
        
        return result;
    }
    
    @Override
    public String toString() {
        return value;
    }
}
