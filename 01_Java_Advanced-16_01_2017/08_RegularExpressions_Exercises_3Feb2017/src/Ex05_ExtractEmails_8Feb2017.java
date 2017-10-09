import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class Ex05_ExtractEmails_8Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String text = reader.readLine();
        Pattern pattern = Pattern.compile("\\b(?<!\\S)[a-z][a-z0-9\\.\\-_]+[a-z0-9]*@[a-z][a-z\\-]+\\.[a-z][a-z\\.]+[a-z]?\\b");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}


/*
Input 1:
info@softuni-bulgaria.org, --123@gmail.com, kiki@hotmail.co.uk, no-reply@github.com, …@mail.bg, s.peterson@mail.uu.net, .info@info.info, info-bg@software-university.software.academy, _steve@yahoo.cn, mike@helloworld, mike@.unknown.soft, s.johnson@invalid-
end

Expected output 1:
info@softuni-bulgaria.org
kiki@hotmail.co.uk
no-reply@github.com
s.peterson@mail.uu.net
info-bg@software-university.software.academy
end

Input 2:
Please contact us at: support@github.com.
end

Expected output 2:
support@github.com


Input 3:
Just send email to s.miller@mit.edu and j.hopking@york.ac.uk for more information.
end

Expected output 3:
s.miller@mit.edu
j.hopking@york.ac.uk



Input 4:
Many users @ SoftUni confuse email addresses. We @ Softuni.BG provide high-quality training @ home or @ class. –- steve.parker@softuni.de.
end

Expected output 4:
steve.parker@softuni.de



Input 5:
--123@gmail.com, …@mail.bg, .info@info.info, _steve@yahoo.cn, mike@helloworld, mike@.unknown.soft., s.johnson@invalid-.
end

Expected output 5:
(no output)




 */
