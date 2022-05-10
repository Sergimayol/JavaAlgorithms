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

    /**
     *
     * @param key
     * @return V
     */
    public V get(K key);

    /**
     *
     * @param key
     * @param value
     * @return V
     */
    public V put(K key, V value);

    /**
     *
     * @param key
     * @return V
     */
    public V remove(K key);

    /**
     *
     * @return boolean
     */
    public boolean isEmpty();

    /**
     *
     * @return Iterator
     */
    public Iterator iterator();

}
