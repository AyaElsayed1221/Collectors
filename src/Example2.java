import java.util.stream.Collectors;
import java.util.stream.Stream;

   //Java 8

public class Example2 {
    //Collectors.joining()
    //The joining() method of Collectors Class, in Java, is used to join various elements of a character or string array into a single string object.
    // This method uses the stream to do so. There are various overloads of joining methods present in the Collector class.

    /** joining() **/
    //java.util.stream.Collectors.joining() is the most simple joining method which does not take any parameter.
    // It returns a Collector that joins or concatenates the input streams into String in the order of their appearance.
    public static void main(String[] args) {
       // char[] ch = {'A','y','a',' ','E','l','s','a','y','e','d'};
        String[] str ={"Long"," Live"," Free"," Proud"," Palestine"};

        String believe1 =
                Stream.of(str[0],str[1],str[2],str[3],str[4])
                        .collect(Collectors.joining());
                       //.forEach(x-> System.out.println(x));
        System.out.println(believe1);

        /************************************************************************/
        //Using delimiter

        String believe2 =
                Stream.of(str[0],str[1],str[2],str[3],str[4])

                        .collect(Collectors.joining(","));

        System.out.println(believe2);
        /*****************************************************************************/
//Using delimiter, prefix and suffix

        String believe3 =
                Stream.of(str[0],str[1],str[2],str[3],str[4])

                        .collect(Collectors.joining(",", "begin "," end"));

        System.out.println(believe3);


    }


}
