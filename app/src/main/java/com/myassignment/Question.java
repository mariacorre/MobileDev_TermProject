package com.myassignment;

public class Question {

    public String questions[] = {
            "Which of the following virtual machine is used by the Android operating system?",
            "Android is based on which of the following language?",
            "APK stands for-?"
    };

    public String choices[][] = {
            {"JVM", "Dalvik virtual machine", "None of the above"},
            {"Java", "C++", "C"},
            {"Android Package Kit", "Android Page Kit", "Android Phone Kit"}
    };

    public String correctAnswer[] = {
            "Dalvik virtual machine",
            "Java",
            "Android Package Kit"
    };

    public String getQuestion(int a){
        String question = questions[a];
        return question;
    }

    public String getchoice1(int a){
        String choice = choices[a][0];
        return choice;
    }

    public String getchoice2(int a){
        String choice = choices[a][1];
        return choice;
    }

    public String getchoice3(int a){
        String choice = choices[a][2];
        return choice;
    }

//    public String getchoice4(int a){
//        String choice = choices[a][3];
//        return choice;
//    }

    public String getCorrectAnswer(int a){
        String answer = correctAnswer[a];
        return answer;
    }
}
