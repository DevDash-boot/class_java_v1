package useful.ch12;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Step2 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.of(2026, 8, 7);
        LocalDateTime today1 = LocalDateTime.of(2026, 8, 7, 15, 2);

        // 100일 후 날짜 계산
        System.out.println("100일 후 : " + today.plusDays(100));
        // n달 후 계산
        System.out.println("다음 달 : " + today.plusMonths(1));
        // n년 전 계산
        System.out.println("1년 전 : " + today.minusYears(1));

        System.out.println("1시간 전 : " + today1.minusHours(1));
    }
}
