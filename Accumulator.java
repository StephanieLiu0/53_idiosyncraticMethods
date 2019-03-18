/**
  Represent accumulating data from the elements in a
  List_inArraySlots that are of a particular type.
 */

public class Accumulator {

    /**
      @return the concatenation of all the Strings
      in the \list that begin with \prefix,
      each followed by a space.
     */
    public static String catElementsStartingWith( List_inArraySlots list, String prefix ) {
        String result = "";

            /* 3.  Stumbling block 0
               Java protects a programmer against applying a method to
               elements in list when some elements of the list might
               omit support for a particular operation.

               This protection is implemented by the compiler
               The following code violates the restriction:

	       for( int el = 0; el < list.size(); el++) {
	           if (list.get( el).startsWith( prefix))
		       result += list.get(el) + " ";
	       }
              */

            /*
             predicted error message: startsWith(prefix) not found

             actual error message: cannot find symbol
             */


            /* 4.  Workaround 0
               A programmer should expect there to be a way to
               work around the stumbling block, because
               both the compiler and JVM
               know the type of an element.

               Java's instanceOf operator identifies the type
               of an element to the compiler.
             */


            /* 5.  Stumbling block 1
               However, use of the operator alone is insufficient,
               because the compiler
               objects to the following code that adds use of
               the operator to the code from Stumbling block 0:

	       for( int el = 0; el < list.size(); el++) {
	           if (list.get( el) instanceof String)
	    	       if (list.get( el).startsWith( prefix))
		           result += list.get(el) + " ";
	       }
             */

            /*
             predicted error message: startsWith(prefix) not found

             actual error message: cannot find symbol
             */


            /* 6. Workaround 1
               Programmers use Java's cast operator
               to tell the compiler
               that code uses a subclass's method on an object,
               even though the reference to the object is stored
               in a super-class variable.
             */


            /* 7. Stumbling block 2
               However, use of this operator alone is insufficient,
               because the JVM
               objects to the following code that adds use of
               the operator to the code from Stumbling block 0:

	       for( int el = 0; el < list.size(); el++) {
	           if (((String)list.get( el)).startsWith( prefix))
	 	       result += list.get(el) + " ";
   	       }
             */

            /*
             predicted error message: cannot cast

             actual error message: java.base/java.lang.Double cannot be cast to java.base/java.lang.String
             */


            /* 8. Workaround 2
               A programmer can combine use of both operators
               to apply a method to exactly those
               elements in the list that support the method.
             */

	for( int el = 0; el < list.size(); el++) {
	    if (list.get( el) instanceof String) {
		String strEl = (String) list.get(el);
		if (strEl.startsWith( prefix))
		    result += strEl + " ";
	    }
	}

        return result;
    }


    /**
      @return a list of each of the Double elements
      from the \list whose value is "finite".
     */
    public static List_inArraySlots finites( List_inArraySlots list) {
	List_inArraySlots finiteDoubles = new List_inArraySlots();
	
	for( int el = 0; el < list.size(); el++) {
	    if (list.get( el) instanceof Double) {
		Double doubleEl = (Double) list.get(el);
		if (doubleEl.isInfinite() == false)
		    finiteDoubles.add( doubleEl);
	    }
	}

	return finiteDoubles;
    }
}
