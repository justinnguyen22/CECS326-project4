import java.util.concurrent.atomic.AtomicInteger;

public class Task
{
    // the representation of each task
    private String name;
    private int tid;
    private int priority;
    private int burst;
    
    //Variables used for calculating wait & response time
    //in Round Robin Scheduling
    private int waittime;
    private int finishedBurst;
    private int response;

    /**
     * We use an atomic integer to assign each task a unique task id.
     */
    private static AtomicInteger tidAllocator = new AtomicInteger();

    public Task(String name, int priority, int burst) {
        this.name = name;
        this.priority = priority;
        this.burst = burst;
        this.waittime = 0;
        this.finishedBurst = 0;
        this.response = 0;

        this.tid = tidAllocator.getAndIncrement();
    }

    /**
     * Appropriate getters
     */
    public String getName() {
        return name;
    }

    public int getTid() {
        return tid;
    }

    public int getPriority() {
        return priority;
    }

    public int getBurst() {
        return burst;
    }
    
    public int getWaitTime(){
      return waittime;
    }
    
    public int getFinBurst(){
      return finishedBurst;
    }
    
    public int getResponse(){
      return response;
    }
    
    /**
     * Appropriate setters
     */
    public int setPriority(int priority) {
        this.priority = priority;

        return priority;
    }
    
    public int setBurst(int burst) {
        this.burst = burst;

        return burst;
    }
    
    public int setWaitTime(int waittime){
      this.waittime = waittime;
      
      return waittime;
    }
    
    public int setFinBurst(int finBurst){
      this.finishedBurst = finBurst;
      
      return finBurst;
    }
    
    public int setResponse(int response){
      this.response = response;
      
      return response;
    }

    /**
     * We override equals() so we can use a
     * Task object in Java collection classes.
     */
    public boolean equals(Object other) {
        if (other == this)
            return true;

        if (!(other instanceof Task))
            return false;

        /**
         * Otherwise we are dealing with another Task.
         * two tasks are equal if they have the same tid.
         */
        Task rhs = (Task)other;
        return (this.tid == rhs.tid) ? true : false;
    }

    public String toString() {
        return
            "Name: " + name + "\n" + 
            "Tid: " + tid + "\n" + 
            "Priority: " + priority + "\n" + 
            "Burst: " + burst + "\n";
    }
}
