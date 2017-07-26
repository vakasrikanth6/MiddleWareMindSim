package coppelia;

import coppelia.IntW;
import coppelia.IntWA;
import coppelia.remoteApi;
import coppelia.LeftAndForward;
import coppelia.RightAndForward;
import coppelia.Backward;
import coppelia.LeftAndBackward;
import coppelia.RightAndBackward;
import coppelia.Forward;

public class LastSprint extends LeftAndForward {
	void RightAndForward(int clientID, float speed) {
		RightAndForward Right = new RightAndForward();

		remoteApi vrep = new remoteApi();
		IntW leftHandle = new IntW(1);
		IntW rightHandle = new IntW(2);
		IntW pingTime = new IntW(3);
		int leftHandleMotor = 0;
		int rightHandleMotor = 0;
		leftHandleMotor = vrep.simxGetObjectHandle(clientID, "Pioneer_p3dx_leftMotor", leftHandle,
				vrep.simx_opmode_blocking);
		System.out.println(leftHandle.getValue());
		vrep.simxSetJointTargetVelocity(clientID, leftHandle.getValue(), speed * 600, vrep.simx_opmode_oneshot);
		vrep.simxGetPingTime(clientID, pingTime);

		try {
			Thread.sleep(1700);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
		Right.moveForward(clientID, speed);
	}

	void moveBackward(int clientID, float speed) {
		remoteApi vrep = new remoteApi();
		IntW leftHandle = new IntW(1);
		IntW rightHandle = new IntW(2);
		IntW pingTime = new IntW(3);
		int leftHandleMotor = 0;
		int rightHandleMotor = 0;
		leftHandleMotor = vrep.simxGetObjectHandle(clientID, "Pioneer_p3dx_leftMotor", leftHandle,
				vrep.simx_opmode_blocking);
		System.out.println(leftHandle.getValue());
		rightHandleMotor = vrep.simxGetObjectHandle(clientID, "Pioneer_p3dx_rightMotor", rightHandle,
				vrep.simx_opmode_blocking);
		System.out.println(rightHandle.getValue());
		vrep.simxSetJointTargetVelocity(clientID, leftHandle.getValue(), -speed * 100, vrep.simx_opmode_oneshot);
		vrep.simxGetPingTime(clientID, pingTime);
		vrep.simxSetJointTargetVelocity(clientID, rightHandle.getValue(), -speed * 100, vrep.simx_opmode_oneshot);
		vrep.simxGetPingTime(clientID, pingTime);
	}

	public static void main(String[] args) {
		remoteApi vrep = new remoteApi();
		Sprint10 forward = new Sprint10();
		vrep.simxFinish(-1);
		int clientID = vrep.simxStart("127.0.0.1", 19999, true, true, 5000, 5);
		float speed = 0.01f;
		if (clientID != -1) {
			System.out.println("connected to remote Api Server  " + clientID);

			IntW leftHandle = new IntW(1);
			IntW rightHandle = new IntW(2);
			IntW pingTime = new IntW(3);
			int leftHandleMotor = 0;
			int rightHandleMotor = 0;
			IntW SensorHandle = new IntW(1);

			BoolW detectionState = new BoolW(true);

			FloatWA detectedPoint = new FloatWA(0);

			IntW detectedObjectHandle = new IntW(0);

			FloatWA detectedSurfaceNormalVector = new FloatWA(0);

			Sprint10 Left = new Sprint10();

			int sensor1 = 0;
			leftHandleMotor = vrep.simxGetObjectHandle(clientID, "Pioneer_p3dx_leftMotor", leftHandle,
					vrep.simx_opmode_blocking);
			// System.out.println(leftHandle.getValue());
			rightHandleMotor = vrep.simxGetObjectHandle(clientID, "Pioneer_p3dx_rightMotor", rightHandle,
					vrep.simx_opmode_blocking);
			vrep.simxGetObjectHandle(clientID, "Pioneer_p3dx_ultrasonicSensor4", SensorHandle,
					vrep.simx_opmode_blocking);
			vrep.simxGetPingTime(clientID, pingTime);
			System.out.println(SensorHandle.getValue());
			vrep.simxReadProximitySensor(clientID, SensorHandle.getValue(), detectionState, detectedPoint,
					detectedObjectHandle, detectedSurfaceNormalVector, vrep.simx_opmode_blocking);
			while (true) {
				System.out.println("is object detected?: "+detectionState.getValue());

				Left.moveForward(clientID, speed);
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				vrep.simxReadProximitySensor(clientID, SensorHandle.getValue(), detectionState, detectedPoint,
						detectedObjectHandle, detectedSurfaceNormalVector, vrep.simx_opmode_blocking);
				while (detectionState.getValue()) {

					vrep.simxReadProximitySensor(clientID, SensorHandle.getValue(), detectionState, detectedPoint,
							detectedObjectHandle, detectedSurfaceNormalVector, vrep.simx_opmode_blocking);
					System.out.println("is object detected? "+detectionState.getValue());
					float[] arr = detectedPoint.getArray();

					float a = arr[0];
					float b = arr[1];
					float c = arr[2];
					System.out.println("x,y,z coordinates are" + a + b + c);
					double d = Math.sqrt(a * a + b * b + c * c);
					System.out.println("Distance between object and Robot is "+d);
					if (d < 0.7) {
						System.out.println("Turning Right");
						Left.LeftAndForward(clientID, speed);
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						System.out.println("No turn");
						Left.moveForward(clientID, speed);
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}
			}

		} else {
			System.out.println("Not Connected");
		}

	}
}
