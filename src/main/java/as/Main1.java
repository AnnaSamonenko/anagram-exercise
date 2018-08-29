package as;

import java.util.ArrayList;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        List<Integer> intsList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            intsList.add(i);
            intsList.add(i);
        }
        ClassWithBug buggy = new ClassWithBug(intsList);
        buggy.removeElementsByFilter((i) -> i % 2 == 0);
        System.out.println(buggy.getInts());
    }

    private static interface Filter {

        public boolean filter(Integer i);

    }

    private static class ClassWithBug {

        private final List<Integer> intsList = new ArrayList<>();
        private List<Integer> toRemove = new ArrayList<>();

        public ClassWithBug(final List<Integer> intsList) {
            this.intsList.addAll(intsList);
        }

        public void removeElementsByFilter(Filter f) {
            for (int i = 0; i < intsList.size(); i++) {
                Integer value = intsList.get(i);
                if (f.filter(value)) {
                    toRemove.add(value);
                }
            }
            intsList.removeAll(toRemove);
        }

        public List<Integer> getInts() {
            return intsList;
        }
    }
}

