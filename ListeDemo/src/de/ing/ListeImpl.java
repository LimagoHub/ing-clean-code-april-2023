package de.ing;

public class ListeImpl<T> implements Liste<T> {


    private Kettenglied<T> start;
    private Kettenglied<T> akt;

    public ListeImpl() {
        start = akt = null;
    }


    @Override
    public void append(T value) {
        Kettenglied<T> neu = new Kettenglied<>(value);
        if(isEmpty()) {
            start = neu;

        } else {
            moveLast();
            neu.vor = akt;
            akt.nach = neu;

        }
        akt = neu;
    }

    @Override
    public T get() {

        return isEmpty() ? null : akt.data;
    }

    @Override
    public boolean update(T newValue) {
        if(isEmpty()) return false;
        akt.data = newValue;
        return true;
    }

    @Override
    public boolean remove() {
        if(isEmpty())
         return false;
        if(isBol() && isEol()) {
            start = akt = null;
        }

        if(isBol()) {
            moveNext();
            start = akt;
            akt.vor = null;
        }

        if(isEol()) {
            movePrevious();
            akt.nach = null;
        }

        akt.vor.nach = akt.nach;
        akt.nach.vor = akt.vor;
        moveNext();

        return true;
    }



    @Override
    public boolean movePrevious() {
        if(isBol()) return false;
        akt = akt.vor;
        return true;
    }

    @Override
    public boolean moveNext() {
        if(isEol()) return false;
        akt = akt.nach;
        return true;
    }

    @Override
    public boolean isEmpty() {

        return start == null;
    }

    @Override
    public boolean isEol() {

        return isEmpty() || akt.nach == null;
    }

    @Override
    public boolean isBol() {

        return isEmpty() || akt.vor == null;
    }

    class Kettenglied<T> {
        Kettenglied vor;
        Kettenglied nach;
        T data;

        public Kettenglied(T data) {
            this.data = data;
            vor = nach = null;
        }

    }
}