import java.sql.Date;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int no;
    String title;
    String contents;
    Date startDate;
    Date endDate;
    int totalHours;
    int dayHours;
    
    System.out.print("번호? ");
    no = Integer.parseInt(scanner.nextLine());

    System.out.print("수업명? ");
    title = scanner.nextLine();

    System.out.print("수업내용? ");
    contents = scanner.nextLine();
    
    System.out.print("시작일? ");
    startDate = Date.valueOf(scanner.nextLine());
    
    System.out.print("종료일? ");
    endDate = Date.valueOf(scanner.nextLine());
    
    System.out.print("총수업시간? ");
    totalHours = Integer.parseInt(scanner.nextLine());
    
    System.out.print("일수업시간? ");
    dayHours = Integer.parseInt(scanner.nextLine());
    
    System.out.println();
    
    System.out.printf("번호: %d\n", no);
    System.out.printf("수업명: %s\n", title);
    System.out.printf("수업내용: %s\n", contents);
    System.out.printf("기간: %s ~ %s\n", startDate, endDate);
    System.out.printf("총수업시간: %d 시간\n", totalHours);
    System.out.printf("일수업시간: %d 시간\n", dayHours);
    
    scanner.close();
  }
}
