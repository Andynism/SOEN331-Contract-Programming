public class Element {
    public String elementName;
  	public int finalPriority;
  	//Constructor
  	public Element() {
  		super();
  		this.elementName = "Default Element";
  		this.finalPriority = 1;
  	}

  	public Element(String elementName, int finalPriority) {
  		super();
  		this.elementName = elementName;
  		this.finalPriority = finalPriority;
  	}

  	public Element(Element j) {
  		super();
  		this.elementName = j.getElementName();
  		this.finalPriority = j.getFinalPriority();
  	}

  	public String toString() {
  		return this.elementName + "; Priority:"+ this.finalPriority;
  	}

  	//Getters and setters
  	public String getElementName() {
  		return elementName;
  	}

  	public void setElementName(String elementName) {
  		this.elementName = elementName;
  	}

  	public int getFinalPriority() {
  		return finalPriority;
  	}

  	public void setFinalPriority(int finalPriority) {
  		this.finalPriority = finalPriority;
  	}
}
