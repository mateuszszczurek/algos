package com.structures;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CircularBufferTest {

    private CircularBuffer buffer = new CircularBuffer(SIZE);;

    private  static final int SIZE = 3;

    @Test
    void shouldBeAbleToWriteToBuffer() {
        buffer.write(4);

        int value = buffer.read();

        assertThat(value).isEqualTo(4);
    }

    @Test
    void shouldBeAbleToWriteToFullCapacity() {
        buffer.write(1);
        buffer.write(2);
        buffer.write(3);

        assertThat(buffer.read()).isEqualTo(1);
        assertThat(buffer.read()).isEqualTo(2);
        assertThat(buffer.read()).isEqualTo(3);
    }

    @Test
    void writingOverFullCapacityOverridesOldestEntries() {
        buffer.write(1);
        buffer.write(2);
        buffer.write(3);
        buffer.write(4);
        buffer.write(5);

        assertThat(buffer.read()).isEqualTo(3);
        assertThat(buffer.read()).isEqualTo(4);
        assertThat(buffer.read()).isEqualTo(5);
    }

    @Test
    void readingMoreThanAvailableWillReturnNulls() {
        buffer.write(1);
        buffer.write(2);

        assertThat(buffer.read()).isNotNull();
        assertThat(buffer.read()).isNotNull();
        assertThat(buffer.read()).isNull();
    }

    @Test
    void readingNullThenNewlyAdded() {
        buffer.write(1);
        buffer.write(2);

        assertThat(buffer.read()).isEqualTo(1);
        assertThat(buffer.read()).isEqualTo(2);
        assertThat(buffer.read()).isNull();

        buffer.write(1);

        assertThat(buffer.read()).isEqualTo(1);
    }

}