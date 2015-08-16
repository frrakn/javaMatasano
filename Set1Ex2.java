import java.util.*;

public class Set1Ex2{ public static void main( String[] args ){
		HexString hexstring = new HexString(args[0]);
		HexString hexstring2 = new HexString(args[1]);
		System.out.println(hexstring.fixedXOR(hexstring2).toString());
	}
}
