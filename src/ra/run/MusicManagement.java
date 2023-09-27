package ra.run;

import ra.model.Singer;
import ra.model.Song;

import java.util.Scanner;

public class MusicManagement {
    public static Singer[] arrSinger = new Singer[100];
    public static Song[] arrSong = new Song[100];
    public static int indexSong = 0;
    public static int indexSinger = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicManagement musicManagement = new MusicManagement();
        boolean isExit = true;

        do {
            System.out.println("************************MUSIC-MANAGEMENT*************************");
            System.out.println("1. Quản lý ca sĩ");
            System.out.println("2. Quản lý bài hát");
            System.out.println("3. Tìm kiếm bài hát");
            System.out.println("4. Thoát");
            System.out.println("Mời nhập các chức năng từ 1-4");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    musicManagement.singerManagement(scanner, arrSinger);
                    break;
                case 2:
                    musicManagement.songManagement(scanner, arrSong);
                    break;
                case 3:
                    musicManagement.searchManagement(scanner);
                    break;
                case 4:
                    scanner.close();
                    System.exit(0);
                    break;
            }
        } while (isExit);
    }

    public void singerManagement(Scanner scanner, Singer[] arrSinger) {
        boolean isSinger = true;
        do {
            System.out.println("**********************SINGER-MANAGEMENT*************************");
            System.out.println("1.Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mớ");
            System.out.println("2.Hiển thị danh sách tất cả ca sĩ đã lưu trữ");
            System.out.println("3.Thay đổi thông tin ca sĩ theo mã id");
            System.out.println("4.Xóa ca sĩ theo mã id (kiểm tra xem nếu ca sĩ có bài hát thì không xóa được)");
            System.out.println("5.Thoát");
            System.out.println("mời chọn chức năng từ 1-5");
            int choice = Integer.parseInt(scanner.nextLine());
            {
                switch (choice) {
                    case 1:
                        addSinger(scanner, arrSinger);
                        break;
                    case 2:
                        displayInformation(scanner);
                        break;
                    case 3:
                        updateSinger(scanner, arrSinger);
                        break;
                    case 4:
                        deleteSinger(scanner);
                        break;
                    case 5:
                        isSinger = false;
                        break;
                    default:
                        System.err.println("Nhập không đúng, vui lòng nhập từ 1-5");
                }
            }
        } while (isSinger);
    }

    public static void addSinger(Scanner scanner, Singer[] arrSinger) {
        System.out.println("Mời nhập số lượng ca sĩ : ");
        int quantity = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < quantity; i++) {
            System.out.println(" Thông tin ca sĩ thứ " + (i + 1) + "là:");
            arrSinger[i] = new Singer();
            arrSinger[i].inputData(scanner, arrSinger);
            indexSinger++;
        }
    }

    public static void displayInformation(Scanner scanner) {
        System.out.println("Hiển thị danh sách tất cả ca sĩ");
        for (int i = 0; i < indexSinger; i++) {
            arrSinger[i].displayData();
        }
    }

    public static void updateSinger(Scanner scanner, Singer[] arrSinger) {
        System.out.println("Thay đổi thông tin ca sĩ theo id");
        System.out.println("Nhập id ca sĩ cần cập nhật");
        int singerId = Integer.parseInt(scanner.nextLine());
        int index = -1;
        for (int i = 0; i < indexSinger; i++) {
            if (arrSinger[i] != null && arrSinger[i].getSingerId() == singerId) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.err.println("Không tìm thấy id cần cập nhật");
        } else {
            System.out.println("Nhập thông tin mới cho ca sĩ : ");
            for (int i = index; i < indexSinger; i++) {
                arrSinger[index].inputData(scanner, arrSinger);
                System.out.println("Thông tin đã được cập nhật");

            }
        }
    }

    public static void deleteSinger(Scanner scanner) {
        System.out.println("Xóa ca sĩ theo id ");
        System.out.println("Mời nhập id ca sĩ cần xóa");
        int deleteId = Integer.parseInt(scanner.nextLine());
        int index = -1;
        for (int i = 0; i < indexSinger; i++) {
            if (arrSinger[i] != null && arrSinger[i].getSingerId() == deleteId) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.err.println("Không tìm thấy id để xóa");
        } else {
            for (int i = index; i < indexSinger; i++) {
                arrSinger[i] = arrSinger[i + 1];
                indexSinger--;
                System.out.println("ca sĩ đã được xóa ");
            }
        }
    }

    public void songManagement(Scanner scanner, Song[] arrSong) {
        boolean checkSong = true;
        do {
            System.out.println("**********************SONG-MANAGEMENT*************************");
            System.out.println("1.Nhập vào số lượng bài hát cần thêm và nhập thông tin cần thêm mớ");
            System.out.println("2.Hiển thị danh sách tất cả bài hát đã lưu trữ");
            System.out.println("3.Thay đổi thông tin bài hát theo mã id");
            System.out.println("4.Xóa bài hát theo mã id");
            System.out.println("5.Thoát");
            System.out.println("Mời chọn các chức năng từ 1-5 ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    addSong(scanner, arrSong);
                    break;
                case 2:
                    displayInformationSong(arrSong);
                    break;
                case 3:
                    updateSong(scanner, arrSong);
                    break;
                case 4:
                    deleteSong(scanner, arrSong);
                    break;
                case 5:
                    checkSong = false;
                    break;
                default:
                    System.err.println("Nhập không đúng vui lòng nhập từ 1-5");
            }
        } while (checkSong);
    }

    public static void addSong(Scanner scanner, Song[] arrSong) {
        System.out.println("Nhập số lượng bài hát: ");
        int quantitySong = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < quantitySong; i++) {
            System.out.println("Thông tin bài hát thứ " + (i + 1) + "là:");
            arrSong[i] = new Song();
            arrSong[i].inputData(scanner, arrSong, arrSinger);
            indexSong++;

        }
    }

    public static void displayInformationSong(Song[] arrSong) {
        System.out.println("Hiển thị danh sách tất cả bài hát ");
        for (int i = 0; i < indexSong; i++) {
            if (arrSong[i]!= null) {
                arrSong[i].displayData();
            }
        }
    }

    public static void updateSong(Scanner scanner, Song[] arrSong) {
        System.out.println("Thay đổi thông tin bài hát theo mã id");
        System.out.println("Mời nhập id bài hát cần thay đổi: ");
        int updateSong = Integer.parseInt(scanner.nextLine());
        int index = -1;
        for (int i = 0; i < indexSong; i++) {
            if (arrSong[i] != null && arrSong[i].getSongId().equals(updateSong)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            System.err.println("Không tìm thấy bài hát để thay đổi");
        } else {
            System.out.println("Nhập thông tin mới cho bài hát : ");
            for (int i = index; i < indexSong; i++) {
                arrSong[index].inputData(scanner, arrSong, arrSinger);
                System.out.println("Đã được cập nhật");
            }
        }
    }

    public static void deleteSong(Scanner scanner, Song[] arrSong) {
        System.out.println("Xóa bài hát theo mã id");
        System.out.println("Mời nhập id để xóa sản phẩm");
        String deleteId = scanner.nextLine();

        int index = -1;
        for (int i = 0; i < indexSong; i++) {
            if (arrSong[i] != null && arrSong[i].getSongId().equals(deleteId)) {
                index = i;
                break;

            }
        }
        if (index == -1) {
            System.err.println("không tìm thấy bài hát để xóa");
        } else {
            for (int i = index; i < indexSong; i++) {
                arrSong[i] = arrSong[i + 1];
                indexSong--;
                System.out.println("Bài hát đã đc xóa");
            }
        }
    }

    public void searchManagement(Scanner scanner) {
        boolean checkSearch = true;
        do {
            System.out.println("*********************SEARCH-MANAGEMENT************************");
            System.out.println("1.Tìm kiếm bài hát theo tên ca sĩ hoặc thể loại");
            System.out.println("2.Tìm kiếm ca sĩ theo tên hoặc thể loại");
            System.out.println("3.Hiển thị danh sách bài hát theo thứ tự tên tăng dần");
            System.out.println("4.Hiển thị 10 bài hát được đăng mới nhất");
            System.out.println("5.Thoát");
            System.out.println("Mời chọn các chức năng từ 1-5");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    searchSong(scanner,arrSong);
                    break;
                case 2:
                    searchSinger(scanner,arrSinger);
                    break;
                case 3:
                    showList(scanner,arrSong);
                    break;
                case 4:
                    displayLatestSongs(arrSong);
                    break;
                case 5:
                    checkSearch = false;
                    break;
                default:
                    System.err.println("Nhập không đúng,Vui lòng nhập lại từ 1-5");
            }
        } while (checkSearch);
    }

    public static void searchSong(Scanner scanner, Song[] arrSong) {
        System.out.println("Mời nhập bài hát or thể loại tìm kiếm : ");
        String searchSong = scanner.nextLine();
        boolean checkSearch = true;
        for (int i = 0; i < arrSong.length; i++) {
            if (arrSong[i] != null && (arrSong[i].getSongName().contains(searchSong) || arrSinger[i].getGenre().contains(searchSong))) {
                arrSong[i].displayData();
                checkSearch = false;
                break;
            }
        }
    }

    public static void searchSinger(Scanner scanner, Singer[] arrSinger) {
        System.out.println("Mời nhập tên ca sĩ hoặc thể loại  tìm kiếm : ");
        String search = scanner.nextLine();
        boolean isExit = false;
        for (int i = 0; i < arrSinger.length; i++) {
            if (arrSinger[i] != null && (arrSinger[i].getSingerName().contains(search) || arrSinger[i].getGenre().contains(search))) {
                arrSinger[i].displayData();
                isExit = false;
                break;
            } else {
                System.err.println("Không tìm kiếm thấy kết quả;");
            }
        }
    }

    public static void showList(Scanner scanner, Song[] arrSong) {
        for (int i = 0; i < indexSong - 1; i++) {
            for (int j = 0; j < indexSong - i - 1; j++) {
                if (arrSong[j].getSongName().compareToIgnoreCase(arrSong[j + 1].getSongName()) > 0) {
                    Song temp = arrSong[j];
                    arrSong[j] = arrSong[j + 1];
                    arrSong[j + 1] = temp;
                }
            }
        }
        System.out.println("Danh sách bài hát theo thứ tự tên tăng dần:");
        for (int i = 0; i < indexSong; i++) {
            System.out.println(arrSong[i].getSongName());
        }
    }
    public static void displayLatestSongs(Song[] allSongs) {
        int count = Math.min(10, allSongs.length);
        Song[] latestSongs = new Song[count];

        for (int i = 0; i < count; i++) {
            latestSongs[i] = allSongs[i];
        }

        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (latestSongs[j].getCreatedDate().compareTo(latestSongs[j + 1].getCreatedDate()) < 0) {
                    Song temp = latestSongs[j];
                    latestSongs[j] = latestSongs[j + 1];
                    latestSongs[j + 1] = temp;
                }
            }
        }

        System.out.println("10 bài hát mới nhất:");
        for (Song song : latestSongs) {
            song.displayData();
        }
    }
}
