package useful.Practice;

public class Practice6 {
    public static void main(String[] args) {
        Box<String> b1 = new Box<>();
        b1.setValue("Java");

        Box<Integer> b2 = new Box<>();
        b2.setValue(100);

        System.out.println(b1.getValue());
        System.out.println(b2.getValue());
    }

    static class Box<T> {

        T value;

        public void setValue(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }
    }
}
