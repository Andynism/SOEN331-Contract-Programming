import be.ac.ua.ansymo.adbc.annotations.ensures;
import be.ac.ua.ansymo.adbc.annotations.invariant;
import be.ac.ua.ansymo.adbc.annotations.requires;

@invariant ({
	"$this.capacity > 0",
	"$this.lastElementIndex >= 0",
	"$this.lastElementIndex <= $this.capacity"
})
public class PriorityQueue {
    public int lastElementIndex, capacity;
  	public MyArrayList<Element> data;	//Array that contains the data
  	
  	@requires({
  		"true"
  	})
  	@ensures({
  		"this.capacity>0"
  	})
  	//Constructor
  	public PriorityQueue() {
  		this(100);
  	}
  	
  	@requires({
  		"size > 0"
  	})
  	@ensures({
  		"$this.capacity > 0",
  		"$this.lastElementIndex==0"
  	})
  	public PriorityQueue(int size) {
  		this.capacity = size + 1;
  		this.data = new MyArrayList(this.capacity);
  		lastElementIndex = 0;
  	}

  	@requires ({
  		"value != null"
  	})
  	@ensures ({
  		"($this.lastElementIndex == $old($this.lastElementIndex)+1) || ($this.lastElementIndex == $old($this.lastElementIndex))"
  	})
  	//Insert a job in the Heap
  	public void insert(Element value) {
  		if(isFull()) {
  			System.out.println("PriorityQueue is Full, swapping the element with the lowest priority with the new element.");
  			int positionToChange = findLowestPriority();
  			data.set(positionToChange, value);
  		}
  		else {
  			data.set(++lastElementIndex, value);

  	  		int pos = lastElementIndex;

  	  		while (pos != 1 && value.getKey() < data.get(pos/2).getKey()){
  	  	            data.set(pos, data.get(pos/2));
  	  	            pos /=2;
  	  		}

  	  		data.set(pos, value);
  		}

  	}

  	//Find the lowest priority item
  	private int findLowestPriority() {
  		int position = 1;
  		for(int i=1; i<this.capacity;i++) {
  			if(data.get(i).getKey() > data.get(position).getKey())
  				position = i;
  		}
  		return position;
  	}

  	//Downheap the root
  	private void downHeap(int location) {
  		if(location < lastElementIndex){
  		    int p = location;
  		    int l = 2*p;
  		    int r = 2*p+1;
  		    if(r <= lastElementIndex && data.get(r).getKey() < data.get(p).getKey() && data.get(r).getKey() < data.get(l).getKey()){
  		        Element temp = data.get(r);
  		        data.set(r, data.get(p));
  		        data.set(p, temp);
  		        downHeap(r);
  		    }else if(l <= lastElementIndex && data.get(l).getKey() < data.get(p).getKey()){
  		        Element temp = data.get(l);
  		        data.set(l, data.get(p));
  		        data.set(p, temp);
  		        downHeap(l);
  		    }
  		}
  	}

  	@requires ({
  		"$this.isEmpty() == false"
  	})
  	@ensures ({
  		"$this.lastElementIndex == $old($this.lastElementIndex)-1"
  	})
  	//Remove the root
  	public Element remove() {
  		if(isEmpty()){
  			System.out.println("The Priority Queue is empty.");
  			return null;
  		}

  		Element elementToReturn = data.get(1);
  		data.set(1, data.get(lastElementIndex--));
  		downHeap(1);

  		return elementToReturn;
  	}

  	@requires({"$this.isEmpty() != true"})
  	@ensures({"$result != null"})
  	//Return the root
  	public Element min() {
  		if(isEmpty()){
  			System.out.println("The Priority Queue is empty.");
  			return null;
  		}
  		return data.get(1);
  	}
  	
  	@requires({"true"})
  	@ensures({"$result != null"})
  	public boolean isEmpty(){
  		return lastElementIndex == 0;
  	}
  	
  	@requires({"true"})
  	@ensures({"$result != null"})
  	public boolean isFull(){
  		return lastElementIndex == capacity - 1;
  	}

  	@requires({"$this.isEmpty() != true"})
  	@ensures({"$ans != null"})
  	public String toString() {
  		String ans = "";
  		for(int i = 1; i < lastElementIndex; i++) {
  			ans += data.get(i).toString();
  			ans +="\n";
  		}
  		return ans;
  	}
  	
  	@requires({"$this.isEmpty() != true"})
  	@ensures({"$ans != null"})
  	public String toString2() {
  		String ans = "";
  		for(int i = 1; i < lastElementIndex; i++) {
  			ans += data.get(i).toString();
  			ans +="\n";
  		}
  		return ans;
  	}

}
