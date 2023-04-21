package de.ing;

public interface Liste<T> {

    void append(T value);
    T get();
    boolean update(T newValue);
    boolean remove();

    default void clear() {
        while(remove());
    }
    default boolean moveFirst(){
        if(isEmpty()) return false;
        while(movePrevious());
        return true;
    }
    default boolean moveLast() {
        if(isEmpty()) return false;
        while(moveNext());
        return true;
    }

    boolean movePrevious();
    boolean moveNext();

    boolean isEmpty();

    /*
     * liefert true wenn entweder die Liste leer ist oder wir AUF dem letzten Datensatz stehen
     */
    boolean isEol();

    /*
     * liefert true wenn entweder die Liste leer ist oder wir AUF dem ersten Datensatz stehen
     */
    boolean isBol();

}