package coppelia;

import coppelia.IntW;
import coppelia.IntWA;
import coppelia.remoteApi;
import coppelia.BoolW;
import coppelia.FloatWA;


public class sprint9 {
	/*public static String toString(double[][] m) { 
		if (m == null) {
	            return "{}";
	        }
	        StringBuilder result = new StringBuilder();
	        result.append("{");
	        if (m.length > 0) {
	            for (int i=0; i < m.length; i++) {
	                result.append("{");
	                result.append(String.valueOf(m[i]));
	                result.append(", ");
	                result.append("}");
	            }
	        }
	        result.append("}");
	        return result.toString();
	}*/
	 public static void main(String[] args)
		    {
				remoteApi vrep=new remoteApi();
				vrep.simxFinish(-1);
				double PI=3.14;
				int clientID=vrep.simxStart("127.0.0.1", 19999, true, true, 5000, 5);
				if(clientID!=-1){
					System.out.println("connected to remote Api Server  "+clientID);
					
					IntW SensorHandle=new IntW(1);
					IntW rightHandle=new IntW(2);
					IntW pingTime=new IntW(3);
					
					float speed=0.01f;

					int Sensor1=vrep.simxGetObjectHandle(clientID, "Pioneer_p3dx_ultrasonicSensor1", SensorHandle, vrep.simx_opmode_blocking);
					System.out.println(SensorHandle.getValue());
					System.out.println(Sensor1);
					BoolW detectionState =new BoolW(false);
					FloatWA detectedPoint = new FloatWA(0);
					
					IntW detectedObjectHandle = new IntW(0);
					FloatWA detectedSurfaceNormalVector = new FloatWA(0);
					int x=vrep.simxReadProximitySensor(clientID, SensorHandle.getValue(), detectionState, detectedPoint, detectedObjectHandle, detectedSurfaceNormalVector, vrep.simx_opmode_blocking);
					vrep.simxGetPingTime(clientID, pingTime);
					System.out.println(x);
					System.out.println(SensorHandle.getValue());
					System.out.println(detectionState.getValue());
					//int v=(detectedPoint.getLength());
					System.out.println(detectedPoint.getLength());
					System.out.println(detectedObjectHandle.getValue());
					System.out.println((detectedSurfaceNormalVector.getLength()));
					//int[] g= new int[detectedPoint.getLength()];
				
					//g.length=detectedPoint.getLength();
					//for(float i=0;i<detectedPoint.getLength();i++){
						//g[i]=detectedPoint.get;
					}
				             
				        //}
				   /* rightHandleMotor=vrep.simxGetObjectHandle(clientID, "Pioneer_p3dx_rightMotor", rightHandle, vrep.simx_opmode_blocking);
					System.out.println(rightHandle.getValue());
					
					vrep.simxSetJointTargetVelocity(clientID, leftHandle.getValue(), speed*1000, vrep.simx_opmode_blocking);
					vrep.simxGetPingTime(clientID, pingTime);
					
					vrep.simxSetJointTargetVelocity(clientID, rightHandle.getValue(), speed*1000, vrep.simx_opmode_blocking);
					vrep.simxGetPingTime(clientID, pingTime);
					 int [] sensor = null;
			            int[] sensor_Val=null;
			            int [] sensor_Loc={(int) (-PI/2), (int) (-50/180.0*PI),(int) (-30/180.0*PI),(int) (-10/180.0*PI),(int) (10/180.0*PI),(int) (30/180.0*PI),(int) (50/180.0*PI),(int) (PI/2),(int) (PI/2),(int) (130/180.0*PI),(int) (150/180.0*PI),(int) (170/180.0*PI),(int) (-170/180.0*PI),(int) (-150/180.0*PI),(int) (-130/180.0*PI),(int) (-PI/2)}; 
				    	for(int x=0;x<sensor_Loc.length;x++){
				    		int sensorHandle=vrep.simxGetObjectHandle(clientID, "Pioneer_p3dx_ultrasonicSensor"+Integer.toString(x), leftHandle, vrep.simx_opmode_oneshot_wait);
				    	    //sensor[x]=sensorHandle;
				    	    System.out.println(sensorHandle);*/

				
				
				else
					System.out.println("connection failed");			
				
		    }
	}

