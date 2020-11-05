package java8codes;

public class towerOfHanoi {
	
	static int tower1 = 1;
	static int tower2 = 2;
	static int tower3 = 3;
	
	public static void recursive(int disks, int srcTower, int destTower, int helpTower) {
		if(disks == 1) {
			System.out.println("Move disk " + disks + " from tower " + srcTower + " to tower " + destTower);
			return;
		}
		
		recursive(disks-1, srcTower, helpTower, destTower);
		System.out.println("Move disk " + disks + " from tower " + srcTower + " to tower " + destTower);
		recursive(disks-1, helpTower, destTower, srcTower);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int disks = 5;
		
		recursive(disks, 1, 3, 2);
		
		
		
		

	}

}
