package negocio;

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


public class Music {
	private static int contador;
	private int idSong;
	private String pathSong;
	private String summarySong;
	private String metaData;
	private String artistSong;
	private String titleSong;
	private String genreSong;
	private boolean favoriteSong;
	
	//GETTERS

	public String getSummarySong() {
		return summarySong;
	}

	public String getMetaData() {
		return metaData;
	}

	public String getArtistSong() {
		return artistSong;
	}

	public String getTitleSong() {
		return titleSong;
	}

	public String getGenreSong() {
		return genreSong;
	}

	public boolean isFavoriteSong() {
		return favoriteSong;
	}

	public void makeFavoriteSong(Music music) 
	{
		if(this.favoriteSong == false) 
		{
			this.favoriteSong = true;
		}
	}

	public void setSummarySong(String summarySong) {
		this.summarySong = summarySong;
	}

	public void setMetaData(String metaData) {
		this.metaData = metaData;
	}

	public void setArtistSong(String artistSong) {
		this.artistSong = artistSong;
	}

	public void setTitleSong(String titleSong) {
		this.titleSong = titleSong;
	}

	public void setGenreSong(String genreSong) {
		this.genreSong = genreSong;
	}

	public void setFavoriteSong(boolean favoriteSong) {
		this.favoriteSong = favoriteSong;
	}

	public int getIdSong() {
		return idSong;
		
	}

	public static int getContador() {
		return contador;
	}

	public static void setContador(int contador) {
		Music.contador = contador;
	}

	public void setIdSong(int idSong) {
		this.idSong = idSong;
	}
	
	
	
	

	public String getPathSong() {
		return pathSong;
	}

	public void setPathSong(String pathSong) {
		this.pathSong = pathSong;
	}

	public void CreatMusic(String path)  throws Exception, IOException, SAXException, TikaException
	{
		setPathSong(path);
		BodyContentHandler handler = new BodyContentHandler();  
	    Metadata metadata = new Metadata();  
	    FileInputStream inputstream = new FileInputStream(new File(path));  
	    ParseContext pcontext = new ParseContext();  
	    Mp3Parser  Mp3Parser = new  Mp3Parser(); 
	    ID3v1Handler tags = new ID3v1Handler(inputstream, handler);
	    Mp3Parser.parse(inputstream, handler, metadata, pcontext);
	    
	    setArtistSong(tags.getArtist());
	    setTitleSong(tags.getTitle());
	    setGenreSong(tags.getGenre());
	    setMetaData(metadata.toString());
	    setSummarySong(handler.toString());
	    
	    
	    setIdSong(Music.contador);
	    
	    addCounter();
	    
	    
	    
	}
	
	public void addCounter() 
	{
		Music.contador++;
		
		
	}
		
	public void printMetadata(String path)throws Exception, IOException, SAXException, TikaException
	{
		BodyContentHandler handler = new BodyContentHandler();  
	    Metadata metadata = new Metadata();  
	    FileInputStream inputstream = new FileInputStream(new File(path));  
	    ParseContext pcontext = new ParseContext();  
	    Mp3Parser  Mp3Parser = new  Mp3Parser(); 
	    Mp3Parser.parse(inputstream, handler, metadata, pcontext);
	    System.out.println("Metadata:\n" + metadata.toString());
	
	}
	
	public void printSummary(String path)throws Exception, IOException, SAXException, TikaException
    {
    	
		BodyContentHandler handler = new BodyContentHandler();  
	    Metadata metadata = new Metadata();  
	    FileInputStream inputstream = new FileInputStream(new File(path));  
	    ParseContext pcontext = new ParseContext();  
	    Mp3Parser  Mp3Parser = new  Mp3Parser(); 
	    Mp3Parser.parse(inputstream, handler, metadata, pcontext);
	    
	    System.out.println("Summary:\n"+ handler.toString());
	}
	
	
	
}
