import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class StringToFile {
    public static void main(String[] args) {
        FileOutputStream tofile = null;
        String a="WriteToFileTest";
        String b="\r\n";
        a+=b;
        try {
            tofile = new FileOutputStream(new File("C:\\Workspace\\test.java"));
            int i=0;
            for(;i<3;i++){
                tofile.write(a.getBytes(StandardCharsets.UTF_8));
            }
            tofile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

