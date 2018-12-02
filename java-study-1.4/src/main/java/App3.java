import java.sql.Date;
import java.util.Scanner;

public class App3 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    
    int no;
    String contents;
    Date writeDate = new Date(System.currentTimeMillis());
    int viewCount = 0;
    
    System.out.print("번호? ");
    no = Integer.parseInt(scanner.nextLine());
    
    System.out.print("내용? ");
    contents = scanner.next();
    
    System.out.println();
    
    System.out.printf("번호: %d\n", no);
    System.out.printf("내용: %s\n", contents);
    System.out.printf("작성일: %s\n", writeDate);
    System.out.printf("조회수: %d\n", viewCount);
    
    scanner.close();
  }
}
