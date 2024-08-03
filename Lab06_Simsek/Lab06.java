import java.util.ArrayList;

public class Lab06 {
    public static void main(String[] args) {
        int[] array = {0,2,3,4,5,7};
        ArrayList<String> list = new ArrayList<String>();
        list = binaryStringsWithoutConsecutiveOnes(8);
        
        System.out.println(list);
        System.out.println(smallestMissingInSortedArray(array));
        System.out.println(search("abcdef", "kkk", 0));
    }

    public static ArrayList<String> binaryStringsWithoutConsecutiveOnes(int k) {
        if(k == 0) {
            ArrayList<String> emptyList = new ArrayList<String>();
            emptyList.add("");
            return emptyList;
        }

        if(k == 1) {
            ArrayList<String> list = new ArrayList<String>();
            list.add("0");
            list.add("1");
            return list;
        }

        ArrayList<String> result = new ArrayList<String>();
        ArrayList<String> prevList = binaryStringsWithoutConsecutiveOnes(k - 1);

        for(int n = 0; n < prevList.size(); n++) {
            result.add(prevList.get(n) + "0");

            if(prevList.get(n).charAt(prevList.get(n).length() - 1) != '1') {
                result.add(prevList.get(n) + "1");
            }
        }

        return result;
    }

    public static boolean search(String word, String subWord, int k) {
        int n = word.length();
        int m = subWord.length();
        
        if(k < n - m + 1) {
            if(word.substring(k, k + m).equals(subWord)) {
                return true;
            }
            else {
                return search(word, subWord, k + 1);
            }
        }
        else {
            return false;
        }
    }

    public static int smallestMissingInSortedArray (int[] array) {
        if(array[0] != 0) {
            return 0;
        }

        if(array[array.length - 1] == array.length - 1) {
            return array.length;
        }

        int first = array[0];

        return firstMissingElement(array, 0, array.length - 1, first);
    }

    public static int firstMissingElement(int[] array, int start, int end, int first) {
        if(start < end) {
            int mid = (start + end) / 2;

            if(array[mid] != mid + first) {
                return firstMissingElement(array, start, mid, first);
            }
            else {
                return firstMissingElement(array, mid + 1, end, first);
            }
        }

        return start + first;
    }

  
}