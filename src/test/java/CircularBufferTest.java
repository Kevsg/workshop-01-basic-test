import org.junit.Test;

import static org.junit.Assert.*;

public class CircularBufferTest {
    @Test
    public void create_new_buffer_should_empty() {
        CircularBuffer cb = new CircularBuffer();
        boolean result = cb.isEmpty();
        assertTrue("Buffer is not empty",result);
    }
    @Test
    public void create_new_buffer_with_default_size_should_10() {
        CircularBuffer cb = new CircularBuffer();
        for(int i=0;i<10;i++) {
            cb.writeData("A");
        }
        boolean result = cb.isFull();
        assertTrue("Buffer is not full",result);
    }
    @Test
    public void write_A_B_to_buffer_should_read_A_B() {
        CircularBuffer cb = new CircularBuffer();
        cb.writeData("A");
        cb.writeData("B");
        assertEquals("A", cb.readData());
        assertEquals("B", cb.readData());
    }
    @Test
    public void read_data_in_full_buffer_should_make_it_not_full() {
        CircularBuffer cb = new CircularBuffer();
        for(int i=0;i<10;i++) {
            cb.writeData("A");
        }
        boolean result = cb.isFull();
        assertTrue("Buffer is not full",result);
        cb.readData();
        result = cb.isFull();
        assertFalse("Buffer is full",result);
    }

    @Test
    public void write_and_read_should_make_buffer_empty() {
        CircularBuffer cb = new CircularBuffer();
        cb.writeData("a");
        cb.readData();
        assertTrue(cb.isEmpty());
    }

    @Test
    public void buffer_should_be_able_to_handle_more_than_10() {
        CircularBuffer cb = new CircularBuffer();
        for(int i=0;i<10;i++) {
            cb.writeData("A");
            cb.readData();
        }
        cb.writeData("B");
        assertEquals("B",cb.readData());;
    }
}