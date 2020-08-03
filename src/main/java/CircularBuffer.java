public class CircularBuffer {

    private String[] buffer;
    private int readPointer = 0;
    private int writePointer = 0;

    public CircularBuffer() {
        this.buffer = new String[11];
    }

    public boolean isEmpty() {
        return readPointer == writePointer;
    }

    public boolean writeData(String input) {
        if(isFull()) {
            return false;
        }
        this.buffer[writePointer] = input;
        incrementWritePointer();
        return true;
    }

    public boolean isFull() {
        return decrementPointer(readPointer) == writePointer;
    }

    public String readData() throws Exception {
        if(isEmpty()) {
            throw new Exception("No data in buffer");
        }
        String s =  this.buffer[readPointer];
        incrementReadPointer();
        return s;
    }

    private void incrementReadPointer() {
        readPointer = (readPointer + 1) % buffer.length;
    }

    private void incrementWritePointer() {
        writePointer = (writePointer + 1) % buffer.length;
    }

    private int decrementPointer(int pointer) {
        return (pointer + buffer.length - 1) % buffer.length;
    }

    public void setSize(int i) {
        String[] newBuffer = new String[i+1];
        for(i =0 ;i<buffer.length;i++) {
            newBuffer[i] = buffer[i];
        }
        buffer = newBuffer;
    }
}
