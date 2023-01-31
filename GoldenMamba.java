package DorianHerzig;
import robocode.*;

public class GoldenMamba extends JuniorRobot{

	public void run() {
	
		setColors(gray, yellow, gray, yellow, black);
		
		while(true) {
			//He uses that to move around, that in wavy lines.
			turnAheadLeft(70, 70);
			turnAheadRight(70, 70);
			turnGunRight(360);
		}
	}

	public void onScannedRobot() {
		//This detects how far away the opponent is.
		out.println(scannedDistance);
		out.println(scannedVelocity);
		turnGunTo(scannedAngle + scannedVelocity/2);
		//When the enemy robot gets closer, it does more damage.
		if(scannedDistance < 15){
			fire(3);
			}
		else if(scannedDistance < 50){
			fire(2);
			}
		else if(scannedDistance < 100){
			fire(1);
			}
	}

	public void onHitByBullet() {
		//This is used to dodge and re-trace the enemy.
		back(50);
		turnBackLeft(40, 30);
	}
	
	public void onHitWall() {
	//This is used when he hits a wall.
  		turnBackLeft(40, 30);
		turnLeft(180);
	}	
}
//more informatione for code witch i found on this Website https://blogs.motiondevelopment.top/blog/posts/junior-robot-code