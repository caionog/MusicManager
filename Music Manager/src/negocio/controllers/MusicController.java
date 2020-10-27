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

import data.MusicRepo; // Repositórios
import data.UserRepo;

import negocio.Music; // Classes base
import negocio.User;

import negocio.Genre; // Enum

import negocio.interfaces.IMusicController; // Interface

public class MusicController implements IMusicController {
	
	private MusicRepo musicRepoInstance = MusicRepo.getInstance();
	
	private UserRepo userRepoInstance = UserRepo.getInstance();


	@Override
    public void extractMetaData(String path) throws Exception, IOException, SAXException, TikaException {
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
		
		musicRepoInstance.createMusic(title, artist, genre, comprimentoStr);
	}
    
	
	@Override
    public void resetRepo() {
    	musicRepoInstance.resetRepo();
    }


	@Override
	public void populateMusicLibrary() throws IOException {
		musicRepoInstance.populateMusicLibrary();
	}


	@Override
	public void deleteMusic(User loggedUser, Music selectedMusic) throws IOException {
		
		// So permite deletar musica se o loggedUser for administrador
		if ( selectedMusic != null && loggedUser.getUserPermission().getValue() ) {
			musicRepoInstance.deleteMusic(selectedMusic);

			userRepoInstance.updateDeletedMusics(selectedMusic.getId());

			userRepoInstance.updateDeletedMusics(selectedMusic.getId());
		} else {
			System.out.println("O Usuário logado não tem permissão para esse ação OU selected music é null");
		}
	}
		

	@Override
	public void printMetadata(String path) throws Exception, IOException, SAXException, TikaException {
		BodyContentHandler handler = new BodyContentHandler();  
	    Metadata metadata = new Metadata();  
	    FileInputStream inputstream = new FileInputStream(new File(path));  
	    ParseContext pcontext = new ParseContext();  
	    Mp3Parser  Mp3Parser = new  Mp3Parser(); 
	    Mp3Parser.parse(inputstream, handler, metadata, pcontext);
	    System.out.println("Metadata:\n" + metadata.toString());
	
	}
	
	
	@Override
	public void printSummary(String path) throws Exception, IOException, SAXException, TikaException {
		BodyContentHandler handler = new BodyContentHandler();  
	    Metadata metadata = new Metadata();  
	    FileInputStream inputstream = new FileInputStream(new File(path));  
	    ParseContext pcontext = new ParseContext();  
	    Mp3Parser  Mp3Parser = new  Mp3Parser(); 
	    Mp3Parser.parse(inputstream, handler, metadata, pcontext);
	    System.out.println("Summary:\n"+ handler.toString());
	}


	@Override
	public ArrayList<Music> getMusicLibrary() {
		return musicRepoInstance.getMusicLibrary();
	}


	@Override
	public Music getMusicById(int id) {
		return musicRepoInstance.getMusicById(id);
	}
	
	
	@Override
	public ArrayList<Music> filterMusic(Genre genre, String title) {

		ArrayList<Music> musics = new ArrayList<Music>(0);

		// TODO Acessa repositório de Musicas e buscar músicas compatíveis

		return musics;
	}
}
