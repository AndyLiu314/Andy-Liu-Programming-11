package sample;

import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class AlarmTest {

    private final static long delay = 2;

    @Test
    //sets a test alarm for 2 seconds
    public void testToString() {
        Alarm alm=new Alarm(delay);
        //matches the output with the alarm set for 2 seconds to test alarm
        String output ="Remind me after " + delay + " seconds.";
        assertEquals(output, alm.toString());
    }
}