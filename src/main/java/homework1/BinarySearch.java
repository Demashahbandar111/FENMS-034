package homework1;

public class BinarySearch {
    public static int[] search(Entry[] entries, String searchableName) {
       int startIndex = findFirstIndex(entries, searchableName, 0, entries.length - 1);
        if (startIndex == -1) {
            return new int[] {}; // No match found
        }
        int endIndex = findLastIndex(entries, searchableName, startIndex, entries.length - 1);
        return new int[] { startIndex, endIndex };
    }

    private static int findFirstIndex(Entry[] entries, String name, int low, int high) {
        int result = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = entries[mid].getName().compareTo(name);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                result = mid;
                high = mid - 1;  // Continue searching to the left
            }
        }
        return result;
    }

    private static int findLastIndex(Entry[] entries, String name, int low, int high) {
        int result = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = entries[mid].getName().compareTo(name);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                result = mid;
                low = mid + 1;  // Continue searching to the right
            }
        }
        return result;
    }
}
