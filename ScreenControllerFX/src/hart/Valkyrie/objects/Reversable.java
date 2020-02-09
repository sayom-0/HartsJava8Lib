package hart.Valkyrie.objects;

import hart.Valkyrie.SuperConductor;
//TODO document this...
public class Reversable<T> implements SuperConductor
{
	T value;
	T last;
	
	public Reversable(T value)
	{
		this.last = value;
		this.value = value;
	}

	public T getValue()
	{
		return value;
	}

	public void setValue(T value)
	{
		last = this.value;
		this.value = value;
	}
	
	public T getLast()
	{
		return last;
	}

	@Override
	public void deConstruct()
	{
		value = null;
		last = null;
	}
}
