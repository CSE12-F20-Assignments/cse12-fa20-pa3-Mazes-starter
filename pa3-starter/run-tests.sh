javac -cp lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar:src/ src/cse12pa3student/*.java

java -cp lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar:src/ org.junit.runner.JUnitCore cse12pa3student.TestSolvers 2>&1 | grep -v "\tat"
