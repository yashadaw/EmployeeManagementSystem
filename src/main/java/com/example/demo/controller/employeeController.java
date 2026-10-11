package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.data.empdata;
import com.example.demo.service.employeeService;

@RestController
@CrossOrigin("*")

public class employeeController {
	@Autowired
	employeeService eser;
	@Value("${file.path}")
	String path;

	@PostMapping("/add")
	public empdata addemp(String name, String city, int salary, MultipartFile file) throws IOException {
		return eser.addemp(name, city, salary, file, path);

	}

	@DeleteMapping("/deletebyname/{file}")
	public boolean delete(@PathVariable String file) {
		eser.delete(file);
		return true;

	}

	@DeleteMapping("/delete/{id}")
	public String deleteBy(@PathVariable int id) {

		return eser.deleteByIdd(id);
	}

	@PutMapping("/updatebyid/{id}")
	public empdata update(@PathVariable int id, String name, String city, int salary, MultipartFile fname)
			throws IOException {
		return eser.updataByIdd(id, name, city, salary, fname, path);
	}

	@GetMapping("/getbyid/{id}")
	public empdata getByid(@PathVariable int id) {
		return eser.getEmpById(id);
	}

	@GetMapping("/getimage/{id}")
	public ResponseEntity<Resource> getimage(@PathVariable int id) throws IOException {
		return eser.getImage(id, path);
	}

}
