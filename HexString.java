import java.util.*;

public class HexString{
	private String str;
	public int length(){
		return str.length();
	}
	public HexString(byte[] bytes){
		byte currentByte;
		StringBuffer output = new StringBuffer(bytes.length * 2);
		for(int i = 0; i < bytes.length; i++){
			output.append(byteToHexChars(bytes[i]));
		}
		str = output.toString();
	}
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
	public char[] byteToHexChars(byte charByte){
		char[] output = new char[2];
		output[0] = byteToHexChar((byte) ((charByte & 0xf0) / 16));
		output[1] = byteToHexChar((byte) (charByte & 0x0f));
		return output;
	}
	private static char byteToHexChar(byte charByte){
		char output;
		if(charByte >= 0 && charByte <= 9){
			output = (char)('0' + charByte);
		}
		else if(charByte >= 10 && charByte <= 15){
			output = (char)('a' + charByte - 10);
		}
		else{
			output = (char) 0;
		}
		return output;
	}
	public HexString fixedXOR(HexString hstring) throws InvalidHexStringException{
		byte[] thisHexString;
		byte[] otherHexString;
		byte[] newHexString;
		if(str.length() != hstring.length()){
			throw new InvalidHexStringException("Hex strings must match in length");
		}
		else{
			thisHexString = this.toBytes();
			otherHexString = hstring.toBytes();
			newHexString = new byte[thisHexString.length];
			for(int i = 0; i < thisHexString.length; i++){
				newHexString[i] = (byte) (thisHexString[i] ^ otherHexString[i]);
			}
			return new HexString(newHexString);
		}
	}
	public String toString(){
		return str;
	}
}
