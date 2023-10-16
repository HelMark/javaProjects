package associations;

public class Tweet {

    private String tweet;
    private Tweet reTweet;
    private int retweetCount;
    private TwitterAccount account;
    
    private boolean isFromSameAccount(Tweet tweet) {
        return this.account == tweet.getOwner();
    }
    private void incrementRetweet() {
        retweetCount++;
    }  

    public Tweet(TwitterAccount account, String tweet) {
        this.account = account;
        this.tweet = tweet;
    }
    public Tweet(TwitterAccount account, Tweet tweet) {
        this.account = account;
        if (isFromSameAccount(tweet))
            throw new IllegalArgumentException("Cannot retweet your own tweet");
        this.account = account;
        this.reTweet = tweet;
        tweet.getOriginalTweet().incrementRetweet();
    }
    public String getText() {
        try {
            return reTweet.getText();
        } catch (Exception e) {
           return tweet;
        }
    }
    public TwitterAccount getOwner() {
        return account;
    }
    public Tweet getOriginalTweet() {
        try {
            return reTweet.getOriginalTweet();
        } catch (Exception e) {
            return this;
        }
    }
    public int getRetweetCount() {
        return retweetCount;
    }
    
    @Override
    public String toString() {
        return getText() + " (" + getRetweetCount() + " retweets)";
    }

    public static void main(String[] args) {
        TwitterAccount nils = new TwitterAccount("Nils");
		TwitterAccount ole = new TwitterAccount("Ole");

		Tweet tweet = new Tweet(nils, "Kvitre!");
        System.out.println(tweet.getOriginalTweet());
        Tweet retweet1 = new Tweet(ole ,tweet);
        System.out.println(retweet1.getOriginalTweet());

    }
}
