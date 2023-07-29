package com.example.quizapp;

public class QuesAns {
    public static String question[] = {
            "Which company owns the android ? ",
            "Which one is not the Programming Language ? ",
            "What is the range of values that can be stored by int datatype in C ? ",
            "How is an array initialized in Java language ? ",
            "How is the 3rd element in an array accessed based on pointer notation ? ",
            "For which of the following Android is mainly developed ?",
            "APK stands for -",
            "What does API stand for ?",
            "Which of the following converts Java byte code into Dalvik byte code ?",
            "Does android support other languages than java ?"
    };

    public static String choices[][] = {
            {"Google", "Apple", "Nokia", "Samsung"},
            {"Java", "Python", "HTML", "Kotlin"},
            {"-(2^31) to (2^31) - 1", "-256 to 255", "-(2^63) to (2^63) - 1", "0 to (2^31) - 1"},
            {"int a[3] = [1,2,3];", "int a = {1,2,3};", "int a[] = new int[3];", "int a(3) = [1,2,3];"},
            {"*a + 3", "*(a + 3)", "*(*a + 3)", "&(a + 3)"},
            {"Servers", "Desktops", "Laptops", "Mobile devices"},
            {"Android Phone Kit", "Android Page Kit", "Android Package Kit", "None of the above"},
            {"Application Programming Interface", "Android Programming Interface", "Android Page Interface", "Application Page Interface"},
            {"Dalvik converter", "Dex compiler", "Mobile interpretive compiler (MIC)", "None of the above"},
            {"Yes", "No", "May be", "Can't say"}
    };

    public static String ans[] = {
            "Google", "HTML", "-(2^31) to (2^31) - 1", "int a[] = new int[3];", "*(a + 3)",
            "Mobile devices", "Android Page Kit", "Application Programming Interface",
            "Dex compiler", "Yes"
    };
}
