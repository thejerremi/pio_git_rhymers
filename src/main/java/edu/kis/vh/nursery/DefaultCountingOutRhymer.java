package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    public static final int TWELVE = 12;
    public static final int NEGATIVE_ONE = -1;
    public static final int ELEVEN = 11;
    public int total = NEGATIVE_ONE;
    private final int[] NUMBERS = new int[TWELVE];

    public void countIn(int in) {
        if (!isFull())
            NUMBERS[++total] = in;
    }

    public boolean callCheck() {
        return total == NEGATIVE_ONE;
    }

    public boolean isFull() {
        return total == ELEVEN;
    }

    protected int peekaboo() {
        if (callCheck())
            return NEGATIVE_ONE;
        return NUMBERS[total];
    }

    public int countOut() {
        if (callCheck())
            return NEGATIVE_ONE;
        return NUMBERS[total--];
    }

}
