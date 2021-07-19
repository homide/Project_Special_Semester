package com.project.projectspecialsemester;

import java.util.HashMap;
public class PhoneHashMap {
    HashMap<Integer, PersonDetails> phoneHashMap;

    public PhoneHashMap(){
        phoneHashMap = new HashMap<>();
    }

    public void insertPhoneHashMap(){
        phoneHashMap.put(1,new PersonDetails("Kanishk", 20,"Noida", "Male",8800769426L,9354433918L));
        phoneHashMap.put(2,new PersonDetails("Kanishk2", 20,"Noida", "Male",8800769426L,9354433918L));
        phoneHashMap.put(3,new PersonDetails("Kanishk3", 20,"Noida", "Male",8800769426L,9354433918L));
        phoneHashMap.put(4,new PersonDetails("Kanishk4", 20,"Noida", "Male",8800769426L,9354433918L));
        phoneHashMap.put(5,new PersonDetails("Kanishk5", 20,"Noida", "Male",8800769426L,9354433918L));
    }

    public PersonDetails findPhoneHashMap(int key){
        if (phoneHashMap.containsKey(key)){
            return phoneHashMap.get(key);
        }else{
            return null;
        }
    }

    public void deletePhoneHashMap(int key){
        if (phoneHashMap.containsKey(key)){
            phoneHashMap.remove(key);
        }
    }

    public boolean updateHashMap(int key, PersonDetails newDetails){
        if (phoneHashMap.containsKey(key)){
            phoneHashMap.put(key, newDetails);
            return true;
        }else{
            return false;
        }
    }

    public HashMap<Integer, PersonDetails> getPhoneHashMap(){
        return phoneHashMap;
    }


}
