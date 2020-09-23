package sample;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class ControllerHelperTest {
    private final static LocalDate date = LocalDate.of(2020, 9, 30);

    @Test
    public void findDate() {
        //tests the find date method
        ControllerHelper ch=new ControllerHelper(date);
        String output ="2020-09-30";
        assertEquals(output, ch.FindDate());

    }
}