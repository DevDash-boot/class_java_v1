package useful.ch01;

import java.util.Objects;

public class EBook {

    private int bookTypeId;
    private String title;
    private String author;

    public EBook(int bookTypeId, String title, String author) {
        this.bookTypeId = bookTypeId;
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "EBook[" + bookTypeId + ", " + title + ", " + author + "]";
    }

    // equals() 메서드의 재정의 목적은 필요하다면 논리적으로 같은 객체라고 판별하고 싶을 때
    @Override
    public boolean equals(Object obj) {
        // 1. 동일 참조 체크(같은 객체를 가리키는지)
        if (this == obj) {
            return true;
        }

        // 2. 타입 체크 - obj가 EBook과 같은 타입이면 true, 다르면 false
        if (!(obj instanceof EBook)) {
            return false;
        }

        // 3. 필드 비교(논리적 기준) - 만약 책 제목과 저자가 같다면 논리적으로 같은 책으로 판별하겠다.
        EBook other = (EBook) obj; // 다운캐스팅
        return this.bookTypeId == other.bookTypeId
                && Objects.equals(this.title, other.title)
                && Objects.equals(this.author, other.author);
    }

    // equals를 사용하면 hashcode도 필요하다.
    // 자료구조 해시맵에서 동등성 비교할 때 hashcode를 재정의하지 않으면 에러 발생
    // 같이 재정의 해야 의도한 대로 잘 동작한다.
    @Override
    public int hashCode() {
        return Objects.hash(bookTypeId, title, author); // 필드 기반 해시코드 생성
    }
}
