package http.ch03;

import lombok.Data;

// JSON 의 키 이름과 자바 필드 이름을 맞춰서 설계합니다
// {"userId":1, "id":1, "title":"...", "completed":false}

@Data
public class Todo {
    private int     userId;     // "userId"
    private int     id;         // "id"
    private String  title;      // "title"
    private boolean completed;  // "completed"
}