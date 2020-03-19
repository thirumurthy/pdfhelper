package pdfhelper;

import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.itextpdf.kernel.pdf.EncryptionConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.ReaderProperties;
import com.itextpdf.kernel.pdf.WriterProperties;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//java -jar target/my-utility.jar -i asd 
		Options options = new Options();

        Option input = new Option("i", "input", true, "input file path");
        input.setRequired(true);
        options.addOption(input);

        Option password = new Option("p", "password", true, "password");
        password.setRequired(true);
        options.addOption(password);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd = null;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);

            System.exit(1);
        }

        String inputFilePath = cmd.getOptionValue("input");
        String filepassword = cmd.getOptionValue("password");

        System.out.println(inputFilePath);
        System.out.println(filepassword);
        try{
        	manipulatePdf(inputFilePath,inputFilePath.replace(".pdf", "_rem.pdf"),filepassword);
        }
        catch(IOException exp){
        	
        }
        
	}

	public static void manipulatePdf(String src, String dest, String password) throws IOException {
	    PdfReader reader = new PdfReader(src, new ReaderProperties().setPassword(password.getBytes()));
	    PdfWriter writer = new PdfWriter(dest,
	            new WriterProperties().setStandardEncryption(null, password.getBytes(), EncryptionConstants.ALLOW_PRINTING,
	                    EncryptionConstants.ENCRYPTION_AES_128 | EncryptionConstants.DO_NOT_ENCRYPT_METADATA));
	    PdfDocument pdfDoc = new PdfDocument(reader, writer);
	    pdfDoc.close();
	}
}
