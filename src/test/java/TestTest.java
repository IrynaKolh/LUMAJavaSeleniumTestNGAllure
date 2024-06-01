import org.testng.*;
import org.testng.annotations.Test;

public class TestTest {
  @Test
  public void testPass() {
    System.out.println("Hello world!");
    Assert.assertTrue(true);
  }
}
