import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        test(a);
        System.out.println(a.size());
    }

    public static void test(List<String> a) {
        a = new ArrayList<String>();
        a.add("色粉色");
    }
}