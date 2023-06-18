import javax.security.auth.x500.X500Principal;
import java.util.Scanner; //import Scanner

public class NeuralNetwork1 {
	
	public class Node {
		
		/*Inner Class Variables*/
		private int weight;
		private int bias;
		private int z;
		private int x;
		
		/*Inner Class Constructors*/
		public Node(int weight, int bias) {
			this.weight = weight;
			this.bias = bias;
		}
		
		public Node(int x) {
			this.x = x;
		}
		
		/*Methods*/
		public int activation(int x1, int x2) {
			z = this.weight*x1 + this.weight*x2 - bias; //activation function
			return (int)Math.round((1/(1 + Math.exp(-1*z)))); //sigmoid function
		}
		
	}

	public static void main(String[] args) {
		
		/*Variables*/
		String cont = ""; //continue
		Scanner scan = new Scanner(System.in); //user input scanner
		
		NeuralNetwork1 neural = new NeuralNetwork1();
		int x1, x2; //value of input nodes 
		Node X1, X2;
		Node h1 = neural.new Node(20, 30); //nodes of hidden layer
		Node h2 = neural.new Node(20,30);
		Node Y = neural.new Node(20, 30);
		
		/*Build Neural Network*/
		Node nodeArr[] = new Node[5]; //3D neural network
		nodeArr[2] = h1;
		nodeArr[3] = h2;
		nodeArr[4] = Y;
		
		/*Introduction*/
		System.out.println("-- Welcome to the Logic AND Neural Network! --");
		System.out.println("\nConsider the AND logic function...");
		System.out.println(" X1    X2 | Output");
		System.out.println("-----------------");
		System.out.println(" 0     0  |   0");
		System.out.println(" 0     1  |   0");
		System.out.println(" 1     0  |   0");
		System.out.println(" 1     1  |   1");
		
		do {
			/*Prompt User*/
			System.out.println("\nInput any of the X (int) values found in the table to the neural network to obtain the appropriate output, ");
			System.out.print(" x1: "); x1 = scan.nextInt();
			System.out.print(" x2: "); x2 = scan.nextInt();
			scan.nextLine();
			X1 = neural.new Node(x1);
			X2 = neural.new Node(x2);
			nodeArr[0] = X1;
			nodeArr[1] = X2;
			
			/*Forward Propagation*/
			
			
			
			
			/*Continue Loop*/
			System.out.print("\nContinue? (y/n) "); cont = scan.nextLine(); 
		} while("y".compareToIgnoreCase(cont) == 0);
		
		
		System.out.println("\n-- End of Program --");
	}

}
