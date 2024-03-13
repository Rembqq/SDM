# Markdown to HTML Parser

## Lannisters always pay their debts

## Application Description

**The application takes a path to a text file with Markdown markup and generates an HTML markup fragment from it.**


## How to set everything up?

### Firstly

_Clone this repository with the following command:_ 

```git clone https://github.com/Rembqq/SDM.git```

### Secondly

Download Java SDK from the [official website](https://www.oracle.com/java/technologies/downloads/) and connect it to your project.

### Thirdly

`Open a terminal and enter the following commands to run the program:`

```
javac MarkdownToHtml.java
```

```
java MarkdownToHtml parse <path_to_md_file> -o <path_to_html_file>
```

## Example

Lets parse example.md file and save output to output.html:

### example.md

```markdown
**Lorem ipsum dolor sit amet**, consectetur adipiscing elit.
Mauris `nec lacinia mauris.` _Duis scelerisque, lacus ut suscipit_
vulputate, leo purus convallis ligula,```non finibus nulla```enim
ut mauris. `Phasellus sed augue aliquet,` hendrerit dui in,
suscipit _turpis._ Vestibulum **aliquet sollicitudin tellus**
```

Parse it:

```
javac MarkdownToHtml.java
```

```
java MarkdownToHtml parse example.md -o output.html
```

### output.html:

```html
<b>Lorem ipsum dolor sit amet</b>, consectetur adipiscing elit.
Mauris <code>nec lacinia mauris.</code> <i>Duis scelerisque, lacus ut suscipit</i>
vulputate, leo purus convallis ligula,<pre>non finibus nulla</pre>enim
ut mauris. <code>Phasellus sed augue aliquet,</code> hendrerit dui in,
suscipit <i>turpis.</i> Vestibulum <b>aliquet sollicitudin tellus</b>
```