import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientParametrizedTest {

    //Объявляются служебные переменные для тестов
    private Ingredient ingredientForParametrizedTest;
    private String ingredientNameForParametrizedTest = "TestIngredientName";
    private float ingredientPriceForParametrizedTest = 200;

    @Parameterized.Parameters
    public static Object[][] getEnumTestData() {
        return new Object[][]{
                {IngredientType.SAUCE, "SAUCE"},
                {IngredientType.FILLING, "FILLING"},
        };
    }


    private IngredientType enumValueForTest;
    private String expected;

    public IngredientParametrizedTest(IngredientType enumValueForTest, String expected) {
        this.enumValueForTest = enumValueForTest;
        this.expected = expected;
    }

    //Проверяется метод getType класса Ingredient с передачей параметров
    @Test
    public void testIngredientGetTypeWithParameters() {
        ingredientForParametrizedTest = new Ingredient(enumValueForTest, ingredientNameForParametrizedTest, ingredientPriceForParametrizedTest);
        Assert.assertEquals(expected, ingredientForParametrizedTest.getType().toString());
    }
}