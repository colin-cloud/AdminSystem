package com.wqf.extend.exercise;

public class ExtendsExercise01 {

    public static void main(String[] args) {

        PC pc = new PC("CPU1", "memory1", "hardDisk1", "brand1");
        NotePad notePad = new NotePad("CPU2", "memory2", "hardDisk2", "白色");
        pc.showInfo();
        notePad.showInfo();
    }
}
