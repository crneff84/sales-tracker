import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class JeanStuffTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void JeanStuff_instantiatesCorrectly_true() {
    JeanStuff testJeanStuff = new JeanStuff("Jacket", 100, "Acid-Wash", 50, 1);
    assertTrue(testJeanStuff instanceof JeanStuff);
  }

  @Test
  public void getName_instantiatesCorrectlyWithName_Sunglasses() {
    JeanStuff testJeanStuff = new JeanStuff("Jacket", 100, "Acid-Wash", 50, 1);
    assertEquals("Jacket", testJeanStuff.getName());
  }

  @Test
  public void getPrice_instantiatesCorrectlyWithPrice_50() {
    JeanStuff testJeanStuff = new JeanStuff("Jacket", 100, "Acid-Wash", 50, 1);
    assertEquals(100, testJeanStuff.getPrice());
  }

  @Test
  public void getDescription_instantiatesCorrectlyWithDescription_Polarized() {
    JeanStuff testJeanStuff = new JeanStuff("Jacket", 100, "Acid-Wash", 50, 1);
    assertEquals("Acid-Wash", testJeanStuff.getDescription());
  }

  @Test
  public void getQuantity_instantiatesCorrectlyWithQuantity_20() {
    JeanStuff testJeanStuff = new JeanStuff("Jacket", 100, "Acid-Wash", 50, 1);
    assertEquals(50, testJeanStuff.getQuantity());
  }

  @Test
  public void getCategoryId_instantiatesCorrectlyWithCategoryId_1() {
    JeanStuff testJeanStuff = new JeanStuff("Jacket", 100, "Acid-Wash", 50, 1);
    assertEquals(1, testJeanStuff.getCategoryId());
  }

  @Test
  public void equals_returnsTrueIfPropertiesAreSame_true() {
    JeanStuff firstJeanStuff = new JeanStuff("Jacket", 100, "Acid-Wash", 50, 1);
    JeanStuff secondJeanStuff = new JeanStuff("Jacket", 100, "Acid-Wash", 50, 1);
    assertTrue(firstJeanStuff.equals(secondJeanStuff));
  }

  @Test
  public void save_returnsTrueIfObjectsAreTheSame_true() {
    JeanStuff testJeanStuff = new JeanStuff("Jacket", 100, "Acid-Wash", 50, 1);
    testJeanStuff.save();
    assertTrue(JeanStuff.all().get(0).equals(testJeanStuff));
  }

  @Test
  public void all_returnsAllInstancesOfJeanStuff_List() {
    JeanStuff firstJeanStuff = new JeanStuff("Jacket", 100, "Acid-Wash", 50, 1);
    firstJeanStuff.save();
    JeanStuff secondJeanStuff = new JeanStuff("Jeans", 75, "Acid-Wash", 50, 1);
    secondJeanStuff.save();
    assertTrue(JeanStuff.all().get(0).equals(firstJeanStuff));
    assertTrue(JeanStuff.all().get(1).equals(secondJeanStuff));
  }

  @Test
  public void find_returnsJeanStuffWithSameId_secondJeanStuff() {
    JeanStuff firstJeanStuff = new JeanStuff("Jacket", 100, "Acid-Wash", 50, 1);
    firstJeanStuff.save();
    JeanStuff secondJeanStuff = new JeanStuff("Jeans", 75, "Acid-Wash", 50, 1);
    secondJeanStuff.save();
    assertEquals(JeanStuff.find(secondJeanStuff.getId()), secondJeanStuff);
  }

}
