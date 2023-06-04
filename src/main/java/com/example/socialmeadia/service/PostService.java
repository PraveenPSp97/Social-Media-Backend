package com.example.socialmeadia.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;
import com.example.socialmeadia.model.Post;
import com.example.socialmeadia.repositories.PostRepo;

@Service
public class PostService {
	
	private static final String path = "C:/Users/PublicPictures/sm";
	private static final String UPLOAD_DIR = "/static/images";
	private final String UPLOAD_DIRECTORY="D:\\React\\social-meadia\\public\\images";



	@Autowired
	PostRepo postRepo;
	
	public List<Post> getposts() {
		return postRepo.findAll();
	}
	
	public String addpost(Post post) {
		System.out.println("inside post");
		postRepo.save(post);
		return "sucess";
	}
	
	public Post getPost(long id) {
		return postRepo.getById(id); 		
	}

	public void updatepost(Post post) {
		// TODO Auto-generated method stub
		postRepo.save(post);
		
	}
	
	public long deletePost(long id) {
		postRepo.deleteById(id);
		return id;
		
	}

	public void uploadfile(MultipartFile file) throws Exception {
		// TODO Auto-generated method stub
	      // Save file on system
        if (!file.getOriginalFilename().isEmpty()) {

            BufferedOutputStream outputStream = 
                  new BufferedOutputStream(
                    new FileOutputStream(new File(path, 
                      file.getOriginalFilename())));

            outputStream.write(file.getBytes());
            outputStream.flush();
            outputStream.close();

        } else {
            throw new Exception();
        }

		
	}

	public List<Post> getByTitle(String title) {
		// TODO Auto-generated method stub
		return postRepo.findBytitle(title);
	}

	public List<Post> getOrderByTitle() {
		// TODO Auto-generated method stub
		return postRepo.findAll(Sort.by(Sort.Direction.ASC, "title"));
		
	}
	
	public String uploadImage(MultipartFile file) throws IOException {
		return saveImage(file);
	}
	
	 public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
//	        Optional<FileData> fileData = fileDataRepository.findByName(fileName);
//	        String filePath=fileData.get().getFilePath();
	        byte[] images = Files.readAllBytes(new File(UPLOAD_DIRECTORY).toPath());
	        return images;
	    }

	
	private String saveImage(MultipartFile file) throws IOException {  
//		String UPLOAD_DIRECTORY="./src/main/resources/static/images";
//		String UPLOAD_DIRECTORY="C:/Users/prave/Downloads/socialmeadia/socialmeadia/src/main/resources/static/images";
		 StringBuilder fileNames = new StringBuilder();
	        Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, file.getOriginalFilename());
	        fileNames.append(file.getOriginalFilename());
	        Files.write(fileNameAndPath, file.getBytes());
	        
	     return file.getOriginalFilename();
	}


	public Post savePost(Post post) {
		return postRepo.save(post);
		
	}


}
