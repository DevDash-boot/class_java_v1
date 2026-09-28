package oop_test.ch07;

public class Main {
    public static void main(String[] args) {
        MusicDao musicDao = new MusicDao();
        MusicService musicService = new MusicService(musicDao);
        musicService.addMusic("노래1", "가수1");
        musicService.addMusic("노래2", "가수2");
        musicService.addMusic("노래3", "가수3");

        musicService.printPlaylist();
    }
}
