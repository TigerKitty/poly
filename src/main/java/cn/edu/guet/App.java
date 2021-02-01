package cn.edu.guet;
import cn.edu.guet.poly.Animal;
import cn.edu.guet.poly.Dog;
import cn.edu.guet.util.ConfigReader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        String className = ConfigReader.getClassName();
        Animal animal = (Animal) Class.forName(className).newInstance();
        animal.bark();
    }
}
