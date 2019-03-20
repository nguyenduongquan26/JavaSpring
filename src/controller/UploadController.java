package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	static String upload(MultipartFile file,String root) {
		try {
		InputStream input = file.getInputStream();
		FileOutputStream output = new FileOutputStream(new File(root+file.getOriginalFilename()));
		byte[] bytes = new byte[1024];
		int len;
		while((len=input.read(bytes,0,1024))>0) {
			output.write(bytes, 0, len);
		}
		output.close();
		input.close();
		return file.getOriginalFilename();
		}catch (IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	
	
	
	@RequestMapping("multiple.html")
	public String multiple() {
		return "multiple";
	}
	
	
	@RequestMapping(value="multiple.html",method=RequestMethod.POST)
	public String multiple(MultipartFile[] file,HttpServletRequest req) {
		String root = req.getServletContext().getRealPath("/upload/");
		List<String> list = new LinkedList<>();
		for(MultipartFile item:file) {
			list.add(upload(item, root));
			System.out.println(item.getOriginalFilename());
		}
		req.setAttribute("file", list);
		return "multiple";
	}
	
	
	
	
	@RequestMapping("simple.html")
	public String simple() {
		return "simple";
	}
	@RequestMapping(value="simple.html",method=RequestMethod.POST)
	public String simple(MultipartFile file,HttpServletRequest req) {
		System.out.println(file.getOriginalFilename());
		
		String root = req.getServletContext().getRealPath("/upload/");
		upload(file, root);
		
		
		return "simple";
	}
}
