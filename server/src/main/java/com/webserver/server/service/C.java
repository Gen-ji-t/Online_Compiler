import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Process compile;
        Process run;
        int runnable=0;

        try {
            //compile c
            compile = Runtime.getRuntime().exec("gcc -o C:\\Users\\Gen_ji\\Desktop\\OC\\c.exe C:\\Users\\Gen_ji\\Desktop\\OC\\c.c");
            //用输入输出流来截取结果
            BufferedReader err = new BufferedReader(new InputStreamReader(compile.getErrorStream()));

            String errl = null;
            errl = err.readLine();
            if (errl == null)
                runnable = 1;
            while ((errl = err.readLine()) != null) {
                System.out.println(errl);
            }
            err.close();
            compile.waitFor();

            //run c
            if (runnable == 1){
                run = Runtime.getRuntime().exec("C:\\Users\\Gen_ji\\Desktop\\OC\\c.exe");
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

        File fil = new File("C:\\Users\\Gen_ji\\Desktop\\OC\\c.exe");
        boolean exist = fil.exists();
        if(exist) {
            fil.delete();
            exist=false;
        }
        if(!exist)
            System.out.println("delete Done");
    }


}
