package com.MobileDevTermProj;

public class Question {
    private int id;
    private String question;
    private String answer;
    private String choice1;
    private String choice2;
    private String choice3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

//    public String questions[] = {
//            "Which of the following virtual machine is used by the Android operating system?",
//            "Android is based on which of the following language?",
//            "APK stands for-?"
//    };
//
//    public String choices[][] = {
//            {"JVM", "Dalvik virtual machine", "None of the above"},
//            {"Java", "C++", "C"},
//            {"Android Package Kit", "Android Page Kit", "Android Phone Kit"}
//    };
//
//    public String correctAnswer[] = {
//            "Dalvik virtual machine",
//            "Java",
//            "Android Package Kit"
//    };
//
//    public String getQuestion(int a){
//        String question = questions[a];
//        return question;
//    }
//
//    public String getchoice1(int a){
//        String choice = choices[a][0];
//        return choice;
//    }
//
//    public String getchoice2(int a){
//        String choice = choices[a][1];
//        return choice;
//    }
//
//    public String getchoice3(int a){
//        String choice = choices[a][2];
//        return choice;
//    }
//
////    public String getchoice4(int a){
////        String choice = choices[a][3];
////        return choice;
////    }
//
//    public String getCorrectAnswer(int a){
//        String answer = correctAnswer[a];
//        return answer;
//    }
}
