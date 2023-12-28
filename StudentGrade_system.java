import java.util.Scanner;

public class StudentGrade_system {
    public static void main(String[] args) {
		try (// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter the Number of Students: ");
			int num = sc.nextInt();
			

			int grades[] = new int[num];

			for (int i = 0; i < num; i++) {
				System.out.print("Enter grade of student " + (i + 1) + ": ");
				grades[i] = sc.nextInt();
			}
			int average = (int)average(grades);
			int highest = highest(grades);
			int lowest = lowest(grades);

			System.out.println("\nResults:");
			System.out.println("Average Score: " + average);
			System.out.println("Highest Score: " + highest);
			System.out.println("Lowest Score: " + lowest);
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	private static double average(int[] array) {
		int sum = 0;
		for (int value : array) {
			sum += value;
		}
		return (double) sum / array.length;
	}
	private static int highest(int[] array) {
		int highest = array[0];
		for (int value : array) {
			if (value > highest) {
				highest = value;
			}
		}
		return highest;
	}
	private static int lowest(int[] array) {
		int lowest = array[0];
		for (int value : array) {
			if (value < lowest) {
				lowest = value;
			}
		}
		return lowest;
	}
    
}
