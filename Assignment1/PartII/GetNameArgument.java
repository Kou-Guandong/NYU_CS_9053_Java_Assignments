
public class GetNameArgument {
	
	public static void main(String[] args) {
		// This will print out the contents of the args array.
		// Don't worry about the specifics of how this works. We
		// will get to that next week
		System.out.println("Hello " + args[0]);
		// if there are command line arguments, then the first will be in
		// args[0], the second in args[1], and so on. If there are no command
		// line arguments, then args[0] will give an error
	}
}
