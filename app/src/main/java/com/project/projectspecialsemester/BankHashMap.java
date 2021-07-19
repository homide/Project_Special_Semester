package com.project.projectspecialsemester;

import java.util.HashMap;

public class BankHashMap {
    HashMap<String, PersonDetails> BankHashMap;

    public BankHashMap(){
        BankHashMap = new HashMap<>();
    }

    public void insertBankHashMap(){
        BankHashMap.put("Kanishk",new PersonDetails("Kanishk", 20,"Noida", "Male",123456789011L));
    }

    public PersonDetails findBankHashMap(String key){
        if (BankHashMap.containsKey(key)){
            PersonDetails details = BankHashMap.get(key);
            return details;
        }else{
            return null;
        }
    }

    public boolean deleteBankHashMap(String key){
        if (BankHashMap.containsKey(key)){
            BankHashMap.remove(key);
            return true;
        }else{
            return false;
        }
    }

    public boolean updateBankHashMap(String key, PersonDetails newDetails){
        if (BankHashMap.containsKey(key)){
            BankHashMap.put(key, newDetails);
            return true;
        }else{
            return false;
        }
    }

    public HashMap<String, PersonDetails> getBankHashMap(){
        return BankHashMap;
    }


}