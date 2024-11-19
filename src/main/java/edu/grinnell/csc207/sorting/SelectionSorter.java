package edu.grinnell.csc207.sorting;

import java.util.Comparator;
import edu.grinnell.csc207.util.ArrayUtils;

/**
 * Something that sorts using selection sort.
 *
 * @param <T>
 *   The types of values that are sorted.
 *
 * @author Samuel A. Rebelsky
 */

public class SelectionSorter<T> implements Sorter<T> {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The way in which elements are ordered.
   */
  Comparator<? super T> order;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter using a particular comparator.
   *
   * @param comparator
   *   The order in which elements in the array should be ordered
   *   after sorting.
   */
  public SelectionSorter(Comparator<? super T> comparator) {
    this.order = comparator;
  } // SelectionSorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array in place using selection sort.
   *
   * @param values
   *   an array to sort.
   *
   * @post
   *   The array has been sorted according to some order (often
   *   one given to the constructor).
   * @post
   *   For all i, 0 &lt; i &lt; values.length,
   *     order.compare(values[i-1], values[i]) &lt;= 0
   */
  @Override
  public void sort(T[] values) {
    for (int i = 0; i < values.length; i++) {
      ArrayUtils.swap(values, i, select(values, i));
    } // for
  } // sort(T[])

  /**
   * Finds the smallest value in a subarray and returns its index.
   *
   * @param values
   *    The full array.
   * @param startIndex
   *    The first index of the subarray.
   * @return the index of the smallest value.
   */
  public int select(T[] values, int startIndex) {
    int index = startIndex;
    for (int i = startIndex; i < values.length; i++) {
        if (order.compare(values[i], values[index]) < 0) {
          index = i;
        } // if
    } // for
    return index;
  } // select(T[], T, int)

} // class SelectionSorter
