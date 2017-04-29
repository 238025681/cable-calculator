package bg.elkabel.calculator.utils;

import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.Row;
import be.quodlibet.boxable.Cell;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

/**
 *
 * @author Kalin
 */
public abstract class PDFCreator {

	public static PDDocument createRequestDocument(RequestProperties requestProperties) throws IOException {
		PDDocument result = null;
//Saving the document
		try (PDDocument document = new PDDocument()) {

			PDPage page = new PDPage(PDRectangle.A4);
			page.setMediaBox(new PDRectangle(PDRectangle.A4.getHeight(), PDRectangle.A4.getWidth()));
			document.addPage(page);
			PDPageContentStream contentStream = new PDPageContentStream(document, page);

//Dummy Table
			contentStream.beginText();
			//Setting the font to the Content stream  
			contentStream.setFont(PDType1Font.TIMES_ROMAN, 24);
			

			//Setting the position for the line 
			contentStream.newLineAtOffset(400, 550); // middle of top page

			//Adding text in the form of string 
			contentStream.showText("ss ");
			
			//Setting the position for the line 
			contentStream.newLineAtOffset(400, 500); // middle of top page

			//Adding text in the form of string 
			contentStream.showText("ss" + requestProperties.getLenght());

			//Ending the content stream
			contentStream.endText();
			// Make sure that the content stream is closed:
			float margin = 150;
// starting y position is whole page height subtracted by top and bottom margin
			float yStartNewPage = page.getMediaBox().getHeight() - (2 * margin);
// we want table across whole page width (subtracted by left and right margin ofcourse)
			float tableWidth = page.getMediaBox().getWidth() - (2 * margin);

			boolean drawContent = true;
			float yStart = yStartNewPage;
			float bottomMargin = 70;
// y position is your coordinate of top left corner of the table
			float yPosition = 450;

			BaseTable table = new BaseTable(yPosition, yStartNewPage, bottomMargin, tableWidth, margin, document, page, true, drawContent);

			Row<PDPage> headerRow = table.createRow(15f);
			Cell<PDPage> cell = headerRow.createCell(20, "data");
			cell = headerRow.createCell(10, "smqna");
			cell = headerRow.createCell(10, "work N");
			cell = headerRow.createCell(20, "worker");
			cell = headerRow.createCell(10, "quantity");
			cell = headerRow.createCell(30, "time");
			table.addHeaderRow(headerRow);
			
			Row<PDPage> row = table.createRow(12);
			cell = row.createCell(30, "Data 1");
			cell = row.createCell(70, "Some value");

			table.draw();

			contentStream.close();
			//Saving the document
			System.out.println(new File("my_doc.pdf").getAbsolutePath());
			document.save(new File("").getAbsolutePath() + "\\src\\main\\resources\\my_doc.pdf");
			result = document;

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

		return result;
	}
}
