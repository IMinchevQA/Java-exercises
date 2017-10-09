package introductionExample;

import introductionExample.lib.LoginService;

public class GitHubService implements LoginService {

    @Override
    public String getUser() {
        return "GitHub";
    }
}
