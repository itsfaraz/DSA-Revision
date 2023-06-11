package dsa.patterns;

public class Main {
    public static void main(String[] args) {

        for (int p = 1; p <= 33;p++){
            Pattern pattern = getInstance(p);
            if (pattern != null){
                pattern.pattern(10);
                System.out.println("\n--------------------------------------------------\n");
            }
        }
    }

    public static Pattern getInstance(int serial){
        switch(serial){
            case 1 : return new Pattern1();
            case 2 : return new Pattern2();
            case 3 : return new Pattern3();
            case 4 : return new Pattern4();
            case 5 : return new Pattern5();
            case 6 : return new Pattern6();
            case 7 : return new Pattern7();
            case 8 : return new Pattern8();
            case 9 : return new Pattern9();
            case 10 : return new Pattern10();
            case 11 : return new Pattern11();
            case 12 : return new Pattern12();
            case 13 : return new Pattern13();
            case 14 : return new Pattern14();
            case 15 : return new Pattern15();
            case 16 : return new Pattern16();
            case 17 : return new Pattern17();
            case 18 : return new Pattern18();
            case 19 : return new Pattern19();
            case 20 : return new Pattern20();
            case 21 : return new Pattern21();
            case 22 : return new Pattern22();
            case 23 : return new Pattern23();
            case 24 : return new Pattern24();
            case 25 : return new Pattern25();
            case 26 : return new Pattern26();
            case 27 : return new Pattern27();
            case 28 : return new Pattern28();
            case 29 : return new Pattern29();
            case 30 : return new Pattern30();
            case 31 : return new Pattern31();
            case 32 : return new Pattern32();
            case 33 : return new Pattern33();
            default : return null;
        }
    }
}

