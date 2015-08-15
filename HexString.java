import java.util.*;

public class HexString{
	private String str;
	public HexString(String string){
		str = string;
	}
	public byte[] toBytes() throws InvalidHexStringException{
		byte[] bytes;
		int val;
		char[] chars = this.str.toCharArray();
		bytes = new byte[chars.length / 2 + chars.length % 2];
		for(int i = 0; i < chars.length; i++){
			if(chars[i] - '0' >= 0 && chars[i] - '0' <= 9){
				val = chars[i] - '0';
			}
			else if(Character.toUpperCase(chars[i]) - 'A' >= 0 && Character.toUpperCase(chars[i]) - 'A' <= 5){
				val = Character.toUpperCase(chars[i]) - 'A' + 10;
			}
			else{
				throw new InvalidHexStringException("String contains non-hex digits " + chars[i]);
			}
			bytes[i / 2] += val << ((1 - (i % 2)) * 4); 
		}
		return bytes;
	}
	public String convertToBase64() throws InvalidHexStringException{
		Base64.Encoder base64Encoder = Base64.getEncoder();
		return base64Encoder.encodeToString(toBytes());
	}
}
