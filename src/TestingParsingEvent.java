
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import net.nortlam.openshift.resource.Event;

/**
 *
 * @author mauricio
 */
public class TestingParsingEvent {
    
    public static final String CONTENT = "2m         2m          1         wordpress-2-deploy   Pod                                     Normal    Scheduled    {default-scheduler }              Successfully assigned wordpress-2-deploy to openshift.example.com";
    
    public static void main(String[] args) {
        Event event = Event.parse(CONTENT);
        System.out.printf(">>> EVENT: %s\n", event.toString());
        
    }
    
}
