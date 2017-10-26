package utils;

public class FormatUils {
	public static Float FloatDelBaifen(String in){
		try{
			in=in.replaceAll("%", "");
			return Float.parseFloat(in);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
