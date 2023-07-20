package structures;

public class BetaList <T> {
    T[] list = (T[]) new Object[10];
    int pointer = 0;

    public void append(T item){
        if (pointer == list.length / 2){
            list = expand();
        }
        list[pointer] = item;
        pointer += 1;
    }

    public void add(T item, int index){
        if (index > pointer){
            throw new IndexOutOfBoundsException();
        }

        T[] newList = (T[]) new Object[list.length];

        for (int i = 0; i < pointer; i++) {
            if (i < index)
                newList[i] = list[i];
            else if (index == i) {
                newList[i] = item;
                newList[i + 1] = list[i];
            }
            else
                newList[i + 1] = list[i];
        }
        list = newList;
    }

    private T[] expand(){
        T[] newList = (T[]) new Object[list.length * 2];

        for (int i = 0; i < list.length; i++) {
            newList[i] = list[i];
        }

        return newList;
    }

    public boolean contains(T item){
        for (int i = 0; i < list.length; i++) {
            if (list[0] == item)
                return true;
        }
        return false;
    }
    public T getFirst(){
        return list[0];
    }

    public T get(int index){
        return list[index];
    }

    public T getLast(){
        return list[pointer - 1];
    }

    public int size(){
        return pointer;
    }

    public void remove(int index){
        if (index > pointer)
            throw new IndexOutOfBoundsException();

        T[] newList = (T[]) new Object[list.length];
        for (int i = 0; i <= pointer; i++) {
            if (i < index)
                newList[i] = list[i];
            else if (i == index)
                continue;
            else
                newList[i - 1] = list[i];
        }
        list = newList;
        pointer -= 1;
    }

    public void clear(){
        list = (T[]) new Object[10];
        pointer = 0;
    }

    public boolean isEmpty(){
        return pointer == 0;
    }

    public int lastIndexOf(T item){
        for (int i = pointer; i > 0; i--) {
            if (item == list[i])
                return i;
        }
        return 0;
    }

    @Override
    public String toString() {
        String stringFormat = "[";

        for (T item: list) {
            if (item == null)
                break;
            stringFormat += item + ", ";
        }

        stringFormat += "]";

        return stringFormat;
    }
}

