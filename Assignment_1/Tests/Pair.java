/*
	Stand-in for the Pair<U, V> class the lab provides for this problem.

	It has exactly what the assignment describes: the two member variables
	first and second, the factory method Pair.of(U, V), and overridden
	equals() / hashCode().

	If your instructor hands out their own Pair.java for this problem, delete
	this file — you cannot have two classes named Pair in the same folder.
*/
class Pair<U, V>
{
	public final U first;
	public final V second;

	private Pair(U first, V second)
	{
		this.first = first;
		this.second = second;
	}

	public static <U, V> Pair<U, V> of(U first, V second)
	{
		return new Pair<U, V>(first, second);
	}

	@Override
	public boolean equals(Object other)
	{
		if (this == other)
		{
			return true;
		}

		if (!(other instanceof Pair))
		{
			return false;
		}

		Pair<?, ?> that = (Pair<?, ?>) other;

		return java.util.Objects.equals(this.first, that.first)
			&& java.util.Objects.equals(this.second, that.second);
	}

	@Override
	public int hashCode()
	{
		return java.util.Objects.hash(first, second);
	}

	@Override
	public String toString()
	{
		return "(" + first + ", " + second + ")";
	}
}
