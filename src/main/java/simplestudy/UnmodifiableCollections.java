package simplestudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnmodifiableCollections {
	
	//Example showing how stupid unmodifiable collections are.
	public void createUnmodifiableCollection() {
		List<String> li1 = new ArrayList<>();
		li1.add("Lola");
		li1.add("Dick");
		List<String> li2 = Collections.unmodifiableList(li1);
		System.out.println("li2: " + li2);
		li1.add("Bobo");
		System.out.println("li2: " + li2);
	}

	public static void main(String[] args) {
		UnmodifiableCollections unc = new UnmodifiableCollections();
		unc.createUnmodifiableCollection();
	}

}
