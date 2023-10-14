import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


//New Features of Java 12

/***  The teeing() method ***/
//teeing() is a static method of the Collectors class that is used to return a Collector combining the results of two Collector operations.

//Parameters
//Collector<? super T, ?, R1> downstream1: The first collector.
//Collector<? super T, ?, R2> downstream2: The second collector.
//BiFunction<? super R1,? super R2, R> merger: The merging function to combine the results of the first and the second collector.
//Return value
//This method returns a collector that aggregates the results of two supplied collectors.

//example:

public class Example3 {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Person{
        String name;
        Integer age;
    }

    public static void main(String[] args) {

        Map<String, List<Person>> map =
                Stream.of(new Person("Ahmed",30), new Person("Zein",29), new Person("Taqi",27))
                        .collect(Collectors.teeing(
                                Collectors.filtering( p->(p.age%2 ==0), Collectors.toList()),
                                Collectors.filtering(p->(p.age%2 !=0), Collectors.toList()),
                                (c1,c2)->{
                                    Map<String, List<Person>> newMap = new HashMap<>();
                                    newMap.put("evenAgedPersons",c1);
                                    newMap.put("oddAgedPersons",c2);
                                    return newMap;
                                }
                        ));


    }
}
