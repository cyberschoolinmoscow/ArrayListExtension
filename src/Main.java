public class Main {
    public static void main(String[] args) {
        A arr = new A();
        arr.add(2); arr.add(1);
        arr.add(5);
        arr.add(3);
        arr.add(7);
        arr.add(3);
        for (Integer k : arr) {
            System.out.println(k);
        }
        //3 2 1
    }
}