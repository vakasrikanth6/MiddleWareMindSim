import java.util.Random;

import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
import lejos.hardware.Button;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.utility.Delay;

@SuppressWarnings({ "deprecation", "unused" })
public class Ultrasonicproject {

	DifferentialPilot pilot;
	
	public static void main(String[] args){
		new Ultrasonicproject();
}
public Ultrasonicproject(){
	pilot=new DifferentialPilot(1.5f, 6, Motor.A, Motor.D);
	Brick b= BrickFinder.getDefault();
	Port s2=b.getPort("S4");
	EV3UltrasonicSensor us=new EV3UltrasonicSensor(s2);
	Ultrasonic ultrasonic=new Ultrasonic(us.getDistanceMode());
	us.enable();
	
	while(true){
		float Distance= ultrasonic.distance();
		if(Button.ESCAPE.isDown()){
			pilot.stop();
			us.close();
			System.exit(0);}
			else if(Distance<0.3){
		
			pilot.backward();
			System.out.println(Distance);
			//Delay.msDelay(100);
			}
		else if(Distance>0.3){
			pilot.forward();
			System.out.println(Distance);
			//Delay.msDelay(100);
			}
		//else 
		//	pilot.stop();
			//System.out.println(Distance);
			Delay.msDelay(1000);
			
		
		
		}
	}
}


