package com.example.demo.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.emprepo;
import com.example.demo.data.empdata;

import ch.qos.logback.core.util.ContentTypeUtil;
import jakarta.transaction.Transactional;

@Service

public class employeeService implements empInterface {

	@Autowired
	emprepo repo;

	@Override
	public empdata addemp(String name, String city, int salary, MultipartFile fname, String path) throws IOException {
		// TODO Auto-generated method stub
		String fileName = fname.getOriginalFilename();
		String filePath = path + fileName;
		Files.copy(fname.getInputStream(), Paths.get(filePath));

		empdata obj = new empdata();
		obj.setName(name);
		obj.setCity(city);
		obj.setSalary(salary);
		obj.setFname(fileName);

		return repo.save(obj);
	}

	Path root = Paths.get("C:/images/");

	@Override
	public boolean delete(String file) {
		// TODO Auto-generated method stub
		Path pname = root.resolve("C:/images/" + file);

//		repo.deleteByName(file);
		try {
			Files.deleteIfExists(pname);
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String deleteByIdd(int id) {
		// TODO Auto-generated method stub
		String filename = repo.findById(id).get().getFname();
		Path path = Paths.get("C:/images/" + filename);

		try {
			Files.deleteIfExists(path);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		repo.deleteById(id);
		return "data removed sucessfully";
	}

	@Override
	public empdata updataByIdd(int id, String name, String city, int salary, MultipartFile file, String path)
			throws IOException {
		// TODO Auto-generated method stub
		// delete
		empdata emp = repo.findById(id).orElse(null);
		if (emp != null) {
			Path path1 = Paths.get(path + emp.getFname());
			try {
				Files.deleteIfExists(path1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// save

			String fname = file.getOriginalFilename();
			String p1 = path + fname;
			Files.copy(file.getInputStream(), Paths.get(p1));

			emp.setName(name);
			emp.setCity(city);
			emp.setSalary(salary);
			emp.setFname(fname);

		}

		return repo.save(emp);

	}

	@Override
	public empdata getEmpById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id).orElse(null);
	}

	@Override
	public ResponseEntity<Resource> getImage(int id, String path) throws IOException {
		// TODO Auto-generated method stub
		empdata em = repo.findById(id).orElse(null);
		String fname1 = em.getFname();
		Path path1 = Paths.get(path + fname1);
		Resource resource = new UrlResource(path1.toUri());
		String responsetype = Files.probeContentType(path1);
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(responsetype)).body(resource);

	}

}
