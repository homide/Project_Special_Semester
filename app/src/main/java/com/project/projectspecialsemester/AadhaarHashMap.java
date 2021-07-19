package com.project.projectspecialsemester;

import java.util.HashMap;

public class AadhaarHashMap {
    HashMap<String, PersonDetails> aadhaarHashMap;

    public AadhaarHashMap(){
        aadhaarHashMap = new HashMap<>();
    }

    public void insertAadhaarHashMap(){
        aadhaarHashMap.put("Kanishk",new PersonDetails("Kanishk", 20,"Noida", "Male",123456789011L));
    }

    public PersonDetails findAadhaarHashMap(String key){
        if (aadhaarHashMap.containsKey(key)){
            PersonDetails details = aadhaarHashMap.get(key);
            return details;
        }else{
            return null;
        }
    }

    public boolean deleteAadhaarHashMap(String key){
        if (aadhaarHashMap.containsKey(key)){
            aadhaarHashMap.remove(key);
            return true;
        }else{
            return false;
        }
    }

    public boolean updateAadhaarHashMap(String key, PersonDetails newDetails){
        if (aadhaarHashMap.containsKey(key)){
            aadhaarHashMap.put(key, newDetails);
            return true;
        }else{
            return false;
        }
    }

    public HashMap<String, PersonDetails> getAadhaarHashMap(){
        return aadhaarHashMap;
    }


}
