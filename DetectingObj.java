package coppelia;

import coppelia.IntW;
import coppelia.IntWA;
import coppelia.remoteApi;

public class DetectingObj {
public static void main(String args[]){
	remoteApi vrep = new remoteApi();
	vrep.simxFinish(-1);
	int clientID = vrep.simxStart("127.0.0.1", 19999, true, true, 5000, 5);
	float speed = 0.01f;
	if (clientID != -1) {
		System.out.println("connected to remote Api Server  " + clientID);
		IntW SensorHandle = new IntW(1);
		IntW pingTime = new IntW(3);
		BoolW detectionState = new BoolW(true);

		FloatWA detectedPoint = new FloatWA(0);

		IntW detectedObjectHandle = new IntW(0);

		FloatWA detectedSurfaceNormalVector = new FloatWA(0);
		vrep.simxGetObjectHandle(clientID, "Pioneer_p3dx_ultrasonicSensor4", SensorHandle,
				vrep.simx_opmode_blocking);
		vrep.simxGetPingTime(clientID, pingTime);
		vrep.simxReadProximitySensor(clientID, SensorHandle.getValue(), detectionState, detectedPoint,
				detectedObjectHandle, detectedSurfaceNormalVector, vrep.simx_opmode_blocking);
		vrep.simxGetPingTime(clientID, pingTime);
		if(detectionState.getValue()){
			vrep.simxReadProximitySensor(clientID, SensorHandle.getValue(), detectionState, detectedPoint,
					detectedObjectHandle, detectedSurfaceNormalVector, vrep.simx_opmode_blocking);
			System.out.println("Is object detected?: "+ detectionState.getValue() );
		}
		else{
			System.out.println("Is Object Detected? "+detectionState.getValue());
		}
		}
	else{
		System.out.println("Not Connected to VREP");
	}
}
}
