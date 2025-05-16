import java.util.*;

enum ActionEnum {feature1Button, feature2Button, feature3Button}

class AnalyticsStore {
    private final ArrayList<ActionEnum> storedActions = new ArrayList<>();

    public void storeActions(Queue<ActionEnum> actions) {
        while (!actions.isEmpty()) {
            ActionEnum action = actions.poll();
            storedActions.add(action);
        }
    }

    public ArrayList<ActionEnum> getActions() {
        return storedActions;
    }
}
public class Analytics {
    private final AnalyticsStore analyticsStore;
    private final int k;
    private final Queue<ActionEnum> actionQueue;
    private final Map<ActionEnum, Integer> actionCounts;
    private int totalLoggedActions;

    Analytics(AnalyticsStore analyticsStore, int k) {
        this.analyticsStore = analyticsStore;
        this.k = k;
        this.actionQueue = new LinkedList<>();
        this.actionCounts = new HashMap<>();
        this.totalLoggedActions = 0;
    }

    void registerAction(ActionEnum action) {
        actionQueue.add(action);
        actionCounts.put(action, actionCounts.getOrDefault(action, 0) + 1);
        totalLoggedActions++;

        if(actionQueue.size()==k) {
            analyticsStore.storeActions(actionQueue);
            actionQueue.clear();
        }
    }

    int getNumberOfActionRegisteredButNotSentToAnalyticsStore() {
        return actionQueue.size();
    }

    int getTotalNumberOfLoggedActions() {
        return totalLoggedActions;
    }

    List<ActionEnum> getMostFrequentlyUsedActions() {
        List<ActionEnum> mostFrequentActions = new ArrayList<>();
        int maxCount = 0;

        for (Map.Entry<ActionEnum, Integer> entry : actionCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentActions.clear();
                mostFrequentActions.add(entry.getKey());
            } else if (entry.getValue() == maxCount) {
                mostFrequentActions.add(entry.getKey());
            }
        }

        mostFrequentActions.sort(Comparator.comparing(ActionEnum::toString));
        return mostFrequentActions;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        System.out.print("Enter total number of requests and size: ");
        int requests = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();

        AnalyticsStore analyticsStore = new AnalyticsStore();
        Analytics analytics = new Analytics(analyticsStore, k);

        while(requests-->0) {
//            System.out.print("Enter action: ");
            String action = sc.next();

            switch (action) {
                case "registerAction" -> {
                    String actionType = sc.next();
                    ActionEnum actionEnum = ActionEnum.valueOf(actionType);
                    analytics.registerAction(actionEnum);
                }

                case "getTotalNumberOfLoggedActions" -> {
                    System.out.println(analytics.getTotalNumberOfLoggedActions());
                }

                case "getNumberOfActionRegisteredButNotSentToAnalyticsStore" -> {
                        System.out.println(analytics.getNumberOfActionRegisteredButNotSentToAnalyticsStore());
                }

                case "getMostFrequentlyUsedActions" -> {
                    List<ActionEnum> mostFrequentActions = analytics.getMostFrequentlyUsedActions();
                    System.out.println(mostFrequentActions);
                }
            }
        }

        System.out.println(analyticsStore.getActions());
    }
}
