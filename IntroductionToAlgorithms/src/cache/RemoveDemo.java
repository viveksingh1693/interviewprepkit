package cache;

import java.util.*;

public class RemoveDemo {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("Original list: " + list);

        // Remove by index (e.g., index 2 → removes 30)
        list.remove(2);
        System.out.println("After remove(2) → removes element at index 2: " + list);

        // Remove by value (e.g., value 40)
        list.remove(Integer.valueOf(40));
        System.out.println("After remove(Integer.valueOf(40)) → removes value 40: " + list);

        // Now trying remove(0), which removes the element at index 0
        list.remove(0);
        System.out.println("After remove(0) → removes element at index 0: " + list);

        // If we try to remove value 100 (not present), list remains unchanged
        boolean removed = list.remove(Integer.valueOf(100));
        System.out.println("Tried to remove value 100: " + (removed ? "Removed" : "Not found"));
        System.out.println("Final list: " + list);
    }
}
