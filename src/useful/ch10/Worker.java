package useful.ch10;

// 1. 스레드를 추가로 만들어서 사용하는 방법 첫 번째 - 상속 활용
public class Worker extends Thread {

    String name;

    public Worker(String name) {
        this.name = name;
    }

    // 약속되어 있는 부분 run() 추상메서드 안에서 작업자(스레드)에게
    // 어떤 일을 시킬 지 정의해 주어야 한다.

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("worker : " + name + " : " + i);

            // 스레드를 잠들게 하는 코드
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
