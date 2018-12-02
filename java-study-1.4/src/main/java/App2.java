import java.sql.Date;
import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {
    
    Scanner scanner = new Scanner(System.in);
    int no;
    String name;
    String email;
    String password;
    String photo;
    String phone;
    
    System.out.print("번호? ");
    no = Integer.parseInt(scanner.nextLine());

    System.out.print("이름? ");
    name = scanner.nextLine();

    System.out.print("이메일? ");
    email = scanner.nextLine();
    
    System.out.print("암호? ");
    password = scanner.nextLine();
    
    System.out.print("사진? ");
    photo = scanner.nextLine();
    
    System.out.print("전화? ");
    phone = scanner.nextLine();
    
    System.out.println();
    
    System.out.printf("번호: %d\n", no);
    System.out.printf("이름: %s\n", name);
    System.out.printf("이메일: %s\n", email);
    System.out.printf("암호: %s\n", password);
    System.out.printf("사진: %s\n", photo);
    System.out.printf("전화: %s\n", phone);
    System.out.printf("가입일: %s\n", new Date(System.currentTimeMillis()));
    
    scanner.close();
  }
}
