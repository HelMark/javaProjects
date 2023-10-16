package interfc.twitter;
import java.util.*;

import associations.TwitterAccount;
public class TwitterMain {
    public static void main(String[] args) {
        TwitterAccount ole = new TwitterAccount("Ole");
        TwitterAccount nils = new TwitterAccount("Nils");
		TwitterAccount kari = new TwitterAccount("Kari");
        TwitterAccount bernt = new TwitterAccount("Bernt");

        ole.follow(nils);
        kari.follow(nils);
        bernt.follow(nils);
        bernt.follow(ole);


        ole.tweet("Hallo");
        ole.tweet("Hade");
        nils.tweet("Hei");


        Comparator<TwitterAccount> comp1 = new UserNameComparator();
        Comparator<TwitterAccount> comp2 = new FollowersCountComparator();
        Comparator<TwitterAccount> comp3 = new TweetsCountComparator();
        Comparator<TwitterAccount> comp4 = new TwitterAccountComparator();
        

        ArrayList<TwitterAccount> accounts = new ArrayList<TwitterAccount>();
        accounts.add(ole);
        accounts.add(nils);
        accounts.add(kari);
        accounts.add(bernt);

        System.out.println("Unsorted:" + accounts);

        Collections.sort(accounts, comp1);
        System.out.println("Sorted by username:" + accounts);

        Collections.sort(accounts, comp2);
        System.out.println("Sorted by followers:" + accounts);

        Collections.sort(accounts, comp3);
        System.out.println("Sorted by tweets:" + accounts);

        Collections.sort(accounts, comp4);
        System.out.println("Sorted by tweets and followers:" + accounts);
    }
}
