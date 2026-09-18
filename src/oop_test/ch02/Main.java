package oop_test.ch02;

public class Main {
    public static void main(String[] args) {
        BoardService boardService = new BoardService();
        boardService.writePost("첫 번째 글", "자바객체지향 연습을 하고 있습니다.");
    }
}
