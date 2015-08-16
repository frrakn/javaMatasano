public class Set1Ex1{
	public static void main( String[] args ){
		HexString hstring = new HexString(args[0]);
		System.out.println(hstring.convertToBase64());
	}
}
