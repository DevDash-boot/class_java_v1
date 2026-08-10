package useful.ch14;

public class HashTableTest {
    public static void main(String[] args) {

        String[] names = {"사과", "바나나", "포도", "딸기", "수박"};
        for (String n : names) {
            System.out.println(n + "->" + n.hashCode());
        }
        System.out.println("--------------");
        System.out.println("사과".hashCode());    // 똑같은 데이터를 넣으면 똑같은 결과를 반환
    }
}
