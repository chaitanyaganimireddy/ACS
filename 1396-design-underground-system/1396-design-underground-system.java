import java.util.*;

class UndergroundSystem {

    // id -> [stationName, checkInTime]
    private Map<Integer, CheckInData> checkInMap;

    // "start,end" -> [totalTime, tripCount]
    private Map<String, TravelData> travelMap;

    static class CheckInData {
        String station;
        int time;

        CheckInData(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    static class TravelData {
        int totalTime;
        int tripCount;

        TravelData(int totalTime, int tripCount) {
            this.totalTime = totalTime;
            this.tripCount = tripCount;
        }
    }

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        travelMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new CheckInData(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInData data = checkInMap.get(id);

        String key = data.station + "," + stationName;
        int travelTime = t - data.time;

        if (travelMap.containsKey(key)) {
            TravelData travel = travelMap.get(key);
            travel.totalTime += travelTime;
            travel.tripCount++;
        } else {
            travelMap.put(key, new TravelData(travelTime, 1));
        }

        checkInMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "," + endStation;

        TravelData travel = travelMap.get(key);

        return (double) travel.totalTime / travel.tripCount;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */