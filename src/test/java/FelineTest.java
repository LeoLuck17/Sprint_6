import com.example.Animal;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {
    @Spy
    Feline feline;
    @Test
    public void eatMeatFeline() throws Exception {
        Animal animal = new Animal();
        List<String> expectedFood = animal.getFood("Хищник");
        List<String> actualFood = feline.eatMeat();
        assertEquals(expectedFood, actualFood);
    }
    @Test
    public void getFamilyFeline(){
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals(expectedFamily, actualFamily);
    }
    @Test
    public void getKittensInputCount(){
        int expectedCountKittens = 3;
        int actualCountKittens = feline.getKittens(3);
        assertEquals(expectedCountKittens, actualCountKittens);
    }
    @Test
    public void getKittensOutputCount(){
        int actualCountKittens = feline.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
        // я не понимаю убрать зависимость getKittens() от getKittens(int),
        // это значение находиться в Feline - мокнуть его я не могу, так как проверяю этот класс
        // не понимаю как мне ТУТ подставить в getKittens(int) значение, которое будет принимать getKittens() в @Test
    }
}