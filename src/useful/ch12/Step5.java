package useful.ch12;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Step5 {
    public static void main(String[] args) {
        // LocalDateTime.now()를 사용하면 실행할 때마다 시간이 달라진다.
        LocalDateTime now = LocalDateTime.of(2026, 8, 7, 10, 17);
        System.out.println(now);    // 2026-08-07T10:17 T는 time의 약자로 시간을 의미

        // 원하는 형식으로 포멧을 지정할 필요가 있다.
        // 날짜 형식
        DateTimeFormatter korean = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
        System.out.println(now.format(korean));

        // 시간 형식
        DateTimeFormatter clock = DateTimeFormatter.ofPattern("a hh시 mm분", Locale.KOREAN);
        System.out.println(now.format(clock));

        // 날짜 + 시간 형식
        DateTimeFormatter log = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(now.format(log));
    }
}
