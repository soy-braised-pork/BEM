import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zlx
 * Creat on 2022-04-01
 */
public class test {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Map map = HashMap.class.newInstance();
        Map map1 = new HashMap<>();
        Map map2= (Map) new HashMap().clone();



    }
}
