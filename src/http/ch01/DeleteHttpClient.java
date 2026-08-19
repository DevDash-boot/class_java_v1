package http.ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class DeleteHttpClient {
    // f-delete 브랜치 만들고 브랜치 이동해서 작업
    // 완료 후 main 이동해서 코드 병합

    public static void main(String[] args) {
        String baseURL = "https://jsonplaceholder.typicode.com";
        String urlString = baseURL + "/posts/1";

        HttpURLConnection connection = null;

        try {
            // 1단계 : URI로 파싱한 뒤 객체로 변환
            URI uri = URI.create(urlString);
            URL url = uri.toURL();

            // 2단계 : 연결 객체 생성
            connection = (HttpURLConnection) url.openConnection();

            // 3단계 : 요청 방식 설정
            connection.setRequestMethod("DELETE");
            connection.setRequestProperty("Accept", "application/json");

            // 4단계 : 이 시점에서 실제로 TCP 연결 + 요청 전송이 발생
            int responseCode = connection.getResponseCode();
            System.out.println("응답코드(HTTP 상태코드) : " + responseCode);

            // 방어적 코드
            if(responseCode!=200){
                System.out.println("요청 실패!");
                return;
            }

            // 5단계 : 응답 본문 읽기
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder response = new StringBuilder();
                String line;

                while((line = reader.readLine()) != null){
                    response.append(line).append("\n");
                }
                System.out.println("[응답내용]");
                System.out.println(response);
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            // 6단계 : 연결 종료
            if(connection !=null){
                connection.disconnect();
            }
        }
    }
}
