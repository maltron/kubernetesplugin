package net.nortlam.openshift.resource;

public enum Type {
    UNKNOWN("Unknown"), NORMAL("Normal"), WARNING("Warning");
    
    private String value;
    
    Type(String value) {
        this.value = value;
    }
    
    public static Type parse(String value) {
        if(value == null) throw new IllegalArgumentException("enum value cannot be null");
        
        Type result = null;
        if(value.trim().equalsIgnoreCase(NORMAL.toString()))
            result = NORMAL;
        else if (value.trim().equalsIgnoreCase(WARNING.toString()))
            result = WARNING;
        
        if(result == null)
            throw new IllegalArgumentException("No enum constant Type."+value);
        
        return result;
    }

    @Override
    public String toString() {
        return value;
    }
}
