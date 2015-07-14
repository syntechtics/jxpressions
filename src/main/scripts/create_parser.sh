cd C:\development\flex-experiment\jflex-1.6.1\bin
jflex ..\..\jxpression\src\main\java\parser\Scanner.flex
cd C:\development\flex-experiment\jxpression\src\main\java\parser
java -cp "..\..\..\..\..\cup\java-cup-11b.jar" java_cup.Main "Parser.cup"
