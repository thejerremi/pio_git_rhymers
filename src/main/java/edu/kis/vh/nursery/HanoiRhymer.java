package edu.kis.vh.nursery;

/**
 * Klasa dostarczająca wyliczankę służącą do przeprowadzania rozrywek skomplikowanych gier całkowito liczbowych.
 * Wyróżnia się tym, że nie jest w niej możliwe zgłoszenie (countIn) liczby większej niż bieżąca (peakaboo)
 */
public class HanoiRhymer extends DefaultCountingOutRhymer {

    private static final int ZERO = 0;
    private int totalRejected = ZERO;


    /**
     * @return zwraca aktualną ilość odrzuconych (niepasujących) liczb
     */
    protected int reportRejected() {
        return totalRejected;
    }

    /**
     * @param in liczba do dodania
     * Funkcja dodaje liczbę in do stosu jeśli jest poprawna bądź zwiększa ilość odrzuconych (niepasujących) liczb
     */
    @Override
    protected void countIn(int in) {
        if (!callCheck() && in > peekaboo())
            totalRejected++;
        else
            super.countIn(in);
    }

    /**
     * @return zwraca aktualną ilość odrzuconych (niepasujących) liczb
     */
    public int getTotalRejected() {
        return totalRejected;
    }

    /**
     * @param totalRejected ilość odrzuconych liczb do ustawienia
     * Funkcja ustawia ilość odrzuconych (niepasujących) liczb na podaną w parametrze totalRejected
     */
    public void setTotalRejected(int totalRejected) {
        this.totalRejected = totalRejected;
    }
}
