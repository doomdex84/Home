package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private Scanner sc;
    public App(Scanner sc) {
        this.sc = sc;

    }

    public void run() {
        System.out.println("==Motivation  실행==");

        int lastId = 0;

        List<Motivation> motivations = new ArrayList<Motivation>();
        // 저장소

        while (true) {
            System.out.print("명령어) ");
            String cmd = sc.nextLine().trim();

            if (cmd.equals("exit")) {
                System.out.println("==Motivation  종료==");
                break;
             }else if (cmd.length() == 0) {
                System.out.println("명령어가 입력되지 않았음");
                continue;
            }

            if (cmd.equals("add")) {

                int id = lastId + 1;
                System.out.print("body: ");
                String body = sc.nextLine();
                System.out.print("source: ");
                String source = sc.nextLine();

                Motivation motivation = new Motivation(id, body, source);
                // 각 객체의 내부정보를 채워줌
                motivations.add(motivation);


                System.out.printf("%d번 moti가 등록됨\n",id);
                lastId++;

            }else if (cmd.equals("list")) {
                System.out.println("=".repeat(40));
                System.out.printf("   번호   /    source    /    body    \n");

                if (motivations.size() == 0) {
                    System.out.println("등록된 moti 없어");
                }
                else {
                    System.out.println("1개 이상있음");
                }
            }
        }
    }
}
class Motivation {
    int id;
    String body;
    String source;

    @Override
    public String toString() {
        return "Motivation{" +
                "id=" + id +
                ", body='" + body + '\'' +
                ", source='" + source + '\'' +
                '}';
    }

    public Motivation(int id, String body, String source) {
        this.id = id;
        this.body = body;
        this.source = source;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}