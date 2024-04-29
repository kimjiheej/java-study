package behavioral.iterator;

import java.util.Iterator;

public interface Aggregate<E> {
	Iterator<E> createIterator();
}
