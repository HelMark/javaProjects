package interfc.twitter;

import java.util.Comparator;

import associations.TwitterAccount;

public class UserNameComparator implements Comparator<TwitterAccount> {

    @Override
    public int compare(TwitterAccount o1, TwitterAccount o2) {
        return o1.getUserName().compareTo(o2.getUserName());
    }
    
}
