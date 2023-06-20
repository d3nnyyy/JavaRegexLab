package ua.lviv.iot.algo.part1;

import lombok.NoArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor
public class PhoneNumberReverser {

    public static final Pattern PHONE_NUMBER = Pattern.compile("(\\b\\d{3}(-\\d{2}){2}\\b)|(\\b(\\d{2}-){3}\\d\\b)|(\\b\\d{7}\\b)");

    public final String reversePhoneNumbers(String text) {

        if (text == null || text.trim().isEmpty()) {
            return "";
        }

        Matcher matcher = PHONE_NUMBER.matcher(text);

        StringBuilder stringBuilder = new StringBuilder();

        while (matcher.find()) {

            String phoneNumber = matcher.group();

            String reversedPhoneNumber =
                    new StringBuilder(phoneNumber)
                            .reverse()
                            .toString();
            matcher.appendReplacement(stringBuilder, reversedPhoneNumber);

        }

        matcher.appendTail(stringBuilder);
        return stringBuilder.toString();
    }
}

