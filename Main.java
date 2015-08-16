import java.util.*;

public class Main{
	public static void main( String[] args ){
		try{
			HexString hexstring = new HexString(args[0]);
			HexString hexstring2 = new HexString(args[1]);
			System.out.println(hexstring.fixedXOR(hexstring2).toString());
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
