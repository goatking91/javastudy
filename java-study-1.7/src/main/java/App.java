import java.sql.Date;
import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    
    Scanner keyboard = new Scanner(System.in);

    final int LENGTH = 10;
    
    Lesson[] lessons = new Lesson[LENGTH];
    int lessonIdx = 0;
    
    Member[] members = new Member[LENGTH];
    int memberIdx = 0;
    
    Board[] boards = new Board[LENGTH];
    int boardIdx = 0;
    
    while (true) {
      System.out.print("명령> ");
      String command = keyboard.nextLine().toLowerCase();
      if (command.equals("quit")) {
        System.out.println("안녕!");
        break;
        
      } else if(command.equals("/lesson/add")) {
     // 클래스로 정의한 새 데이터 타입의 메모리(인스턴스) 만들기
        Lesson lesson = new Lesson();
        
        // 사용자가 입력한 값을 메모리에 담는다.
        System.out.print("번호? ");
        lesson.no = Integer.parseInt(keyboard.nextLine());
        
        System.out.print("수업명? ");
        lesson.title = keyboard.nextLine();
        
        System.out.print("설명? ");
        lesson.contents = keyboard.nextLine();
        
        System.out.print("시작일? ");
        lesson.startDate = Date.valueOf(keyboard.nextLine());
        
        System.out.print("종료일? ");
        lesson.endDate = Date.valueOf(keyboard.nextLine());
        
        System.out.print("총수업시간? ");
        lesson.totalHours = Integer.parseInt(keyboard.nextLine());
        
        System.out.print("일수업시간? ");
        lesson.dayHours = Integer.parseInt(keyboard.nextLine());
        
        // i 번째 배열에 수업 정보를 담고 있는 Lesson 객체(의 주소)를 보관한다.
        lessons[lessonIdx++] = lesson;
        
        System.out.println("저장하였습니다.\n");
        
      } else if (command.equals("/lesson/list")) {
        for (int i = 0; i < lessonIdx; i++) {
          System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
              lessons[i].no, lessons[i].title, lessons[i].startDate, 
              lessons[i].endDate, lessons[i].totalHours);
        }
        System.out.println();
        
      } else if(command.equals("/member/add")) {
        Member member = new Member();
        
        System.out.print("번호? ");
        member.no = Integer.parseInt(keyboard.nextLine());
        
        System.out.print("이름? ");
        member.name = keyboard.nextLine();
        
        System.out.print("이메일? ");
        member.email = keyboard.nextLine();
        
        System.out.print("암호? ");
        member.password = keyboard.nextLine();
    
        System.out.print("사진? ");
        member.photo = keyboard.nextLine();
    
        System.out.print("전화? ");
        member.tel = keyboard.nextLine();
    
        member.registeredDate = new Date(System.currentTimeMillis()); 
        
        members[memberIdx++] = member;
        
        System.out.println("저장하였습니다.\n");
        
      } else if (command.equals("/member/list")) {
        for (int i = 0; i < memberIdx; i++) {
          System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n", 
              members[i].no, members[i].name, members[i].email, 
              members[i].tel, members[i].registeredDate);
        }
        System.out.println();
        
      } else if(command.equals("/board/add")) {
        Board board = new Board();
        
        System.out.print("번호? ");
        board.no = Integer.parseInt(keyboard.nextLine());
        
        System.out.print("내용? ");
        board.contents = keyboard.nextLine();
        
        board.createdDate = new Date(System.currentTimeMillis()); 
        
        board.viewCount = 0;
        
        boards[boardIdx++] = board;
        
        System.out.println("저장하였습니다.\n");
        
      } else if (command.equals("/board/list")) {
        for (int i = 0; i < boardIdx; i++) {
          System.out.printf("%3d, %-20s, %s, %d\n", 
              boards[i].no, boards[i].contents, boards[i].createdDate, boards[i].viewCount);
        }
        System.out.println();
        
      } else {
        System.out.println("실행할 수 없는 명령어입니다.\n");
        
      }
    }
    
    keyboard.close();
    
    System.out.println(); // 빈 줄 출력
    
    
  }
}
