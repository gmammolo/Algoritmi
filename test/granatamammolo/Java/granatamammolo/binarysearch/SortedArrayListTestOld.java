package granatamammolo.Java.granatamammolo.binarysearch;
import org.junit.Test;
import static org.junit.Assert.*;
/*TOSEE: attenta, che tu avevi testato l'intSortedArray invece che il SortedArray.
  **************** hai ragione, ora correggo
 *parti da questa base che ho fatto io per sistemare i test e usa i String o al massimo i Double/Float per 
 * testare, altrimenti tanto valeva usare IntSortedArray appunto.. 
******************* ok, uso gli String
 * il defaultArray serve per avere un array già riempito con nomi random  e non perdere un giorno ogni volta.
******************* ogni metodo deve essere indipendente dall'altro (tant'è che vengono eseguiti con un ordine diverso
ogni volta), quindi se usi un array che viene modificato ogni volta in maniera diversa, senza aver la certezza di
cosa ottieni in input, non puoi fare un test consistente
 * 
 */
/**
 *
 * @author Federica
 */
public class SortedArrayListTestOld {
    
    private String[] defaultArray = new String[]{"Katy","Baba","Drizzit","Collinolio","Wally"};
    

   /**
     * Test of size method, of class SortedArrayList.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        
         System.out.println("\t array vuoto");
        SortedArrayList instance = new SortedArrayList();
        assertEquals(0, instance.size());
        
        System.out.println("\t array pieno");
        instance = new SortedArrayList(defaultArray);
        System.out.println("\t\t"+instance.toString());
        assertEquals(5, instance.size());
    }

    /**
     * Test of insert method, of class SortedArrayList.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        
        System.out.println("\tAd Array Vuoto:");
        SortedArrayList instance = new SortedArrayList();
        int result = instance.insert("Anna");
        assertEquals(0, result);
        assertEquals("[Anna]", instance.toString());
        System.out.println("\tAlla fine dell' Array:");
        instance = new SortedArrayList(defaultArray);
        result = instance.insert("Zara");
        assertEquals(5, result);
        assertEquals("[Baba, Collinolio, Drizzit, Katy, Wally, Zara]", instance.toString());
        System.out.println("\tA metà dell' Array:");
    }

    /**
     * Test of get method, of class SortedArrayList.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        SortedArrayList instance = new SortedArrayList(defaultArray);
        assertEquals("Baba", instance.get(0));
        assertEquals("Drizzit", instance.get(2));
    }

    /**
     * Test of indexOf method, of class SortedArrayList.
     */
    @Test
    public void testIndexOf() {
        System.out.println("indexOf");
        SortedArrayList instance = new SortedArrayList(defaultArray);
        assertEquals(0, instance.indexOf("Baba"));
        assertEquals(-1, instance.indexOf("Zara"));
        assertEquals(instance.size()-1, instance.indexOf("Wally"));
    }

    /**
     * Test of toString method, of class SortedArrayList.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        System.out.println("\t Array Vuoto");
        SortedArrayList instance = new SortedArrayList();
        assertEquals("[]", instance.toString());
        System.out.println("\t Array Default");
        instance = new SortedArrayList(defaultArray);
        assertEquals("[Baba, Collinolio, Drizzit, Katy, Wally]", instance.toString());
    }
    
}
