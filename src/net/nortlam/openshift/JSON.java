package net.nortlam.openshift;


import javax.json.JsonObject;

/**
 *
 * @author mauricio
 */
public interface JSON {
    
    public static final String DATE_FORMAT = "2016-10-25T23:18:34Z";
    
    public JsonObject toJson();
    
}
