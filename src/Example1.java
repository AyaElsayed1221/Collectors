import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        //System.out.println(treeResult);

        /************************* collect to Map *******************************************/

        //If you want to collect the stream items in to a MAP we have two methods doing that
        //toMap(Function)
        //The toMap() method is a static method of Collectors class which returns a Collector that accumulates elements into a Map whose keys and values are the result of applying the provided mapping functions to the input elements.
        // Note that keys are unique and if in any case the keys are duplicated then an IllegalStateException is thrown when the collection operation is performed.
        //There are 3 overloads of toMap() method:
       /**  1.  toMap(Function keyMapper, Function valueMapper)     **/

       //Parameters: This method accepts following parameters:
        //keyMapper: a mapping function to produce keys
        //valueMapper: a mapping function to produce values
        //Return Value: This method returns a Collector which collects elements into a Map whose keys and values are the result of applying mapping functions to the input elements

//example:
              Stream<String[]> inputStream =  Stream.of( new String[][]{
                        {"1","Ayaa","Elsayed"},
                        {"1","Rahma","Shrief"},
                        {"3","Asmaa","Mohammed"}
                });


//        Map<Integer, String> resultMap1 =
//                        inputStream.collect(Collectors.toMap(
//                                x -> Integer.parseInt(x[0]), x-> (x[1]+" "+x[2])
//                        )
//                        ); //the first parameter represent the key: which must be unique and the second parameter is the value

        //System.out.println("Map: "+resultMap1); //Exception of duplicate key expected

        /** 2. toMap(Function keyMapper, Function valueMapper, BinaryOperator<U> mergeFunction) **/
        //Parameters: This method accepts following parameters:
        //keyMapper: a mapping function to produce keys
        //valueMapper: a mapping function to produce values
        //mergeFunction: a merge function, used to resolve collisions between values associated with the same key, as supplied to Map.merge(Object, Object, BiFunction)

    //Return Value: This method returns a Collector which collects elements into a Map whose keys are the result of applying a key mapping function to the input elements,
        // and whose values are the result of applying a value mapping function to all input elements equal to the key
        // and combining them using the merge function
        //example:

//        Map<Integer, String> resultMap2 =
//                inputStream.collect(Collectors.toMap(
//                                x-> Integer.parseInt(x[0]),
//                                x-> (x[1]+" "+x[2]),
//                                (a,b)-> a+"  or  "+b  //The third parameter id a bi-function telling the method what will happen with the values in case of duplication keys.
//                        //a and b represent the values of the both duplicated keys
//                        )
//                );

       //System.out.println("Map: "+resultMap2);

       /** 3.  toMap(Function keyMapper, Function valueMapper, BinaryOperator<U> mergeFunction, Supplier mapSupplier) **/
       // This is an overloaded method of toMap() with an additional parameter .i.e Suppliers.
        // We need to pass supplier here. Supplier is the interface of the java.util.Function class.
        // This is a functional interface and can therefore be used as the assignment target for a lambda expression or method reference.
        // If we want to return LinkedHashMap, we need to pass supplier as LinkedHashMap::new.
      //Parameters: This method accepts following parameters:
        //
        //keyMapper: a mapping function to produce keys
        //valueMapper: a mapping function to produce values
        //mergeFunction: a merge function, used to resolve collisions between values associated with the same key, as supplied to Map.merge(Object, Object, BiFunction)
        //mapSupplier : a function which returns a new, empty Map into which the results will be inserted
        //Return Value: This method returns a Collector which collects elements into a Map whose keys are the result of applying a key mapping function to the input elements, and whose values are the result of applying a value mapping function to all input elements equal to the key and combining them using the merge function
        //
        //Below example illustrates the above method:

        LinkedHashMap<Integer, String> linkedHashMap =
                                                    inputStream.collect(Collectors.toMap(
                                                                                        k-> Integer.parseInt(k[0]),
                                                                                        v-> v[1] + v[2],
                                                                                        (v1,v2)-> (v1+" / "+v2),
                                                                                        LinkedHashMap::new
                                                                                        ));

        System.out.println("linkedHashMap:"+linkedHashMap);
    }
}