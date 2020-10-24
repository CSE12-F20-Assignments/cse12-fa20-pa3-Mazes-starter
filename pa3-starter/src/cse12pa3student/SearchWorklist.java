package cse12pa3student;

/*
 * Class to implement SearchWorklist as a Stack and a Queue.
 * You can use any built-in Java collections for this class.
 */

class StackWorklist implements SearchWorklist {
	
}

class QueueWorklist implements SearchWorklist {

}

public interface SearchWorklist {
	void add(Square c);
	Square remove();
	boolean isEmpty();
}
