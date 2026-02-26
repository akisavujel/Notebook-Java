package controller;

import model.TopicModel;

import java.sql.Timestamp;
import java.util.ArrayList;

public class TopicController {
    private ArrayList<TopicModel> topics = new ArrayList<>(); // make private
    private int idCounter = 1;

    // Add a new topic
    public String addTopic(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "Please provide a topic name!";
        }

        // Prevent duplicate topic names (case-insensitive)
        for (TopicModel t : topics) {
            if (t.getName().equalsIgnoreCase(name.trim())) {
                return "Topic already exists!";
            }
        }

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        TopicModel topic = new TopicModel(idCounter++, name.trim(), timestamp, timestamp);
        topics.add(topic);
        return "Topic added successfully!";
    }

    // View all topics
    public void viewTopic() {
        if (topics.isEmpty()) {
            System.out.println("No topics available.");
            return;
        }

        System.out.println("=== List of Topics ===");
        for (TopicModel topic : topics) {
            System.out.println(topic.getId() + ". " + topic.getName() + " (Created: " + topic.getCreatedAt() + ")");
        }
    }
}