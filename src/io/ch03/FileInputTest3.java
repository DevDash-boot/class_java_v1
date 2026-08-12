package io.ch03;

import java.io.FileInputStream;

public class FileInputTest3 {

    public static void main(String[] args) {
        // in.read(byte[] b)를 사용해서 코드 완성
        // 데이터를 담을 그릇이 필요
        // 크기 10 - 한 번에 최대 10 바이트까지 읽어 오겠다고 설정
        byte[] buffer = new byte[255];

        // read(byte[]) 는 읽은 바이트 수를 반환
        // read()가 바이트 값 자체를 돌려주는 것과는 다름
        int readCount;

        try(FileInputStream in = new FileInputStream("assets/a.txt")){
            // [a][b][c][d][e][]
            // [a][b][c]
            // [d][e][c]  <-- c가 덮어쓰기 되어짐
            while((readCount = in.read(buffer)) != -1){
                for(int i=0; i< readCount;i++){
                    System.out.print((char)buffer[i]);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        // close() 자동 호출됨
    }
}
