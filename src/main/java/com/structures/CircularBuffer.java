package com.structures;

public class CircularBuffer {

    private int writePosition;
    private int readPosition;
    private final Integer[] buffer;

    public CircularBuffer(int size) {
        this.buffer = new Integer[size];
    }

    public void write(Integer value) {
        if (buffer[writePosition] != null && writePosition == readPosition) {
            readPosition++;
        }

        buffer[writePosition] = value;

        if (++writePosition >= buffer.length) {
            writePosition = 0;
        }
    }

    public Integer read() {
        if (buffer[readPosition] == null) {
            return null;
        }
        Integer value = buffer[readPosition];
        buffer[readPosition] = null;
        if (++readPosition >= buffer.length) {
            readPosition = 0;
        }
        return value;
    }

}
