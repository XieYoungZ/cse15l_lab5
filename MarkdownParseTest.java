import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
public class MarkdownParseTest {

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testLinkAtBeginning() {
        String contents= "[link title](a.com)";
        List<String> expect = List.of("a.com");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
    public void testFile1() throws IOException {
        String contents = Files.readString(Path.of("/Users/wang/Documents/GitHub/markdown-parser_Lab4/test-file.md"));
        //List<String> expect = List.of("https://something.com", "some-thing.html");
        assertEquals(List.of("https://something.com", "some-thing.html"), MarkdownParse.getLinks(contents));
    }

    @Test
    public void testFile2() throws IOException {
        String contents= Files.readString(Path.of("/Users/wang/Documents/GitHub/markdown-parser_Lab4/test-file2.md"));
        List<String> expect = List.of("https://google.com", "some-thing.html");
        assertEquals(MarkdownParse.getLinks(contents), expect);
    }

    @Test
   public void testTestFile1() throws IOException{
       List<String> StringInput = List.of("https://google.com", "some-thing.html");
       List<String> Actual = MarkdownParse.getLinks(Files.readString(Path.of("/Users/wang/Documents/GitHub/markdown-parser_Lab4/test-file2.md")));
       assertEquals(StringInput, Actual);
   }

   @Test
   public void testTestFile3() throws IOException{
       List<String> StringInput = List.of();
       List<String> Actual = MarkdownParse.getLinks(Files.readString(Path.of("/Users/wang/Documents/GitHub/markdown-parser_Lab4/test-file3.md")));
       assertEquals(StringInput, Actual);
   }
 
   @Test
   public void testTestFile5() throws IOException{
       List<String> StringInput = List.of("page.com");
       List<String> Actual = MarkdownParse.getLinks(Files.readString(Path.of("/Users/wang/Documents/GitHub/markdown-parser_Lab4/test-file5.md")));
       assertEquals(StringInput, Actual);
   }
 
   @Test
   public void testTestFile6() throws IOException{
       List<String> StringInput = List.of("page.com");
       List<String> Actual = MarkdownParse.getLinks(Files.readString(Path.of("/Users/wang/Documents/GitHub/markdown-parser_Lab4/test-file6.md")));
       assertEquals(StringInput, Actual);
   }

    

}