package app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ImmutableLinkedList implements ImmutableLinkedListIface {

    private Item _head;
    private int _count = 0;

    public Item add(int value) {

        if(_head == null){
            Item item = new Item(value,null);
            _head = item;
        }else{
            List<Integer> values = getArrayList();
            values.add(value);
            buildNewLinkedList(values);
        }
        
        _count++;
        return _head;
    }


    public Item insert(Item prev, int value) {

        if(contain(value)){
            return null;
        }

        Integer prevInt = prev.value;
        List<Integer> values = getArrayList();
        List<Integer> newValues = new ArrayList<>();
        for(Integer v:values){
            newValues.add(v);
            if(v == prevInt){
                newValues.add(value);
            }
        }

        buildNewLinkedList(newValues);

        _count++;
        return _head;
    }

    public void remove(Item item) {
        
        if(!contain(item.value)){
            return;
        }

        List<Integer> values = getArrayList();
        List<Integer> newValues = new ArrayList<>();
        for(Integer v:values){
            if(v != item.value){
                newValues.add(v);
            }
        }

        buildNewLinkedList(newValues);
        _count--;
    }

    public Item find(int value) {
        
        Iterator<Item> it = iterator();
        while (it.hasNext()){
            Item item = it.next();
            if(item.value == value){
                return item;
            }
        }

        return null;
    }

    @Override
    public int count() {
        return _count;
    }

    public void buildNewLinkedList(List<Integer> values){

        Item next = null;
        for(int i = values.size()-1;i>=0;i--){
            Integer temp = values.get(i);
            Item prev = new Item(temp, next);
            next = prev;
        }

        _head = next;
    }

    public List getArrayList(){

        Iterator<Item> it = iterator();
        List<Integer> values = new ArrayList<>();
        while(it.hasNext()){
            values.add(it.next().value);
        }

        return values;
    }

    @Override
    public Iterator iterator() {
        return new ItemIterator(_head);
    }


    public boolean contain(int v){
        
        Iterator<Item> it = iterator();
        while (it.hasNext()){
            Item item = it.next();
            if(item.value == v){
                return true;
            }
        }
        
        return false;
    }


    private class ItemIterator implements Iterator<Item>{

        private Item _current;
        private Item next ;

        private ItemIterator(Item start){
            next = start;
        }

        @Override
        public boolean hasNext() {
            if(next == null){
                return false;
            }
            _current =next;
            next= _current.next;
            return true;
        }

        @Override
        public Item next() {
            return _current;
        }

    }
}
