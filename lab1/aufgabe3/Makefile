run: package
	java -jar hello.jar

package: compile
	jar cfm hello.jar MANIFEST.mf sample/*/*.class

compile: 
	javac sample/*/*.java
