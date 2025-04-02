package edu.kis.vh.nursery;

/**
 * Klasa FIFORhymer rozszerza klasę defaultCountingOutRhymer.
 * Implementuje metodę countOut, która realizuje operację wyciągania elementu
 * z kolejki FIFO, przy pomocy dodatkowego obiektu tymczasowego.
 *
 * @see defaultCountingOutRhymer
 */
public class FIFORhymer extends defaultCountingOutRhymer {

    /**
     * Tymczasowy obiekt typu defaultCountingOutRhymer wykorzystywany do przechowywania
     * elementów podczas operacji wyciągania elementu z głównego obiektu.
     */
    public defaultCountingOutRhymer temp = new defaultCountingOutRhymer();

    /**
     * Zlicza i zwraca element w kolejności FIFO (First In First Out).
     * Wykorzystuje tymczasowy obiekt do przechowywania elementów,
     * zanim zostaną one ponownie umieszczone w głównym obiekcie.
     *
     * @return Wartość elementu wyciągniętego z kolejki FIFO.
     */
    @Override
    public int countOut() {
        // Przenosimy elementy do tymczasowego obiektu, dopóki główny obiekt nie jest pusty.
        while (!callCheck()) {
            temp.countIn(super.countOut());
        }

        // Zapisujemy element z tymczasowego obiektu.
        int ret = temp.countOut();

        // Przenosimy elementy z powrotem do głównego obiektu.
        while (!temp.callCheck()) {
            countIn(temp.countOut());
        }

        return ret;
    }
}

