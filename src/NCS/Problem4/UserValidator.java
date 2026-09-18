package NCS.Problem4;

/*
[과제 상황]
회원가입과 로그인 등 여러 기능에서 중복으로 사용되는 ‘데이터 검증 로직’을 순수 자바 프로젝트로 구현하여 제출하십시오.

[수행 요구사항]

클래스 설계: UserValidator라는 공통 클래스를 생성하고, 아이디와 비밀번호를 검증하는 메소드를 작성하십시오.
구조 설계: 각 검증 로직은 독립된 메소드로 구성하며, 입력값(String)과 출력값(결과 코드)을 명확히 정의하십시오.
설계 원칙: 타 클래스의 변수를 직접 수정하지 않고, 전달받은 파라미터만 처리하는 낮은 결합도 방식을 취하십시오.
기능 코드: 성공(0), 길이 미달(1), 형식 불일치(2) 등 결과를 구분할 수 있는 상수(static final)를 설계에 포함하십시오.
* */

public class UserValidator {
    // 기능 코드
    private static final int SUCCESS = 0;
    private static final int LENGTH_SHORT = 1;
    private static final int FORMAT_MISMATCH = 2;

    // 클래스 설계
    // 아이디 : 영문 대소문자, 숫자만 허용
    private static String idForm = "^[a-zA-Z0-9]+$";
    // 비밀번호 : 영문 대소문자, 숫자만 허용하며, 소문자와 숫자는 각각 최소 1개 이상 필요
    private static String pwForm = "^(?=.*[a-z])(?=.*[0-9])[a-zA-Z0-9]+$";

    // 아이디 검증
    public static String vId(String id) {
        // 아이디가 빈칸일 때
        /* [trim().isEmpty() 사용 이유]
         * equals()는 ""만 찾는다.
         * isEmpty()의 경우 "" 은 true, " "은 false를 반환한다.
         * trim().isEmpty()는 ""은 true, " "도 true를 반환한다.
         * isBlank()도 공백 체크를 하기 때문에 ""은 true, " "도 true를 반환한다.
         * */

        if (id == null || id.trim().isEmpty()) {
            System.out.println("[형식 오류] 아이디는 빈칸일 수 없습니다.");
            return "아이디 : 형식 불일치(" + FORMAT_MISMATCH + ")"; // 2 출력
        }
        // 아이디의 형식이 안맞을 때. 영문 대소문자, 숫자만 허용
        else if (!id.matches(idForm)) {
            System.out.println("[형식 오류] 영문 대소문자, 숫자만 입력할 수 있습니다.");
            return "아이디 : 형식 불일치(" + FORMAT_MISMATCH + ")"; // 2 출력
        }
        // 아이디의 길이가 짧을 때
        else if (id.length() < 5) {
            System.out.println("[길이 오류] 아이디는 최소 5글자 이상입니다.");
            return "아이디 : 길이 미달(" + LENGTH_SHORT + ")";    // 1 출력
        }
        // 형식과 길이에 맞게 입력했을 경우
        return "아이디 : 성공(" + SUCCESS + ")"; // 0 출력
    }

    // 비밀번호 검증
    public static String vPw(String pw) {
        // 비밀번호가 없는 경우이거나 형식이 불일치 할 때(영문 소문자 1개이상, 숫자 1개이상, 대문자만 형식에 해당)
        if (pw == null || pw.trim().isEmpty()) {
            System.out.println("[형식 오류] 비밀번호는 빈칸일 수 없습니다.");
            return "비밀번호 : 형식 불일치(" + FORMAT_MISMATCH + ") "; // 2 출력
        } else if (!pw.matches(pwForm)) {
            System.out.println("[형식 오류] 영문 대소문자, 숫자만 입력할 수 있으며, 소문자와 숫자가 각각 최소 1개 이상이 필요합니다.");
            return "비밀번호 : 형식 불일치(" + FORMAT_MISMATCH + ")"; // 2 출력
        }
        // 비밀번호의 길이가 짧을 때
        else if (pw.length() < 7) {
            System.out.println("[길이 오류] 비밀번호는 최소 7글자 이상입니다.");
            return "비밀번호 : 길이 미달(" + LENGTH_SHORT + ")";    // 1 출력
        }
        // 형식과 길이에 맞게 입력했을 경우
        return "비밀번호 : 성공(" + SUCCESS + ")"; // 0 출력
    }

    // 코드 작동 테스트 메인
    public static void main(String[] args) {
        String id1 = "";        // 2
        String id2 = "123";     // 1
        String id3 = "12345";   // 0
        String id4 = "abc123";  // 0
        String id5 = "aBc123";  // 0

        String pw1 = "";            // 2
        String pw2 = "12345678";    // 2
        String pw3 = "abcdefg";     // 2
        String pw4 = "ABCD1234";    // 2
        String pw5 = "abcd1234";    // 0
        String pw6 = "Abcd1234";    // 0
        String pw7 = "Abcd1";       // 1

        System.out.println(vId(id1));
        System.out.println(vId(id2));
        System.out.println(vId(id3));
        System.out.println(vId(id4));
        System.out.println(vId(id5));

        System.out.println(vPw(pw1));
        System.out.println(vPw(pw2));
        System.out.println(vPw(pw3));
        System.out.println(vPw(pw4));
        System.out.println(vPw(pw5));
        System.out.println(vPw(pw6));
        System.out.println(vPw(pw7));
    }
}

