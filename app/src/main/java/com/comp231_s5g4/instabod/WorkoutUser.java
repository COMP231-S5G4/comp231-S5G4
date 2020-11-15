package com.comp231_s5g4.instabod;

public class WorkoutUser {

    //Workout User private fields
    private int userName;
    private String password;
    private int age;
    private String gender;
    private String securityQ1;
    private String securityA1;
    private String securityQ2;
    private String securityA2;
    private double height;
    private double waistCircumference;
    private double rfm;
    private int pushUpScore;
    private int sitUpScore;
    private int frequencyOfExercise;

    public WorkoutUser(){

    }

    public WorkoutUser(int userName, String password, int age, String gender, String securityQ1, String securityA1, String securityQ2, String securityA2, double height, double waistCircumference, double rfm, int pushUpScore, int sitUpScore, int frequencyOfExercise) {
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.gender = gender;
        this.securityQ1 = securityQ1;
        this.securityA1 = securityA1;
        this.securityQ2 = securityQ2;
        this.securityA2 = securityA2;
        this.height = height;
        this.waistCircumference = waistCircumference;
        this.rfm = rfm;
        this.pushUpScore = pushUpScore;
        this.sitUpScore = sitUpScore;
        this.frequencyOfExercise = frequencyOfExercise;
    }

    public int getUserName() {
        return userName;
    }

    public void setUserName(int userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSecurityQ1() {
        return securityQ1;
    }

    public void setSecurityQ1(String securityQ1) {
        this.securityQ1 = securityQ1;
    }

    public String getSecurityA1() {
        return securityA1;
    }

    public void setSecurityA1(String securityA1) {
        this.securityA1 = securityA1;
    }

    public String getSecurityQ2() {
        return securityQ2;
    }

    public void setSecurityQ2(String securityQ2) {
        this.securityQ2 = securityQ2;
    }

    public String getSecurityA2() {
        return securityA2;
    }

    public void setSecurityA2(String securityA2) {
        this.securityA2 = securityA2;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWaistCircumference() {
        return waistCircumference;
    }

    public void setWaistCircumference(double waistCircumference) {
        this.waistCircumference = waistCircumference;
    }

    public double getRfm() {
        return rfm;
    }

    public void setRfm(double rfm) {
        this.rfm = rfm;
    }

    public int getPushUpScore() {
        return pushUpScore;
    }

    public void setPushUpScore(int pushUpScore) {
        this.pushUpScore = pushUpScore;
    }

    public int getSitUpScore() {
        return sitUpScore;
    }

    public void setSitUpScore(int sitUpScore) {
        this.sitUpScore = sitUpScore;
    }

    public int getFrequencyOfExercise() {
        return frequencyOfExercise;
    }

    public void setFrequencyOfExercise(int frequencyOfExercise) {
        this.frequencyOfExercise = frequencyOfExercise;
    }

    public static int convertUsernameToUniqueId(String username)
    {
        int i=0;
        int uniqueId = 1;
        String[] input = new String[35];
        String inputString = username;
        char[] inputChar = inputString.toCharArray();
        for(char a = 'A' ; a<='Z' ; a++ ){
            i++;
            input[i-1] = a+":"+i;
        }
        for(char b = '1';b<='9';b++){
            i++;
            input[i-1] = String.valueOf(b)+":"+i;
        }

        for(int k=0;k<inputChar.length;k++){
            for(int j = 0;j<input.length;j++){
                if(input[j].charAt(0)==inputChar[k]){

                    uniqueId*=Integer.parseInt(input[j].substring(input[j].indexOf(':')+1,input[j].length()));
                }
            }
        }
        return uniqueId;
    }
}
