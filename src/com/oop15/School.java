package com.oop15;

public class School {

    private String schoolName;
    private Student[] students;
    private int count;

    public School(String schoolName, int size) {
        this.schoolName = schoolName;
        this.students = new Student[size];
        this.count = 0;
    }

    public void addStudents(String student){
        if(student !=null && count < students.length){

            count++;
            System.out.println("학생을 추가합니다.");
        }else{
            System.out.println("학생을 추가할 수 없습니다.");
        }
    }

    boolean target = false;

    public void removeStudent(Student student){
        for(int i=0;i<students.length;i++){
            if(student !=null && students[i].equals(target)){
                for(int j =i; j<count-1;j++){
                    students[j] = students[j+1];
                }
                students[i-1] = null;
                count--;
                System.out.println("학생을 삭제합니다.");
                return;
            }
        }
    }

    public void showStudents(){
        System.out.println("학교명: " + schoolName);
        for(int i=0; i<count; i++){
            students[i].showInfo();
        }
    }


}
