# Markdown to HTML Parser

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
java src/main/java/mdtohtml/MarkdownToHtml.java <path_to_md_file> --out <path_to_new_file>
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
java src/main/java/mdtohtml/MarkdownToHtml.java example.md --out output.html
```

### output.html:

```html
<p><b>Lorem ipsum dolor sit amet</b>, consectetur adipiscing elit. 
Mauris <code>nec lacinia mauris.</code> <i>Duis scelerisque, lacus ut suscipit</i>
vulputate, leo purus convallis ligula,<pre>non finibus nulla</pre>enim
ut mauris. <code>Phasellus sed augue aliquet,</code> hendrerit dui in,
suscipit <i>turpis.</i> Vestibulum <b>aliquet sollicitudin tellus</b></p>
```

## How to launch tests?

`Open a terminal and enter the following commands to run the tests:`

```
mvn test
```

## Revert Commit

[Revert Commit](https://github.com/Rembqq/SDM/commit/d4753f738b662a3d0e2d47a2814963ebaa5decd1)

## Failed-Test Commit

[Failed-Test Commit](https://github.com/Rembqq/SDM/commit/c7dacc5d4e46280866efb1a2cb3b9082e102bd03)

## Conclusion

_Це був мій перший досвід роботи з unit тестами, попередньо робив хіба що мануальні)
Спочатку не було зрозуміло навіщо вони потрібні. Потім дійшло що при залежності одного
шматка коду він іншого, ручками перевіряти кожну функцію окремо виходить повільно, 
крім того що все може осипатися. На мою думку, саме це є головним критерієм написання
unit-тестів. З іншими ж тестами мені ще слід познайомитися на практиці_ (＾◡＾)

