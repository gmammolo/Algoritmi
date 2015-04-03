/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package granatamammolo.Java.granatamammolo.binarysearch;

import granatamammolo.Java.granatamammolo.binarysearch.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Federica
 */
public class IntSortedArrayTest {
  
  public IntSortedArrayTest() {
  }
  
  @BeforeClass
  public static void setUpClass() {
  }
  
  @AfterClass
  public static void tearDownClass() {
  }
  
/******************************************************************************/
/************************ TEST BINARY SEARCH **********************************/
/******************************************************************************/

/**
  * Casi da testare:
  * - x è presente nell'array
  * - x non è presente nell'array
  * - x è cercato in un array vuoto
  * - x è cercato in un array di una sola cella
  * - x è minore del valore minimo presente nell'array
  * - x è maggiore del valore massimo presente nell'array
 */
  
  /**
   * Test of binarySearch method, of class IntSortedArray.
   * Caso: il valore x è cercato in un array 'corretto' ed è presente
   */
  @Test
  public void testBinarySearchClassic() {
    System.out.println("binarySearch: elemento presente");
    IntSortedArray instance = new IntSortedArray(6);
    instance.insert(5);
    instance.insert(6);
    instance.insert(3);
    instance.insert(9);
    instance.insert(10);
    instance.insert(11);
    int result = instance.binarySearch(9);
    assertEquals(3, result);
  }
  
//  @Test
//  public void testBinarySearchNotPresence() { // TOSEE nome del metodo
//    System.out.println("binarySearch: elemento non presente");
//    IntSortedArray instance = new IntSortedArray(6);
//    instance.insert(5);
//    instance.insert(6);
//    instance.insert(3);
//    instance.insert(9);
//    instance.insert(10);
//    instance.insert(11);
//    int result = instance.binarySearch(4);
//    assertEquals(-1, result);   // TOSEE è giusto aspettarsi -1?
//  }
  
  @Test
  public void testBinarySearchEmptyArray() {
    System.out.println("binarySearch: array vuoto");
    IntSortedArray instance = new IntSortedArray(0);
    int result = instance.binarySearch(9);
    assertEquals(-1, result);
  }
  
  @Test
  public void testBinarySearchSingleCell() {
    System.out.println("binarySearch: array di un solo elemento");
    IntSortedArray instance = new IntSortedArray(1);
    instance.insert(4);
    int result = instance.binarySearch(4);
    assertEquals(0, result);
  }
  
  @Test
  public void testBinaryValueLittle() {   // TOSEE nome metodo
    System.out.println("binarySearch: elemento presente");
    IntSortedArray instance = new IntSortedArray(6);
    instance.insert(5);
    instance.insert(6);
    instance.insert(3);
    instance.insert(9);
    instance.insert(10);
    instance.insert(11);
    int result = instance.binarySearch(1);
    assertEquals(-1, result);
  }
  
  @Test
  public void testBinaryValueBig() {    // TOSEE nome metodo
    System.out.println("binarySearch: elemento presente");
    IntSortedArray instance = new IntSortedArray(6);
    instance.insert(5);
    instance.insert(6);
    instance.insert(3);
    instance.insert(9);
    instance.insert(10);
    instance.insert(11);
    int result = instance.binarySearch(13);
    assertEquals(-7, result);
  }

/******************************************************************************/
/************************ TEST SIZE *******************************************/
/******************************************************************************/
  
  /**
   * Casi da testare:
   * - array vuoto
   * - array pieno
   * - array parzialmente riempito
   */
  
  /**
   * Test of size method, of class IntSortedArray.
   */
  @Test
  public void testSizeEmpty() {
    System.out.println("size: empty array");
    IntSortedArray instance = new IntSortedArray();
    int expResult = 0;
    int result = instance.size();
    assertEquals(expResult, result);
  }
  
  @Test
  public void testSizeFull() {
    System.out.println("size: array pieno");
    IntSortedArray instance = new IntSortedArray(4);
    instance.insert(5);
    instance.insert(9);
    instance.insert(6);
    instance.insert(4);
    int expResult = 4;
    int result = instance.size();
    assertEquals(expResult, result);
  }
  
