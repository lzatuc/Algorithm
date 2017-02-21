import java.util.*;

/**
 * Created by lizheng on 2017/2/18.
 */

public class ReconstructItinerary {

    private Map<String, List<String>> graph;
    private List<String> rs;
    private int nroutes;

    public ReconstructItinerary(){
        graph = new HashMap<>();
    }

    public List<String> findItinerary(String[][] tickets) {
        int m = tickets.length;
        nroutes = m;
        for (String[] ticket : tickets) {
            String start = ticket[0];
            String end = ticket[1];
            List<String> nbs = graph.computeIfAbsent(start, k -> new LinkedList<>());
            nbs.add(end);
        }
        for (List<String> nbs : graph.values()){
            Collections.sort(nbs);
        }
        List<String> curRoute = new ArrayList<>();
        curRoute.add("JFK");
        dfs("JFK", curRoute);
        return rs;
    }

    private void dfs(String airport, List<String> curRoute){
        if (rs != null){
            return;
        }
        if (curRoute.size() == nroutes + 1){
            rs = new ArrayList<>(curRoute);
        }
        else{
            List<String> nbs = graph.get(airport);
            if (nbs != null){
                ListIterator<String> iter = nbs.listIterator();
                while(iter.hasNext()){
                    String nxt = iter.next();
                    iter.remove();
                    curRoute.add(nxt);
                    dfs(nxt, curRoute);
                    iter.add(nxt);
                    curRoute.remove(curRoute.size() - 1);
                }
            }
        }
    }

    public static void main(String args[]){
        String[][] tic = {{"JFK","SFO"},{"SFO","ATL"},{"JFK","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
//        String[][] tic = {{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}};
//        ReconstructItinerary rci = new ReconstructItinerary();
//        rci.findItinerary(tic);
//        System.out.println("res = " + rci.rs);
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        ListIterator<Integer> iter = list.listIterator();
        while(iter.hasNext()){
            Integer integer = iter.next();
            if (integer == 1){
                iter.remove();
            }
            if (integer == 2){
                iter.add(5);
            }
        }
        System.out.println(list);

    }
}
//[["EZE","AXA"],["TIA","ANU"],["ANU","JFK"],["JFK","ANU"],["ANU","EZE"],["TIA","ANU"],["AXA","TIA"],["TIA","JFK"],["ANU","TIA"],["JFK","TIA"]]