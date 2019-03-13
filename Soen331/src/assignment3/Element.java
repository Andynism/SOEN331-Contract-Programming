public class Element {
    public String elementName;
  	public int key;
  	//Constructor
  	public Element() {
  		super();
  		this.elementName = "Default Element";
  		this.key = 1;
  	}

  	public Element(String elementName, int key) {
  		super();
  		this.elementName = elementName;
  		this.key = key;
  	}

  	public Element(Element j) {
  		super();
  		this.elementName = j.getElementName();
  		this.key = j.getKey();
  	}

  	public String toString() {
  		return this.elementName + "; Key:"+ this.key;
  	}

  	//Getters and setters
  	public String getElementName() {
  		return elementName;
  	}

  	public void setElementName(String elementName) {
  		this.elementName = elementName;
  	}

  	public int getKey() {
  		return key;
  	}

  	public void setKey(int key) {
  		this.key = key;
  	}
}
