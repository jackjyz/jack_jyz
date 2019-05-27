public class ThreadTest extends Thread{

    private int i;


    @Override
    public void run() {
        for (;i<100;i++){
            System.out.println(getName()+"-"+i);
        }
    }
    public static void main(String[] args){
        ThreadTest threadTest = new ThreadTest();
        threadTest.setName("s1");
        threadTest.start();
        new ThreadTest().start();
    }
}