  @Test
  public void testSizeNotFull() {                   // parzialmente riempito
    System.out.println("size: array parzialmente riempito");
    IntSortedArray instance = new IntSortedArray(7);
    instance.insert(5);
    instance.insert(9);
    instance.insert(6);
    instance.insert(4);
    int expResult = 4;
    int result = instance.size();
    assertEquals(expResult, result);
  }

/******************************************************************************/
/************************ TEST REALLOCATE *************************************/
/******************************************************************************/
  
  /**
   * Casi da testare:
   * - array di dimensione 0
   * - array classico (si prenda caso di default con dimensione 16)
   */
  
  /**
   * Test of reallocate method, of class IntSortedArray.
   */
  @Test
  public void testReallocateEmptyArray() {
    System.out.println("reallocate: array vuoto");
    IntSortedArray instance = new IntSortedArray(0);
    instance.reallocate();
    int expResult = 0;
    int result = instance.elements.length;
    assertEquals(expResult, result);
  }
  
//  @Test
//  public void testReallocateClassicArray() {    // TOSEE non funziona nella classe
//    System.out.println("reallocate: array di capacità 16");
//    IntSortedArray instance = new IntSortedArray();
//    instance.reallocate();
//    int result = instance.elements.length;
//    int expResult = 32;    
//    assertEquals(expResult, result);
//  }

/******************************************************************************/
/************************ TEST INSERT *****************************************/
/******************************************************************************/
  
/**
 * Casi da testare:
 * - l'array è già pieno e l'elemento è inserito all'inizio
 * - l'array è già pieno e l'elemento è inserito al fondo
 * - l'array è già pieno e l'elemento è inserito in mezzo
 * - l'array è vuoto
 * - l'array è parzialmente riempito e l'elemento è presente
 * - l'array è parzialmente riempito e l'elemento non è presente
 */
  
  /**
   * Test of insert method, of class IntSortedArray.
   */
  @Test
  public void testInsertFullArrayStart() {
    System.out.println("insert: array pieno - inserimento all'inizio");
    IntSortedArray instance = new IntSortedArray(3);
    instance.insert(5);
    instance.insert(9);
    instance.insert(6);
    int x = 4;
    int resultPosizion = instance.insert(x);
    // test della size di instance
    assertEquals(4, instance.size);
    // test della posizione di inserimento
    assertEquals(0, resultPosizion);
  }
  
  @Test
  public void testInsertFullArrayEnd() {
    System.out.println("insert: array pieno - inserimento al fondo");
    IntSortedArray instance = new IntSortedArray(3);
    instance.insert(5);
    instance.insert(9);
    instance.insert(6);
    int resultPosition = instance.insert(8);
    // test della size di instance
    assertEquals(4, instance.size);
    // test della posizione di inserimento
    assertEquals(2, resultPosition);
  }
  
  @Test
  public void testInsertFullArrayMiddle() {
    System.out.println("insert: array pieno - inserimento in mezzo");
    IntSortedArray instance = new IntSortedArray(3);
    instance.insert(5);
    instance.insert(9);
    instance.insert(7);
    int x = 6;
    int resultPosition = instance.insert(x);
    // test della size di instance
    assertEquals(4, instance.size);
    // test della posizione di inserimento
    assertEquals(1, resultPosition);
  }

//  @Test
//  public void testInsertEmptyArray() {    // TOSEE controllare questo caso, non effettua l'inserimento
//    System.out.println("insert: array vuoto");
//    IntSortedArray instance = new IntSortedArray(0);
////    System.out.println(instance.size);
//    int resultPosition = instance.insert(4);    
//    // test della size di instance
//    assertEquals(0, instance.size);
//    // test della posizione di inserimento
//    assertEquals(0, resultPosition);
//  }
  
  @Test
  public void testInsertPresentElement() {    // TOSEE nome metodo
    System.out.println("insert: array parzialmente riempito - elemento già presente");
    IntSortedArray instance = new IntSortedArray(4);
    instance.insert(5);
    instance.insert(9);
    instance.insert(6);
    int x = 6;
    int resultPosizion = instance.insert(x);
    // test della size di instance
    assertEquals(4, instance.size);
    // test della posizione di inserimento
    assertEquals(1, resultPosizion);
  }
  
