public class PriorityQueue {
    private int lastElementIndex, capacity;
  	private Element[] data;	//Array that contains the data

  	//Constructor
  	public PriorityQueue() {
  		this(100);
  	}

  	public PriorityQueue(int size) {
  		this.capacity = size*2;
  		this.data = new Element[this.capacity];
  		lastElementIndex = 0;
  	}

  	//Insert job in array
  	public void insert(Element value) {
  		data[++lastElementIndex] = value;
  	}

  	//Remove the smallest element
  	public Element removeMin() {
  		if(isEmpty()){
  			System.out.println("The Priority Queue is empty.");
  			return null;
  		}
  		int positionToRemove = 0;
  		while(positionToRemove <= lastElementIndex)  {
  			if(data[positionToRemove] != null)
  				break;
  			positionToRemove++;
  		}
  		int i = 0;
  		while(i < lastElementIndex) {
  			if(data[positionToRemove] != null && data[i] != null) {
  				if(data[i].getFinalPriority() < data[positionToRemove].getFinalPriority())
  					positionToRemove = i;
  			}
  			i++;

  		}

  		Element min = data[positionToRemove];
  		data[positionToRemove] = null;
  		return min;
  	}

  	//Return the smallest element
  	public Element getMin() {
  		if(isEmpty()){
  			System.out.println("The Priority Queue is empty.");
  			return null;
  		}
  		int positionToRemove = 0;
  		while(positionToRemove <= lastElementIndex)  {
  			if(data[positionToRemove] != null)
  				break;
  			positionToRemove++;
  		}
  		int i = 0;
  		while(i < lastElementIndex-1) {
  			if(data[positionToRemove] != null && data[i] != null) {
  				if(data[i].getFinalPriority() < data[positionToRemove].getFinalPriority())
  					positionToRemove = i;
  			}
  			i++;

  		}


  		return data[positionToRemove];
  	}

  	public boolean isEmpty(){
  		Element a = data[0];
  		for(int i=0;i<data.length;i++) {
  			if(data[i] != null)
  				a = data[i];
  		}
  		if(a != null) {
  			return false;
  		}

  		return true;
  	}

  	public boolean isFull(){
  		return lastElementIndex == capacity - 1;
  	}

  	public String toString() {
  		String ans = "";
  		for(int i = 1; i < lastElementIndex; i++) {
  			ans += data[i].toString();
  			ans +="\n";
  		}
  		return ans;
  	}

  	public int getSize() {
  		return data.length;
  	}
}
