package edu.kis.vh.nursery;

public class DefaultCountingOutRhymer {

    public static final int twelve = 12;
    public static final int negativeOne = -1;
    public static final int eleven = 11;
    public int total = negativeOne;
    private int[] NUMBERS = new int[twelve];

    public void countIn(int in) {
        if (!isFull())
            NUMBERS[++total] = in;
    }

    public boolean callCheck() {
        return total == negativeOne;
    }

    public boolean isFull() {
        return total == eleven;
    }

    protected int peekaboo() {
        if (callCheck())
            return negativeOne;
        return NUMBERS[total];
    }

    public int countOut() {
        if (callCheck())
            return negativeOne;
        return NUMBERS[total--];
    }

}
