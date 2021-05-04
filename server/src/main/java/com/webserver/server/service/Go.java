import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Go {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Process compile;
        Process run;
        int runnable=0;

        try {
            //compile Go
            compile = Runtime.getRuntime().exec("go build -o C:\\Users\\Gen_ji\\Desktop\\OC\\Go C:\\Users\\Gen_ji\\Desktop\\OC\\main.go");
            //用输入输出流来截取结果
            BufferedReader err = new BufferedReader(new InputStreamReader(compile.getErrorStream()));

            String errl = null;
            if ( err.read()!= 0)
                runnable = 1;
            while ((errl = err.readLine()) != null) {
                System.out.println(errl);
            }
            err.close();
            compile.waitFor();

            //run Go
            //runnable =1;
            if (runnable != 0){
                run = Runtime.getRuntime().exec("go run C:\\Users\\Gen_ji\\Desktop\\OC\\main.go");
                BufferedReader res = new BufferedReader(new InputStreamReader(run.getInputStream()));
                String resl = null;
                while ((resl = res.readLine()) != null)
                    System.out.println(resl);
                res.close();
                run.waitFor();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        File fil = new File("C:\\Users\\Gen_ji\\Desktop\\OC\\Go");
        boolean exist = fil.exists();
        if(exist) {
            fil.delete();
            exist=false;
        }
        if(!exist)
            System.out.println("Delete Done");
    }
}
