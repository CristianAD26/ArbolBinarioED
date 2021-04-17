import java.util.Comparator;

class Compare<E extends Comparable<E>>
{
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(E a, E b)
    {
        return a.compareTo(b);
    }
} 