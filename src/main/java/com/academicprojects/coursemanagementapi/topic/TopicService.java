package com.academicprojects.coursemanagementapi.topic;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    List<Topic> topics = new ArrayList<>(Arrays.asList (
            new Topic("javaee","JavaEE","JavaEE Tutorials"),
            new Topic("springboot","SpringBoot","SpringBoot Tutorials"),
            new Topic("angular","Angular","Angular Tutorials")
    ));


    public List<Topic> getAllTopics() {
        return topics;
    }

    public Topic getTopic(String id){
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topics.add(topic);
    }

    public void updateTopic(Topic topic, String id) {
        for(int i=0; i< topics.size(); i++) {
            if((topics.get(i)).getId().equals(id)) {
                topics.set(i,topic);
                return;
            }
        }
    }

    public void deleteTopic(String id) {
        topics.removeIf(t -> t.getId().equals(id));
    }
}
