package com.mjc.school;

import com.mjc.school.controller.Controller;
import com.mjc.school.controller.implementation.CController;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Controller newsController = new CController();
        newsController.init();
        Scanner in = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            try {
                System.out.println("""
                        Select operation:
                        0. Get all news
                        1. Get news by ID
                        2. Create news
                        3. Update news
                        4. Delete news by ID
                        -1. Exit""");
                int operationChoice = Integer.parseInt(in.nextLine());
                switch (operationChoice) {
                    case 0 -> NewsMethods.getAllNews(newsController);
                    case 1 -> NewsMethods.getNewsById(newsController);
                    case 2 -> NewsMethods.createNews(newsController);
                    case 3 -> NewsMethods.updateNews(newsController);
                    case 4 -> NewsMethods.deleteNewsById(newsController);
                    case -1 -> exit = true;
                    default -> System.out.println("No such operation: " + operationChoice);
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
