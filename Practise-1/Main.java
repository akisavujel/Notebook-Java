package view;

import controller.TopicController;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);               // create once
        TopicController topicController = new TopicController(); // create once

        while(true){
            System.out.println("\n======Logger Journal======");
            System.out.println("1. Add Topic");
            System.out.println("2. View Topic");
            System.out.println("3. Exit");
            System.out.print("Please select your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch(choice) {
                case 1:
                    System.out.print("Enter topic name: ");
                    String name = sc.nextLine();
                    System.out.println(topicController.addTopic(name));
                    break;

                case 2:
                    System.out.println("Here are the topics:");
                    topicController.viewTopic();
                    break;

                case 3:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Please enter a valid choice!");
            }
        }
    }
}