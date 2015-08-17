package org.hibnet.jsourcemap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArraySet<T> {

    private Map<T, Integer> _set;
    private List<T> _array;

    /**
     * A data structure which is a combination of an array and a set. Adding a new member is O(1), testing for
     * membership is O(1), and finding the index of an element is O(1). Removing elements from the set is not supported.
     * Only strings are supported for membership.
     */
    public ArraySet() {
        _set = new HashMap<>();
        _array = new ArrayList<>();
    }

    /**
     * Static method for creating ArraySet instances from an existing array.
     */
    public static <T> ArraySet<T> fromArray(List<T> aArray, Boolean aAllowDuplicates) {
        ArraySet<T> set = new ArraySet<>();
        for (int i = 0, len = aArray.size(); i < len; i++) {
            set.add(aArray.get(i), aAllowDuplicates);
        }
        return set;
    }

    /**
     * Return how many unique items are in this ArraySet. If duplicates have been added, than those do not count towards
     * the size.
     *
     * @returns Number
     */
    public int size() {
        return _array.size();
    }

    /**
     * Add the given string to this set.
     *
     * @param String
     *            aStr
     */
    public void add(T t, Boolean aAllowDuplicates) {
        boolean isDuplicate = this.has(t);
        int idx = _array.size();
        if (!isDuplicate || (aAllowDuplicates != null && aAllowDuplicates)) {
            _array.add(t);
        }
        if (!isDuplicate) {
            _set.put(t, idx);
        }
    }

    /**
     * Is the given string a member of this set?
     *
     * @param String
     *            aStr
     */
    public boolean has(T t) {
        return _set.containsKey(t);
    }

    /**
     * What is the index of the given string in the array?
     *
     * @param String
     *            aStr
     */
    public int indexOf(T t) {
        Integer i = _set.get(t);
        if (i == null) {
            return -1;
        }
        return i;
    }

    /**
     * What is the element at the given index?
     *
     * @param Number
     *            aIdx
     */
    public T at(int i) {
        return _array.get(i);
    }

    /**
     * Returns the array representation of this set (which has the proper indices indicated by indexOf). Note that this
     * is a copy of the internal array used for storing the members so that no one can mess with internal state.
     */
    public List<T> toArray() {
        return new ArrayList<>(_array);
    }
}
