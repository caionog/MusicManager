package negocio.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.apache.tika.parser.mp3.ID3v1Handler;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import data.MusicRepo;
public class MusicController {

    public void extractMetaData(MusicRepo mr, String path) throws Exception, IOException, SAXException, TikaException {
		BodyContentHandler handler = new BodyContentHandler();  
	    Metadata metadata = new Metadata();  
	    FileInputStream inputstream = new FileInputStream(new File(path));  
	    ParseContext pcontext = new ParseContext();  
		Mp3Parser  Mp3Parser = new  Mp3Parser(); 
		ID3v1Handler tags = new ID3v1Handler(inputstream, handler);
		
		Mp3Parser.parse(inputstream, handler, metadata, pcontext); // Extrai metadata nesse comando

		String artist = tags.getArtist();
	    String title = tags.getTitle();
		String genresTemp = tags.getGenre();
		String metaData = metadata.toString();
		String summary = handler.toString();
		
		// TO-DO Tratamento do output genresTemp do tika para se encaixar no ArrayList<Genre> que eh um arraylist de enum
		// genres = new ArrayList<Genre>();
        // Genre g = Enum.valueOf(Genre.class, "ELETRONIC");
        // Genre g1 = Enum.valueOf(Genre.class, "POP");
		// Genre g2 = Enum.valueOf(Genre.class, "ROCK");
		
		Boolean debugMode = false;
	
		if (debugMode) {
			System.out.println("=-= Informações extraidas =-=");
			System.out.println("artist: " + artist);
			System.out.println("title: " + title);
			System.out.println("Generos temp: " + genresTemp);
			System.out.println("metaData: " + metaData);
			System.out.println("summary: " + summary + "\n");
		}
		
		mr.createMusic(artist, title, null, metaData, summary);
	}
		
	public void printMetadata(String path) throws Exception, IOException, SAXException, TikaException {
		BodyContentHandler handler = new BodyContentHandler();  
	    Metadata metadata = new Metadata();  
	    FileInputStream inputstream = new FileInputStream(new File(path));  
	    ParseContext pcontext = new ParseContext();  
	    Mp3Parser  Mp3Parser = new  Mp3Parser(); 
	    Mp3Parser.parse(inputstream, handler, metadata, pcontext);
	    System.out.println("Metadata:\n" + metadata.toString());
	
	}
	
	public void printSummary(String path) throws Exception, IOException, SAXException, TikaException {
		BodyContentHandler handler = new BodyContentHandler();  
	    Metadata metadata = new Metadata();  
	    FileInputStream inputstream = new FileInputStream(new File(path));  
	    ParseContext pcontext = new ParseContext();  
	    Mp3Parser  Mp3Parser = new  Mp3Parser(); 
	    Mp3Parser.parse(inputstream, handler, metadata, pcontext);
	    System.out.println("Summary:\n"+ handler.toString());
	}
}
