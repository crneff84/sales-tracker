import org.junit.*;
import static org.junit.Assert.*;


public class ProductTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void Product_instantiatesCorrectly_true() {
    Product testProduct = new Product("Sunglasses", 50, "Polarized-Waterproof", 20, 1);
    assertTrue(testProduct instanceof Product);
  }

  @Test
  public void getName_instantiatesCorrectlyWithName_Sunglasses() {
    Product testProduct = new Product("Sunglasses", 50, "Polarized", 20, 1);
    assertEquals("Sunglasses", testProduct.getName());
  }

  @Test
  public void getPrice_instantiatesCorrectlyWithPrice_50() {
    Product testProduct = new Product("Sunglasses", 50, "Polarized", 20, 1);
    assertEquals(50, testProduct.getPrice());
  }

  @Test
  public void getDescription_instantiatesCorrectlyWithDescription_Polarized() {
    Product testProduct = new Product("Sunglasses", 50, "Polarized", 20, 1);
    assertEquals("Polarized", testProduct.getDescription());
  }

  @Test
  public void getQuantity_instantiatesCorrectlyWithQuantity_20() {
    Product testProduct = new Product("Sunglasses", 50, "Polarized", 20, 1);
    assertEquals(20, testProduct.getQuantity());
  }

  @Test
  public void getCategoryId_instantiatesCorrectlyWithCategoryId_1() {
    Product testProduct = new Product("Sunglasses", 50, "Polarized", 20, 1);
    assertEquals(1, testProduct.getCategoryId());
  }

  @Test
  public void equals_returnsTrueIfPropertiesAreSame_true() {
    Product firstProduct = new Product("Sunglasses", 50, "Polarized", 20, 1);
    Product secondProduct = new Product("Sunglasses", 50, "Polarized", 20, 1);
    assertTrue(firstProduct.equals(secondProduct));
  }

  @Test
  public void save_returnsTrueIfObjectsAreTheSame_true() {
    Product testProduct = new Product("Sunglasses", 50, "Polarized", 20, 1);
    testProduct.save();
    assertTrue(Product.all().get(0).equals(testProduct));
  }

  @Test
  public void all_returnsAllInstancesOfProduct_List() {
    Product firstProduct = new Product("Sunglasses", 50, "Polarized", 20, 1);
    firstProduct.save();
    Product secondProduct = new Product("Sunglasses", 40, "Non-Polarized", 20, 1);
    secondProduct.save();
    assertTrue(Product.all().get(0).equals(firstProduct));
    assertTrue(Product.all().get(1).equals(secondProduct));
  }

}
