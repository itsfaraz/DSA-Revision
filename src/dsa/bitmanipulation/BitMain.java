package dsa.bitmanipulation;

public class BitMain {
    public static void main(String[] args) {
        int no = -45;
        System.out.println(Integer.toBinaryString(no));
        System.out.println(20|40);
        System.out.println(36&40);
        System.out.println(36^40);
        System.out.println(Integer.toBinaryString(20<<2));
        System.out.println((13<<2));
        System.out.println(13*Math.pow(2,2));

        byte num = 13;
        System.out.println(num<<8);

        System.out.println(100>>2);

    }
}
