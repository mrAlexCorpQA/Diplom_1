import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    private Bun bunForTest;
    private String bunNameForTest = "name";
    private float bunPriceForTest = (float) 12.12345;


    //Создаются объекты для тестов
    @Before
    public void createBunObjectsBeforeTest() {
        bunForTest = new Bun(bunNameForTest, bunPriceForTest);
    }

    //Проверяется метод getName класса Bun
    @Test
    public void testBunGetName() {
        createBunObjectsBeforeTest();
        Assert.assertEquals(bunNameForTest, bunForTest.getName());
    }

    //Проверяется метод getPrice класса Bun
    @Test
    public void testBunGetPrice() {
        createBunObjectsBeforeTest();
        Assert.assertEquals(bunPriceForTest, bunForTest.getPrice(), 0.0f);
    }

}