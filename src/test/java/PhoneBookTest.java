import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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

}