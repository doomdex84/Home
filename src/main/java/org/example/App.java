package org.example;

import java.util.Scanner;

public class App {

    private Scanner sc;
    public App(Scanner sc) {
        this.sc = sc;

    }

    public void run() {
        System.out.println("==Motivation  실행==");

        int lastId = 1;

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

                System.out.print("body: ");
                String body = sc.nextLine();
                System.out.print("source: ");
                String source = sc.nextLine();
                System.out.printf("%d번 moti가 등록됨\n",lastId);
                lastId++;
            }else if (cmd.equals("list")) {
                System.out.print("=".repeat(40));
                System.out.printf("   번호   /    source    /    body    \n");

            }
        }
    }
}
