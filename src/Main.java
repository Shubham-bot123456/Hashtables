import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println(fineApproach("shubham jadhav"));
        System.out.println(firstRepeatCharacter("green apple"));
        System.out.println(firstrepeatedcharacterUsingSets("shubham jadhav."));
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


    public static void printTheHashMap(Map<String, Integer> integerStringHashMap) {
        System.out.println(integerStringHashMap.toString());
    }


    public static String firstRepeatCharacter(String string) {

        String[] stringArray = string.split("");
        Map<String, Integer> hashMap = new HashMap<>();
        String result = "";
        for (String item : stringArray) {
            if (!hashMap.keySet().contains(item)) {
                hashMap.put(item, 1);
                continue;
            }
            hashMap.put(item, hashMap.get(item) + 1);
            result = item;
            break;
        }
        return result;
    }


    public static String firstrepeatedcharacterUsingSets(String inputString) {
        String[] array = inputString.split("");
        Set<String> hashSet = new HashSet<>();
        int size = 0;
        String result="";
        for (String element : array) {
            hashSet.add(element);
            size += 1;
            if(hashSet.size()<size){
                result=element;
                break;
            }
        }
        return result;
    }

}