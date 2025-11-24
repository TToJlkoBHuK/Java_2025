Запуск:

```javac HuffmanArchiver.java```<br>
```javac --release 8 HuffmanArchiver.java```

```Set-Content -Path test1.txt -Value "1111111111" -NoNewline```<br>
```java HuffmanArchiver encode test1.txt out.huf```<br>
```java HuffmanArchiver decode out.huf test1_restored.txt```

```Set-Content -Path test2.txt -Value "11111111112222233333" -NoNewline```<br>
```java HuffmanArchiver encode test2.txt test2.huf```

```java HuffmanArchiver encode HuffmanArchiver.class app.huf```<br>
```java HuffmanArchiver decode app.huf HuffmanArchiver_new.class```<br>
```Compare-Object -ReferenceObject (Get-Content -Path HuffmanArchiver.class -Encoding Byte) -DifferenceObject (Get-Content -Path HuffmanArchiver_new.class -Encoding Byte)```

```java HuffmanArchiver encode pg2601.txt out_1.huf```<br>
```java HuffmanArchiver decode out_1.huf pg2602.txt```
