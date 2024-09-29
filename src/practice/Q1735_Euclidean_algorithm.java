package practice;

import java.util.Scanner;

public class Q1735_Euclidean_algorithm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 첫 번째 분수 입력
        int a1 = scanner.nextInt();
        int b1 = scanner.nextInt();

        // 두 번째 분수 입력
        int a2 = scanner.nextInt();
        int b2 = scanner.nextInt();

        // 분수의 합 계산
        int numerator = a1 * b2 + a2 * b1; // 분자
        int denominator = b1 * b2; // 분모

        // 최대공약수(GCD) 구하기
        int gcd = gcd(numerator, denominator);

        // 기약분수 형태로 출력
        System.out.println((numerator / gcd) + " " + (denominator / gcd));

        scanner.close();
    }

    // 유클리드 호제법으로 GCD 계산
    private static int gcd(int a, int b) {

        while (b != 0) {
            System.out.println(a+" "+b);
            int temp = b;
            System.out.println("temp: "+temp);
            b = a % b;
            a = temp;
        }
        return a;
    }
}