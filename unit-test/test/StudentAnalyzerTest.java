import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.Collections;

public class StudentAnalyzerTest {

    StudentAnalyzer analyzer = new StudentAnalyzer();

    @Test
    void testCount() {
        assertEquals(2,
            analyzer.countExcellentStudents(
                Arrays.asList(9.0,8.5,7.0,11.0,-1.0)));
    }

    @Test
    void testAverage() {
        assertEquals(8.17,
            analyzer.calculateValidAverage(
                Arrays.asList(9.0,8.5,7.0,11.0,-1.0)),0.01);
    }
}