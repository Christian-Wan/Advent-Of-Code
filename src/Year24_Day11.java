import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Year24_Day11 {
    public static void main(String[] args) {
        HashMap<String, Long> input = new HashMap<>();
        HashMap<String, Long> storage = new HashMap<>();

        input.put("0", 1L);
        input.put("7", 1L);
        input.put("198844", 1L);
        input.put("5687836", 1L);
        input.put("58", 1L);
        input.put("2478", 1L);
        input.put("25475", 1L);
        input.put("894", 1L);

//        input.put("125", 1L);
//        input.put("17", 1L);
        Set<String> keys = new HashSet<>();
        for (int i = 0; i < 75; i++) {
            storage.clear();
            keys.clear();
            for (String key: input.keySet()) {
                if (Long.parseLong(key) == 0) {
                    if (keys.contains("1")) {
                        storage.replace("1", storage.get("1") + input.get(key));
                    }
                    else {
                        storage.put("1", input.get(key));
                    }
                }
                else if (key.length() % 2 == 0) {
                    String value1 = String.valueOf(Long.parseLong(key.substring(0, key.length()/2)));
                    String value2 = String.valueOf(Long.parseLong(key.substring(key.length()/2)));
                    if (keys.contains(value1)) {

                        storage.replace(value1, storage.get(value1) + input.get(key));
                    }
                    else {
                        storage.put(value1, input.get(key));
                    }
                    if (keys.contains(value2)) {
                        storage.replace(value2, storage.get(value2) + input.get(key));
                    }
                    else {
                        storage.put(value2, input.get(key));
                    }
                }
                else {
                    String key1 = String.valueOf(Long.parseLong(key) * 2024);
                    if (keys.contains(key1)) {
                        storage.replace(key1, storage.get(key1) + storage.get(key));
                    }
                    else {
                        storage.put(key1, input.get(key));
                    }
                }
                keys = storage.keySet();
            }
            input = new HashMap<>(storage);
        }
        Long total = 0L;
        for (String key: input.keySet()) {
            total += input.get(key);
        }
        System.out.println(total);
    }
}
