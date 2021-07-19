package com.project.projectspecialsemester;

public class PersonDetails {
    //Common details
    String name, address,gender;
    int age;

    //For phone number
    long phone1, phone2;

    //For aadhaar number
    long aadhaarNumber;

    //For bank accounts
    long bankNumber;
    String expirationDate;
    String nameOnCard;
    int CVVNumber;

    //Contructor for phone directory
    public PersonDetails(String name, int age, String address, String gender, long phone1, long phone2){
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.age = age;
        this.phone1 = phone1;
        this.phone2 = phone2;
    }

    public PersonDetails(String name, int age, String address, String gender, long aadhaarNumber){
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.age = age;
        this.aadhaarNumber = aadhaarNumber;
    }

    public PersonDetails(String name, int age, String address, String gender, long bankNumber, String expirationDate, String nameOfCard, int CVVNumber){
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.age = age;
        this.bankNumber = bankNumber;
        this.expirationDate = expirationDate;
        this.nameOnCard = nameOfCard;
        this.CVVNumber = CVVNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPhone1() {
        return phone1;
    }

    public void setPhone1(long phone1) {
        this.phone1 = phone1;
    }

    public long getPhone2() {
        return phone2;
    }

    public void setPhone2(long phone2) {
        this.phone2 = phone2;
    }

    public long getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber(long aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }

    public long getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(long bankNumber) {
        this.bankNumber = bankNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public int getCVVNumber() {
        return CVVNumber;
    }

    public void setCVVNumber(int CVVNumber) {
        this.CVVNumber = CVVNumber;
    }
}
