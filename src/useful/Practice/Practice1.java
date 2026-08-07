package useful.Practice;

public class Practice1 {
    public static void main(String[] args) {
        String s = "Java";
        StringBuffer sb = new StringBuffer(s);

        System.out.println("입력 : " + s);
        System.out.println("원본 : " + s);
        System.out.println("뒤집기 : " + sb.reverse());
        System.out.println("길이 : " + s.length());
    }
}
