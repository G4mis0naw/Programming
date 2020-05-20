package app;

public interface ImmutableLinkedListIface extends Iterable<Integer> {
    public class Item {
        public final int value;
        public final Item next;

        public Item(int value, Item next) {
            this.value = value;
            this.next = next;
        }
    }

    Item add(int value);//to the end
    Item insert(Item prev, int value);// after prev
    void remove(Item item);
    Item find(int value);
    int count();

}
