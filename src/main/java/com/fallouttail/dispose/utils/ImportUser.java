package com.fallouttail.dispose.utils;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class ImportUser {
    private MultipartFile files;
}
