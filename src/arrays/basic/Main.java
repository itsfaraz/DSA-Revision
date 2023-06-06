package arrays.basic;

public class Main {
    public static void main(String[] args) {
        Basic basic = new Basic();
        basic.takeInput(6);
        basic.display();
        System.out.println(basic.max());
        System.out.println(basic.find(9));
        System.out.println(basic.search(22));
        System.out.println("Rotate 1");
        basic.rotate(2);
        basic.display();
        basic.sort();
        System.out.println("Rotate 2");
        basic.rotateEnhanced(2);
        basic.display();
        basic.reverse();
    }
}
