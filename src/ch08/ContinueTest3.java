package ch08;

public class ContinueTest3 {

    public static void main(String[] args) {

        int last, first;

        for (int i = 1; i < 73; i++) {
            last = i % 10;
            first = i / 10;
            if(last==1){
                System.out.println();
            }

            if (last == 3 || last == 6 || last == 9) {
                System.out.print("짝!\t");
                continue;
            }
            else if (first == 3 || first == 6 || first == 9){
                System.out.print("짝!\t");
                continue;
            }
            else{
                System.out.print(i + "\t");
            }
        }

    } // end of main

} // end of class
