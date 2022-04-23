package Utilities;

import java.util.Iterator;

/**
 *
 * @author Sergi
 * @param <E>
 */
public interface Set<E> {

    public boolean contains(E elem);

    public boolean add(E elem);

    public boolean remove(E elem);

    public boolean isEmpty();

    public Iterator iterator();
}
