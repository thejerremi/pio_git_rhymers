package edu.kis.vh.nursery;

public class HanoiRhymer extends DefaultCountingOutRhymer {

    protected static final int ZERO = 0;
    int totalRejected = ZERO;

    protected int reportRejected() {
        return totalRejected;
    }
    @Override
    protected void countIn(int in) {
        if (!callCheck() && in > peekaboo())
            totalRejected++;
        else
            super.countIn(in);
    }
}
