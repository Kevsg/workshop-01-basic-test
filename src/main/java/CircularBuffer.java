public class CircularBuffer {

    private int bufferSize = 11;
    private String[] buffer;
    private int readPointer = 0;
    private int writePointer = 0;

    public CircularBuffer() {
        this.buffer = new String[11];
    }

    public boolean isEmpty() {
        return readPointer == writePointer;
    }

    public void writeData(String input) {
        this.buffer[writePointer] = input;
        incrementWritePointer();
    }

    public boolean isFull() {
        return decrementPointer(readPointer) == writePointer;
    }

    public String readData() {
        String s =  this.buffer[readPointer];
        incrementReadPointer();
        return s;
    }

    private void incrementReadPointer() {
        readPointer = (readPointer + 1) % bufferSize;
    }

    private void incrementWritePointer() {
        writePointer = (writePointer + 1) % bufferSize;
    }

    private int decrementPointer(int pointer) {
        return (pointer + bufferSize - 1) % bufferSize;
    }

}
