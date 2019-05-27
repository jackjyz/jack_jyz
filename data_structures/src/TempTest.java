public class TempTest {

    private void test1(Integer a) {
        a = 130;
        System.out.println("test1的值为" + a);
    }

    public static void main(String[] args) {
        TempTest t = new TempTest();
        Integer a = 177;
        Integer b = 177;
        Integer c = 112;
        Integer d = 112;
        System.out.println("均大于127"+(a==b));
        System.out.println("一大一小"+(a==c));
        System.out.println("俩小"+(c==d));
        System.out.println("值传递前的a值"+c);
        t.test1(c);
        System.out.println("值传递后的a值" + c);
    }
}
