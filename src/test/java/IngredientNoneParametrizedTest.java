import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientNoneParametrizedTest {

    //Объявляются служебные переменные для тестов
    private Ingredient ingredientForNoneParametrizedTest;
    private String ingredientNameForTest = "hot sauce";
    private float ingredientPriceForTest = 100;


    //Создаются объекты для тестов
    @Before
    public void createIngredientObjectsBeforeTest() {
        ingredientForNoneParametrizedTest = new Ingredient(IngredientType.SAUCE, ingredientNameForTest, ingredientPriceForTest);
    }

    //Проверяется метод getPrice класса Ingredient
    @Test
    public void testIngredientGetPrice() {
        createIngredientObjectsBeforeTest();
        Assert.assertEquals(ingredientPriceForTest, ingredientForNoneParametrizedTest.getPrice(), 0.0f);
    }

    //Проверяется метод getName класса Ingredient
    @Test
    public void testIngredientGetName() {
        createIngredientObjectsBeforeTest();
        Assert.assertEquals(ingredientNameForTest, ingredientForNoneParametrizedTest.getName());
    }

}