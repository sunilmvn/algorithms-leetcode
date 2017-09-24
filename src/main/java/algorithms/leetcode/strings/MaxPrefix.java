package algorithms.leetcode.strings;

/**
 * Find Max Length prefix of an Array of Strings
 * @author vmukkavilli
 *
 */
public class MaxPrefix {
	public static String getMaxPrefix(String[] s){
		boolean breakNow= false;
		StringBuffer sb = new StringBuffer();
		int i = 0;
		while(!breakNow){
			Character a = null;
			boolean init = false;
			for(int j=0;j<s.length;j++){
				System.out.println("This is for string "+s[j]+" at index "+i);
				if(s[j] == null){
					breakNow = true;
					break;
				}
				char[] c = s[j].toCharArray();
				if(c.length == i){
					breakNow = true;
					break;
				}
				else{
					if(!init){
						a = c[i];
					} else if(!a.equals(c[i])){
						breakNow = true;
						break;
					}
				}
			}
			if(!breakNow){
				i++;
				sb.append(a);
			}
		}
		return sb.toString();
	}
	public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
		String[] s = {"answer","ansker","answher","ans","answert","answe"};
		System.out.println(getMaxPrefix(s));
    }
}
