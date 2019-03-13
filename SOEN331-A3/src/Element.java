import be.ac.ua.ansymo.adbc.annotations.ensures;
import be.ac.ua.ansymo.adbc.annotations.invariant;
import be.ac.ua.ansymo.adbc.annotations.requires;

@invariant ({
	"$this.key != null",
	"$this.elementName != null"
})
public class Element {
    public String elementName;
  	public int key;
  	
  	@requires({"true"})
  	@ensures({
  		"$this.key != null",
  		"$this.elementName != null"
  	})
  	//Constructor
  	public Element() {
  		this.elementName = "Default Element";
  		this.key = 1;
  	}

  	@requires({
  		"elementName != null",
  		"key >= 0"
  	})
  	@ensures({
  		"$this.key != null",
  		"$this.elementName != null"
  	})
  	public Element(String elementName, int key) {
//  		super();
  		this.elementName = elementName;
  		this.key = key;
  	}

  	@requires({
  		"$this.elementName != null",
  		"$this.key != null"
  	})
  	@ensures({
  		"$result != null"
  	})
  	public String toString() {
  		return this.elementName + "; Key:"+ this.key;
  	}
  	
 	@requires({
  		"$this.elementName != null",
  		"$this.key != null"
  	})
  	@ensures({
  		"$result != null"
  	})
  	public String toString2() {
  		return this.elementName + "; Key:"+ this.key;
  	}

 	@requires({
  		"$this.elemenetName != null",
  	})
  	@ensures({
  		"$result == $this.elementName"
  	})
  	//Getters and setters
  	public String getElementName() {
  		return elementName;
  	}

	@requires({
  		"elemenetName != null",
  	})
  	@ensures({
  		"$this.elementName == elementName"
  	})
  	public void setElementName(String elementName) {
  		this.elementName = elementName;
  	}

	@requires({
  		"true",
  	})
  	@ensures({
  		"$this.key != null && $this.key > 0"
  	})
  	public int getKey() {
  		return key;
  	}

	@requires({
  		"key >=0",
  	})
  	@ensures({
  		"$this.key != null && $this.key > 0",
  		"this.key == key"
  	})
  	public void setKey(int key) {
  		this.key = key;
  	}
}
