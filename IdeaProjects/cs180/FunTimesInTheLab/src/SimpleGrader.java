import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Skeleton Code for task 2
 */
public class SimpleGrader implements Runnable {
	public final static int SEED = 2430;
	public static int[] correctAnswers = generateCorrectAnswers();
	public static int[][] studentAnswers = generateStudentAnswers(correctAnswers);
	/* Do not change variables above (you can still import other packages if necessary) */
	/* add or edit necessary variables here*/
	public static int grade = 0;
	private int questionNumber;
	public static Object obj = new Object();
	private AtomicInteger a = new AtomicInteger(0);

	public SimpleGrader(int questionNumber){
		this.questionNumber = questionNumber;
	}
	// hint: When we create threads in main method, each thread only grades its assigned question
	// Therefore, we need a variable to indicate index of the assigned question.
	public SimpleGrader(){}
	
	
	@Override
	/**
	 * run() method will be called when a thread starts.
	 * in this case, the grading part should be done here
	 */
	public void run() {
		for(int i = 0; i < studentAnswers[questionNumber].length; i++){
			if(studentAnswers[questionNumber][i] == correctAnswers[questionNumber]){
				synchronized (obj){
					grade += 10;
				}
			}
			else if (studentAnswers[questionNumber][i] != 0){
				synchronized (obj){
					grade -= 3;
				}
			}
		}
//		grade += a.get();
	}
	
	public static void main(String[] args){
		Thread[] threads = new Thread[10];
		for(int i = 0; i < threads.length; i++){
			threads[i] = new Thread(new SimpleGrader(i));
		}
		// As the class implements Runnable instead of extends Thread, here is an example line of create a thread:
		// Thread t = new Thread(new SimpleGrader(...)); //the arguments should be corresponding to your constructor
		
		for(int i = 0; i < threads.length; i++){
			threads[i].start();
		}

		for(int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				System.out.println("Oops!");
			}
		}


		// to get the average grade
		// you can make changes if necessary
		double average = grade / 1000.0;
		System.out.printf("The average score is %.3f\n", average);
	}
	
	/* Do not change lines below */
	public static int[] generateCorrectAnswers(){
		int[] answers = new int[10];
		Random r = new Random(SEED);
		for(int i = 0; i < answers.length; i ++){
			answers[i] = r.nextInt(4) + 1;
		}
		return answers;
	}
	
	public static int[][] generateStudentAnswers(int[] answers){
		int[][] response = new int[10][1000];
		Random r = new Random(SEED);
		for(int i = 0; i < response.length; i ++){
			int answer = answers[i];
			for(int j = 0; j < response[i].length; j++){
				if(r.nextInt(10) < 7){
					response[i][j] = answer;
				}else if(r.nextBoolean()){
					response[i][j] = 0;
				}else{
					response[i][j] = r.nextInt(4) + 1;
				}
			}
		}
		return response;
	}
}
