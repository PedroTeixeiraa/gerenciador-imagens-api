package com.br.pedroteixeiraa.gerenciadorimagensapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.log4j.Log4j2;

import com.amazonaws.services.s3.AmazonS3;
import com.br.pedroteixeiraa.gerenciadorimagensapi.dto.ImageResponseDto;
import com.br.pedroteixeiraa.gerenciadorimagensapi.dto.UploadImageResponseDto;
import com.br.pedroteixeiraa.gerenciadorimagensapi.utils.FileUtil;

@Log4j2
@Service
class ImageServiceImpl implements ImageService {

	@Autowired
	private AmazonS3 amazonS3;

	@Value("${s3.bucketName}")
	private String bucketName;

	@Override
	public UploadImageResponseDto upload(MultipartFile file) {
		try {
			var name = file.getOriginalFilename();
			var inputStream = file.getInputStream();

			amazonS3.putObject(bucketName, name, inputStream, null);

			log.info("%s uploaded successfully to Amazon S3.".formatted(name));
			return new UploadImageResponseDto("Image uploaded successfully.");
		} catch (Exception e) {
			var message = "Image upload failed to Amazon S3: " + e.getMessage();
			log.error(message);
			return new UploadImageResponseDto(message);
		}
	}

	@Override
	public List<ImageResponseDto> getImages() {
		var objectSummaries = amazonS3.listObjects(bucketName).getObjectSummaries();

		var images = objectSummaries.stream().map(summary -> {
			var s3Object = amazonS3.getObject(bucketName, summary.getKey());
			byte[] imageBytes = FileUtil.readInputStream(s3Object.getObjectContent());
			return ImageResponseDto.builder()
					.base64(imageBytes)
					.name(summary.getKey())
					.build();
		}).toList();

		log.info("Images uploaded successfully from Amazon S3");

		return images;
	}
}
