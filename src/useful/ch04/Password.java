package useful.ch04;

public class Password {
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password == null){
            throw new PasswordException("비밀번호는 null일 수 없습니다.");
        } else if (password.length() < 4){
            throw new PasswordException("비밀번호는 4글자 이상이어야 합니다.");
        }
        this.password = password;
    }

    public static void main(String[] args) {
        Password password = new Password();

        try{
            // password.setPassword(null);
            // password.setPassword("123");
            password.setPassword("1234");
        }catch (PasswordException e){
            System.out.println(e.getMessage());
        }
        System.out.println("비정상 종료 안됨");

    }
}

// 1. 사용자 정의 예외 클래스 설계
// 2. messsage를 받아서 출력할 수 있도록 설계
// 3. setPassword에 오류 안내 메세지를 예외 클래스로 활용
// 4. 예외 클래스 이름은 PasswordException으로 설계
class PasswordException extends RuntimeException{
    private String msg;

    public PasswordException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
