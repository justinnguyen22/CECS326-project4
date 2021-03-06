import java.util.*;
import java.io.*;

public class Driver
{
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage: java Driver <schedule> <algorithm>");
            System.exit(0);
        }

        BufferedReader inFile = new BufferedReader(new FileReader(args[0]));

        String schedule;

        // create the queue of tasks
        List<Task> queue = new ArrayList<Task>();

        // read in the tasks and populate the ready queue        
        while ( (schedule = inFile.readLine()) != null) {
            String[] params = schedule.split(",\\s*");
            queue.add(
            new Task(params[0], Integer.parseInt(params[1]), Integer.parseInt(params[2])));
        }

        Algorithm scheduler = null;
        String choice = args[1].toUpperCase();

        switch(choice) {
            case "FCFS":
                scheduler = new FCFS(queue);
                break;
            case "PRI":
                scheduler = new Priority(queue);
                break;
            case "RR":
                scheduler = new RR(queue);
                break;
            default:
                System.err.println("Invalid algorithm");
                System.exit(0);
        }

        // start the scheduler
        scheduler.schedule();

        // report statistics
        System.out.println("Average Wait Time = " + scheduler.getAverageWaitTime());
        System.out.println("Average Turnaround Time = " + scheduler.getAverageTurnaroundTime());
        System.out.println("Average Response Time = " + scheduler.getAverageResponseTime());

        inFile.close();
    }
}
