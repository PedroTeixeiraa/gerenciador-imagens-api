package com.br.pedroteixeiraa.gerenciadorimagensapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.br.pedroteixeiraa.gerenciadorimagensapi.dto.ImageResponseDto;
import com.br.pedroteixeiraa.gerenciadorimagensapi.dto.UploadImageResponseDto;
import com.br.pedroteixeiraa.gerenciadorimagensapi.service.ImageService;

@RestController
@RequestMapping("/api/images")
public class ImageController {

	@Autowired
	private ImageService imageService;

	@PostMapping(value = "/upload", produces = MediaType.APPLICATION_JSON_VALUE)
	public UploadImageResponseDto uploadImage(@RequestParam("file") MultipartFile file) {
		return imageService.upload(file);
	}

	@GetMapping
	public List<ImageResponseDto> getImages() {
		return imageService.getImages();
	}
}
