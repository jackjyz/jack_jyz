import org.omg.IOP.Encoding;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReadFromProcess {
    public static void main(String[] args) throws Exception {
        Process p=Runtime.getRuntime().exec("javac");
        try(
                BufferedReader br= new BufferedReader(new InputStreamReader(p.getErrorStream()))){
                String buff=null;
                while((buff = br.readLine())!=null){
                        System.out.println(buff);
                    }
                }

    }
}
