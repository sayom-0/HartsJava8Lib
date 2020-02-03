package hart.Valkyrie.objects.NamedLists;

import java.io.Serializable;
import java.util.LinkedList;

import hart.Valkyrie.objects.NamedList;

public class NamedLinkedList<T> extends NamedList<T> implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3965547293843701026L;

	public NamedLinkedList()
	{
		NAL = new LinkedList<String>();
		DAL = new LinkedList<T>();
	}
}
