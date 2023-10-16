package encapsulation;

public class StopWatch {    //dataorientert klasse
    
    //Instansvariabler
    private int startTime;      //Atributtene må være private for å sikre at de kun endres gjennom konstruktør / settere.
    private int time;
    private int lapTime;
    private int timesStarted;
    private int timesStopped;
    private int timesLapStarted;
    private int timesTicked;
    private int ticks;
    private boolean running;
    
    //Konstruktør
    public StopWatch(){     //så det mest hensiksmessig å ikke legge til noen metoder for validrering av dataene
        this.startTime = 0;
        this.time = 0;
        this.running = false;
    }

    //Metoder
    public void tick(int ticks){
        if (ticks < 0) {
            throw new IllegalArgumentException("Ticks cannot be negative");  //Legge til en validering som sjekker at tiden ikke er negativ
        }
        this.timesTicked++;
        if(running){ 
            this.time += ticks;
        }
        this.ticks += ticks;
    }
    public void start() {
        if (this.running) {
            throw new IllegalStateException("StopWatch is already running"); //Legge til en validering som gjør at en ikke kan starte klokken flere ganger
        }
        this.timesStarted++;
        this.running = true;
    }
    public void stop() {
        if (!this.running) {
            throw new IllegalStateException("StopWatch is not running"); //Legge til en validering som gjør at en ikke kan stoppe klokken flere ganger
        }
        this.timesStopped++;
        this.running = false;
    }
    public void lap() {
        if (!this.running) {
            throw new IllegalStateException("StopWatch is not running");    //Legge til en validering som gjør at en ikke kan ta en runde når klokken ikke er i gang
        }
        this.startTime = this.time;
        this.timesLapStarted++;
        this.lapTime = this.time;
        this.time = 0;
    }

    //Spørremetoder
    public boolean isStarted() {
        if (this.timesStarted > 0) {
            return true;
        }
        return false;
    }
    public boolean isStopped() {
        if (this.timesStopped > 0) {
            return true;
        }
        return false;
    }
    public int getTicks() {
        return this.ticks;
    }
    public int getTime() {
        if(timesStarted > 0){
            if (this.running && this.timesLapStarted > 0 ){
                return this.lapTime + this.time;
            } else if (this.running) {
                return this.time;
            }
            return this.startTime + this.time;
        }
        return -1;
    }
    public int getLapTime() {
        if(this.running == false && timesStarted > 0){    
            return 0;
        } else if (timesStarted > 0) {
            return this.time;
        }
        return -1;
    }   
    public int getLastLapTime() {
        if(this.running == false && timesLapStarted > 0 && timesTicked > 1){
            return this.time;
        } else if (timesLapStarted > 0) {
            return this.lapTime;
        }
        return -1;
        
    }

    public static void main(String[] args) {
        StopWatch p = new StopWatch();
        System.out.println(p.getLapTime());
    }
}