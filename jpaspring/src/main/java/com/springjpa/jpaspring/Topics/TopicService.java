package com.springjpa.jpaspring.Topics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

/*
    private List<Topic> topics = new ArrayList<Topic>(Arrays.asList(
            new Topic("spring", "Spring Framework", "spring Framwork description"),
        new Topic("java", "java Framework", "Java Framwork description"),
        new Topic("tomcat", "Tomcat Framework", "Tomcat Framwork description"),
        new Topic("javaScrit", "JavaScript Framework", "spring Framwork description")));
*/

    public List<Topic> getListOfTopics(){
        //return topics;
        List<Topic>topics = new ArrayList<>();
        topicRepository.findAll().forEach(topics::add);
        return topics;
    }

    public Optional<Topic> getTopic(String id){
        // search for the first match topic in topics list
        return  topicRepository.findById(id);
       }


    public void addTopic(Topic topic) {

        topicRepository.save(topic);
    }

    public void updateTopic(Topic topic, String id) {
/*        for (Topic item: topics){
            if (item.getId() == id) {
                topics.set(topics.indexOf(item), topic);
                return;
            }
        }*/
        topicRepository.save(topic);
    }

    public void deleteTopic (String id){
//        topics.removeIf(t -> t.getId().equals(id));
        topicRepository.deleteById(id);
    }

}
