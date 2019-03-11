public class PriorityQueueDriver {
  public static void main(String[] args){
    int maxNumberOfElement = 500;
    Element[] elementsInputArray = new Element[maxNumberOfElement];
    Element executing;
    String elementName;
    int elementPriority;
    int counterOfElementDone = 0;

    //Setting the jobsInputArray for all the testing
    for(int i=0;i<maxNumberOfElement;i++) {
    		elementName = "Element_" + (i+1);
    		elementPriority = (int) (Math.random()*100+1);
    		elementsInputArray[i] = new Element(elementName,elementPriority);
    }


    PriorityQueue pq1 = new PriorityQueue(maxNumberOfElement);

    //Insert elements to ADT
		for(int i=0;i<maxNumberOfElement;i++) {
			pq1.insert(elementsInputArray[i]);
		}

    //Loop to do all the jobs in the ADT
		long start = System.currentTimeMillis();
		while(!pq1.isEmpty()) {
			executing = pq1.getMin();//Get most important job
			if(executing != null) {
				System.out.println("Now executing " + executing.toString());

				pq1.removeMin();//Remove the job
				counterOfElementDone++;
			}

		}
		long end = System.currentTimeMillis();

    System.out.print("Number of elements done:" + counterOfElementDone);
  }
}
