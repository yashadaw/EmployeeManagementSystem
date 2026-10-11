package com.example.demo.service;

import java.io.IOException;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.data.empdata;

public interface empInterface {
	empdata addemp(String name, String city, int salary, MultipartFile file, String path) throws IOException;

	boolean delete(String file);

	String deleteByIdd(int id);

	empdata updataByIdd(int id, String name, String city, int salary, MultipartFile file, String path)
			throws IOException;

	empdata getEmpById(int id);

	ResponseEntity<Resource> getImage(int id, String path) throws IOException;

}
