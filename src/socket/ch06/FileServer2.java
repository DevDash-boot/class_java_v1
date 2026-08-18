package socket.ch06;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer2 {

    private static final int PORT = 5000;
    private static final String UPLOAD_DIR = "uploads";

    // 서버 - 클라이언트 약속(프로토콜)
    // [1 바이트] 파일 이름의 길이
    // [N 바이트] 파일 이름
    // [나머지] 파일 내용 (클라이언트가 출력 방향을 닫으면 끝)

    public static void main(String[] args) {
        // File 객체 = 경로가 적힌 쪽지 일 뿐, 실제 폴더나 파일이 아니다.
        // 아래 한 줄로는 uploads 폴더가 만들어지지 않는다.
        // 그냥 uploads라는 경로를 가리키는 객체가 메모리에 하나 생겼을 뿐이다.
        File dir = new File(UPLOAD_DIR);

        // false일 때 실행
        if (!dir.exists()) {
            // mkdirs() 를 호출하는 순간 실제 폴더를 만들 수 있다.
            // mkdir() 과 달리 중간 경로까지 한 번에 만들어준다.
            boolean creadted = dir.mkdirs();
            System.out.println("업로드 폴더 생성 : " + creadted);
        }

        System.out.println("파일 서버 시작 - 포트 : " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            Socket socket = serverSocket.accept();  // 연결될 떄까지 블로킹
            System.out.println("클라이언트 연결 됨 : " + socket.getInetAddress().getHostAddress());

            // 소켓에 연결된 입출력 스트림 준비
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();

            //-------------------------------------------------
            // 1단계 : 파일 이름의 길이 읽기 (1바이트)
            //-------------------------------------------------

            // byte가 아니라 int로 돌려주는 이유
            // byte는 -128 ~ +127까지라 끝(-1)을 표현할 자리가 없다.
            // 그래서 int는 0 ~ 255까지라 데이터를 구분해서 -1이 들어오면 끝 신호로 구분해서 쓴다(read())
            int nameLength = in.read();

            // 방어적 코드
            // 이 검사를 빼면 new byte[-1]이 되어 오류가 발생한다.
            if (nameLength == -1) {
                System.out.println("클라이언트가 아무것도 보내지 않고 종료했습니다.");
                return;
            }
            System.out.println("파일의 이름 길이 : " + nameLength + " 바이트로 들어온다고 확인 됨");

            //-------------------------------------------------
            // 2단계 : 파일 이름을 정확하게 nameLength만큼 읽기
            //-------------------------------------------------
            byte[] nameBuffer = new byte[nameLength];
            int nameRead = 0; // 지금까지 읽어서 채운 바이트 수

            // while 문 : 바이트 길이만큼만 받는 코드
            // read(값을 담을 배열, 시작 위치, 최대 개수)는 요청한 만큼 반드시 읽어 준다는 보장이 없다.
            // 네트워크 사정에 따라 총 30바이트를 받는다고 가정하면 첫 번째에 3바이트만 올 수도 있다.
            while (nameRead < nameLength) {
                int count = in.read(nameBuffer, nameRead, nameLength - nameRead);
                if (count == -1) {
                    throw new IOException("파일 이름을 받는 중에 연결이 끊겼습니다.");
                }
                // 받은 만큼 커서를 앞으로 민다. 이 줄이 없으면 무한 루프가 된다.
                nameRead += count;
            }
            // 예) a.zip을 받는 경우 --> [5][a][.][z][i][p][.... 파일 내용]
            String fileName = new String(nameBuffer);   // 바이트 단위를 문자열로 변환
            // 방어적 코드 : 악의적인 클라이언트가 "../../비밀.txt" 와 같은 이름을 보내면
            if (fileName.contains("..") || fileName.contains("/") || fileName.contains("\\")) {
                System.out.println("허용되지 않은 파일 이름입니다. : " + fileName);
                return;
            }
            System.out.println("수신할 파일 이름 : " + fileName);

            //-------------------------------------------------
            // 3단계 : 파일 내용을 받아서 서버 측 컴퓨터 디스크에 저장
            //-------------------------------------------------

            // 여기서도 아직 파일은 만들어지지 않았다. 경로를 가리키는 객체일 뿐이다.
            File target = new File(dir, fileName);
            // FileOutputStream 생성자가 실행되는 순간 디스크가 실제 파일이 생긴다.(있으면 내용이 지워지고 새로 시작)
            // 덮어쓰는게 아니라 새로 생성하기 위한 것이기 때문에 append는 사용하지 않는다.
            FileOutputStream fos = new FileOutputStream(target);

            byte[] buffer = new byte[4096]; // 4KB 운영체제가 디스크를 다루는 단위와 맞춘 크기
            int bytesRead;
            long total = 0;

            // 클라이언트가 shutdownOutput()을 호출하면 (클라이언트가 소켓 close() 전에 -1 을 보낼 수 있다.)
            // 그 신호가 도착해서 read()가 -1을 반환한다.
            while ((bytesRead = in.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
                total += bytesRead;
            }
            System.out.println("저장 완료 : " + target.getPath() + " 총 " + total + " 바이트");

            //-------------------------------------------------
            // 4단계 : 완료 응답 전송
            //-------------------------------------------------

            // 클라이언트 출력 방향만 닫은 상태이며 입력 방향은 살아 있으므르 서버가 보낸 응답을 정상적으로 받을 수 있다.
            out.write(("업로드 성공 : " + fileName).getBytes());
            out.flush();    // 통로에 남은 데이터를 다 밀어낸다.

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

