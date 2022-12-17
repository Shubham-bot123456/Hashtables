import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(fineApproach("shubham jadhav"));
    }


    private static String firstNotRepeatedString(String string) {
        String[] arrayString = string.split("");
        Map<String, Integer> hashMap = new HashMap<>();
        for (String item : arrayString) {
            if (hashMap.keySet().contains(item)) continue;
            for (int i = 0; i < arrayString.length; i++) {
                if (hashMap.keySet().contains(item)) {
                    if (arrayString[i].equals(item)) {
                        if (!hashMap.containsKey(item)) hashMap.put(item, 1);
                        hashMap.put(item, hashMap.get(item) + 1);
                    }
                } else {
                    if (item.equals(arrayString[i]))
                        hashMap.put(item, 1);
                    else hashMap.put(item, 0);
                }
            }
            if (hashMap.get(item) == 1) return item;
        }

        return "nothing";
    }


    public static String fineApproach(String string) {
        String[] stringArray = string.split("");
        Map<String, Integer> map = new HashMap<>();
        for (String item : stringArray) {
            if (map.containsKey(item)) map.put(item, map.get(item) + 1);
            else map.put(item, 1);
        }

        String result = "nothing";
        for (String itemstring : stringArray) {
            if (map.get(itemstring) == 1) {
                result = itemstring;
                break;
            }
        }
        return result;
    }
}