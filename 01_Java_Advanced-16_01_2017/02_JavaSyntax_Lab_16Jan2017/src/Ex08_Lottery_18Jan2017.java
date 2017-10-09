import java.util.Locale;

public class Ex08_Lottery_18Jan2017 {
    public static void main(String[] args){
        Locale.setDefault(Locale.ROOT);

        for (int n1 = 1; n1 <= 8 ; n1++) {
            for (int n2 = n1 + 1; n2 <= 9; n2++) {
                for (int n3 = n2 + 1; n3 <= 10; n3++) {
                    System.out.printf("%s %s %s%n", n1, n2, n3);
                }

            }

        }

    }
}




//        //If we look for 6/49 the out for loop must iterate btw
//        // 1 and 44(the first number of the last possible combination)
//        for (int n1 = 1; n1 <= 44; n1++) {
//            for (int n2 = n1 + 1; n2 <= 45; n2++) {
//                for (int n3 = n2 + 1; n3 <= 46 ; n3++) {
//                    for (int n4 = n3 + 1; n4 <= 47; n4++) {
//                        for (int n5 = n4 + 1; n5 <= 48; n5++) {
//                            for (int n6 = n5 + 1; n6 < 49; n6++) {
//                                System.out.printf("%s %s %s %s %s %s%n", n1, n2, n3, n4, n5, n6);
//                            }
//                        }
//                    }
//                }
//            }
//        }
