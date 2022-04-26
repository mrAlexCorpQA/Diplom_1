import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    private Bun bun;
    private String bunNameForTest = "name";
    private float bunPriceForTest = (float) 12.12345;


    //Создаются объекты для тестов
    @Before
    public void createBunObjectsBeforeTest() {
        bun = new Bun(bunNameForTest, bunPriceForTest);
    }

    //Проверяется метод getName класса Bun
    @Test
    public void testGetName() {
        createBunObjectsBeforeTest();
        Assert.assertEquals(bunNameForTest, bun.getName());
    }

    //Проверяется метод getPrice класса Bun
    @Test
    public void testGetPrice() {
        createBunObjectsBeforeTest();
        Assert.assertEquals(bunPriceForTest, bun.getPrice(), 0.0f);
    }

}