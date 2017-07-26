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
public class Sprint10 extends LeftAndForward {
	void RightAndForward(int clientID,float speed){
		RightAndForward Right=new RightAndForward(); 
		
	remoteApi vrep=new remoteApi();
	IntW leftHandle=new IntW(1);
	IntW rightHandle=new IntW(2);
	IntW pingTime=new IntW(3);
	int leftHandleMotor=0;
	int rightHandleMotor=0;
	leftHandleMotor=vrep.simxGetObjectHandle(clientID, "Pioneer_p3dx_leftMotor", leftHandle, vrep.simx_opmode_blocking);
	System.out.println(leftHandle.getValue());
	
   //rightHandleMotor=vrep.simxGetObjectHandle(clientID, "Pioneer_p3dx_rightMotor", rightHandle, vrep.simx_opmode_blocking);
	//ystem.out.println(rightHandle.getValue());
	vrep.simxSetJointTargetVelocity(clientID, leftHandle.getValue(), speed*600, vrep.simx_opmode_oneshot);
	vrep.simxGetPingTime(clientID, pingTime);
	//vrep.simxSetJointTargetVelocity(clientID, rightHandle.getValue(), speed*1000, vrep.simx_opmode_oneshot);
	
	//vrep.simxGetPingTime(clientID, pingTime);
	//Right.moveForward(clientID, speed);*/
	try {
	    Thread.sleep(1700);
	} catch(InterruptedException ex) {
	    Thread.currentThread().interrupt();
	}
	Right.moveForward( clientID, speed);
	}
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

