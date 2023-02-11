import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionSexTest {
    Feline feline = Mockito.mock(Feline.class);
    private final String sex;
    private final Boolean haveMane;

    public LionSexTest(String sex, Boolean haveMane) {
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
}
