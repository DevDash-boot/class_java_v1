package useful.ch03;

public class StringTextBlock {
    public static void main(String[] args) {
        String str1 = "가나다라마바사\n" + "아자차카타파하\n" + "\tABCDEFG";
        System.out.println(str1);

        String textBlock = """
                가나다라마바사
                아자차카타파하
                    ABCDEFG
                """;
        System.out.println(textBlock);
    }
}
