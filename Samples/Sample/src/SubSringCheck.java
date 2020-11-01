
public class SubSringCheck {

	static String checkSubStr(String str, String subStr) {
		String retStr = "";

		if (str.contains(subStr)) {
			retStr = "available";
		} else {
			retStr = "not available";
		}

		return retStr;
	}

	static final synchronized strictfp public void main(String... args) {
		// TODO Auto-generated method stub
		String str = "a,the,last,best,first,guest,test,last,best,one";
		//String subStr = "first,test";
		String subStr = "best,one";

		System.out.println("SubString[" + subStr + "] is " + checkSubStr(str, subStr) + " in Str [" + str + "]");
	
	}

}
