import java.util.ArrayList;
import java.util.Iterator;

public class MyIterator<T> implements Iterator<T> {
	
    private ArrayList<T> data;
    
    private int position;

    public MyIterator(ArrayList<T> data) {
    	
        this.data = data;
        
        position = 0;
    }

    @Override
    public boolean hasNext() {
    	
        return position < data.size();
    }

    @Override
    public T next() {
    	
        T element = data.get(position);
        
        position++;
        
        return element;
    }

    @Override
    public void remove() {
    	
        data.remove(position - 1);
        
        position--;
    }

    public void reset() {
        position = 0;
    }
}
