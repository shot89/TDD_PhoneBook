import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {

    private static Map<String,String> PHONE_BOOK = new TreeMap<>();

    public int add(String number, String name){
        if (PHONE_BOOK.isEmpty()){
            PHONE_BOOK.put(number, name);
            return 1;
        } else if (!PHONE_BOOK.containsKey(number)){
            PHONE_BOOK.put(number, name);
            return 1;
        }
        return -1;
    }

    public String findByNumber(String number){
        return PHONE_BOOK.get(number);
    }

}
