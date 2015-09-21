import java.io.IOException;

public class XSNameChain {
	
    static int maxPathLength = 0;
    static final StringBuffer maxPathExample = new StringBuffer(500000);

	public static String names[];
    
    public static String getFirstChar(String str) {
		return str.substring(0, str.indexOf(" "));
	}

	public static String getLastChar(String str) {
	    return str.substring(str.indexOf(" ") + 1, str.length());
	}
	
	public static void getNameChain(String[] names){
		 for (int i = 0; i < names.length; i++) {
	            String tmp = names[0];
	            names[0] = names[i];
	            names[i] = tmp;
	            recursive(names, 1);//get into the recursive comparing
	            names[i] = names[0];
	            names[0] = tmp;
	       }
	}
	static void recursive(String[] part, int offset) {
        if (offset > maxPathLength) {//record longest name chain each time
            maxPathLength = offset;
            maxPathExample.setLength(0);
            maxPathExample.append(getFirstChar(part[0]));
            for (int i = 0; i < offset; i++) {
                maxPathExample.append(" " + getLastChar(part[i]));
            }
        }
        String lastChar = getLastChar(part[offset - 1]);
        for (int i = offset; i < part.length; i++) {
            if (getFirstChar(part[i]).equals(lastChar)) {
            	//compare if this element can be in the chain
                String tmp = names[offset];
                names[offset] = names[i];
                names[i] = tmp;
                recursive(names, offset+1);
                names[i] = names[offset];
                names[offset] = tmp;
            }
        }
    }
	
 
    public static void main(String[] args) {
//    	String FilePath = "src/test.txt";
    	String FilePath = "src/CeleName.txt";
		try {
			names = FileUtils.readFile(FilePath).split(";");
		} catch (IOException e) {
			// Auto-generated catch block
			e.printStackTrace();
		} 
    	 getNameChain(names);
    	System.out.println("maximum path length        : " + maxPathLength);
	    System.out.println("example path of that length: " + maxPathExample);
    }
}
