import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class LionTest {
    Feline feline = Mockito.mock(Feline.class);
    @Test
    public void doesHaveManeReturnedException() throws Exception {
        Exception exception = assertThrows(Exception.class, () ->{
            Lion lion = new Lion(feline, "Окно");
            lion.doesHaveMane();
        });
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
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