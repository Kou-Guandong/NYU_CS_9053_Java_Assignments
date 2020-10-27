import java.util.*;

public class MaxFinder<T> {
        private Object[] values;
        private final int defaultSize = 64;
        private volatile int size;

        public MaxFinder() {
                values = new Object[defaultSize];
        }

        public <T extends Number> T max() {
                T max = (T) values[0];
                for (int i = 1; i < size; i++) {
                        T element = (T) values[i];
                        if (max.intValue() < element.intValue()) {
                                max = element;
                        }
                }
                return max;
        }

        public void add(T t) {
                if (t == null) {
                        System.out.println("invalid object");
                        return;
                }
                values[size] = t;
                size++;
                if (size >= defaultSize) {
                        Object[] newData = Arrays.copyOf(values, defaultSize << 1);
                        values = newData;
                }
        }

        public int size() {
                return this.size;
        }

        @SuppressWarnings("unchecked")
        public T get(int index) {
                if (index >= 0 && index < size) {
                        return (T) values[index];
                } else {
                        throw new RuntimeException("invalid index");
                }
        }

        public static void main(String[] args) {
                MaxFinder<Number> m = new MaxFinder<Number>();
                ComplexNumber n1 = new ComplexNumber(1, 5);
                int a = 3;
                double d = 2.4;
                m.add(n1);
                m.add(a);
                m.add(d);
                Number max = m.max();
                System.out.println("max for m is " + max);
                MaxFinder<Integer> m1 = new MaxFinder<Integer>();
                Integer b = 10;
                Integer c = 7;
                m1.add(b);
                m1.add(c);
                Integer max1 = m1.max();
                System.out.println("max for m1 is " + max1);
        }

}
