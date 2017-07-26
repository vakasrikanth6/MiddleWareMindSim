package coppelia;
import coppelia.Backward;
import coppelia.Rotate;
public class LeftAndBackward extends Backward {
	void LeftAndBackward(int clientID,float speed){
		LeftAndBackward Left=new LeftAndBackward(); 
	remoteApi vrep=new remoteApi();
	IntW leftHandle=new IntW(1);
	IntW rightHandle=new IntW(2);
	IntW pingTime=new IntW(3);
	FloatWA eulerAngles=new FloatWA(1);
	int leftHandleMotor=0;
	int rightHandleMotor=0;
	//leftHandleMotor=vrep.simxGetObjectHandle(clientID, "Pioneer_p3dx_leftMotor", leftHandle, vrep.simx_opmode_blocking);
	//System.out.println(leftHandle.getValue());
    rightHandleMotor=vrep.simxGetObjectHandle(clientID, "Pioneer_p3dx_rightMotor", rightHandle, vrep.simx_opmode_blocking);
	//System.out.println(rightHandle.getValue());
	//vrep.simxSetJointTargetVelocity(clientID, leftHandle.getValue(), speed*600, vrep.simx_opmode_oneshot);
	//vrep.simxGetPingTime(clientID, pingTime);
	vrep.simxSetJointTargetVelocity(clientID, rightHandle.getValue(), speed*600, vrep.simx_opmode_oneshot);
	vrep.simxGetPingTime(clientID, pingTime);
	
	
	try {
	    Thread.sleep(1100);
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	Left.moveBackward( clientID, speed);
	}
}
