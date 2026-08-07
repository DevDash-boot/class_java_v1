package useful.Practice;

public class Practice8 {
    public static void main(String[] args) {
        String s1 ="12345";

        StringBuffer sb = new StringBuffer(s1);
        int n = Integer.parseInt(sb.reverse().toString());

        System.out.println(n);

    }
}
