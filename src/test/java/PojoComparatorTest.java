import com.acl.Person;
import com.acl.PojoComaparator;
import com.acl.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;


public class PojoComparatorTest {

    Person alban = new Person("Alban", "Clevy", "1234");
    Person alban2 = new Person("Alban", "Clevy", "123");
    Person audrey = new Person("Audrey", "Clevy","67889");
    String test = "Test";

    @Test
    public void testClassName() {

        PojoComaparator comparator = new PojoComaparator();

        Assertions.assertNull(comparator.compare(test,alban));
        Assertions.assertNotNull(comparator.compare(alban,audrey));
    }


    @Test
    public void testNumberOfDifference() {

        PojoComaparator comparator = new PojoComaparator();

        List<Result> resultList = comparator.compare(alban,audrey);
        Assertions.assertEquals(2,resultList.size());

        //  Assertions.assertNotNull(comparator.compare(alban,audrey));
    }
    @Test
    public void testDifference() {

        PojoComaparator comparator = new PojoComaparator();

        List<Result> resultList = comparator.compare(alban, alban2);
        Assertions.assertEquals(1,resultList.size());
        Assertions.assertEquals("telephone",resultList.get(0).getField());
        Assertions.assertEquals("1234",resultList.get(0).getValue1());
        Assertions.assertEquals("123",resultList.get(0).getValue2());
    }

    @Test
    public void testDifferenceWithExclude() {

        PojoComaparator comparator = new PojoComaparator();

        List<Result> resultList = comparator.compare(alban, alban2,"telephone");
        Assertions.assertEquals(0,resultList.size());

        resultList = comparator.compare(alban, audrey,"telephone","nom");
        Assertions.assertEquals(0,resultList.size());
    }
}
