
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TestSimpleDateFormat {
    
    public static void main(String[] args) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        System.out.printf(">>> ORIGINAL: 2016-10-25T23:18:34Z\n");
        System.out.printf(">>> FORMATED: %s\n", dateFormat.format(Calendar.getInstance().getTime()));
    }
    
}
