package ra.model;

import java.util.Date;
import java.util.Scanner;

public class Song {
    private String songId;
    private String songName;
    private String descriptions;
    private String singer;
    private String songWriter;
    private Date createdDate;
    private boolean songStatus;

    public Song() {
        createdDate =new Date();
    }

    public Song(String songId, String songName, String descriptions, Singer singer, String songWriter, Date createdDate, boolean songStatus) {
        this.songId = songId;
        this.songName = songName;
        this.descriptions = descriptions;
        this.singer = String.valueOf(singer);
        this.songWriter = songWriter;
        this.createdDate = createdDate;
        this.songStatus = songStatus;
    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(Singer singer) {
        this.singer = String.valueOf(singer);
    }

    public String getSongWriter() {
        return songWriter;
    }

    public void setSongWriter(String songWriter) {
        this.songWriter = songWriter;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isSongStatus() {
        return songStatus;
    }

    public void setSongStatus(boolean songStatus) {
        this.songStatus = songStatus;
    }
    public void inputData(Scanner scanner ,Song[] arrSong,Singer[] arrSinger){
        /** songId ***/
        boolean isExit = true;
        System.out.println("Mời nhập mã bài hát(String) :");
        do {
            this.songId = scanner.nextLine();
            if (this.songId.length() == 4){
                boolean checkSongId = true;
                for (int i = 0; i < arrSong.length; i++) {
                    if (arrSong[i] != null && arrSong[i].getSongId().equals(this.songId)){
                        checkSongId = false;
                        break;
                    }
                }
                if (checkSongId){
                    System.err.println("Mã bài hát tồn tại, vui lòng nhập lại ");
                }else {
                    if (this.songId.startsWith("S")){
                        isExit = false;
                    }else {
                        System.err.println("Mã bài hát Có 4 ký tự và bắt đầu bằng kí tự S, không trùng lặp,Vui lòng nhập lại");
                    }
                }
            }
        }while (isExit);
        /** songName ***/
        boolean checkName = false;
        while (!checkName){
            System.out.println("Mời nhập tên bài hát(String) : ");
            String nameSong = scanner.nextLine();
            if (nameSong.isEmpty()){
                System.err.println("Tên bài hát không để được trống ");
            }else {
                this.songName =nameSong;
                checkName = true;
            }
        }
        /*** descriptions ***/
        System.out.println("Mời nhập mô tả bài hát(String) : ");
        this.descriptions = scanner.nextLine();
        /** singer ***/
        boolean checkSinger = false;
        while (!checkSinger) {
            System.out.println("Mời nhập tên ca sĩ: ");
            String singerName = scanner.nextLine();

            boolean singerExists = false;
            for (Singer singer : arrSinger) {
                if (singer != null && singer.getSingerName().equalsIgnoreCase(singerName)) {
                    singerExists = true;
                    break;
                }
            }

            if (singerExists) {
                System.out.println("Ca sĩ đã tồn tại.");
            } else {
                this.singer = singerName;
                checkSinger = true;
            }

            if (!checkSinger) {
                System.err.println("Ca sĩ không tồn tại. Vui lòng nhập lại.");
            }
        }


        /** songWriter **/
        boolean checkSongWriter = false;
        while (!checkSongWriter){
            System.out.println("Mời nhập người sáng tác(String): ");
            String songWriter = scanner.nextLine();
            if (songWriter.isEmpty()){
                System.err.println("Không được để trống");
            }else {
                this.songWriter = songWriter;
                checkSongWriter = true;
            }
        }
        /** songStatus ***/
        System.out.println("Mời nhập trạng thái bài hát(boolean) : ");
       this.songStatus = Boolean.parseBoolean(scanner.nextLine());
    }
    public void displayData(){
        System.out.println("Mã bài hát: " + songId);
        System.out.println("Tên bài hát: " + songName);
        System.out.println("Mô tả bài hát: " + descriptions);
        System.out.println("Ca sĩ: " + singer);
        System.out.println("Người sáng tác: " + songWriter);
        System.out.println("Ngày tạo: " + createdDate);
        System.out.println("Trạng thái: " + (songStatus ? "Hoạt động" : "Không hoạt động"));
    }

}
