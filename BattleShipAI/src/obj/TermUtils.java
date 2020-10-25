package obj;

public class TermUtils {

	public static final String RESET = "\033[0m"; 
	
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    
    public static void printBoard(char [][] matrix) {
    	char c; 
    	for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				c = matrix[i][j];
				switch (c) {
				case 'o':
					//System.out.print(BLUE_BACKGROUND + " ");
					System.out.print(" o ");
					break;
				case 'x':
					//System.out.print(RED_BACKGROUND + "x");
					System.out.print(" x ");
					break;
				case '#':
					//System.out.print(GREEN_BACKGROUND + "#");
					System.out.print(" # ");
					break;
				case '-':
					//System.out.print(BLUE_BACKGROUND + "-");
					System.out.print(" - ");
					break;
				case '^':
					//System.out.print(BLUE_BACKGROUND + "-");
					System.out.print(" ^ ");
					break;
				case 'v':
					//System.out.print(BLUE_BACKGROUND + "-");
					System.out.print(" v ");
					break;
				case '<':
					//System.out.print(BLUE_BACKGROUND + "-");
					System.out.print(" < ");
					break;
				case '>':
					//System.out.print(BLUE_BACKGROUND + "-");
					System.out.print(" > ");
					break;
				default:
					break;
				}
			}
			//System.out.println(RESET);
			System.out.println(" ");
		}
    }
    
	
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    
}
