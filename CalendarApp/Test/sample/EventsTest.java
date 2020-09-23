package sample;

import org.junit.Before;
import org.junit.Test;

import javax.management.MXBean;
import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;


public class EventsTest {
    //sets a specific date object in the LocalDate class for the sake of testing
    private final static LocalDate date = LocalDate.of(2020, 9, 30);

    @Before
    public void setUp() throws Exception {
        Events event = new Events(date, "Event", "Info", "Importance");
    }

    //some simple test to make sure that the getters for the Events class are working properly
    @Test
    public void getInfo() {
        Events events = new Events(date, "Event", "Info", "Importance");
        String output ="Info";
        assertEquals(output, events.getInfo());
    }

    @Test
    public void getImportance() {
        Events events = new Events(date, "Event", "Info", "Importance");
        String output = "Importance";
        assertEquals(output, events.getImportance());
    }

    @Test
    public void testToString() {
        Events events = new Events(date, "Event", "Info", "Importance");
        String output = "Event";
        assertEquals(output, events.toString());
    }

    @Test
    public void testGetDate() {
        Events events = new Events(date, "Event", "Info", "Importance");
        String output = "2020-09-30";
        assertEquals(output, events.getDate().toString());
    }
}