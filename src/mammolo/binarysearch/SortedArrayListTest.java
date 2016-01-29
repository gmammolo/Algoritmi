package mammolo.binarysearch;

import mammolo.binarysearch.SortedArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Federica
 */
public class SortedArrayListTest {
  
  public SortedArrayListTest() {
      
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
   * Test of binarySearch method, of class SortedArrayList.
   * Caso: il valore x è cercato in un array 'corretto' ed è presente
   */
  @Test
  public void testBinarySearchClassic() {
    System.out.println("binarySearch: elemento presente");
    SortedArrayList instance = new SortedArrayList(6);
    instance.insert("Alice");
    instance.insert("Gianmarco");
    instance.insert("Isidoro");
    instance.insert("Lorenza");
    instance.insert("Norberto");    
    instance.insert("Rebecca");    
    int result = instance.binarySearch("Lorenza");
    assertEquals(3, result);
  }
  
  @Test
  public void testBinarySearchElementoNonPresente() { 
    System.out.println("binarySearch: elemento non presente");
    SortedArrayList instance = new SortedArrayList(6);
    instance.insert("Alice");
    instance.insert("Norberto");
    instance.insert("Isidoro");
    instance.insert("Rebecca");
    instance.insert("Lorenza");
    instance.insert("Gianmarco");
    int result = instance.binarySearch("Arianna");
    assertEquals(-2, result);   
  }
  
  @Test
  public void testBinarySearchEmptyArray() {
    System.out.println("binarySearch: array vuoto");
    SortedArrayList instance = new SortedArrayList(6);
    int result = instance.binarySearch("Arianna");
    assertEquals(-1, result);
  }
  
  @Test
  public void testBinarySearchSingleCell() {
    System.out.println("binarySearch: array di un solo elemento");
    SortedArrayList instance = new SortedArrayList(1);
    instance.insert("Alice");
    int result = instance.binarySearch("Alice");
    assertEquals(0, result);
  }
  
  @Test
  public void testBinarySearchFirstPositionElement() {   
    System.out.println("binarySearch: elemento non presente - andrebbe inserito"
            + " nella prima posizione");
    SortedArrayList instance = new SortedArrayList(6);
    instance.insert("Arianna");
    instance.insert("Norberto");
    instance.insert("Isidoro");
    instance.insert("Rebecca");
    instance.insert("Lorenza");
    instance.insert("Gianmarco");
    int result = instance.binarySearch("Alice");
    assertEquals(-1, result);
  }
  
  @Test
  public void testBinarySearchLastPositionElement() {    
    System.out.println("binarySearch: elemento non presente - andrebbe inserito"
            + " nell'ultima poszione");
    SortedArrayList instance = new SortedArrayList(6);
    instance.insert("Arianna");
    instance.insert("Norberto");
    instance.insert("Isidoro");
    instance.insert("Rebecca");
    instance.insert("Lorenza");
    instance.insert("Gianmarco");
    int result = instance.binarySearch("Zorro");
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
   * Test of size method, of class SortedArrayList.
   */
  @Test
  public void testSizeEmpty() {
    System.out.println("size: empty array");
    SortedArrayList instance = new SortedArrayList();
    int expResult = 0;
    int result = instance.size();
    assertEquals(expResult, result);
  }
  
  @Test
  public void testSizeFull() {
    System.out.println("size: array pieno");
    SortedArrayList instance = new SortedArrayList(6);
    instance.insert("Arianna");
    instance.insert("Norberto");
    instance.insert("Isidoro");
    instance.insert("Rebecca");
    instance.insert("Lorenza");
    instance.insert("Gianmarco");
    int expResult = 6;
    int result = instance.size();
    assertEquals(expResult, result);
  }
  
  @Test
  public void testSizeNotFull() {                   
    System.out.println("size: array parzialmente riempito");
    SortedArrayList instance = new SortedArrayList(8);
    instance.insert("Arianna");
    instance.insert("Norberto");
    instance.insert("Isidoro");
    instance.insert("Rebecca");
    int expResult = 4;
    int result = instance.size();
    assertEquals(expResult, result);
  }

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
   * Test of insert method, of class SortedArrayList.
   */
  @Test
  public void testInsertFullArrayStart() {
    System.out.println("insert: array pieno - inserimento all'inizio");
    SortedArrayList instance = new SortedArrayList(7);
    instance.insert("Arianna");
    instance.insert("Norberto");
    instance.insert("Isidoro");
    instance.insert("Rebecca");
    instance.insert("Lorenza");
    instance.insert("Gianmarco");
    instance.insert("Zorro");
    int resultPosition = instance.insert("Alice");
    // test della size di instance
    assertEquals(8, instance.size());
    // test della posizione di inserimento
    assertEquals(0, resultPosition);
  }
  
  @Test
  public void testInsertFullArrayEnd() {
    System.out.println("insert: array pieno - inserimento al fondo");
    SortedArrayList instance = new SortedArrayList(8);
    instance.insert("Arianna");
    instance.insert("Norberto");
    instance.insert("Isidoro");
    instance.insert("Rebecca");
    instance.insert("Lorenza");
    instance.insert("Gianmarco");
    instance.insert("Alice");
    int resultPosition = instance.insert("Zorro");
    // test della size di instance
    assertEquals(8, instance.size());
    // test della posizione di inserimento
    assertEquals(7, resultPosition);
  }
  
  @Test
  public void testInsertFullArrayMiddle() {
    System.out.println("insert: array pieno - inserimento in mezzo");
    SortedArrayList instance = new SortedArrayList(3);
    instance.insert("Arianna");
    instance.insert("Rebecca");
    instance.insert("Alice");
    int resultPosition = instance.insert("Lorenza");
    // test della size di instance
    assertEquals(4, instance.size());
    // test della posizione di inserimento
    assertEquals(2, resultPosition);
  }

  @Test
  public void testInsertEmptyArray() {    
    System.out.println("insert: array vuoto");
    SortedArrayList instance = new SortedArrayList(5);
    int resultPosition = instance.insert("Lorenza");    
    // test della size di instance
    assertEquals(1, instance.size());
    // test della posizione di inserimento
    assertEquals(0, resultPosition);
  }
  
  @Test
  public void testInsertElementoPresente() {    
    System.out.println("insert: array parzialmente riempito - elemento già presente");
    SortedArrayList instance = new SortedArrayList(6);
    instance.insert("Arianna");
    instance.insert("Zorro");
    instance.insert("Lorenza");
    instance.insert("Gianmarco");
    int resultPosition = instance.insert("Lorenza");
    // test della size di instance
    assertEquals(5, instance.size());
    // test della posizione di inserimento
    assertEquals(2, resultPosition);
  }
  
  @Test
  public void testInsertElementoNonPresente() {
    System.out.println("insert: array parzialmente riempito - elemento non presente");
    SortedArrayList instance = new SortedArrayList(8);
    instance.insert("Arianna");
    instance.insert("Zorro");
    instance.insert("Lorenza");
    instance.insert("Gianmarco");
    int resultPosition = instance.insert("Rebecca");
    // test della size di instance
    assertEquals(5, instance.size());
    // test della posizione di inserimento
    assertEquals(3, resultPosition);
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
   * Test of get method, of class SortedArrayList.
   */
  @Test(expected = ArrayIndexOutOfBoundsException.class)  
  public void testGetNegativeIndex() {
    System.out.println("get: indice negativo");
    SortedArrayList instance = new SortedArrayList(8);
    instance.insert("Arianna");
    instance.insert("Norberto");
    instance.insert("Isidoro");
    instance.get(-3);
  }
  
  @Test
  public void testGetClassic() {
    System.out.println("get: indice corretto");
    SortedArrayList instance = new SortedArrayList();
    instance.insert("Arianna");
    instance.insert("Norberto");
    instance.insert("Isidoro");
    String expResult = "Arianna";
    Object result = instance.get(0);
    assertEquals(expResult, result);
  }
  
  @Test(expected = ArrayIndexOutOfBoundsException.class)  
  public void testGetIndexBiggerLength() {
    System.out.println("get: indice più grande di size");
    SortedArrayList instance = new SortedArrayList();
    instance.insert("Arianna");
    instance.insert("Norberto");
    instance.insert("Isidoro");
    instance.get(6);
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
   * Test of indexOf method, of class SortedArrayList.
   */
  @Test
  public void testIndexOfElementoPresente() {  
    System.out.println("indexOf - elemento presente");
    SortedArrayList instance = new SortedArrayList(8);
    instance.insert("Arianna");
    instance.insert("Norberto");
    instance.insert("Isidoro");
    instance.insert("Rebecca");
    int result = instance.indexOf("Norberto");
    int expResult = 2;
    assertEquals(expResult, result);
  }
  
    @Test
  public void testIndexOfElementoNonPresente() {    
    System.out.println("indexOf - elemento non presente");
    SortedArrayList instance = new SortedArrayList(8);
    instance.insert("Arianna");
    instance.insert("Norberto");
    instance.insert("Isidoro");
    instance.insert("Rebecca");
    int result = instance.indexOf("Zorro");
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
   * Test of toString method, of class SortedArrayList.
   */
  @Test
  public void testToStringEmptyArray() {
    System.out.println("toString - array vuoto");
    SortedArrayList instance = new SortedArrayList(8);
    String result = instance.toString();
    String expResult = "[]";
    boolean bool = expResult.equals(result);
    assertTrue(bool);
  }
  
  @Test
  public void testToStringSingleCell() {
    System.out.println("toString - un solo elemento");
    SortedArrayList instance = new SortedArrayList(8);
    instance.insert("Arianna");
    String result = instance.toString();
    String expResult = "[Arianna]";
    boolean bool = expResult.equals(result);
    assertTrue(bool);
  }
  
  @Test         
  public void testToStringClassicArray() {        
    System.out.println("toString - versione classica");
    SortedArrayList instance = new SortedArrayList(8);
    instance.insert("Arianna");
    instance.insert("Norberto");
    instance.insert("Isidoro");
    instance.insert("Rebecca");
    String result = instance.toString();    
    String expResult = "[Arianna, Isidoro, Norberto, Rebecca]";
    boolean bool = expResult.equals(result);
    assertTrue(bool);
  }
  
}
