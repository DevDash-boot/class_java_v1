package http.ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

// 이 파일에서 HTTP 통신으로 접근할 서버 주소
// https://jsonplaceholder.typicode.com <-- 서버 주소
//                                     /todos/1 <-- 엔드 포인트
// 요청 완성 주소 : https://jsonplaceholder.typicode.com/todos/1
public class SimpleHttpClient {
    public static void main(String[] args) {
        String baseURL = "https://jsonplaceholder.typicode.com";
        String urlString = baseURL + "/todos/2";
        //String urlString = "https://www.kakaocorp.com/page/";
        HttpURLConnection connection = null;    // HTTP 통신을 위해 필요함

        try {
            // 1단계 : UTI로 파싱한 뒤 객체로 변환
            URI uri = URI.create(urlString);
            URL url = uri.toURL();

            // 2단계 : 연결 객체 생성(아직 연결되지 않음)
            connection = (HttpURLConnection) url.openConnection();  // 다운캐스팅 필요

            // 3단계 : 요청 방식 설정(Method 등 설정)
            connection.setRequestMethod("GET");
            // GET 요청은 HTTP 요청 메시지에서 HTTP 바디 영역이 없는 요청이다.
            // 추가 설정도 세팅할 수 있다.
            connection.setRequestProperty("Accept", "application/json");    // content-type 부분

            // 4단계 : 이 시점에서 실제로 TCP 연결 + 요청 전송이 발생
            int responseCode = connection.getResponseCode();
            System.out.println("응답 코드(HTTP 상태 코드) : " + responseCode);

            // 방어적 코드
            if(responseCode != 200){
                // 실패 응답의 본문은 getInputStream()이 아니라 getErrorStream()으로 읽어야 한다.
                System.out.println("요청 실패!");
                return;
            }

            // 5단계 : 응답 본문(HTTP 응답 메시지 바디 부분) 읽기
            // I/O 단원에서 배운 그대로 데이터를 추출 + 보조 스트림(버퍼 스트림 활용)
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder response = new StringBuilder();  // 단일 스레드에서는 StringBuilder 사용
                String line;

                while((line = reader.readLine())!=null){
                    response.append(line).append("\n"); // 두 번째 append는 한 줄 읽을 때마다 한 줄 띄움
                }
                System.out.println("[응답 내용]");
                System.out.println(response);
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            // 6단계 : 연결 종료
            // HttpURLConnection() : 예전에 만든 녀석이라 try-with-resources 를 사용할 수 없음
            // 문법적으로는 인터페이스 Closeable을 구현하지 않아서 사용할 수 없음
            if(connection != null){
                connection.disconnect();    // 연결 끊기
            }
        }
    }
}