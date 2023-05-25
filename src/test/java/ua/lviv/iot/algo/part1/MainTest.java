package ua.lviv.iot.algo.part1;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MainTest {

    private Main obj;
    private String text;

    @Before
    public void setUp() {
        text="";
        obj = new Main(text);
    }

    @Test
    public void emptyText() {

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        obj.replacePhoneNumbers();
        assertEquals("Error: text can't be empty.", outContent.toString().trim());
    }

    @Test
    public void textWithNoNumbers() {
        this.text = "hello";
        obj = new Main(text);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        obj.replacePhoneNumbers();

        assertEquals(text, outContent.toString().trim());
    }

    @Test
    public void textWithFirstPattern() {
        this.text = "My number is 123-45-67";
        obj = new Main(text);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        obj.replacePhoneNumbers();

        assertEquals("My number is 76-54-321", outContent.toString().trim());
    }

    @Test
    public void textWithSecondPattern() {
        this.text = "My number is 12-34-56-7";
        obj = new Main(text);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        obj.replacePhoneNumbers();

        assertEquals("My number is 7-65-43-21", outContent.toString().trim());
    }

    @Test
    public void textWithThirdPattern() {
        this.text = "My number is 1234567";
        obj = new Main(text);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        obj.replacePhoneNumbers();

        assertEquals("My number is 7654321", outContent.toString().trim());
    }

    @Test
    public void textWithWrongPattern() {
        this.text = "My numbers are 123-123-123, 45-45-45-45-45, 123456 and 123-45-671";
        obj = new Main(text);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        obj.replacePhoneNumbers();

        assertEquals("My numbers are 123-123-123, 45-45-45-45-45, 123456 and 123-45-671", outContent.toString().trim());
    }
}