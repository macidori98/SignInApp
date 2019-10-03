package com.example.signinapp;

public class MyCounterClass {
    public static int signInPageToReg, signInPageToProf, registrationPageToSigin, registrationPageToProf,
            profilePageToReg, profilePageToSigin;

    MyCounterClass(){
        signInPageToProf = signInPageToReg  = profilePageToReg = registrationPageToSigin
                = profilePageToSigin = registrationPageToProf = 0;
    }

    public static int getSignInPageToReg() {
        return signInPageToReg;
    }

    public static void setSignInPageToReg() {
        MyCounterClass.signInPageToReg = signInPageToReg+1;
    }

    public static int getSignInPageToProf() {
        return signInPageToProf;
    }

    public static void setSignInPageToProf() {
        MyCounterClass.signInPageToProf = signInPageToProf+1;
    }

    public static int getRegistrationPageToSigin() {
        return registrationPageToSigin;
    }

    public static void setRegistrationPageToSigin() {
        MyCounterClass.registrationPageToSigin = registrationPageToSigin+1;
    }

    public static int getRegistrationPageToProf() {
        return registrationPageToProf;
    }

    public static void setRegistrationPageToProf() {
        registrationPageToProf = registrationPageToProf +1;
    }

    public static int getProfilePageToReg() {
        return profilePageToReg;
    }

    public static void setProfilePageToReg() {
        MyCounterClass.profilePageToReg = profilePageToReg+1;
    }

    public static int getProfilePageToSigin() {
        return profilePageToSigin;
    }

    public static void setProfilePageToSigin() {
        MyCounterClass.profilePageToSigin = profilePageToSigin+1;
    }
}
