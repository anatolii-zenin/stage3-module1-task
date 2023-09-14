package com.mjc.school;

import com.mjc.school.controller.Controller;
import com.mjc.school.dto.NewsDTO;

import java.util.Scanner;

public class NewsMethods {
    public static void getAllNews(Controller newsController) {
        for (var newsDTO : newsController.getAllNews()) {
            System.out.println(newsDTO.toString());
        }
    }

    public static void getNewsById(Controller newsController) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter ID:");
        Long id = Long.parseLong(in.nextLine());
        System.out.println(newsController.getNewsById(id).toString());
    }

    public static void createNews(Controller newsController) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter title:");
        var title = in.nextLine();
        System.out.println("Enter content:");
        var content = in.nextLine();
        System.out.println("Enter author ID:");
        Long authorID = Long.parseLong(in.nextLine());
        var newsDTO = new NewsDTO();
        newsDTO.setTitle(title);
        newsDTO.setContent(content);
        newsDTO.setAuthorId(authorID);
        var newNews = newsController.createNewsEntry(newsDTO);
        System.out.println(newNews.toString());
    }

    public static void updateNews(Controller newsController) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter news ID");
        Long newsID = Long.parseLong(in.nextLine());
        System.out.println("Enter title:");
        var title = in.nextLine();
        System.out.println("Enter content:");
        var content = in.nextLine();
        System.out.println("Enter author ID:");
        Long authorID = Long.parseLong(in.nextLine());
        var newsDTO = new NewsDTO();
        newsDTO.setId(newsID);
        newsDTO.setTitle(title);
        newsDTO.setContent(content);
        newsDTO.setAuthorId(authorID);
        var updatedNews = newsController.updateNewsEntry(newsDTO);
        System.out.println("Success:");
        System.out.println(updatedNews.toString());
    }

    public static void deleteNewsById(Controller newsController) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter news ID");
        Long newsID = Long.parseLong(in.nextLine());
        if(newsController.deleteNewsEntry(newsID))
            System.out.println("Success:");
        else
            System.out.println("Failure:");
    }
}
