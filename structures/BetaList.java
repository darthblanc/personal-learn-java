package structures;

public class BetaList <T> {
    T[] list = (T[]) new Object[10];
    int pointer = 0;

    /**
     * @param item
     * adds an item to the end of the list
     */
    public void append(T item){
        if (pointer == list.length / 2){
            expand();
        }
        list[pointer] = item;
        pointer += 1;
    }

    /**
     * @param item
     * @param index
     * add an item into a certain index
     */
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

    /**
     * expand the list
     */
    private void expand(){
        T[] newList = (T[]) new Object[list.length * 2];

        for (int i = 0; i < list.length; i++) {
            newList[i] = list[i];
        }

        list = newList;
    }

    /**
     * @param item
     * @return boolean
     * check if the list contains a certain item
     */
    public boolean contains(T item){
        for (int i = 0; i < list.length; i++) {
            if (list[0] == item)
                return true;
        }
        return false;
    }

    /**
     * @return first item in list
     */
    public T getFirst(){
        return list[0];
    }

    /**
     * @param index
     * @return item at certain index
     */
    public T get(int index){
        return list[index];
    }

    /**
     * @return last item in list
     */
    public T getLast(){
        return list[pointer - 1];
    }

    /**
     * @return size of the list
     */
    public int size(){
        return pointer;
    }


    /**
     * @param index
     * remove item at a certain index
     */
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

    /**
     * empty the list
     */
    public void clear(){
        list = (T[]) new Object[10];
        pointer = 0;
    }

    /**
     * @return boolean
     * check if list is empty
     */
    public boolean isEmpty(){
        return pointer == 0;
    }

    /**
     * @param item
     * @return last index of an item
     */
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

