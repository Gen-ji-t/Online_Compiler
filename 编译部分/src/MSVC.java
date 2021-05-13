import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MSVC {
    Process compile;
    Process run;
    int runnable=0;

         {
        //compile c
        compile = Runtime.getRuntime().exec("cl -o "+workdir+"c.exe "+workdir+"c.c");
        //用输入输出流来截取结果
        BufferedReader err = new BufferedReader(new InputStreamReader(compile.getErrorStream()));

        String errl = null;
        try {
            errl = err.readLine();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        if (errl == null)
            runnable = 1;
        while (true) {
            try {
                if (!((errl = err.readLine()) != null)) break;
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            System.out.println(errl);
            errl+="\r\n";
            toerr.write(errl.getBytes(StandardCharsets.UTF_8));
        }
        try {
            err.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        try {
            compile.waitFor();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }

        //run c
        if (runnable == 1){
            run = Runtime.getRuntime().exec(workdir+"c.exe");
            BufferedReader res = new BufferedReader(new InputStreamReader(run.getInputStream()));
            String resl = null;
            while (true) {
                try {
                    if (!((resl = res.readLine()) != null)) break;
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                System.out.println(resl);
                resl+="\r\n";
                tores.write(resl.getBytes(StandardCharsets.UTF_8));
            }
            try {
                res.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            try {
                run.waitFor();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }

}
