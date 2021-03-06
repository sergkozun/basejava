package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MainCollections {
    private static final String UUID_1= "uuid1";
    private static final Resume RESUME_1;
    private static final String UUID_2= "uuid2";
    private static final Resume RESUME_2;
    private static final String UUID_3= "uuid3";
    private static final Resume RESUME_3;
    private static final String UUID_4= "uuid4";
    private static final Resume RESUME_4;

    static{
            RESUME_1 = new Resume(UUID_1, "name1");
            RESUME_2 = new Resume(UUID_2,"name2");
            RESUME_3 = new Resume(UUID_3,"name3");
            RESUME_4 = new Resume(UUID_4,"name4");
    }

    public static void main(String[] args) {
        Collection<Resume> collection = new ArrayList<>();
        collection.add(RESUME_1);
        collection.add(RESUME_2);
        collection.add(RESUME_3);
        collection.add(RESUME_4);

        Map<String, Resume> map = new HashMap<>();
        map.put(UUID_1, RESUME_1);
        map.put(UUID_2, RESUME_2);
        map.put(UUID_3, RESUME_3);
        map.put(UUID_4, RESUME_4);

        for(String uuid: map.keySet()){
            System.out.println(map.get(uuid));
        }

        for(Map.Entry<String, Resume> entry: map.entrySet()){
            System.out.println(entry.getValue());
        }
    }
}
