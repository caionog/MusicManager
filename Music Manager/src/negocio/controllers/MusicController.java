package negocio.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import data.MusicRepo;
import negocio.Genre;
public class MusicController {

    public void extractMetaData(MusicRepo mr, String path) throws Exception, IOException, SAXException, TikaException {
		BodyContentHandler handler = new BodyContentHandler();  
	    Metadata metadata = new Metadata();  
	    FileInputStream inputstream = new FileInputStream(new File(path));  
	    ParseContext pcontext = new ParseContext();  
		Mp3Parser  Mp3Parser = new  Mp3Parser(); 
		
		Mp3Parser.parse(inputstream, handler, metadata, pcontext); // Extrai metadata nesse metodo
		// ID3v1Handler tags = new ID3v1Handler(inputstream, handler);
		// String artist = tags.getArtist();
	    // String title = tags.getTitle();
		// String genresTemp = tags.getGenre();
		
		String artist = metadata.get("creator");
	    String title =  metadata.get("title");
		String genresTemp = metadata.get("xmpDM:genre");
		String comprimentoStr = metadata.get("xmpDM:duration");
		String metaData = metadata.toString();
		String summary = handler.toString();
		
		// Tratamento dos dados extraidos

		Double comprimento = comprimentoStr.isEmpty() ?  0.0 : Double.valueOf(comprimentoStr);
		int seconds = (int) (comprimento / 1000) % 60 ;
		int minutes = (int) ((comprimento / (1000*60)) % 60);
		int hours   = (int) ((comprimento / (1000*60*60)) % 24);

		ArrayList<Genre> genres = null;
		if ( genresTemp != null ) {
			genres = new ArrayList<Genre>(0);
			Genre g = Enum.valueOf(Genre.class, genresTemp.toUpperCase());
			genres.add(g);
		}

		// TO-DO pedir para o usuario completar os generos ???
		

		Boolean debugMode = true;
	
		if (debugMode) {
			System.out.println("=-= Informações extraidas =-=");
			System.out.println("artist: " + artist);
			System.out.println("title: " + title);
			System.out.println("Generos temp: " + genresTemp);
			System.out.println("Duração em ms: " + comprimento + "|" + String.format("%02d:%02d:%02d", hours, minutes, seconds) );
			// System.out.println("metaData: " + metaData);
			// System.out.println("summary: " + summary + "\n");
			System.out.println("=-= --------------------- =-=");
			
			Boolean mostrarTags = false;

			if (mostrarTags) {
				System.out.println("Print das tags");
			
				for( String tag : metadata.names() ) {		  
					System.out.println(tag + ": " + metadata.get(tag));
				}
				System.out.println("=-= --------------------- =-=");
			}
		}
		
		mr.createMusic(artist, title, genres, metaData, summary);
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
