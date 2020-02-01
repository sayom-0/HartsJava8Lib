package hart.Valkyrie.objects;

public class Reversable<T>
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
}
