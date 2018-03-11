package application;

public enum MyEnum {
	  FIRST_CHOICE ("Deweloperskie"),
	  SECOND_CHOICE ("Testowe"),
	  THIRD_CHOICE("Produkcyjne") ;
	  private String choice;

	  MyEnum(String choice) {
	    this.choice = choice;
	  }

	  public String toString() {
	    return choice;
	  }
	}
