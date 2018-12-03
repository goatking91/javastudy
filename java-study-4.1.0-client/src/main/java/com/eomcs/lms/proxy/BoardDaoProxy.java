package com.eomcs.lms.proxy;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import com.eomcs.lms.domain.Board;

public class BoardDaoProxy {
  ObjectInputStream in;
  ObjectOutputStream out;

  public BoardDaoProxy(ObjectInputStream in, ObjectOutputStream out) {
    this.in = in;
    this.out = out;
  }

  public int delete(int no) throws Exception {
    out.writeUTF("/board/delete");
    out.writeInt(no);
    out.flush();

    if (in.readUTF().equals("ok")) {
      return 1;
    } else {
      return 0;
    }

  }

  public int update(Board board) throws Exception {
    out.writeUTF("/board/update");
    out.writeObject(board);
    out.flush();

    if (in.readUTF().equals("ok")) {
      return 1;
    } else {
      return 0;
    }

  }

  public int add(Board board) throws Exception {
    out.writeUTF("/board/add");
    out.writeObject(board);
    out.flush();

    if (in.readUTF().equals("ok")) {
      return 1;
    } else {
      return 0;
    }

  }

  public Board[] list() throws Exception {
    out.writeUTF("/board/list");
    out.flush();

    if (in.readUTF().equals("ok")) {
      return (Board[]) in.readObject();
    } else {
      return null;
    }

  }

  public Board detail(int no) throws Exception {
    out.writeUTF("/board/detail");
    out.writeInt(no);
    out.flush();

    if (in.readUTF().equals("ok")) {
      return (Board) in.readObject();
    } else {
      return null;
    }

  }

  public static void main(String[] args) throws Exception {
    try (Socket socket = new Socket("localhost", 8888);
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());) {

      BoardDaoProxy boardDao = new BoardDaoProxy(in, out);
      
      Board[] boards = boardDao.list();
      
      for (Board board : boards) {
        System.out.println(board);
      }
    }
  }
}
