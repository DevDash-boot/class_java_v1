package oop_test.ch07;

import java.util.List;

public class MusicService {
    private MusicDao dao;

    public MusicService(MusicDao dao) {
        this.dao = dao;
    }

    public void addMusic(String title, String artist){
        Music music = new Music(title, artist);
        dao.insert(music);
    }
    public void printPlaylist(){
        List<Music> music = dao.findAll();
        System.out.println("--- 노래 목록 ---");
        for(Music m : music){
            System.out.println("곡 : " + m.getTitle() + ", 아티스트 : " + m.getArtist());
        }
    }
}
