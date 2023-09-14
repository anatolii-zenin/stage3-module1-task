package com.mjc.school;

import com.mjc.school.controller.Controller;
import com.mjc.school.controller.CController;
import com.mjc.school.dto.NewsDTO;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Controller newsController = new CController();
        newsController.init();
        Scanner in = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            System.out.println("Select operation:\n" +
                    "0. Get all news\n" +
                    "1. Get news by ID\n" +
                    "2. Create news\n" +
                    "3. Update news\n" +
                    "4. Delete news by ID\n" +
                    "-1. Exit");
            int operationChoice = Integer.parseInt(in.nextLine());
            switch (operationChoice) {
                case 0:
                    NewsMethods.getAllNews(newsController);
                    break;
                case 1:
                    NewsMethods.getNewsById(newsController);
                    break;
                case 2:
                    NewsMethods.createNews(newsController);
                    break;
                case 3:
                    NewsMethods.updateNews(newsController);
                    break;
                case 4:
                    NewsMethods.deleteNewsById(newsController);
                    break;
                case -1:
                    exit = true;
                    break;
                default:
                    System.out.println("No such operation: " + operationChoice);
            }
        }
    }
}
