package com.project.projectspecialsemester;

import java.util.HashMap;

public class AadhaarHashMap {
    HashMap<Integer, PersonDetails> aadhaarHashMap;

    public AadhaarHashMap(){
        aadhaarHashMap = new HashMap<>();
    }

    public void insertAadhaarHashMap(){
        aadhaarHashMap.put(1,new PersonDetails("Jaime" ,20 ,"Noida","Male" ,854592627085L));
        aadhaarHashMap.put(2,new PersonDetails("Chung" ,21 ,"Delhi" ,"Male", 723515467977L));
        aadhaarHashMap.put(3,new PersonDetails("Clark" ,22 ,"Kolkata" ,"Male" ,622659638210L));
        aadhaarHashMap.put(4,new PersonDetails("Brett" ,23, "Kanpur", "Male", 398644465183L));
        aadhaarHashMap.put(5,new PersonDetails("Cortez" ,24 ,"Lucknow", "Male" ,924463575675L));
        aadhaarHashMap.put(6,new PersonDetails("Mariano" ,25, "Mumbai", "Female" ,634242997196L));
        aadhaarHashMap.put(7,new PersonDetails("Joan" ,26, "Agra" ,"Female", 328051430808L));
        aadhaarHashMap.put(8,new PersonDetails("Dane" ,27 ,"Jaipur", "Female", 704793389115L));
        aadhaarHashMap.put(9,new PersonDetails("Richard" ,28 ,"Noida","Female", 133508150833L));
        aadhaarHashMap.put(10,new PersonDetails("Nathaniel" ,29, "Delhi", "Female", 807976231642L));
        aadhaarHashMap.put(11,new PersonDetails("Sammy" ,30 ,"Kolkata" ,"Male", 914024146705L));
        aadhaarHashMap.put(12,new PersonDetails("Robin" ,31, "Kanpur" ,"Male", 365372238310L));
        aadhaarHashMap.put(13,new PersonDetails("Fredric" ,32 ,"Lucknow" ,"Male", 914301339834L));
        aadhaarHashMap.put(14,new PersonDetails("Hayden" ,33 ,"Mumbai" ,"Male", 816664324345L));
        aadhaarHashMap.put(15,new PersonDetails("Pablo" ,34 ,"Agra", "Male", 316751506558L));
        aadhaarHashMap.put(16,new PersonDetails("Verda" ,35, "Jaipur", "Female", 403410582898L));
        aadhaarHashMap.put(17,new PersonDetails("Beatris" ,36, "Noida" ,"Female", 236776921609L));
        aadhaarHashMap.put(18,new PersonDetails("Velda" ,37 ,"Delhi", "Female", 139539843167L));
        aadhaarHashMap.put(19,new PersonDetails("Ingrid" ,38 ,"Kolkata", "Female", 878281378858L));
        aadhaarHashMap.put(20,new PersonDetails("Joeann" ,39 ,"Kanpur" ,"Female", 414254503394L));
        aadhaarHashMap.put(21,new PersonDetails("Deandre" ,40 ,"Lucknow" ,"Male", 784902410489L));
        aadhaarHashMap.put(22,new PersonDetails("Bert" ,41 ,"Mumbai", "Female", 126676743275L));
        aadhaarHashMap.put(23,new PersonDetails("Erin" ,42 ,"Agra", "Male", 372991680694L));
        aadhaarHashMap.put(24,new PersonDetails("Van" ,43 ,"Jaipur" ,"Female", 641119259455L));
        aadhaarHashMap.put(25,new PersonDetails("Maurice" ,44, "Delhi", "Male", 258967254083L));
    }

    public void insertHash(int key, PersonDetails details){
        aadhaarHashMap.put(key,details);
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

    public boolean updateAadhaarHashMap(int key, PersonDetails newDetails){
        if (aadhaarHashMap.containsKey(key)){
            aadhaarHashMap.put(key, newDetails);
            return true;
        }else{
            return false;
        }
    }

    public HashMap<Integer, PersonDetails> getAadhaarHashMap(){
        return aadhaarHashMap;
    }


}
