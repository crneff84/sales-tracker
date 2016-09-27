import org.junit.*;
import static org.junit.Assert.*;
import org.sql2o.*;

public class AccessoryTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Accessory_instantiatesCorrectly_true() {
    Accessory testAccessory = new Accessory("Sunglasses", 50, "Polarized-Waterproof", 20, 1);
    assertTrue(testAccessory instanceof Accessory);
  }

  @Test
  public void getName_instantiatesCorrectlyWithName_Sunglasses() {
    Accessory testAccessory = new Accessory("Sunglasses", 50, "Polarized", 20, 1);
    assertEquals("Sunglasses", testAccessory.getName());
  }

  @Test
  public void getPrice_instantiatesCorrectlyWithPrice_50() {
    Accessory testAccessory = new Accessory("Sunglasses", 50, "Polarized", 20, 1);
    assertEquals(50, testAccessory.getPrice());
  }

  @Test
  public void getDescription_instantiatesCorrectlyWithDescription_Polarized() {
    Accessory testAccessory = new Accessory("Sunglasses", 50, "Polarized", 20, 1);
    assertEquals("Polarized", testAccessory.getDescription());
  }

  @Test
  public void getQuantity_instantiatesCorrectlyWithQuantity_20() {
    Accessory testAccessory = new Accessory("Sunglasses", 50, "Polarized", 20, 1);
    assertEquals(20, testAccessory.getQuantity());
  }

  @Test
  public void getCategoryId_instantiatesCorrectlyWithCategoryId_1() {
    Accessory testAccessory = new Accessory("Sunglasses", 50, "Polarized", 20, 1);
    assertEquals(1, testAccessory.getCategoryId());
  }

  @Test
  public void equals_returnsTrueIfPropertiesAreSame_true() {
    Accessory firstAccessory = new Accessory("Sunglasses", 50, "Polarized", 20, 1);
    Accessory secondAccessory = new Accessory("Sunglasses", 50, "Polarized", 20, 1);
    assertTrue(firstAccessory.equals(secondAccessory));
  }

  @Test
  public void save_returnsTrueIfObjectsAreTheSame_true() {
    Accessory testAccessory = new Accessory("Sunglasses", 50, "Polarized", 20, 1);
    testAccessory.save();
    assertTrue(Accessory.all().get(0).equals(testAccessory));
  }

  @Test
  public void all_returnsAllInstancesOfAccessory_List() {
    Accessory firstAccessory = new Accessory("Sunglasses", 50, "Polarized", 20, 1);
    firstAccessory.save();
    Accessory secondAccessory = new Accessory("Sunglasses", 40, "Non-Polarized", 20, 1);
    secondAccessory.save();
    assertTrue(Accessory.all().get(0).equals(firstAccessory));
    assertTrue(Accessory.all().get(1).equals(secondAccessory));
  }

  @Test
  public void find_returnsAccessoryWithSameId_secondAccessory() {
    Accessory firstAccessory = new Accessory("Sunglasses", 50, "Polarized", 20, 1);
    firstAccessory.save();
    Accessory secondAccessory = new Accessory("Jean Jacket", 100, "Acid-Wash", 50, 2);
    secondAccessory.save();
    assertEquals(Accessory.find(secondAccessory.getId()), secondAccessory);
  }

}
