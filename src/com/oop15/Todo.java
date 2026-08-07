package com.oop15;

public class Todo {

    private String content;
    // boolean의 필드명에 관례상 is를 붙이지 않는다.
    private boolean completed;

    // 생성자
    public Todo(String content) {
        this.content = content;
    }

    // getter
    public String getContent() {
        return content;
    }

    // getter의 boolean 타입은 관례상 is로 만들어 준다.
    public boolean isCompleted() {
        return completed;
    }

    // setter - 단순히 상태값만 변경하는 메서드를 set으로 만들어준다.
    // set에서는 if를 사용하지 않고 set으로 이름을 만들어준다.
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // 각각의 객체에 대해 완료, 미완료
    public void showInfo() {
        String status;
        if (completed == true) {
            status = "[완료]";
        } else {
            status = "[미완료]";
        }
        System.out.println("할 일 내용: " + content + ", " + status);
    }
}

