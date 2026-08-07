package useful.ch03;

public class StringTextBlock2 {
    public static void main(String[] args) {
        String textBlock = """
                나무위키는 umanle S.R.L.이 운영 중인 the seed 엔진 기반의 한국어 위키이며, 
                2015년 4월 17일에 리그베다 위키(구 엔하위키)의 데이터베이스를 기반으로 설립되었다.
            """;
        changeText(textBlock);
    }

    // String API 확인해서 나무위키 단어를 다른 단어로 변경하는 함수를 만들어주세요.
    public static void changeText(String str){
        String result1 = str.replace("위키", "wiki");
        System.out.println(result1);
    }

}
