import javax.security.auth.x500.X500Principal;
import java.util.Scanner; //import Scanner

public class NeuralNetwork1 {
	
	public class Node {
		
		/*Inner Class Variables*/
		private int weight;
		private int bias;
		private int sigmoid;
		private int z;
		private int x;
		
		/*Inner Class Constructors*/
		public Node(int weight, int bias) {
			this.weight = weight;
			this.bias = bias;
			this.sigmoid = 2;
		}
		
		public Node(int x) {
			this.x = x;
		}
		
		/*Setters and Getters*/
		public int getX() { return this.x; }
		public int getSigmoid() { return this.sigmoid; }
		public void setSigmoid(int sigmoid) { this.sigmoid = sigmoid; }
		
		/*Methods*/
		public int activation(int x1, int x2) {
			z = this.weight*x1 + this.weight*x2 - bias; //activation function
			return (int)Math.round((1/(1 + Math.exp(-1*z)))); //sigmoid function
		}
		
	} //end of inner class

	public static void main(String[] args) {
		
		/*Variables*/
		String cont = ""; //continue
		Scanner scan = new Scanner(System.in); //user input scanner
		int j = 0;
		
		NeuralNetwork1 neural = new NeuralNetwork1();
		int x1, x2; //value of input nodes 
		Node X1, X2;
		Node h1 = neural.new Node(20, 30); //nodes of hidden layer
		Node h2 = neural.new Node(20,30);
		Node Y = neural.new Node(20, 30);
		
		/*Build Neural Network*/
		Node inputLayer[] = new Node[2]; //input layer
		//inputLayer[0] = X1;
		//inputLayer[1] = X2;
		Node hiddenLayer[] = new Node[2]; //hidden layer
		hiddenLayer[0] = h1;
		hiddenLayer[1] = h2;
		Node outputLayer[] = new Node[1]; //output layer
		outputLayer[0] = Y;
		
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
			System.out.print(" X1: "); x1 = scan.nextInt();
			System.out.print(" X2: "); x2 = scan.nextInt();
			scan.nextLine();
			X1 = neural.new Node(x1);
			X2 = neural.new Node(x2);
			inputLayer[0] = X1;
			inputLayer[1] = X2;
			
			/*Forward Propagation*/
			for(int i = 0; i < hiddenLayer.length; i++) {
				j = (i == 1) ? 0 : 1;
				hiddenLayer[i].setSigmoid(hiddenLayer[i].activation(inputLayer[i].getX(), inputLayer[j].getX())); //activation function
			}
			outputLayer[0].setSigmoid(outputLayer[0].activation(hiddenLayer[0].getSigmoid(), hiddenLayer[1].getSigmoid()));
			System.out.println("The Output of the neural network is... " + outputLayer[0].getSigmoid());
			
			/*Continue Loop*/
			System.out.print("\nContinue? (y/n) "); cont = scan.nextLine(); 
		} while("y".compareToIgnoreCase(cont) == 0);
		
		System.out.println("\n-- End of Program --");
	} //end of driver

} //end of class
