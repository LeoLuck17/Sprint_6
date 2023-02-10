import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTest {
    Feline feline = Mockito.mock(Feline.class);
    private final String sex;
    private final Boolean haveMane;
    public LionTest(String sex, Boolean haveMane){
        this.sex = sex;
        this.haveMane = haveMane;
    }
    @Parameterized.Parameters
    public static Object[][] setData(){
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }
    @Test
    public void doesHaveManeReturned() throws Exception {
        Lion lion = new Lion(feline, sex);
        boolean expectedHaveMane = haveMane;
        boolean actualHaveMane = lion.doesHaveMane();
        assertEquals(expectedHaveMane, actualHaveMane);
    }
    @Test
    public void doesHaveManeReturnedException() throws Exception {
        try {
            Lion lion = new Lion(feline, "Окно");
            lion.doesHaveMane();
        } catch (Exception exception) {
            assertEquals(exception.getMessage(), "Используйте допустимые значения пола животного - самец или самка");
        }
    }
    @Test
    public void lionGetFoodHowPredator() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualFood = lion.getFood();
        assertEquals(expectedFood, actualFood);
    }
    @Test
    public void lionGetKittens() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        int expectedKittens = 3;
        Mockito.when(feline.getKittens()).thenReturn(3);
        int actualKittens = lion.getKittens();
        assertEquals(expectedKittens, actualKittens);
    }
}