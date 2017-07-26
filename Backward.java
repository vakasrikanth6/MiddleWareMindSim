package coppelia;

public class Backward {
	
		 void moveBackward(int clientID,float speed){
				//speed=0.01f;
			 remoteApi vrep=new remoteApi();
				IntW leftHandle=new IntW(1);
				IntW rightHandle=new IntW(2);
				IntW pingTime=new IntW(3);
				int leftHandleMotor=0;
				int rightHandleMotor=0;
				leftHandleMotor=vrep.simxGetObjectHandle(clientID, "Pioneer_p3dx_leftMotor", leftHandle, vrep.simx_opmode_blocking);
				System.out.println(leftHandle.getValue());
			    rightHandleMotor=vrep.simxGetObjectHandle(clientID, "Pioneer_p3dx_rightMotor", rightHandle, vrep.simx_opmode_blocking);
				System.out.println(rightHandle.getValue());
				vrep.simxSetJointTargetVelocity(clientID, leftHandle.getValue(), -speed*100, vrep.simx_opmode_oneshot);
				vrep.simxGetPingTime(clientID, pingTime);
				vrep.simxSetJointTargetVelocity(clientID, rightHandle.getValue(), -speed*100, vrep.simx_opmode_oneshot);
				vrep.simxGetPingTime(clientID, pingTime);
			}
		
	}

