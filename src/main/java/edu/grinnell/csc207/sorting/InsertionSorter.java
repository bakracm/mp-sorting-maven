package edu.grinnell.csc207.sorting;

import java.util.Comparator;

/**
 * Something that sorts using insertion sort.
 *
 * @param <T>
 *   The types of values that are sorted.
 *
 * @author Samuel A. Rebelsky
 */

public class InsertionSorter<T> implements Sorter<T> {
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
  public InsertionSorter(Comparator<? super T> comparator) {
    this.order = comparator;
  } // InsertionSorter(Comparator)

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * Sort an array in place using insertion sort.
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
    for(int i = 1; i < values.length; i++) {
      if (order.compare(values[i], values[i - 1]) < 0) {
        insert(values[i], i, values);
      } // if
    } // for
  } // sort(T[])

  /**
   * Move values over and insert a value into the right spot.
   *
   * @param val
   *    value to insert.
   * @param index
   *    initial index of the value.
   * @param values
   *    array of values.
   */
  public void insert(T val, int index, T[] values) {
    int isInserted = 0;
    int i = 0;
    while(isInserted == 0) {
      if(order.compare(values[index], values[i]) < 0) {
        for (int j = index; j > i; j--) {
          values[j] = values[j - 1];
        } // for
        values[i] = val;
        isInserted = 1;
      } // if
      i++;
    } // while
  } // insert(T, int, T[])
} // class InsertionSorter<T>

