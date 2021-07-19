package com.project.projectspecialsemester;

import java.util.HashMap;

public class BankHashMap {
    HashMap<Integer, PersonDetails> BankHashMap;

    public BankHashMap(){
        BankHashMap = new HashMap<>();
    }

    public void insertBankHashMap(){
        BankHashMap.put(1,new PersonDetails("Kanishk", 20,"Noida", "Male",123456789111L,"19/7/2022",123));
    }

    public PersonDetails findBankHashMap(int key){
        if (BankHashMap.containsKey(key)){
            PersonDetails details = BankHashMap.get(key);
            return details;
        }else{
            return null;
        }
    }

    public boolean deleteBankHashMap(int key){
        if (BankHashMap.containsKey(key)){
            BankHashMap.remove(key);
            return true;
        }else{
            return false;
        }
    }

    public boolean updateBankHashMap(int key, PersonDetails newDetails){
        if (BankHashMap.containsKey(key)){
            BankHashMap.put(key, newDetails);
            return true;
        }else{
            return false;
        }
    }

    public HashMap<Integer, PersonDetails> getBankHashMap(){
        return BankHashMap;
    }


}