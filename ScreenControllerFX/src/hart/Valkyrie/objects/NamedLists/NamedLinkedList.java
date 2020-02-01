package hart.Valkyrie.objects.NamedLists;

import java.io.Serializable;
import java.util.LinkedList;

public class NamedLinkedList<T> extends NamedArrayList<T> implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3965547293843701026L;

	public NamedLinkedList()
	{
		NAL = new LinkedList<String>();
		DAL = new LinkedList<T>();
		trim = true;
	}

	public NamedLinkedList(boolean flag)
	{
		NAL = new LinkedList<String>();
		DAL = new LinkedList<T>();
		trim = flag;
	}
}
