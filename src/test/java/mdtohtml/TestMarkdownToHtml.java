package mdtohtml;

import org.junit.Assert;
import org.junit.Test;


public class TestMarkdownToHtml {
    @Test
    public void testBold() throws mdtohtml.MarkdownToHtml.InvalidMarkdownException{

        String MarkdownText = "Це правильний markdown текст **без закриваючих тегів**";
        String expectedHtml = "<p>Це правильний markdown текст <b>без закриваючих тегів</b></p>";

        //Assert
        Assert.assertEquals(expectedHtml, mdtohtml.MarkdownToHtml.convertToHtml(MarkdownText));
    }

    @Test
    public void testItalics() throws mdtohtml.MarkdownToHtml.InvalidMarkdownException{

        String MarkdownText = "Це правильний markdown текст _без закриваючих тегів_";
        String expectedHtml = "<p>Це правильний markdown текст <i>без закриваючих тегів</i></p>";

        //Assert
        Assert.assertEquals(expectedHtml, mdtohtml.MarkdownToHtml.convertToHtml(MarkdownText));
    }

    @Test
    public void testMono() throws mdtohtml.MarkdownToHtml.InvalidMarkdownException{

        String MarkdownText = "Це правильний markdown текст `без закриваючих тегів`";
        String expectedHtml = "<p>Це правильний markdown текст <code>без закриваючих тегів</code></p>";

        //Assert
        Assert.assertEquals(expectedHtml, mdtohtml.MarkdownToHtml.convertToHtml(MarkdownText));
    }

    @Test
    public void testParagraph() throws mdtohtml.MarkdownToHtml.InvalidMarkdownException{

        String MarkdownText = "People wouldn't\n want to watch GOT S3 EP 9\n\nlike I did yesterday";
        String expectedHtml = "<p>People wouldn't\n want to watch GOT S3 EP 9</p>\n<p>\nlike I did yesterday</p>";

        //Assert
        Assert.assertEquals(expectedHtml, mdtohtml.MarkdownToHtml.convertToHtml(MarkdownText));
    }

    @Test
    public void testPreformatted() throws mdtohtml.MarkdownToHtml.InvalidMarkdownException{

        String MarkdownText = "People wouldn't\n want to watch GOT S3 EP 9\n\nlike I did yesterday";
        String expectedHtml = "<p>People wouldn't\n want to watch GOT S3 EP 9</p>\n<p>\nlike I did yesterday</p>";

        //Assert
        Assert.assertEquals(expectedHtml, mdtohtml.MarkdownToHtml.convertToHtml(MarkdownText));
    }

    @Test
    public void testConsoleHtml() throws mdtohtml.MarkdownToHtml.InvalidMarkdownException{

        String MarkdownText = "**Lorem ipsum dolor sit amet**, consectetur adipiscing elit.\n" +
                "Mauris `nec lacinia mauris.` _Duis scelerisque, lacus ut suscipit_\n" +
                "vulputate, leo purus convallis ligula,```non finibus nulla```enim\n" +
                "ut mauris. `Phasellus sed augue aliquet,` hendrerit dui in,\n" +
                "suscipit _turpis._ Vestibulum **aliquet sollicitudin tellus**";

        String expectedHtml = "<p><b>Lorem ipsum dolor sit amet</b>, consectetur adipiscing elit.\n" +
                "Mauris <code>nec lacinia mauris.</code> <i>Duis scelerisque, lacus ut suscipit</i>\n" +
                "vulputate, leo purus convallis ligula,<pre>non finibus nulla</pre>enim\n" +
                "ut mauris. <code>Phasellus sed augue aliquet,</code> hendrerit dui in,\n" +
                "suscipit <i>turpis.</i> Vestibulum <b>aliquet sollicitudin tellus</b></p>";

        //Assert
        Assert.assertEquals(expectedHtml, mdtohtml.MarkdownToHtml.convertToHtml(MarkdownText));
    }

}
