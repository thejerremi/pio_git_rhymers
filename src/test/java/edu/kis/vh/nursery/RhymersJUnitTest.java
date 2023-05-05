package edu.kis.vh.nursery;

import org.junit.Assert;
import org.junit.Test;

public class RhymersJUnitTest {

    @Test
    public void testCountIn() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        int testValue = 4;
        rhymer.countIn(testValue);

        int result = rhymer.peekaboo();
        Assert.assertEquals(testValue, result);
    }

    @Test
    public void testCallCheck() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        boolean result = rhymer.callCheck();
        Assert.assertEquals(true, result);

        rhymer.countIn(888);

        result = rhymer.callCheck();
        Assert.assertEquals(false, result);
    }

    @Test
    public void testIsFull() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int STACK_CAPACITY = 12;
        for (int i = 0; i < STACK_CAPACITY; i++) {
            boolean result = rhymer.isFull();
            Assert.assertEquals(false, result);
            rhymer.countIn(888);
        }

        boolean result = rhymer.isFull();
        Assert.assertEquals(true, result);
    }

    @Test
    public void testPeekaboo() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int EMPTY_STACK_VALUE = -1;

        int result = rhymer.peekaboo();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);

        int testValue = 4;
        rhymer.countIn(testValue);

        result = rhymer.peekaboo();
        Assert.assertEquals(testValue, result);
        result = rhymer.peekaboo();
        Assert.assertEquals(testValue, result);
    }

    @Test
    public void testCountOut() {
        DefaultCountingOutRhymer rhymer = new DefaultCountingOutRhymer();
        final int EMPTY_STACK_VALUE = -1;

        int result = rhymer.countOut();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);

        int testValue = 4;
        rhymer.countIn(testValue);

        result = rhymer.countOut();
        Assert.assertEquals(testValue, result);
        result = rhymer.countOut();
        Assert.assertEquals(EMPTY_STACK_VALUE, result);
    }


    @Test
    public void testHanoiReportRejected(){
        HanoiRhymer rhymer = new HanoiRhymer();
        final int ZERO = 0;

        int result = rhymer.reportRejected();
        Assert.assertEquals(ZERO, result);
    }

    @Test
    public void testHanoiGetAndSetTotalRejected(){
        HanoiRhymer rhymer = new HanoiRhymer();
        final int testRejected = 1234;

        rhymer.setTotalRejected(testRejected);

        int result = rhymer.getTotalRejected();
        Assert.assertEquals(testRejected, result);
    }

    @Test
    public void testHanoiCountIn(){
        HanoiRhymer rhymer = new HanoiRhymer();
        rhymer.countIn(3);
        rhymer.countIn(2);
        rhymer.countIn(1);

        Assert.assertEquals(0,rhymer.getTotalRejected());

        final int actualNumber = rhymer.peekaboo();
        rhymer.countIn(10);
        Assert.assertEquals(actualNumber, rhymer.peekaboo());
        Assert.assertEquals(1, rhymer.getTotalRejected());
    }
}
