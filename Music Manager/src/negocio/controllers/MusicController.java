package negocio.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

import data.MusicRepo;
import negocio.Genre;
import negocio.Music;
public class MusicController {

    public void extractMetaData(MusicRepo musicRepo, String path) throws Exception, IOException, SAXException, TikaException {
		BodyContentHandler handler = new BodyContentHandler();
	    Metadata metadata = new Metadata();  
	    FileInputStream inputstream = new FileInputStream(new File(path));  
	    ParseContext pcontext = new ParseContext();  
		Mp3Parser  Mp3Parser = new  Mp3Parser(); 
		
		Mp3Parser.parse(inputstream, handler, metadata, pcontext); // Extrai metadata nesse metodo
		
		String title =  metadata.get("title");
		String artist = metadata.get("creator");
		String genreStr = metadata.get("xmpDM:genre");
		String comprimentoStr = metadata.get("xmpDM:duration");
		
		// Tratamento dos dados extraidos

		Double comprimento = comprimentoStr.isEmpty() ?  0.0 : Double.valueOf(comprimentoStr);
		int seconds = (int) (comprimento / 1000) % 60 ;
		int minutes = (int) ((comprimento / (1000*60)) % 60);
		int hours   = (int) ((comprimento / (1000*60*60)) % 24);

		Genre genre;
		if ( genreStr != null ) {
			genre = Enum.valueOf(Genre.class, genreStr.toUpperCase());
		} else {
			genre = Genre.NULL;
		}

		// TO-DO pedir para o usuario completar os genero nos arquivos sem genero (Genre.NULL)
		

		Boolean teste = false;
	
		if (teste) {
			System.out.println("=-= Informações extraidas =-=");
			System.out.println("title: " + title);
			System.out.println("artist: " + artist);
			System.out.println("Generos temp: " + genreStr);
			System.out.println("Duração em ms: " + comprimento + "|" + String.format("%02d:%02d:%02d", hours, minutes, seconds) );
			// System.out.println("metaData: " +  metadata.toString());
			// System.out.println("summary: " + handler.toString());
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
		
		musicRepo.createMusic(title, artist, genre, comprimentoStr);
	}


	public void populateMusicLibrary(MusicRepo musicRepo) throws IOException {
		musicRepo.populateMusicLibrary();
	}


	public void deleteMusic(MusicRepo musicRepo, Music selectedMusic) {
		musicRepo.deleteMusic(selectedMusic);
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
