package introductionExample.lib;

public class LoginController {

    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    public void login() {
        System.out.println(this.loginService.getUser() + " is here!");
    }

}
