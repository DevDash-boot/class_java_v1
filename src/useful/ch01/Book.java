package useful.ch01;

// import java.lang.String;
// import java.lang.*; 자동으로 가지고오기 때문에 직접 명시할 필요가 없다.

// Object 클래스는 모든 클래스의 최상위 클래스이다.
// extends Object를 선언하지 않아도 자동으로 생성된다.
public class Book {

    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "[ " + title + ", " + author + " ]";
    }

    public static void main(String[] args) {
        Book book1 = new Book("데미안", "헤르만헤세");
        Book book2 = book1;
        Book book3 = new Book("데미안", "헤르만헤세");

        System.out.println(book1 == book2); // true
        System.out.println(book1 == book3); // false(주소값이 다르기 때문)
        // equals 의 기본 동작은 == 이다.
        // 재정의할 때 equals를 많이 쓴다.
        System.out.println(book1.equals(book2));  // true
        System.out.println(book1.equals(book3));  // false(주소값이 다르기 때문)

        System.out.println(book1);

        System.out.println("-------------");
        System.out.println("로깅 1 - 책의 제목: " + book1.title);

        // 논리적으로 같은 객체라고 판별하고 싶을 때 equals() 메서드를 재정의해서 활용할 수 있다.
        // 단, equals() 메서드를 재정의할 때 해시코드도 함께 재정의해야 한다.

        System.out.println(book1.hashCode());

    }
}
