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
    public void write_A_B_to_buffer_should_read_A_B() throws Exception {
        CircularBuffer cb = new CircularBuffer();
        cb.writeData("A");
        cb.writeData("B");
        assertEquals("A", cb.readData());
        assertEquals("B", cb.readData());
    }
    @Test
    public void read_data_in_full_buffer_should_make_it_not_full() throws Exception {
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
    public void write_and_read_should_make_buffer_empty() throws Exception {
        CircularBuffer cb = new CircularBuffer();
        cb.writeData("a");
        cb.readData();
        assertTrue(cb.isEmpty());
    }

    @Test
    public void buffer_should_be_able_to_handle_more_than_10() throws Exception {
        CircularBuffer cb = new CircularBuffer();
        for(int i=0;i<10;i++) {
            cb.writeData("A");
            cb.readData();
        }
        cb.writeData("B");
        assertEquals("B",cb.readData());;
    }

    @Test
    public void buffer_that_become_full_again_should_return_full() throws Exception {
        CircularBuffer cb = new CircularBuffer();
        for(int i=0;i<10;i++) {
            cb.writeData("A");

        }
        cb.readData();
        cb.writeData("B");
        assertTrue(cb.isFull());
    }

    @Test
    public void insert_data_in_full_buffer_should_false() {
        CircularBuffer cb = new CircularBuffer();
        for(int i=0;i<10;i++) {
            cb.writeData("A");
        }
        assertFalse(cb.writeData("B"));
    }

    @Test
    public void set_size_should_give_the_same_data() throws Exception {
        CircularBuffer cb = new CircularBuffer();
        for(int i=0;i<10;i++) {
            cb.writeData("A"+i);
        }
        cb.setSize(15);
        assertEquals("A0",cb.readData());
    }

    @Test
    public void set_size_should_be_able_to_handle_more_data() throws Exception {
        CircularBuffer cb = new CircularBuffer();
        for(int i=0;i<10;i++) {
            cb.writeData("A"+i);
        }
        assertFalse(cb.writeData("Z"));
        cb.setSize(15);
        assertTrue(cb.writeData("Z"));
        for(int i=0;i<10;i++) {
            assertEquals("A"+i,cb.readData());
        }
        assertEquals("Z",cb.readData());
        assertTrue(cb.isEmpty());
    }

    @Test(expected = Exception.class)
    public void read_when_empty_should_throw() throws Exception {
        CircularBuffer cb = new CircularBuffer();
        cb.readData();
    }

}