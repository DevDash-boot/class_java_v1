package io.exercise;

import java.io.*;
import java.util.Scanner;

public class Subject2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("정보 입력: ");
        String info = sc.nextLine();
        double avg = 0;
        String name;
        int kor,eng,math;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/io/exercise/info.txt"))) {
            bw.write(info);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader br = new BufferedReader(new FileReader("src/io/exercise/info.txt"))) {
            String line = br.readLine();
            String[] data = line.split(",");

            name=data[0];
            name = data[0];
            kor = Integer.parseInt(data[1]);
            eng = Integer.parseInt(data[2]);
            math = Integer.parseInt(data[3]);

            avg = (kor + eng + math) / 3.0;

            System.out.println("이름: " + name);
            System.out.println("국어 : " + kor);
            System.out.println("영어 : " + eng);
            System.out.println("수학 : " + math);
            System.out.println("평균 : " + avg);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        sc.close();
    }
}
