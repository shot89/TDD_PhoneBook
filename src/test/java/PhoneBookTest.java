import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.List;
import java.util.stream.Stream;


class PhoneBookTest {
    PhoneBook phoneBook;

    @BeforeEach
    void setUp() {
        System.out.println("Test start");
        phoneBook = new PhoneBook();
    }

    @ParameterizedTest
    @MethodSource("addSource")
    void test_add(int expected, String phone, String name){
        Assertions.assertEquals(expected, phoneBook.add(phone,name));
    }

    private static Stream<Arguments> addSource(){
        return Stream.of(
                Arguments.of(1, "89999999999","admin"),
                Arguments.of(-1, "89999999999","admin")
        );
    }

    @Test
    void test_findByNumber(){
        String number = "89991231234";
        String name = "Vasya";
        String expected = "Vasya";

        phoneBook.add(number,name);
        String result = phoneBook.findByNumber(number);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test_findByName(){
        String number = "89991231234";
        String name = "Vasya";
        String expected = "89991231234";

        phoneBook.add(number,name);
        String result = phoneBook.findByName(name);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void test_printAllNames() {
        String number1 = "89999999999";
        String name1 = "admin";
        String number2 = "89991231234";
        String name2 = "Vasya";
        List<String> expected = List.of(name2, name1);
        
        phoneBook.add(number1, name1);
        phoneBook.add(number2, name2);
        List<String> result = phoneBook.printAllNames();
        
        Assertions.assertEquals(expected, result);
                
    }
}