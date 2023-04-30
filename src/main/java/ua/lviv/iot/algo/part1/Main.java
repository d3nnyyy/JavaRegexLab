package ua.lviv.iot.algo.part1;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private final String text;

    public Main(final String text) {
        this.text = text;
    }

    public final void replacePhoneNumbers() {

        if (text == null || text.trim().isEmpty()) {
            System.out.println("Error: text can't be empty.");
            return;
        }

//        String regex = "\\b\\d{2,3}-\\d{2,3}-\\d{2,3}-?\\d?\\b|\\b\\d{7}\\b";
        String regex = "\\b\\d{3}-\\d{2}-\\d{2}\\b|\\b\\d{2}-\\d{2}-\\d{2}-\\d\\b|\\b\\d{7}\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);

        StringBuilder sb = new StringBuilder();

        while (matcher.find()) {

            String phoneNumber = matcher.group();

            String reversedPhoneNumber =
                    new StringBuilder(phoneNumber)
                            .reverse()
                            .toString();
            matcher.appendReplacement(sb, reversedPhoneNumber);

//            String phoneNumberReplaced = phoneNumber.replace("-", "");
//
//            String reversedPhoneNumber =
//                    new StringBuilder(phoneNumberReplaced)
//                            .reverse()
//                            .toString();
//
//            //XX-XX-XX-X
//            String subPattern1 = "\\d{2}-\\d{2}-\\d{2}-\\d";
//            if (phoneNumber.matches(subPattern1)) {
//                String formattedPhoneNumber = reversedPhoneNumber.charAt(0)
//                        + "-"
//                        + reversedPhoneNumber.substring(1, 3)
//                        + "-"
//                        + reversedPhoneNumber.substring(3, 5)
//                        + "-"
//                        + reversedPhoneNumber.substring(5);
//                matcher.appendReplacement(sb, formattedPhoneNumber);
//            }
//
//            //XXX-XX-XX
//            String subPattern2 = "\\d{3}-\\d{2}-\\d{2}";
//            if (phoneNumber.matches(subPattern2)) {
//                String formattedPhoneNumber = reversedPhoneNumber.substring(0, 2)
//                        + "-"
//                        + reversedPhoneNumber.substring(2, 4)
//                        + "-"
//                        + reversedPhoneNumber.substring(4);
//                matcher.appendReplacement(sb, formattedPhoneNumber);
//            }
//
//            //XXXXXXX
//            String subPattern3 = "\\d{7}";
//            if (phoneNumber.matches(subPattern3)) {
//                matcher.appendReplacement(sb, reversedPhoneNumber);
//            }

        }

        matcher.appendTail(sb);
        String result = sb.toString();
        System.out.println(result);
    }

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in, "UTF-8");
//        System.out.println("Enter the text: ");
//
//        String text = scanner.nextLine();
//        Main obj = new Main(text);
//        obj.replacePhoneNumbers();
//
//        scanner.close();
//    }
}