import java.io.FileWriter;
import java.io.IOException;

public class SecurityLogger {

    public static void log(String event) {

        try {

            FileWriter fw =
                    new FileWriter("security.log",true);

            fw.write(event + "\n");

            fw.close();

        } catch(IOException e) {

            System.out.println(e.getMessage());
        }
    }
}

