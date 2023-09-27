package ra.model;

import java.util.Scanner;

public class Singer {
    private static int count = 0;
    private int singerId;
    private String singerName;
    private int age;
    private String nationality;
    private boolean gender;
    private String genre;

    public Singer() {
        this.singerId = count++;
    }

    public Singer(int singerId, String singerName, int age, String nationality, boolean gender, String genre) {
        this.singerId = singerId;
        this.singerName = singerName;
        this.age = age;
        this.nationality = nationality;
        this.gender = gender;
        this.genre = genre;
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void inputData(Scanner scanner,Singer[] arrSinger) {
        /** singerName **/
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Mời nhập tên ca sĩ :  ");
            String nameSinger = scanner.nextLine();
            if (nameSinger.isEmpty()) {
                System.out.println("Tên ca sĩ không để được để trống:");
            } else {
                this.singerName = nameSinger;
                isExit = true;
            }
        }
        /** age **/
        boolean checkAge = false;
        while (!checkAge) {
            System.out.println("Mời nhập số tuổi : ");
            int ageSinger = Integer.parseInt(scanner.nextLine());
            if (ageSinger < 0) {
                System.err.println("Tuổi ca sĩ phải lớn hơn 0 : ");
            }else {
                this.age = ageSinger;
                checkAge = true;
            }


        }
        /** nationality **/
        boolean checkNationality = false;
        while (!checkNationality){
            System.out.println("Mời nhập quốc tịch(String) : ");
            String nationalitySinger = scanner.nextLine();
            if (nationalitySinger.isEmpty()){
                System.err.println("Quốc tịch không để được để trống : ");
            }else {
                this.nationality = nationalitySinger;
                checkNationality = true;
            }
        }
        /** gender **/
        System.out.println("Mời nhập giới tính(boolean) :  ");
        this.gender = Boolean.parseBoolean(scanner.nextLine());
        /** genre **/
        boolean checkGenre = false;
        while (!checkGenre) {
            System.out.println("Mời nhập thể loại(String) : ");
            String genreSingher = scanner.nextLine();
            if (genreSingher.isEmpty()){
                System.err.println("Thể loại không để được trống");
            }else {
                this.genre = genreSingher;
                checkGenre = true;
            }
        }

    }
    public void displayData(){
        System.out.println("Mã ca sĩ :  "+ singerId);
        System.out.println("Tên ca sĩ : "+ singerName);
        System.out.println("Tuổi ca sĩ : "+age);
        System.out.println("Quốc tịch ca sĩ :  "+ nationality);
        System.out.println("Giới tính ca sĩ :  "+ (gender?"nam":"nữ"));
        System.out.println("Thể loại : "+ genre);
    }
}
