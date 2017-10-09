package introductionExample;

import introductionExample.lib.LoginService;

public class TwitterService implements LoginService {
    @Override
    public String getUser() {
        return "Twitter";
    }
}
