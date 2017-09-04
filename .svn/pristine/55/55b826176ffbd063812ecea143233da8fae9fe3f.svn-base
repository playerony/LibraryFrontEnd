package pl.kamsoft.nfz.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.playerony.libraryV2.dao.BookDao;
import com.playerony.libraryV2.exception.DatabaseException;
import com.playerony.libraryV2.exception.InputException;
import com.playerony.libraryV2.impl.AuthorDaoImpl;
import com.playerony.libraryV2.impl.BookDaoImpl;
import com.playerony.libraryV2.model.Book;

import pl.kamsoft.nfz.XMLGeneratror.xml.dom4j.impl.XMLImport;
import pl.kamsoft.nfz.XMLGeneratror.xml.dom4j.impl.XMLParser;
import pl.kamsoft.nfz.XMLGeneratror.xml.exception.XMLException;
import pl.kamsoft.nfz.XMLGeneratror.xml.stax.StaxXmlParser;

@Controller
@RequestMapping("/xml")
public class XmlController {

	@RequestMapping("/")
	public String index() throws DatabaseException{
		return "xml";
	}
	
	@PostMapping("/export")
	public String exportXml(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws DatabaseException, XMLException {
	    XMLParser xmlParser = new XMLParser();
		Path path = Paths.get(file.getOriginalFilename());
	    
		xmlParser.exportBooksAndAuthorsWithResultSet(path.toString());
		
		return "redirect:/xml/";
	}
	
	@PostMapping("/import")
	public String importXml(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws DatabaseException, XMLException {
		XMLImport xmlImport = new XMLImport();
		Path path = Paths.get(file.getOriginalFilename());
		
		xmlImport.importBooksAndAuthors(path.toString());
		
		return "redirect:/xml/";
	}
}
