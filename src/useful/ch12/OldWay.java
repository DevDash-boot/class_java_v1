package useful.ch12;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class OldWay {
    public static void main(String[] args) {

        // Date - JDK 1 버전에 만들어진 클래스
        // 1. 현재 시간 출력
        Date now = new Date();
        System.out.println("현재 시각 : " + now);

        // 출력 형식부터 문제 - 영어 요일과 월 이름이 섞여 있어서 사용자 화면에 그대로 사용할 수 없음

        // 2. Date 로 특정 날짜 만들기
        Date date = new Date(2025, 4, 12);
        System.out.println("date로 설정한 날짜1 : " + date);
        // 3925년도로 결과가 확인됨
        // Date의 연도는 1900년을 기준으로 세기 때문에
        // 2025년을 만들려고 하면 125를 넣어야 한다.

        Date date2 = new Date(125, 4, 12);  // 2025.05.12
        System.out.println("date로 설정한 날짜2 : " + date2);
        // Date에서 month는 0부터 시작. 5월 달은 n-1이기 때문에 4를 넣어야 한다.
        // 위와 같은 문제점 때문에 JDK 1.1 버전부터 곧바로 Calendar 클래스를 만들어 줬다.

        System.out.println("----------------------------");

        Calendar cal = Calendar.getInstance();  // new 해서 객체 생성하는 개념과 같다
        // Singleton 패턴으로 구현되어 있어 static 메서드로 호출해야한다.
        cal.set(2025, 4, 12); // 2025.05.12
        System.out.println("cal로 설정한 날짜3 : " + cal.getTime());

        // 위 문제들을 해결하기 위해서 8 버전부터 java.time을 제공함
        LocalDate localDate = LocalDate.of(2025, 5, 12);  // 2025.05.12
        System.out.println("설정한 날짜4 : " + localDate);
    }
}