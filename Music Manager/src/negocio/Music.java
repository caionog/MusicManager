package negocio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.ArrayList;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;  
import org.apache.tika.parser.ParseContext;  
import org.apache.tika.parser.mp3.Mp3Parser;
import org.apache.tika.parser.mp3.ID3v1Handler;
import org.apache.tika.sax.BodyContentHandler; 
import org.xml.sax.SAXException;

public class Music {

	private int id;
	private String title;
	private String artist;
	private ArrayList<Genre> genres = new ArrayList<Genre>();

	private String summary;
	private String metaData;

	public Music(int id, String title, String artist, ArrayList<Genre> genres, String summary, String metaData) {
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.genres = genres;

		this.summary = summary;
		this.metaData = metaData;
	}

	//---------------------getters-----------------//

	public int getId() {
		return id;
	}
	public String getSummary() {
		return summary;
	}
	public String getMetaData() {
		return metaData;
	}
	public String getArtistSong() {
		return artist;
	}
	public String getTitle() {
		return title;
	}
	public ArrayList<Genre> getGenres() {
		return genres;
	}

	//----------------------setters------------------//
	
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public void setMetaData(String metaData) {
		this.metaData = metaData;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setGenres(ArrayList<Genre> genres) {
		this.genres = genres;
	}

	//--------------------metodos-------------------\\
	
	public void CreateMusic(String path) throws Exception, IOException, SAXException, TikaException {
		BodyContentHandler handler = new BodyContentHandler();  
	    Metadata metadata = new Metadata();  
	    FileInputStream inputstream = new FileInputStream(new File(path));  
	    ParseContext pcontext = new ParseContext();  
	    Mp3Parser  Mp3Parser = new  Mp3Parser(); 
	    ID3v1Handler tags = new ID3v1Handler(inputstream, handler);
	    Mp3Parser.parse(inputstream, handler, metadata, pcontext);
	    
	    
	    setArtist( tags.getArtist() );
	    setTitle( tags.getTitle() );
	    String genresTemp = tags.getGenre();
	    setMetaData( metadata.toString() );
		setSummary( handler.toString() );
		
		// Tratamento do output do tika para se encaixar no enum
	    System.out.println("Generos temp: " + genresTemp);
	    System.out.println("Generos: " + genres);
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

	public void addGenre(Genre g) {
		genres.add(g);
	}
	
	public String toString() {
		String s = "[";
		s += "id= " + id;
		s += ", title= " + title;
		s += ", artista= "+ artist;
		s += ", generos=" + genres;
		s += ", metadata= " + metaData;
		s += ", summary= " + summary;
		s += "]";

		return s;
	}

}
