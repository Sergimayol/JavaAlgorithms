/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.util.Iterator;

/**
 *
 * @author Sergi
 * @param <K>
 * @param <V>
 */
public interface Mapping<K, V> {

    public V get(K key);

    public V put(K key, V value);

    public V remove(K key);

    public boolean isEmpty();

    public Iterator iterator();
}
