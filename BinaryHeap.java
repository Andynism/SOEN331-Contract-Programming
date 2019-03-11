public class BinaryHeap {
    private int lastElementIndex, capacity;
  	private MyArrayList<Element> data;	//Array that contains the data

  	//Constructor
  	public HeapArrayList() {
  		this(100);
  	}

  	public HeapArrayList(int size) {
  		this.capacity = size + 1;
  		this.data = new MyArrayList(this.capacity);
  		lastElementIndex = 0;
  	}

  	//Insert a job in the Heap
  	public void insert(Element value) {
  		data.set(++lastElementIndex, value);

  		int pos = lastElementIndex;

  		while (pos != 1 && value.getFinalPriority() < data.get(pos/2).getFinalPriority()){
  	            data.set(pos, data.get(pos/2));
  	            pos /=2;
  	    }

  	    data.set(pos, value);
  	}

  	//Downheap the root
  	public void downHeap(int location) {
  		if(location < lastElementIndex){
  		    int p = location;
  		    int l = 2*p;
  		    int r = 2*p+1;
  		    if(r < lastElementIndex && data.get(r).getFinalPriority() < data.get(p).getFinalPriority() && data.get(r).getFinalPriority() < data.get(l).getFinalPriority()){
  		        Job temp = data.get(r);
  		        data.set(r, data.get(p));
  		        data.set(p, temp);
  		        downHeap(r);
  		    }else if(l < lastElementIndex && data.get(l).getFinalPriority() < data.get(p).getFinalPriority()){
  		        Job temp = data.get(l);
  		        data.set(l, data.get(p));
  		        data.set(p, temp);
  		        downHeap(l);
  		    }
  		}
  	}

  	//Remove the root
  	public Element removeMin() {
  		if(isEmpty()){
  			System.out.println("The Priority Queue is empty.");
  			return null;
  		}

  		ELement elementToReturn = data.get(1);
  		data.set(1, data.get(lastElementIndex--));
  		downHeap(1);

  		return elementToReturn;
  	}

  	//Return the root
  	public Element getMin() {
  		if(isEmpty()){
  			System.out.println("The Priority Queue is empty.");
  			return null;
  		}
  		return data.get(1);
  	}

  	//Find the oldest job in the heap
  	public void findOldest() {
  		//System.out.println("Changing the oldest job's priority.");
  		Element oldest = data.get(1);
  		for(int i = 1; i< data.size();i++) {
  			if(data.get(i) != null && data.get(i).getEntryTime() > oldest.getEntryTime())
  				oldest = data.get(i);
  		}
  		oldest.setFinalPriority(1);
  	}


  	public boolean isEmpty(){
  		return lastElementIndex == 0;
  	}

  	public boolean isFull(){
  		return lastElementIndex == capacity - 1;
  	}

  	public String toString() {
  		String ans = "";
  		for(int i = 1; i < lastElementIndex; i++) {
  			ans += data.get(i).toString();
  			ans +="\n";
  		}
  		return ans;
  	}

}
