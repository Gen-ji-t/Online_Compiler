
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Python {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Process compile;
        try {
             compile= Runtime.getRuntime().exec("python C:\\Users\\Gen_ji\\Desktop\\OC\\python.py");// 执行py文件
            //用输入输出流来截取结果

            BufferedReader res = new BufferedReader(new InputStreamReader(compile.getInputStream()));
            BufferedReader err = new BufferedReader(new InputStreamReader(compile.getErrorStream()));


            String resl = null;
            String errl= null;
            while ((errl = err.readLine())!=null){
                System.out.println(errl);
            }
            err.close();
            while ((resl = res.readLine()) != null) {
                System.out.println(resl);
            }
            res.close();
            compile.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
