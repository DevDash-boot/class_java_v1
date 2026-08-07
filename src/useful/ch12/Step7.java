package useful.ch12;

public class Step7 {
    public static void main(String[] args) {
        int sum = 0;

        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= 100_000_000; i++) {
            sum += i;
        }
        long endTime = System.currentTimeMillis();

        long time = endTime - startTime;

        System.out.println("몇 밀리초 걸릴까? : " + time + "ms");
    }
}
