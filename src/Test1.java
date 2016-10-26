
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.PumpStreamHandler;

/**
 *
 * @author mauricio
 */
public class Test1 {
    
    public static final String COMMAND = "/home/mauricio/java/tools/openshift/client/oc version";
    
    public static void main(String[] args) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PumpStreamHandler streamHandler = new PumpStreamHandler(output);
        DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler() {
            @Override
            public void onProcessFailed(ExecuteException e) {
                System.err.printf("### onProcessFailed()\n");
                e.printStackTrace();
            }

            @Override
            public void onProcessComplete(int exitValue) {
                System.out.printf(">>> onProcessComplete()\n");
            }
            
        };
        
        CommandLine commandLine = CommandLine.parse(COMMAND);
        DefaultExecutor executor = new DefaultExecutor();
        executor.setStreamHandler(streamHandler);
        try {
            System.out.printf(">>> EXECUTING\n");
            executor.execute(commandLine, resultHandler);
            
            if(resultHandler.hasResult()) {
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
