
import java.io.IOException;
import net.nortlam.openshift.resource.Event;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.LogOutputStream;
import org.apache.commons.exec.PumpStreamHandler;

public class Test2 {
    
    public static final String COMMAND = "/home/mauricio/java/tools/openshift/client/oc get events";
    
    public static void main(String[] args) {
        CommandLine commandLine = CommandLine.parse(COMMAND);
        DefaultExecutor executor = new DefaultExecutor();
        
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PumpStreamHandler streamHandler = new PumpStreamHandler(new LogOutputStream() {
            @Override
            protected void processLine(String line, int level) {
                System.out.printf(">>> processLine(): Level:%d Line:%s\n", level, line);
//                Event event = Event.parse(line);
            }
            
        });
        executor.setStreamHandler(streamHandler);
        
        try {
            DefaultExecuteResultHandler resultsHandler = new DefaultExecuteResultHandler();
            executor.execute(commandLine, resultsHandler);
            
            if(resultsHandler.hasResult()) {
                System.out.printf(">>> RESULTS\n");
            } else {
                System.err.printf("### NO RESULTS\n");
            }
            
        } catch(ExecuteException ex) {
            System.err.printf("### EXECUTE EXCEPTION: %s\n", ex.getMessage());
        } catch(IOException ex) {
            System.err.printf("### IO EXCEPTION: %s\n", ex.getMessage());
        }
        
        
    }
    
}
