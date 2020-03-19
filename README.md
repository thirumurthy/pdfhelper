# pdfhelper
pdfhelper is used to convert the password encrypted PDF to remove the password. It is using iText

# To Deploy Jar
mvn clean compile assembly:single

# To Test PDF
C:\Users\Thiru\workspace\pdfhelper\target>java -jar pdfhelper-0.0.1-SNAPSHOT-jar
-with-dependencies.jar -i Thiru_EAadhaar.pdf -p XXXXYYYY