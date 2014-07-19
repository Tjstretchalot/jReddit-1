package com.github.jreddit.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.github.jreddit.user.User;
import com.github.jreddit.utils.restclient.Response;
import com.github.jreddit.utils.restclient.RestClient;

/**
 * Some constants that are used for specifying Reddit API endpoints (example: /api/new_captcha)
 *
 * @author Andrei Sfat
 */
public class ApiEndpointUtils {

    public static final String REDDIT_BASE_URL = "http://www.reddit.com";

    public static final String REDDIT_BASE_API_ENDPOINT = "/api";

    /* Captcha specific constants */
    
    public static final String CAPTCHA_NEW = REDDIT_BASE_API_ENDPOINT + "/new_captcha";

    public static final String CAPTCHA_NEEDS = REDDIT_BASE_API_ENDPOINT + "/needs_captcha.json";
    
    /* Message specific constants */
    
    public static final String MESSAGE_COMPOSE = REDDIT_BASE_API_ENDPOINT + "/compose";
    
    public static final String MESSAGE_READ = REDDIT_BASE_API_ENDPOINT + "/read_message";

    public static final String MESSAGE_GET = "/message/%s.json";
    
    /* Submission specific constants */
    
    public static final String SUBMISSION_COMMENT = REDDIT_BASE_API_ENDPOINT + "/comment";
    
    public static final String SUBMISSION_MARK_AS_NSFW = REDDIT_BASE_API_ENDPOINT + "/marknsfw";
    
    public static final String SUBMISSION_UNMARK_AS_NSFW = REDDIT_BASE_API_ENDPOINT + "/unmarknsfw";
    
    public static final String SUBMISSION_VOTE = REDDIT_BASE_API_ENDPOINT + "/vote";
    
    /* User specific constants */
    
    public static final String USER_LOGIN = REDDIT_BASE_API_ENDPOINT + "/login/%s";
    
    public static final String USER_SUBMIT = REDDIT_BASE_API_ENDPOINT + "/submit";

    public static final String USER_ABOUT = "/user/%s/about.json";

    public static final String USER_COMMENTS = "/user/%s/comments.json?%s";

    public static final String USER_GET_SUBSCRIBED = "/subreddits/mine/subscriber.json";

    public static final String USER_SUBMISSIONS_INTERACTION = "/user/%s/%s.json?%s";

    public static final String USER_SUBMISSIONS = "/user/%s/submitted.json";

    public static final String USER_INFO = REDDIT_BASE_API_ENDPOINT + "/me.json";
    
	public static final String USER_UPDATE = REDDIT_BASE_API_ENDPOINT + "/update";

    /* Subreddits specific constants */

    public static final String SUBREDDITS = "/subreddits.json";

    public static final String SUBREDDITS_GET = "/subreddits/%s.json";
    
    public static final String SUBMISSIONS = "/r/%s/.json";

    /* Misc */
    
    public static final String FULLNAME_TO_LINK = REDDIT_BASE_API_ENDPOINT + "/info.json";
    
    public static String getFullnameFromLink(RestClient client, User user, String fullname) {
    	Response response = client.get(FULLNAME_TO_LINK + "?id=" + fullname, user.getCookie());
    	JSONObject data = (JSONObject) ((JSONObject) response.getResponseObject()).get("data");
    	JSONArray children = (JSONArray) data.get("children");
    	JSONObject first = (JSONObject) children.get(0);
    	data = (JSONObject) first.get("data");
    	
    	return REDDIT_BASE_URL + data.get("permalink");
    }
}
