package com.br.pedroteixeiraa.gerenciadorimagensapi.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.br.pedroteixeiraa.gerenciadorimagensapi.dto.ImageResponseDto;
import com.br.pedroteixeiraa.gerenciadorimagensapi.dto.UploadImageResponseDto;

public interface ImageService {

	UploadImageResponseDto upload(MultipartFile file);

	List<ImageResponseDto> getImages();
}
