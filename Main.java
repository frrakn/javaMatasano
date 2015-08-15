import java.util.*;

public class Main{
	public static void main( String[] args ){
		try{
			HexString hexstring = new HexString(args[0]);
			System.out.println(hexstring.convertToBase64());
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
