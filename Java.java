import java.io.*;

public class Java {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Process compile;
        Process run;
        int runnable=0;

        try {
            //compile c
            compile = Runtime.getRuntime().exec("javac C:\\Users\\Gen_ji\\Desktop\\OC\\java.java");
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
                run = Runtime.getRuntime().exec("java C:\\Users\\Gen_ji\\Desktop\\OC\\java.java");
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

        File fil = new File("C:\\Users\\Gen_ji\\Desktop\\OC\\java.class");
        boolean exist = fil.exists();
        if(exist) {
            fil.delete();
            exist=false;
        }
        if(!exist)
            System.out.println("Delete Done");
    }


}
