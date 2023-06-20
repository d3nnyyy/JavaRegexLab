package ua.lviv.iot.algo.part1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PhoneNumberReverserTest {

    private PhoneNumberReverser numberReverser = new PhoneNumberReverser();
    private String text;
    private String actual;

    @Test
    public void emptyText() {
        text = "   ";

        actual = numberReverser.reversePhoneNumbers(text);
        assertEquals("", actual);
    }

    @Test
    public void textWithNoNumbers() {
        this.text = "hello";

        actual = numberReverser.reversePhoneNumbers(text);
        assertEquals(text, actual);
    }

    @Test
    public void textWithFirstPattern() {
        this.text = "My number is 123-45-67";

        actual = numberReverser.reversePhoneNumbers(text);
        assertEquals("My number is 76-54-321", actual);
    }

    @Test
    public void textWithSecondPattern() {
        this.text = "My number is 12-34-56-7";

        actual = numberReverser.reversePhoneNumbers(text);
        assertEquals("My number is 7-65-43-21", actual);
    }

    @Test
    public void textWithThirdPattern() {
        this.text = "My number is 1234567";

        actual = numberReverser.reversePhoneNumbers(text);
        assertEquals("My number is 7654321", actual);
    }

    @Test
    public void textWithWrongPattern() {
        this.text = "My numbers are 123-123-123, 45-45-45-45-45, 123456 and 123-45-671";

        actual = numberReverser.reversePhoneNumbers(text);
        assertEquals("My numbers are 123-123-123, 45-45-45-45-45, 123456 and 123-45-671", actual);
    }
}