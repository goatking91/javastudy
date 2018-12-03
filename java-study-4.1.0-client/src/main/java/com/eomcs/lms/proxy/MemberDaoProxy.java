package com.eomcs.lms.proxy;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import com.eomcs.lms.domain.Member;

public class MemberDaoProxy {
  ObjectInputStream in;
  ObjectOutputStream out;

  public MemberDaoProxy(ObjectInputStream in, ObjectOutputStream out) {
    this.in = in;
    this.out = out;
  }

  public int delete(int no) throws Exception {
    out.writeUTF("/member/delete");
    out.writeInt(no);
    out.flush();

    if (in.readUTF().equals("ok")) {
      return 1;
    } else {
      return 0;
    }

  }

  public int update(Member member) throws Exception {
    out.writeUTF("/member/update");
    out.writeObject(member);
    out.flush();

    if (in.readUTF().equals("ok")) {
      return 1;
    } else {
      return 0;
    }

  }

  public int add(Member member) throws Exception {
    out.writeUTF("/member/add");
    out.writeObject(member);
    out.flush();

    if (in.readUTF().equals("ok")) {
      return 1;
    } else {
      return 0;
    }

  }

  public Member[] list() throws Exception {
    out.writeUTF("/member/list");
    out.flush();

    if (in.readUTF().equals("ok")) {
      return (Member[]) in.readObject();
    } else {
      return null;
    }

  }

  public Member detail(int no) throws Exception {
    out.writeUTF("/member/detail");
    out.writeInt(no);
    out.flush();

    if (in.readUTF().equals("ok")) {
      return (Member) in.readObject();
    } else {
      return null;
    }

  }

  public static void main(String[] args) throws Exception {
    try (Socket socket = new Socket("localhost", 8888);
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());) {

      MemberDaoProxy memberDao = new MemberDaoProxy(in, out);
      
      Member[] members = memberDao.list();
      
      for (Member member : members) {
        System.out.println(member);
      }
    }
  }

}
