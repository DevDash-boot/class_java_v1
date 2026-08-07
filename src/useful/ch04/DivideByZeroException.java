package useful.ch04;

// 사용자 정의 예외 클래스 만들기
public class DivideByZeroException extends RuntimeException{
    private String msg;

    public DivideByZeroException(String msg) {
        // RuntimeException 생성자에 내가 작성한 메시지를 넣을 수 있도록 설계
        // e.getMessage()에 정의한 메시지가 출력
        super(msg);
        this.msg = msg;
    }
}
