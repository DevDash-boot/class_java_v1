package useful.ch12;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Step6 {
    public static void main(String[] args) {
        // 생일 요일 계산
        LocalDate birth = LocalDate.of(2000, 7, 19);
        System.out.println("생일 요일 : " + birth.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.KOREAN));

        // 기준 날짜 시점의 만 나이
        LocalDate today = LocalDate.of(2026, 8, 7);
        Period age = Period.between(birth, today);
        System.out.println("만 나이: " + age.getYears() + "세");

        // 태어난 지 총 며칠이 지났는지
        long hl = ChronoUnit.DAYS.between(birth, today);
        System.out.println("태어난 지 총 : " + hl + "일");

        // 기준 날짜부터 크리스마스까지 D-day
        LocalDate xmas = LocalDate.of(2026, 12, 25);
        long dday = ChronoUnit.DAYS.between(today, xmas);
        System.out.println("D-day : " + dday + "일");

        // 기준 시각을 2025년 05월 13일 오후 02시 30분 형식으로 출력
        LocalDateTime ldt = LocalDateTime.of(2025, 5, 13, 14, 30);
        DateTimeFormatter ldt1 = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 a hh:mm");
        System.out.println(ldt.format(ldt1));
    }
}
