public class Recursion {

    public static int fn(int n){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return fn(n-1)+fn(n-2);
    }
    public static int addDigits(int num) {
        if(num<10){
            return num;
        }
        return addDigits(num/10+num%10);

    }

    /**
     * 执行方法
     * @param args
     */
    public static void main(String[] args) {
        String aa =null;
        long start;
        long end;
        start = System.currentTimeMillis();
        System.out.println(fn(10));
        end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
