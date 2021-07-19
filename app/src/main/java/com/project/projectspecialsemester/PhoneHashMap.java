package com.project.projectspecialsemester;

import java.util.HashMap;
public class PhoneHashMap {
    HashMap<Integer, PersonDetails> phoneHashMap;

    public PhoneHashMap(){
        phoneHashMap = new HashMap<>();
    }

    public void insertPhoneHashMap(){
        phoneHashMap.put(1,new PersonDetails("Kanishk",20,"Noida","Male",9423546754L,6735498674L));
        phoneHashMap.put(2,new PersonDetails("Ramesh",19,"Srinagar","Male",7645546754L,6098498674L));
        phoneHashMap.put(3,new PersonDetails("Kashish",21,"Gurgaon","Male",7073546754L,1042498674L));
        phoneHashMap.put(4,new PersonDetails("Isha",20,"Mumbai","Female",7623546754L,6730008374L));
        phoneHashMap.put(5,new PersonDetails("Aditi",22,"Pune","Female",9592146754L,6735490003L));
        phoneHashMap.put(6,new PersonDetails("Harsh",20,"Banglore","Male",9423332754L,6735003311L));
        phoneHashMap.put(7,new PersonDetails("Dhruv",19,"Jaipur","Male",9452876254L,6636552674L));
        phoneHashMap.put(8,new PersonDetails("Parikshit",22,"Jhunjhunu","Male",7177946754L,8895498674L));
        phoneHashMap.put(9,new PersonDetails("Kritika",23,"Kanpur","Female",9423588890L,6888903674L));
        phoneHashMap.put(10,new PersonDetails("Satakshi",19,"Delhi","Female",8822546754L,6738882224L));
        phoneHashMap.put(11,new PersonDetails("Hamid",22,"Chandigarh","Male",7575546754L,6738998674L));
        phoneHashMap.put(12,new PersonDetails("Jayant",20,"Gurgaon","Male",5938346754L,6333498674L));
        phoneHashMap.put(13,new PersonDetails("Bhavya",23,"Jaipur","Male",9090546754L,6909098674L));
        phoneHashMap.put(14,new PersonDetails("Mahesh",20,"Lucknow","Male",9493293254L,9352878674L));
        phoneHashMap.put(15,new PersonDetails("Anam",21,"Pune","Female",7777546754L,6735498090L));
        phoneHashMap.put(16,new PersonDetails("Harshvardhini",24,"Sydney","Female",9999232754L,6984803311L));
        phoneHashMap.put(17,new PersonDetails("Ishika",19,"Delhi","Female",9023476254L,9002352674L));
        phoneHashMap.put(18,new PersonDetails("Palak",22,"Ajmer","Female",8900346754L,8890003274L));
        phoneHashMap.put(19,new PersonDetails("Ritik",23,"Bhopal","Male",9423237890L,6888900909L));
        phoneHashMap.put(20,new PersonDetails("Vipin",25,"Rohtang","Male",9322246754L,6730022224L));
        phoneHashMap.put(21,new PersonDetails("Ashish",21,"Chandigarh","Male",777046754L,9111998674L));
        phoneHashMap.put(22,new PersonDetails("Nikita",20,"Delhi","Female",8933486754L,6339843674L));
        phoneHashMap.put(23,new PersonDetails("Amisha",19,"Lucknow","Male",9090546754L,6909098674L));
        phoneHashMap.put(24,new PersonDetails("Minakshi",22,"Chennai","Female",9234324324L,8827872374L));
        phoneHashMap.put(25,new PersonDetails("Aryan",21,"Vellore","Male",7788846754L,6281028090L));

    }

    public void insertHash(int key, PersonDetails details){
        phoneHashMap.put(key,details);
    }

    public PersonDetails findPhoneHashMap(int key){
        if (phoneHashMap.containsKey(key)){
            return phoneHashMap.get(key);
        }else{
            return null;
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
