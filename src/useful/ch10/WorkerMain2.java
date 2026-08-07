package useful.ch10;

public class WorkerMain2 {
    public static void main(String[] args) {

        System.out.println("===== Main 쓰레드 시작 =====");

        Worker2 worker2 = new Worker2();
        // 스레드를 동작 시키려면 무조건 Thread의 start()메서드를 호출해야한다.
        // worker2.start(); <-- start()가 없는 상태

        // Thread t = new Thread(worker2);
        // t.start();
        new Thread(worker2).start();

        System.out.println("===== Main 쓰레드 종료 =====");
    }
}