	public static void main(String[] args)
    {
	remoteApi vrep=new remoteApi();
	   Sprint10 forward=new Sprint10();
		vrep.simxFinish(-1);
		int clientID=vrep.simxStart("127.0.0.1", 19999, true, true, 5000, 5);
		float speed=0.01f;
		if(clientID!=-1){
			System.out.println("connected to remote Api Server  "+clientID);
			
			IntW leftHandle=new IntW(1);
			IntW rightHandle=new IntW(2);
			IntW pingTime=new IntW(3);
			int leftHandleMotor=0;
			int rightHandleMotor=0;
			IntW SensorHandle=new IntW(1);
			
			
			BoolW detectionState=new BoolW(true);
			
			
			FloatWA detectedPoint=new FloatWA(0);
			
			
			IntW detectedObjectHandle=new IntW(0);
			
			
			FloatWA detectedSurfaceNormalVector= new FloatWA(0);
			
			
			Sprint10 Left=new Sprint10();
			
			int sensor1=0;
			leftHandleMotor=vrep.simxGetObjectHandle(clientID, "Pioneer_p3dx_leftMotor", leftHandle, vrep.simx_opmode_blocking);
			//System.out.println(leftHandle.getValue());
		    rightHandleMotor=vrep.simxGetObjectHandle(clientID, "Pioneer_p3dx_rightMotor", rightHandle, vrep.simx_opmode_blocking);
		    vrep.simxGetObjectHandle(clientID, "Pioneer_p3dx_ultrasonicSensor4", SensorHandle, vrep.simx_opmode_blocking);
		    vrep.simxGetPingTime(clientID, pingTime);
			System.out.println(SensorHandle.getValue());
			vrep.simxReadProximitySensor(clientID, SensorHandle.getValue(), detectionState, detectedPoint, detectedObjectHandle, detectedSurfaceNormalVector, vrep.simx_opmode_blocking);
	         while(true){
	        	 float[] arr = detectedPoint.getArray();
	        	 
	        	 float a=arr[0];
	        	 float b=arr[1];
	        	 float c=arr[2];
	        	 double d=Math.sqrt(a*a+b*b);
	        	 System.out.println(d);
	        	 System.out.println(detectionState.getValue());
	        	 if(detectionState.getValue()==true){
	        		 Left.LeftAndForward(clientID, speed);
	        		 try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}}
	        	 else {
	        		 Left.moveForward(clientID, speed);
	        		 try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        	 }
	        	 vrep.simxReadProximitySensor(clientID, SensorHandle.getValue(), detectionState, detectedPoint, detectedObjectHandle, detectedSurfaceNormalVector, vrep.simx_opmode_blocking);
			/*System.out.println(sensor1);
			 vrep.simxGetObjectHandle(clientID, "Pioneer_p3dx_ultrasonicSensor1", SensorHandle1, vrep.simx_opmode_blocking);
			    vrep.simxGetPingTime(clientID, pingTime);
				System.out.println(SensorHandle1.getValue());
				 vrep.simxGetObjectHandle(clientID, "Pioneer_p3dx_ultrasonicSensor8", SensorHandle2, vrep.simx_opmode_blocking);
				    vrep.simxGetPingTime(clientID, pingTime);
					System.out.println(SensorHandle2.getValue());
					 vrep.simxGetObjectHandle(clientID, "Pioneer_p3dx_ultrasonicSensor12", SensorHandle3, vrep.simx_opmode_blocking);
					    vrep.simxGetPingTime(clientID, pingTime);
						System.out.println(SensorHandle3.getValue());*/
					/*	while(true){
						vrep.simxReadProximitySensor(clientID, SensorHandle.getValue(), detectionState, detectedPoint, detectedObjectHandle, detectedSurfaceNormalVector, vrep.simx_opmode_blocking);
				            vrep.simxGetPingTime(clientID, pingTime);
				            vrep.simxReadProximitySensor(clientID, SensorHandle1.getValue(), detectionState1, detectedPoint1, detectedObjectHandle1, detectedSurfaceNormalVector1, vrep.simx_opmode_blocking);
				            vrep.simxGetPingTime(clientID, pingTime);
				            vrep.simxReadProximitySensor(clientID, SensorHandle2.getValue(), detectionState2, detectedPoint2, detectedObjectHandle2, detectedSurfaceNormalVector2, vrep.simx_opmode_blocking);
				            vrep.simxGetPingTime(clientID, pingTime);
				            vrep.simxReadProximitySensor(clientID, SensorHandle3.getValue(), detectionState3, detectedPoint3, detectedObjectHandle3, detectedSurfaceNormalVector3, vrep.simx_opmode_blocking);
				            vrep.simxGetPingTime(clientID, pingTime);
				           // System.out.println(z);
				           // System.out.println(detectionState.getValue());
				          //  System.out.println(detectionState1.getValue());
				         //   System.out.println(detectionState2.getValue());
				         //   System.out.println(detectionState3.getValue());
				            float[] arr = detectedPoint.getArray();
				            float[] arr1 = detectedPoint1.getArray();
				            float[] arr2 = detectedPoint2.getArray();
				            float[] arr3 = detectedPoint3.getArray();
				           
				            for(int i=0;i<3;i++){
					            System.out.println(arr[i]);
					           }
				            for(int i=0;i<3;i++){
					            System.out.println(arr1[i]);
					           }
				            for(int i=0;i<3;i++){
					            System.out.println(arr2[i]);
					           }   			
				            for(int i=0;i<3;i++){
					            System.out.println(arr3[i]);
					           }
				            float a=arr[0],b=arr[1],c=arr[2];
					           float e=arr1[0],f=arr1[1],g=arr1[2];
					           float h=arr2[0],i=arr2[1],j=arr2[2];
					           float k=arr3[0],l=arr3[1],m=arr3[2];
					           double d=Math.sqrt(a*a+b*b+c*c), x=Math.sqrt(e*e+f*f+g*g), y=Math.sqrt(h*h+i*i+j*j), z=Math.sqrt(k*k+l*l+m*m);
					           System.out.println(d);
					           System.out.println(x);
					           System.out.println(y);
					           System.out.println(z);
					           /*while(detectionState.getValue()||detectionState1.getValue()||detectionState2.getValue()||detectionState3.getValue()){
					           if(d>(x+y)&&d>(y+z)&&d>(z+x)){
					        	   System.out.println(detectionState.getValue());
					        	   Left.moveForward(clientID, speed);
					        	   
					        	   try {
									Thread.sleep(1000);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
					           }
					           else if(x>(d+y)&&x>(y+z)&&x>(z+d)){
					        	   System.out.println(detectionState1.getValue());
					        	   Left.LeftAndForward(clientID, speed);
					        	   try {
										Thread.sleep(1000);
									} catch (InterruptedException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
					           }
					           else if(y>(d+x)&&y>(x+z)&&y>(z+d)){
					        	   System.out.println(detectionState2.getValue());
					        	   Left.RightAndForward(clientID,speed);
					        	   try {
										Thread.sleep(1000);
									} catch (InterruptedException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
					           }
					           else if(z>(x+y)&&z>(y+d)&&z>(d+x)){
					        	   System.out.println(detectionState3.getValue());
					        	   Left.moveBackward(clientID,speed);
					        	   try {
										Thread.sleep(1000);
									} catch (InterruptedException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
					           }
					           else{
					        	   Left.moveForward(clientID, speed);}
					           }*/
				           /* while(true){
			vrep.simxReadProximitySensor(clientID, SensorHandle.getValue(), detectionState, detectedPoint, detectedObjectHandle, detectedSurfaceNormalVector, vrep.simx_opmode_blocking);
            vrep.simxGetPingTime(clientID, pingTime);
            System.out.println(detectionState.getValue());
            float[] arr = detectedPoint.getArray();
            for(int i=0;i<3;i++){
	            System.out.println(arr[i]);
	           }
            float a=arr[0],b=arr[1],c=arr[2];
            double d=Math.sqrt(a*a+b*b+c*c);
            System.out.println(d);
           	Left.moveForward(clientID, speed);
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println(detectionState.getValue());
            	while(detectionState.getValue()){
            if(d<1.3 && detectionState.getValue()){
            	Left.LeftAndForward(clientID, speed);
            	vrep.simxReadProximitySensor(clientID, SensorHandle.getValue(), detectionState, detectedPoint, detectedObjectHandle, detectedSurfaceNormalVector, vrep.simx_opmode_blocking);
            	arr = detectedPoint.getArray();
                for(int i=0;i<3;i++){
    	            System.out.println(arr[i]);
    	           }
                a=arr[0];
                b=arr[1];
                //c=arr[2];
                d=Math.sqrt(a*a+b*b);
            	System.out.println(d);}*/
            //}
           // }/*
            	/*if(d<1.3 && detectionState.getValue()){
            	Left.LeftAndForward(clientID, speed);
            	vrep.simxReadProximitySensor(clientID, sensorHandle.getValue(), detectionState, detectedPoint, detectedObjectHandle, detectedSurfaceNormalVector, vrep.simx_opmode_blocking);
            	System.out.println(d);
            if(d<0.3 && detectionState.getValue()){
            	Left.LeftAndForward(clientID, speed);
            	vrep.simxReadProximitySensor(clientID, sensorHandle.getValue(), detectionState, detectedPoint, detectedObjectHandle, detectedSurfaceNormalVector, vrep.simx_opmode_blocking);
            	System.out.println(d);
            if(d<1.3 && detectionState.getValue()){
                	Left.LeftAndForward(clientID, speed);
                	vrep.simxReadProximitySensor(clientID, sensorHandle.getValue(), detectionState, detectedPoint, detectedObjectHandle, detectedSurfaceNormalVector, vrep.simx_opmode_blocking);
            }}}}
            else{
            	Left.moveForward(clientID,speed);//System.out.println(rightHandle.getValue());
            }
			/*vrep.simxSetJointTargetVelocity(clientID, leftHandle.getValue(), speed*-100, vrep.simx_opmode_oneshot);
			vrep.simxGetPingTime(clientID, pingTime);
			vrep.simxSetJointTargetVelocity(clientID, rightHandle.getValue(), speed*-100, vrep.simx_opmode_oneshot);
			vrep.simxGetPingTime(clientID, pingTime);*/
		    //Left.RightAndBackward(clientID,speed);*/
//System.exit(detectedPoint.getLength());

					           
	         }	           }
    
						
	else{
			System.out.println("Not Connected");
		}

		
    }}

