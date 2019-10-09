# MiddleWareMindSim

We can establish the interface between V-Rep and Eclipse as following .The corresponding links  for installation are furnished at the bottom of this document.

•	At first we should download the Lejos mindstorm ev3(1),eclipse Neon (2) and V-Rep(3) and go through their respective guides to get better understanding.

•	Along with Lejos mindstorm we will be given an user manual through which we can assemble the mindstorm brick in different ways.

•	We can proceed with testing mindstorm brick to get better understanding by writing basic programs which is necessary.Ev3 programmer can be installed by following the below steps.	

1.we should download Java Jdk(4)  based on our operating system and Java se embedded version(can vary for 32 bit and 64 bit).

2.Then we can download Lejos Ev3 SD card creator(5) from the official site.


We create a file in our sd card using SD card creator and Java se embedded version and then insert it in the mindstorm brick.

•	It’s time to go back eclipse(neon) and add Lejos Ev3 plugin(6) in the preferences

•	Now we can try connecting Ev3 with eclipse for which we need IP address and we can find it by following steps:

Can be done using Netgear N150 as stated in the official website,but this is no longer available.we can use Edimax EW7811UN wireless usb adapter(7) as alternative to find the IP address 

•	After finding IP address we have to add in the preferences , then create a basic program(can be using touch sensor etc.).Now if we run our project in eclipse as a Lejos ev3 program then as per our program our brick will act

•	Interface: Interface between eclipse and V-Rep can be done as follows.

•	In V-Rep, we will have different types of pre-defined robots which we can use and they have pre-defined programming which will be in LUA scripting

•	As we can’t change the programming of a robot, we use a cuboid to insert our program and operate the robot by disabling its main LUA script.

•	After the installation of V-Rep we will get supporting  files for Java ,Python ,Matlab etc. .For the interface to be successful we should include these files which are in the Java modules,we should add them to our workspace so that eclipse can use these files.Don’t forget to include RemoteApi.dll and RemoteApiJava.dll.

•	 We can establish the interface by enabling remote API server with the command  "simExtRemoteApiStart(19999)". Then if we run our basic project in eclipse we can see the robot moving and our corresponding output in v rep

•	We can create our own robot as well with the pre-defined modules which connected can form a robot.

•	We can test the robot in V-REP environment by writing Java programs in Java IDE(Eclipse)


1.Lejos Ev3 
https://sourceforge.net/projects/ev3.lejos.p/files/

2.Eclipse  Neon version
http://www.eclipse.org/downloads/eclipse-packages/

3.V-REP 
http://www.coppeliarobotics.com/downloads.html

4.Java Jdk
http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

5.Creating bootable sd card
https://sourceforge.net/p/lejos/wiki/Creating%20a%20bootable%20SD%20card%200.7.0/

6.lejos ev3 plugin for eclipse 
https://sourceforge.net/p/lejos/wiki/Installing%20the%20Eclipse%20plugin/

7.Edimax EW-7811UN adapter
https://www.amazon.de/EDIMAX-EW-7811UN-Wireless-Adapter-IEEE802-11b/dp/B003MTTJOY

