import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileUtils {
    /**
     * read all the content into buffer
     * @param buffer
     * @param filePath 
     * @throws IOException 
     */
    public static void readToBuffer(StringBuffer buffer, String filePath) throws IOException {
        InputStream is = new FileInputStream(filePath);
        String line; // Save every line's content
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        line = reader.readLine(); // Read the first line
        while (line != null) { // Finish if line is null
            buffer.append(line); // add content into buffer
            buffer.append("\n"); // switch line
            line = reader.readLine(); // read next line
        }
        reader.close();
        is.close();
    }

    public static String readFile(String filePath) throws IOException {
        StringBuffer sb = new StringBuffer();
        FileUtils.readToBuffer(sb, filePath);
        return sb.toString();
    }
}