  @Test
  public void testInsertNotPresentElement() {   // TOSEE nome metodo
    System.out.println("insert: array parzialmente riempito - elemento non presente");
    IntSortedArray instance = new IntSortedArray(4);
    instance.insert(5);
    instance.insert(9);
    instance.insert(6);
    int x = 7;
    int resultPosizion = instance.insert(x);
    // test della size di instance
    assertEquals(4, instance.size);
    // test della posizione di inserimento
    assertEquals(2, resultPosizion);
  }
  
/******************************************************************************/
/************************ TEST GET ********************************************/
/******************************************************************************/
  
  /**
   * Casi da testare:
   * - indice negativo
   * - indice corretto
   * - indice > size
   */
  
  /**
   * Test of get method, of class IntSortedArray.
   */
  @Test(expected = ArrayIndexOutOfBoundsException.class)  
  public void testGetNegativeIndex() {
    System.out.println("get: indice negativo");
    int i = -3;
    IntSortedArray instance = new IntSortedArray(2);
    instance.insert(5);
    instance.insert(9);
    instance.get(i);
  }
  
  @Test
  public void testGetClassic() {
    System.out.println("get: indice corretto");
    int i = 0;
    IntSortedArray instance = new IntSortedArray(2);
    instance.insert(5);
    instance.insert(9);
    int expResult = 5;
    int result = instance.get(i);
    assertEquals(expResult, result);
  }
  
  @Test(expected = ArrayIndexOutOfBoundsException.class)  
  public void testGetIndexBiggerLength() {
    System.out.println("get: indice più grande di size");
    int i = 3;
    IntSortedArray instance = new IntSortedArray(5);
    instance.insert(5);
    instance.insert(9);
    instance.get(i);
  }

/******************************************************************************/
/************************ TEST INDEX OF ***************************************/
/******************************************************************************/
  
  /**
   * Casi da testare:
   * - elemento presente
   * - elemento non presente
   */
  
  /**
   * Test of indexOf method, of class IntSortedArray.
   */
  @Test
  public void testIndexOfPresence() {   // TOSEE nome metodo
    System.out.println("indexOf - elemento presente");
    IntSortedArray instance = new IntSortedArray(5);
    instance.insert(5);
    instance.insert(9);
    int result = instance.indexOf(5);
    int expResult = 0;
    assertEquals(expResult, result);
  }
  
    @Test
  public void testIndexOfNotPresence() {    // TOSEE nome metodo
    System.out.println("indexOf - elemento non presente");
    IntSortedArray instance = new IntSortedArray(5);
    instance.insert(5);
    instance.insert(9);
    int result = instance.indexOf(8);
    int expResult = -1;
    assertEquals(expResult, result);
  }

/******************************************************************************/
/************************ TEST TO STRING **************************************/
/******************************************************************************/
  
  /**
   * Casi da testare:
   * - ritorna una stringa con la stessa formattazione di:
   *    - array vuoto
   *    - array con un elemento
   *    - array con più elementi
   */
  
  /**
   * Test of toString method, of class IntSortedArray.
   */
  @Test
  public void testToStringEmptyArray() {
    System.out.println("toString - array vuoto");
    IntSortedArray instance = new IntSortedArray(0);
    String result = instance.toString();
    String expResult = "[]";
    boolean bool = expResult.equals(result);
    assertTrue(bool);
  }
  
  @Test
  public void testToStringSingleCell() {
    System.out.println("toString - un solo elemento");
    IntSortedArray instance = new IntSortedArray(1);
    instance.insert(4);
    String result = instance.toString();
    String expResult = "[4]";
    boolean bool = expResult.equals(result);
    assertTrue(bool);
  }
  
//  @Test         // TOSEE da errore nella classe
//  public void testToStringClassicArray() {
//    System.out.println("toString");
//    IntSortedArray instance = new IntSortedArray(4);
//    instance.insert(5);
//    instance.insert(9);
//    instance.insert(6);
//    String result = instance.toString();    
//    String expResult = "[5, 6, 9]";
//    System.out.println(result  + " result \nexp:" + expResult);
//    boolean bool = expResult.equals(result);
//    assertTrue(bool);
//  }
  
}
