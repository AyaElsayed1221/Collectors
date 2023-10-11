import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Example1 {

    /**
     * collect( Collector ) is a terminal operator
     * takes as  parameter a Collector
     * Collector is the object telling the method how to collect the values.
     * You will not implement ur own collectors, but you will use some collectors already exist by the means of static methods find in the Collectors class.
     *
     **/

    public static void main(String[] args) {
       //example Collect.toList
        List<Integer> l1 = List.of(1,2,3,4,5,2,3,4);

        List l2 =
                l1.stream()
                // some intermediate operations
                .collect(Collectors.toList());

        //System.out.println(l2);

        /****************************************************/

        //example Collect.toSet

        Set resultSet =
                l1.stream()
                //some intermediate operations
                        .collect(Collectors.toSet());

          //  System.out.println(resultSet);

        /**************************************************/

        // If you want another specific type of collection like TreeSet or LinkedHashSet or others
        // u have to use Collect.toCollection
        // toCollection method takes a parameter of type supplier (Remember: supplier consumes no values and return a value)
        // the supplier in toCollection method have to return a new instance of the required collection.
        // example

        TreeSet<Integer> treeResult =
                l1.stream()
                //some intermediate operations
                        .collect(Collectors.toCollection(()->new TreeSet<Integer>()));

        System.out.println(treeResult);
    }
}