import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burgerForTest;

    @Mock
    Ingredient ingredientMockForTest1;
    @Mock
    Ingredient ingredientMockForTest2;
    @Mock
    Ingredient ingredientMockForTest3;
    @Mock
    Bun bunMockObjectForTest;

    //Создаются объекты для тестов
    @Before
    public void createBurgerObjectsBeforeTest() {
        burgerForTest = new Burger();
    }

    //Проверяется метод setBuns класса Burger
    @Test
    public void setBunsTest() {
        burgerForTest.setBuns(bunMockObjectForTest);
        System.out.println(burgerForTest.bun);
        Assert.assertEquals(burgerForTest.bun, bunMockObjectForTest);
    }

    //Проверяется метод addIngredient класса Burger
    @Test
    public void addIngredientTest() {
        burgerForTest.addIngredient(ingredientMockForTest1);
        Assert.assertEquals(burgerForTest.ingredients.get(0), ingredientMockForTest1);
    }

    //Проверяется метод removeIngredient класса Burger
    @Test
    public void removeIngredientTest() {
        burgerForTest.addIngredient(ingredientMockForTest1);
        Assert.assertEquals(burgerForTest.ingredients.get(0), ingredientMockForTest1);
        burgerForTest.removeIngredient(0);
        Assert.assertTrue(burgerForTest.ingredients.isEmpty());
    }

    //Проверяется метод moveIngredient класса Burger
    @Test
    public void moveIngredientTest() {
        burgerForTest.addIngredient(ingredientMockForTest1);
        Assert.assertEquals(burgerForTest.ingredients.get(0), ingredientMockForTest1);
        burgerForTest.addIngredient(ingredientMockForTest2);
        Assert.assertEquals(burgerForTest.ingredients.get(1), ingredientMockForTest2);
        burgerForTest.moveIngredient(0, 1);
        Assert.assertEquals(burgerForTest.ingredients.get(1), ingredientMockForTest1);
    }

    //Проверяется метод getPrice класса Burger
    @Test
    public void getPriceTest() {
        burgerForTest.setBuns(bunMockObjectForTest);
        burgerForTest.addIngredient(ingredientMockForTest1);
        burgerForTest.addIngredient(ingredientMockForTest2);
        burgerForTest.addIngredient(ingredientMockForTest3);
        Mockito.when(bunMockObjectForTest.getPrice()).thenReturn(100f);
        Mockito.when(ingredientMockForTest1.getPrice()).thenReturn(100f);
        Mockito.when(ingredientMockForTest2.getPrice()).thenReturn(200f);
        Mockito.when(ingredientMockForTest3.getPrice()).thenReturn(300f);
        Assert.assertEquals(burgerForTest.getPrice(), 800f, 0);
    }

    //Проверяется метод getReceipt класса Burger
    @Test
    public void getReceiptTest() {
        burgerForTest.setBuns(bunMockObjectForTest);
        burgerForTest.addIngredient(ingredientMockForTest1);
        burgerForTest.addIngredient(ingredientMockForTest2);
        burgerForTest.addIngredient(ingredientMockForTest3);

        Mockito.when(bunMockObjectForTest.getName()).thenReturn("black bun");
        Mockito.when(bunMockObjectForTest.getPrice()).thenReturn(100f);

        Mockito.when(ingredientMockForTest1.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(ingredientMockForTest1.getName()).thenReturn("sour cream");
        Mockito.when(ingredientMockForTest1.getPrice()).thenReturn(200f);

        Mockito.when(ingredientMockForTest2.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientMockForTest2.getName()).thenReturn("cutlet");
        Mockito.when(ingredientMockForTest2.getPrice()).thenReturn(100f);

        Mockito.when(ingredientMockForTest3.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredientMockForTest3.getName()).thenReturn("dinosaur");
        Mockito.when(ingredientMockForTest3.getPrice()).thenReturn(200f);

        Assert.assertEquals("(==== black bun ====)\r\n= sauce sour cream =\r\n= filling cutlet =\r\n= filling dinosaur =\r\n(==== black bun ====)\r\n\r\nPrice: 700,000000\r\n", burgerForTest.getReceipt());
    }


}