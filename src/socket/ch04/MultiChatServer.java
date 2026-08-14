package socket.ch04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class MultiChatServer {

    private static final int PORT = 5002;
    // Vector 는 멀티스레드 환경해서 안전한 동적을 한다 (why)
    private static Vector<PrintWriter> clientWriterList = new Vector<>();

    // 내부 클래스 선언 및 스레드 상속
    private static class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        // run() 메서드가 Thread().start() 시 일하는 약속되어 있는 메서드이다.
        @Override
        public void run() {
            try {
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                // 추후 브로드 캐스트(접속자들에에 방송하기 위해서 생성된 출력 스트림을 자료구조 저장)
                clientWriterList.add(out);
                String message;
                while ( (message = in.readLine()) != null ) {
                    System.out.println("수신 : " + message);
                    // A, B, C
                    // 받은 메세지를 현재 연결된 모든 클라이언트에게 전송(브로드 캐스트)
                    broadcast(message);
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                // 클라이언트 강제 종료 및 우리만의 프로토콜 exit 값이 넘어 오면
                // 서버측에서 관리하고 있는 자료구조에서 출력 스트림을 제거 해야 한다.
                clientWriterList.remove(out); // 출력 스트림 제거
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

        private void broadcast(String msg) {
            for (PrintWriter w : clientWriterList) {
                // 자료구조에 저장된 출력스트림을 전체 꺼내서 하나씩 메시지 전송
                w.println(msg);
            }
        }
    } // end of inner class

    public static void main(String[] args) {
        System.out.println("---- 서버 시작 ---- ");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = serverSocket.accept();
                // 클라이언트가 연결되면 새로운 객체를 생성하고 연결된 소켓 객체 주소값을 해당 클래스 필드에 할당 한다.
                new ClientHandler(socket).start();
                System.out.println("클라이언트 접속, 현재 족속자 " + clientWriterList.size() + "명" );
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
