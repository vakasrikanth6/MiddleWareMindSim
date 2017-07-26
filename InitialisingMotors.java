package coppelia;

public class InitialisingMotors {
public static void main(String args[]){
	 remoteApi vrep=new remoteApi();
	 int clientID = vrep.simxStart("127.0.0.1", 19999, true, true, 5000, 5);
		IntW leftHandle=new IntW(1);
		IntW rightHandle=new IntW(2);
		IntW pingTime=new IntW(3);
		int leftHandleMotor=0;
		int rightHandleMotor=0;
		leftHandleMotor=vrep.simxGetObjectHandle(clientID, "Pioneer_p3dx_leftMotor", leftHandle, vrep.simx_opmode_blocking);
		System.out.println(leftHandle.getValue());
	    rightHandleMotor=vrep.simxGetObjectHandle(clientID, "Pioneer_p3dx_rightMotor", rightHandle, vrep.simx_opmode_blocking);
		System.out.println(rightHandle.getValue());
}
}
