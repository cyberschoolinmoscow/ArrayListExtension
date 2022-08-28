import java.util.*;

public class A extends ArrayList<Integer> {

    public Iterator<Integer> iterator() {
        return new Iter();
    }
    public A(){
        data=new Integer[10];
    }
    // Your CODE will be placed HERE
    public Integer[] data;
    // длина используемой части
    private int size;

    @Override
    public boolean add (Integer obj)
    {
        if (size==0){
            data[size] = obj;
            size++;
            return true;
        }
     else    if (size == data.length){
            Integer[] nData = new Integer[size * 2];
            System.arraycopy(data, 0, nData, 0, size);
            data = nData;
        }
        data[size] = obj;
//     sort();

// if (obj>data[size-1]){
//         data[size] = obj;
//     }else {
//         int a=data[size-1];
//         data[size-1]=obj;
//         data[size]=a;
//     }

        size++;



        return true;
    }

//    private void sort() {
//        boolean isSorted=false;int k=0;
//        while (!isSorted){
//            k=0;
//            for (int i=0;i<data.length-2;i++) {
//                if(i+1>= data.length-2){
//                    break;
//                }
////                if (data[i]==(null)){
////                    break;
////                }
//                if (data[i+1]==(null)){
//                    break;
//                }
//                if (data[i] > data[i + 1]) {
//                    int buf = data[i];
//                    data[i] =
//                            data[i + 1];
//                    data[i + 1] = buf;
//                    isSorted = false;
//                    k++;
//                }
//            }
//                if(k==0){
//                    isSorted=true;
//                }
//
//        }
//    }

    public Integer remove(int i) {
        if (i != size - 1)
            System.arraycopy(data, i + 1, data, i, size - i);
        // очищаем последний элемент
        data[size - 1] = null;
        size--;
        return null;
    }
    public int getSize() {
        return size;
    }

    public Integer get(int i) {
        return data[i];
    }
public void set(Integer i,int j){
        data[i]=j;
}


    private  class Iter implements Iterator<Integer> {
        int cursor=size-1;
        private void sort() {
            boolean isSorted=false;int k=0;
            while (!isSorted){
                k=0;
                for (int i=0;i<data.length-2;i++) {
                    if(i+1>= data.length-2){
                        break;
                    }
//                if (data[i]==(null)){
//                    break;
//                }
                    if (data[i+1]==(null)){
                        break;
                    }
                    if (data[i] > data[i + 1]) {
                        int buf = data[i];
                        data[i] =
                                data[i + 1];
                        data[i + 1] = buf;
                        isSorted = false;
                        k++;
                    }
                }
                if(k==0){
                    isSorted=true;
                }

            }
        }
        @Override
        public boolean hasNext() {
            sort();
            if (cursor >= 0)
                return true;
            else
                return false;
        }

        @Override
        public Integer next() {

            cursor--;
            return data[cursor + 1];
        }

        @Override
        public void remove() {
            A.this.remove(cursor);
        }
    }
}
