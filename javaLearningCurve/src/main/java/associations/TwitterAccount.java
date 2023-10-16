package associations;
import java.util.*;

public class TwitterAccount {
    
    private String username;
    private ArrayList<Tweet> tweets;
    private ArrayList<Tweet> retweets;
    private ArrayList<TwitterAccount> following;
    private ArrayList<TwitterAccount> followers;

    public TwitterAccount(String username) {
        this.username = username;
        this.tweets = new ArrayList<Tweet>();
        this.retweets = new ArrayList<Tweet>();
        this.following = new ArrayList<TwitterAccount>();
        this.followers = new ArrayList<TwitterAccount>();
    }

    public String getUserName() {
        return username;
    }
    public void follow(TwitterAccount account) {
        following.add(account);
        account.followers.add(this);
    }
    public void unfollow(TwitterAccount account) {
        following.remove(account);
        account.followers.remove(this);
    }
    public boolean isFollowing(TwitterAccount account) {
        return following.contains(account);
    }
    public boolean isFollowedBy(TwitterAccount account) {
        return account.isFollowing(this);
    }
    public void tweet(String tweet) {
        Tweet p = new Tweet(this, tweet);
        tweets.add(p);
    }
    public void retweet(Tweet tweet) {
        Tweet p = new Tweet(this, tweet);
        tweets.add(p);
    }
    public Tweet getTweet(int i) {
        return tweets.get(tweets.size() - i);
    }
    public int getTweetCount() {
        return tweets.size() + retweets.size();
    }
    public int getRetweetCount() {
        int p = 0;
        for (Tweet i : tweets) {
            p += i.getRetweetCount();
        }
        return p;
    }

    //New getters to Oving 5
    public int getFollowersCount() {
        return this.followers.size();
    }
    public ArrayList<TwitterAccount> getFollowers(Comparator<TwitterAccount> comp) {
        if (comp == null) {
            return this.followers;
        }
        Collections.sort(this.followers, comp);
        return this.followers;

    }
    
    @Override
    public String toString() {
        return username + " (" + getTweetCount() + " tweets, " + getRetweetCount() + " retweets, " + getFollowersCount() + " followers)";
    }

    public static void main(String[] args) {
        TwitterAccount ole = new TwitterAccount("Ole");
        TwitterAccount nils = new TwitterAccount("Nils");
		TwitterAccount kari = new TwitterAccount("Kari");

        nils.tweet("kvitre!");
        ole.retweet(nils.getTweet(1));
        kari.retweet(ole.getTweet(1));
        System.out.println(nils.getTweetCount());
        System.out.println(nils.getRetweetCount());
    }
}
