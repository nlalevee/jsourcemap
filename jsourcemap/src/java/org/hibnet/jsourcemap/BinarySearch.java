/*
 *  Copyright 2015 JSourceMap contributors
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.hibnet.jsourcemap;

import java.util.List;

class BinarySearch {

    enum Bias {
        GREATEST_LOWER_BOUND, LEAST_UPPER_BOUND
    }

    static interface Comparator<T> {

        int compare(T needle, T element);

    }

    private static <T> int recursiveSearch(int aLow, int aHigh, T aNeedle, List<T> aHaystack, Comparator<T> aCompare, Bias aBias) {
        // This function terminates when one of the following is true:
        //
        // 1. We find the exact element we are looking for.
        //
        // 2. We did not find the exact element, but we can return the index of
        // the next-closest element.
        //
        // 3. We did not find the exact element, and there is no next-closest
        // element than the one we are searching for, so we return -1.
        int mid = (int) (Math.floor((aHigh - aLow) / 2) + aLow);
        int cmp = aCompare.compare(aNeedle, aHaystack.get(mid));
        if (cmp == 0) {
            // Found the element we are looking for.
            return mid;
        } else if (cmp > 0) {
            // Our needle is greater than aHaystack[mid].
            if (aHigh - mid > 1) {
                // The element is in the upper half.
                return recursiveSearch(mid, aHigh, aNeedle, aHaystack, aCompare, aBias);
            }

            // The exact needle element was not found in this haystack. Determine if
            // we are in termination case (3) or (2) and return the appropriate thing.
            if (aBias == Bias.LEAST_UPPER_BOUND) {
                return aHigh < aHaystack.size() ? aHigh : -1;
            } else {
                return mid;
            }
        } else {
            // Our needle is less than aHaystack[mid].
            if (mid - aLow > 1) {
                // The element is in the lower half.
                return recursiveSearch(aLow, mid, aNeedle, aHaystack, aCompare, aBias);
            }

            // we are in termination case (3) or (2) and return the appropriate thing.
            if (aBias == Bias.LEAST_UPPER_BOUND) {
                return mid;
            } else {
                return aLow < 0 ? -1 : aLow;
            }
        }
    }

    static <T> int search(T aNeedle, List<T> aHaystack, Comparator<T> aCompare, Bias aBias) {
        if (aHaystack.size() == 0) {
            return -1;
        }

        if (aBias == null) {
            aBias = Bias.GREATEST_LOWER_BOUND;
        }

        int index = recursiveSearch(-1, aHaystack.size(), aNeedle, aHaystack, aCompare, aBias);
        if (index < 0) {
            return -1;
        }

        // We have found either the exact element, or the next-closest element than
        // the one we are searching for. However, there may be more than one such
        // element. Make sure we always return the smallest of these.
        while (index - 1 >= 0) {
            if (aCompare.compare(aHaystack.get(index), aHaystack.get(index - 1)) != 0) {
                break;
            }
            --index;
        }

        return index;
    }
}
