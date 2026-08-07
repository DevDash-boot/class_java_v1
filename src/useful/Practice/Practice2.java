package useful.Practice;

public class Practice2 {
    public static void main(String[] args) {
        String[] score = {"80", "95", "70", "100"};

        int n1 = Integer.parseInt(score[0]);
        int n2 = Integer.parseInt(score[1]);
        int n3 = Integer.parseInt(score[2]);
        int n4 = Integer.parseInt(score[3]);

        int sum = 0;
        double avg = 0;
        sum = n1 + n2 + n3 + n4;
        avg = (double)sum / 4;

        System.out.println("총점: " + sum );
        System.out.println("평균: " + avg );

    }
}
