package interfc.twitter;

import java.util.Comparator;

import associations.TwitterAccount;

public class TwitterAccountComparator implements Comparator<TwitterAccount> {

    @Override
    public int compare(TwitterAccount o1, TwitterAccount o2) {
        if (o1.getFollowersCount() == o2.getFollowersCount() && o1.getTweetCount() == o2.getTweetCount()) {
            return o1.getUserName().compareTo(o2.getUserName());

        } else if (o1.getFollowersCount() == o2.getFollowersCount()) {
            return o2.getTweetCount() - o1.getTweetCount();
            
        }
        return o2.getFollowersCount() - o1.getFollowersCount(); 
    }
    
}
