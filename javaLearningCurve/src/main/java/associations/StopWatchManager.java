package associations;

import java.util.*;

import encapsulation.StopWatch;

public class StopWatchManager {
    
    private Map<String, StopWatch> stopWatches = new HashMap<String, StopWatch>();


    //endringsmetoder
    public StopWatch newStopWatch(String name) {
        if (stopWatches.containsKey(name)) {
            throw new IllegalArgumentException("StopWatch with name " + name + " already exists");
        }
        StopWatch stopWatch = new StopWatch();
        stopWatches.put(name, stopWatch);
        return stopWatch;
    }

    public void removeStopWatch(String name) {
        if (!stopWatches.containsKey(name)) {
            throw new IllegalArgumentException("StopWatch with name " + name + " does not exist");
        }
        stopWatches.remove(name);
    }

    public void tick(int ticks) {
        for (StopWatch stopwatch : stopWatches.values()) {
            stopwatch.tick(ticks);
        }
    }

    //lesemetoder
    public StopWatch getStopWatch(String name) {
        //if (!stopWatches.containsKey(name)) {
        //    throw new IllegalArgumentException("StopWatch with name " + name + " does not exist");
        //}
        return stopWatches.get(name);
    }

    public Collection<StopWatch> getAllWatches() {
        return stopWatches.values();
    }

    public Collection<StopWatch> getStartedWatches() {
        ArrayList<StopWatch> startedWatches = new ArrayList<StopWatch>();
        for (StopWatch stopwatch : stopWatches.values()) {
            if (stopwatch.isStarted()) {
                startedWatches.add(stopwatch);
            }
        }
        return startedWatches;
    }

    public Collection<StopWatch> getStoppedWatches() {
        ArrayList<StopWatch> startedWatches = new ArrayList<StopWatch>();
        for (StopWatch stopwatch : stopWatches.values()) {
            if (stopwatch.isStopped()) {
                startedWatches.add(stopwatch);
            }
        }
        return startedWatches;
    }

    public static void main(String[] args) {
        
        StopWatchManager manager = new StopWatchManager();
        
        manager.newStopWatch("sw1");
        manager.getStopWatch("sw1").start();
        manager.getStopWatch("sw1").stop();
        System.out.println(manager.getStoppedWatches().size());

    }
}
