package useful.ch10;

// 2. 스레드를 사용하는 방법 2번째 - Runnable 인터페이스를 구현해서 만들 수 있음
public class Worker2 implements Runnable {

    // run() - 위임시키고자 하는 일을 명시하는 곳(미리 약속 되어 있음)
    @Override
    public void run() {
        int i;
        for (i = 0; i < 20; i++) {
            System.out.print(i + "\t");

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
