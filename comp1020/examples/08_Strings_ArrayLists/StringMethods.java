/**Testing some notable String methods
  * from the class slides.
  * 
  * Look at the Strings documentation
  * for detailed expalanation on how
  * these work.
  */

public class StringMethods {
  public static void main(String [] parms) {
    
    String s = "The big fat dog";
    String domain = "http://google.com";
    
    // Extracting the domain name ("google.com") from domain
    String domainName = domain.substring(domain.indexOf("//") + 2);
    System.out.println(domainName);
    
    // Extracting the top-level domain (".com") from domainName
    System.out.println(domainName.substring(domainName.indexOf("."))); // or ".c", ".com" - all the same result
    
    // Given the String s, extract the substring "big fat " from s.
    String sub1 = s.substring(s.indexOf("big"), s.indexOf("dog"));
    System.out.println(sub1);
    
    // Searching the string s for the word "e".
    // This returns the index of the first occurence of "e"
    // in s. If s does not contain "e", it will return an
    // integer value less than 0; usually -1. RTFM (lol)
    System.out.println(s.indexOf("e"));
  }
}