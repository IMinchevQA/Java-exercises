package introductionExample;

import introductionExample.lib.LoginController;

public class Main {
    public static void main(String[] args) {

        LoginController lg = new LoginController(new GitHubService());

        lg.login();
    }
}
