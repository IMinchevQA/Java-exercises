import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Ex12_SemanticHTML_8Feb2017 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Pattern openDiv = Pattern.compile("(<div).*?(\\s*(?:id|class)(?:\\s*=\\s*\")(\\w+)\")");
        Pattern closeDiv = Pattern.compile("(<\\/div>\\s*<!--\\s*(\\w+)\\s*-->)");

        String line = "";
        while (!"END".equals(line = reader.readLine())) {
            Matcher openMatch = openDiv.matcher(line);
            Matcher closeMatch = closeDiv.matcher(line);
            while (openMatch.find()) {
                line = line.replace(openMatch.group(1), "<" + openMatch.group(3));
                line = line.replace(openMatch.group(2), "");
                line = line.replaceAll("\\s+>", ">");
                line = line.replaceAll("\\s+", " ");
            }
            while (closeMatch.find()) {
                line = line.replace(closeMatch.group(1), "</" + closeMatch.group(2) + ">");
            }
            System.out.println(line);
        }
    }
}


/*
Input 1:
<div id="header">
</div> <!-- header -->
END

Expected output 1:
<header>
</header>




Input 2:
<div style="color:red" id="header">
</div> <!-- header -->
END


Expected output 2:
<header style="color:red">
</header>




Input 3:
<div class="header" style="color:blue">
</div> <!-- header -->
END

Expected output 3:
<header style="color:blue">
</header>



Input 4:
<div align="left" id="nav" style="color:blue">
  <ul class="header">
    <li id="main">
      Hi, I have id="main".
    </li>
  </ul>
</div> <!-- nav -->
END


Expected output 4:
<nav align="left" style="color:blue">
  <ul class="header">
    <li id="main">
      Hi, I have id="main".
    </li>
  </ul>
</nav>



Input 5:
<p class = "section" >
    <div style = "border: 1px" id = "header" >
        Header
        <div id = "nav" >
            Nav
        </div>   <!--   nav   -->
    </div>  <!--header-->
  </p> <!-- end paragraph section -->
END


Expected output 5:
  <p class = "section" >
    <header style = "border: 1px">
        Header
        <nav>
            Nav
        </nav>
    </header>
  </p> <!-- end paragraph section -->



 */