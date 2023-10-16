package interfc.twitter;

import java.util.Comparator;

import associations.TwitterAccount;
 
public class FollowersCountComparator implements Comparator<TwitterAccount>{

    @Override
    public int compare(TwitterAccount o1, TwitterAccount o2) {
        return o2.getFollowersCount() - o1.getFollowersCount();
    }
    
}
