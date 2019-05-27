public class StringTest {
    public static void main(String[] args) {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        //    在编译期间对S6进行了优化
        //    StringBuffer temp = new StringBuffer();
        //    temp.append(s3).append(s4);
        //    String s = temp.toString();
        //    所以在进行比较时(s1==s6)为false;
        String s6 = s3 + s4;
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s5);
        System.out.println(s6);
        System.out.println(s1 == s2);               //false
        //s1和s5是指向同一个对象
        System.out.println(s1 == s5);               //true
        System.out.println(s1 == s6);               //false
        System.out.println(s1 == s6.intern());      //true
        System.out.println("s1.equals(s6)"+s1.equals(s6));
        System.out.println(s2 == s2.intern());      //false
    }
}
