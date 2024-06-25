package assignment_2;

import java.util.Scanner;

/**
 * The class JobScheduler performs job scheduling 
 * stimulating the First Come First Serve Algorithm
 */
public class JobScheduler {
	/**
	 * Calculate and returns the completion time of the processes
	 * @param processes  Two dimensional integer array 
	 * @return     Integer array with completion time
	 */
	static int[] getCompletionTime(int [][] processes) {
		int length = processes.length;
		int currTime = 0;
		int iterator = 0;
		int[] completionTime = new int[length];
		while(iterator<processes.length) {
			if(currTime >= processes[iterator][0]) {
				currTime += processes[iterator][1];
				completionTime[iterator] = currTime;
				iterator++;
			} else {
				currTime = processes[iterator][0];
			}
		}
		return completionTime;
	}
	
	/**
	 * Calculate and returns the Turn around time of the processes
	 * @param process
	 * @param completionTime
	 * @return
	 */
	private static int[] getTurnAroundTime(int[][] process, int[] completionTime) {
		int length = completionTime.length;
	    int[] turnAroundTime = new int[length];
	    for(int i = 0; i < length; i++) {
	    	turnAroundTime[i] = completionTime[i] - process[i][0];
	    }
		return turnAroundTime;
	}
	
	/**
	 * Calculate and returns the Waiting time of the processes
	 * @param process
	 * @param turnAroundTime
	 * @return
	 */
	private static int[] getWaitingTime(int[][] process, int[] turnAroundTime) {
		int length = turnAroundTime.length;
		int[] waitingTime = new int[length];
		for(int i = 0; i < length; i++) {
			waitingTime[i] = turnAroundTime[i] - process[i][1];
		}
		return waitingTime;
	}
	
	/**
	 * Calculate and returns the average waiting time of the process
	 * @param waitingTime
	 * @return
	 */
	private static double getAvgWaitingTime(int[] waitingTime) {
		double avgWaitingTime = 0;
		for(int i = 0; i < waitingTime.length; i++) {
			avgWaitingTime += waitingTime[i];
		}
		avgWaitingTime /= waitingTime.length;
		return avgWaitingTime;
	}
	
	/**
	 * Calculate and returns the average waiting time of the process
	 * @param waitingTime
	 * @return
	 */
	private static double getMaxWaitingTime(int[] waitingTime) {
		double maxWaitingTime = waitingTime[0];
		for(int i = 1; i < waitingTime.length; i++) {
			if( waitingTime[i] > maxWaitingTime )
				maxWaitingTime = waitingTime[i];
		}
		return maxWaitingTime;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of Process: ");
		int numberOfProcess = sc.nextInt();
		int[][] process = new int[numberOfProcess][2];
		System.out.println("Enter process arrival time and burst time:");
		for(int i=0; i < numberOfProcess; i++) {
			process[i][0] = sc.nextInt();
			process[i][1] = sc.nextInt();
		}
		sc.close();
		int[] completionTime = getCompletionTime(process);
		int[] turnAroundTime = getTurnAroundTime(process, completionTime);
		int[] waitingTime = getWaitingTime(process, turnAroundTime);
		System.out.println("Arrival Time\tBurst Time\tCompletion Time\t    Turn Around Time\tWaiting Time");
		for(int i=0; i<numberOfProcess; i++) {
			System.out.println("   " +process[i][0] +"\t\t   "+process[i][1]+"\t\t   "+completionTime[i]+"\t\t     "+turnAroundTime[i]+"\t\t\t     "+waitingTime[i]);
		}
		System.out.println("Average Waiting Time: " + getAvgWaitingTime(waitingTime));
		System.out.println("Maximum Waiting Time: " + getMaxWaitingTime(waitingTime));
	}
}
